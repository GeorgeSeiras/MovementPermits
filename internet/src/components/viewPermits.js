import React from "react";
import "./viewPermits.css";
import Cookies from 'universal-cookie';

class ViewPermits extends React.Component {

    constructor() {
        super();
        this.state = {
            permits: [],
            user: {}
        }
    };

    async componentDidMount() {

        const cookies = new Cookies();
        const responseMe = await fetch(process.env.REACT_APP_API + "/auth/me?jwt=" + cookies.get('token'), {
            method: 'GET'
        });
        if (!responseMe.ok) {
            document.getElementById("message").value = "There was an error while retrieving your data";
        }
        const dataMe = await responseMe.json();
        this.setState({ user: dataMe });

        const responsePermits = await fetch(process.env.REACT_APP_API + "/permits?userID=" + this.state.user.userID);
        if (!responsePermits.ok) {
            document.getElementById("message").value = "There was an error while retrieving your permits";
        }
        const dataPermits = await responsePermits.json();
        this.setState({ permits: dataPermits })

    }
    render() {
        return (
            <div className="container">
                <div className="left"></div>
                <div className="central">
                    <button className="createButton" onClick={() => {
                        window.location.replace("/permits/create")
                    }}>Create Permit Request</button>
                    <p id="message" className="message" style={{ color: "red" }}></p>

                    <table className="permitTable">
                        <tbody id="permitTable">
                            <tr>
                                <td>Type</td>
                                <td>Start Date</td>
                                <td>End Date</td>
                                <td>Status</td>
                            </tr>
                            {this.state.permits.map((permit, index) => {
                                return (<tr index={index} key={index}>
                                    <td>{permit.type}</td>
                                    <td>{permit.startDate}</td>
                                    <td>{permit.endDate}</td>
                                    <td>{permit.status}</td>
                                    <td className="last"><button type="button" onClick={() => { window.location.replace("/permits/" + permit.permitID) }}>View</button></td>
                                </tr>)
                            })}
                        </tbody>
                    </table>
                </div>
                <div className="right"></div>
            </div>
        )
    }
}

export default ViewPermits;