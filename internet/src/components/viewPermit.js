import React from "react";

class viewPermit extends React.Component {
    constructor() {
        super();
        this.state = {
        }
    };

    componentDidMount() {
        fetch('http://localhost:8080/permits/' + this.getPermitId())
            .then(response => response.json())
            .then((response) => this.setState({ permit: response }))
            .catch(err => console.error('Error ', err.toString()));
    }

    render() {
        if (this.state.permit === undefined) {
            return (
                <h3>No permits found</h3>
            )
        }
        return (
            <div>
                <table>
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
            </div >
        )
    }
    getPermitId() {
        return window.location.href.substring(window.location.href.lastIndexOf("/") + 1);
    }
}

export default viewPermit;