import React from "react";
import "./createPermit.css";
class CreatePermit extends React.Component {
    constructor() {
        super();
        this.state = {
            user: {}
        }
    };

    async componentDidMount() {
        // const response = await fetch("http://localhost:8080/user/me", {
        //     method: 'POST',
        //     headers: {
        //         'Content-Type': 'application/json'
        //     },
        //     body: JSON.stringify({ token: localStorage.getItem('token') })
        // });
        // if (!response.ok) {
        //     document.getElementById("message").innerHTML = "There was an error while retrieving your data";
        // }
        // const data = await response.json();
        // this.setState({ user: data });

    }

    render() {
        return (
            <div className="container">
                <h1>Fill the form to submit a movement permit application</h1>
                <p> Address: <input type="text" id="address"></input></p>
                <p>Type :<select id="type">
                    <option value="daily">Daily</option>
                    <option value="weekly">Weekly</option>
                    <option value="monthly">Montly</option>
                </select></p>
                <p> Start Date:<input type="date" id="startDate" onChange={() => {
                    const type = document.getElementById("type").value;
                    document.getElementById("endDate").value = document.getElementById("startDate").value;
                    if (type === "daily") {
                        document.getElementById("endDate").stepUp();

                    } else if (type === "weekly") {
                        document.getElementById("endDate").stepUp(7);
                    } else if (type === "monthly") {
                        document.getElementById("endDate").stepUp(30);
                    }
                }}></input></p>
                <p> End Date:<input type="date" id="endDate" onChange={() => {
                    const type = document.getElementById("type").value;
                    document.getElementById("startDate").value = document.getElementById("endDate").value;
                    if (type === "daily") {
                        document.getElementById("startDate").stepDown();
                    } else if (type === "weekly") {
                        document.getElementById("startDate").stepDown(7);
                    } else if (type === "monthly") {
                        document.getElementById("startDate").stepDown(30);
                    }
                }}></input></p>
                <p id="message" className="message"></p>
                <p>
                    <button onClick={async () => {
                        if (this.validateInput()) {
                            const requestOptions = {
                                method: 'POST',
                                headers: { 'Content-Type': 'application/json' },
                                body: JSON.stringify({
                                    address: document.getElementById("address").value,
                                    type: document.getElementById("type").value,
                                    startDate: document.getElementById("startDate").value,
                                    endDate: document.getElementById("endDate").value,
                                    status:"PENDING",
                                    user:this.state.user.userID
                                })
                            }
                            const response = await fetch("http://localhost:8080/permits", requestOptions)
                            if (!response.ok) {
                                document.getElementById("message").innerHTML = "There was an error while creating the permit";
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
