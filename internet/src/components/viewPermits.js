import React from "react";

class viewPermits extends React.Component {
    constructor() {
        super();
        this.state = {
            permits: []
        }
    };
    componentDidMount() {
        fetch("http://localhost:8080/permits")
            .then(response => response.json())
            .then((response) => this.setState({ permits: response }))
            .catch(err => console.error('Error ', err.toString()));

    }
    render() {
        if (this.state.permits.length === 0) {
            return (<h2>No permits found</h2>)
        }
        return (
            <div>
                <table >
                    <tbody id="permitTable">
                        <tr>
                            <td>Type</td>
                            <td>Start Date</td>
                            <td>End Date</td>
                            <td>Status</td>
                        </tr>
                        {this.state.permits.map((permit, index) => {
                            return (<tr index={index}>
                                <td>{permit.type}</td>
                                <td>{permit.startDate}</td>
                                <td>{permit.endDate}</td>
                                <td>{permit.status}</td>
                                <button type="button" onclick={() => { window.location.replace("/permits/" + permit.permitID) }}>View</button>
                            </tr>)
                        })}
                    </tbody>
                </table>
            </div>
        )
    }
}

export default viewPermits;