import React from "react";

class viewPermits extends React.Component {
    constructor() {
        super();
        this.state = {
            permits: [],
            user: {}
        }
    };
    async componentDidMount() {
        const responseMe = await fetch("http://localhost:8080/user/me")
        if (!responseMe.ok) {
            document.getElementById("message").innerHTML = "There was an error while retrieving your permits";
        }
        const dataMe = await responseMe.json();
        this.setState({ user: dataMe });

        const responsePermits = await fetch("http://localhost:8080/permits?userId=" + this.state.user.userID);
        if (!responsePermits.ok) {
            document.getElementById("message").innerHTML = "There was an error while retrieving your permits";
        }
        const dataPermits = await responsePermits.json();
        this.setState({ permits: dataPermits })

    }
    render() {
        if (this.state.permits.length === 0) {
            return (<h2>No permits found</h2>)
        }
        return (
            <div>
                <button onClick={
                    window.location.replace = "/permits/create"
                }>Create Permit Request</button>
                <table >
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
                                <td><button type="button" onClick={() => { window.location.replace("/permits/" + permit.permitID) }}>View</button></td>
                            </tr>)
                        })}
                    </tbody>
                </table>
                <p id="message" style={{ color: "red" }}></p>
            </div>
        )
    }
}

export default viewPermits;