import React from "react";
import "./viewPermit.css";
import Cookies from "universal-cookie";
class ViewPermit extends React.Component {
    constructor() {
        super();
        this.state = {
            permit: null,
            user: null
        }
    };

    async componentDidMount() {
        const cookies = new Cookies();
        const responseJwt = await fetch(process.env.REACT_APP_API + "/auth/me?jwt=" + cookies.get('token'));
        if (!responseJwt.ok) {
            document.getElementById("message").innerHTML = "There was an error while retrieving your data";
            return;
        }
        const user = await responseJwt.json();
        this.setState({ user: user });
        const response = await fetch(process.env.REACT_APP_API + '/permits/' + this.getPermitId() + "?userID=" + this.state.user.userID);
        if (!response.ok) {
            document.getElementById("message").innerHTML = "Permit does not exist";
            return;
        }
        const data = await response.json();
        this.setState({ permit: data });
    }

    render() {
        if (this.state.permit === undefined || this.state.permit === null) {
            return (
                <div className="container">
                    <p id="message" className="message"></p>
                </div >
            )
        }
        return (
            <div className="container">
                <table className="table">
                    <tbody>
                        <tr>
                            <td>First Name</td>
                            <td>Last Name</td>
                            <td>Address</td>
                            <td>Phone Number</td>
                            <td>Type</td>
                            <td>Start Date</td>
                            <td>End Date</td>
                            <td>Status</td>
                        </tr>
                        {
                            <tr >
                                <td>{this.state.permit.user.fname}</td>
                                <td>{this.state.permit.user.lname}</td>
                                <td>{this.state.permit.address}</td>
                                <td>{this.state.permit.user.phoneNum}</td>
                                <td>{this.state.permit.type}</td>
                                <td>{this.state.permit.startDate}</td>
                                <td>{this.state.permit.endDate}</td>
                                <td>{this.state.permit.status}</td>
                            </tr>
                        }
                    </tbody>
                </table>
                <p id="message" className="message"></p>
            </div >
        )
    }
    getPermitId() {
        return window.location.href.substring(window.location.href.lastIndexOf("/") + 1);
    }
}

export default ViewPermit;