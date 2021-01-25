import React from "react";
import "./createPermit.css";
import Cookies from 'universal-cookie';
class CreatePermit extends React.Component {
    constructor() {
        super();
        this.state = {
            user: {}
        }
    };

    async componentDidMount() {
        const cookies = new Cookies();
        const response = await fetch("http://localhost:8080/auth/me?jwt=" + cookies.get('token'));
        if (!response.ok) {
            document.getElementById("message").innerHTML = "There was an error while retrieving your data";
        }
        const data = await response.json();
        this.setState({ user: data });
    }

    calcEndDate() {
        const type = document.getElementById("type").value;
        if (document.getElementById("startDate").value !== "") {
            document.getElementById("endDate").value = document.getElementById("startDate").value;
            switch (type) {
                case "daily":
                    document.getElementById("endDate").stepUp();
                    break;
                case "weekly":
                    document.getElementById("endDate").stepUp(7);
                    break;
                case "monthly":
                    document.getElementById("endDate").stepUp(30);
                    break;
                default:
            }
        }
    }

    calcStartDate() {
        const type = document.getElementById("type").value;
        document.getElementById("startDate").value = document.getElementById("endDate").value;
        switch (type) {
            case "daily":
                document.getElementById("startDate").stepDown();
                break;
            case "weekly":
                document.getElementById("startDate").stepDown(7);
                break;
            case "monthly":
                document.getElementById("startDate").stepDown(30);
                break;
            default:
        }
    }


    render() {
        return (
            <div className="container">
                <h1>Fill the form to submit a movement permit application</h1>
                <p> Address: <input type="text" id="address"></input></p>
                <p>Type :<select id="type" onChange={() => { this.calcEndDate() }}>
                    <option value="daily">Daily</option>
                    <option value="weekly">Weekly</option>
                    <option value="monthly">Montly</option>
                </select></p>
                <p> Start Date:<input type="date" id="startDate" onChange={() => { this.calcEndDate() }}></input></p>
                <p> End Date:<input type="date" id="endDate" onChange={() => { this.calcStartDate() }}></input></p>
                <p id="message" className="message"></p>
                <p>
                    <button onClick={async () => {
                        if (this.validateInput()) {
                            const requestOptions = {
                                method: 'POST',
                                headers: { 'Content-Type': 'application/json' },
                                body: JSON.stringify({
                                    permit: {
                                        address: document.getElementById("address").value,
                                        type: document.getElementById("type").value,
                                        startDate: document.getElementById("startDate").value,
                                        endDate: document.getElementById("endDate").value,
                                        status: "PENDING"
                                    },
                                    userID: this.state.user.userID
                                })
                            }
                            const response = await fetch("http://localhost:8080/permits", requestOptions)
                            if (response.ok) {
                                document.getElementById("message").innerHTML = "Successfully created permit";
                                document.getElementById("message").style.color = "green";
                            } else if (response.status === 404) {
                                document.getElementById("message").innerHTML = "There was an error while creating the permit";
                                document.getElementById("message").style.color = "red";
                            }
                        }
                    }}>Submit</button>
                </p>
            </div >
        )
    }
    validateInput() {
        const address = document.getElementById("address").value;
        const startDate = document.getElementById("startDate").value;
        const endDate = document.getElementById("endDate").value;
        var message = "";
        const invalidFields = [];
        if (address === "") {
            invalidFields.push("address");
        }
        if (startDate === "") {
            invalidFields.push("startDate");
        }
        if (endDate === "") {
            invalidFields.push("endDate");
        }
        if (invalidFields.length === 0) {
            return true;
        } else {
            invalidFields.forEach(field => {
                if (message === "") {
                    message += field;
                } else {
                    message += ", " + field
                }
            });
            if (invalidFields.length === 1) {
                message += " is required."
            } else if (invalidFields.length > 1) {
                message += " are required."
            }
            document.getElementById("message").innerHTML = message;
            return false;
        }
    }
}

export default CreatePermit;
