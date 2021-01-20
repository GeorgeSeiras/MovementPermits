import React from "react";
import "./viewPermit.css"
class ViewPermit extends React.Component {
    constructor() {
        super();
        this.state = {
        }
    };

    async componentDidMount() {
        const response = await fetch('http://localhost:8080/permits/' + this.getPermitId());
        if (!response.ok) {
            document.getElementById("message").innerHTML = "There was an error while retrieving your permits";
        }
        const data = await response.json();
        this.setState({ permit: data });

    }

    render() {
        if (this.state.permit === undefined) {
            return (
                <h3>No permits found</h3>
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