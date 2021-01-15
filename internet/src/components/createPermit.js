import React from "react";
class createPermit extends React.Component {
    render() {
        return (
            <div>
                <h1>Fill the form to submit a movement permit application</h1>
                <p> Address: <input type="text" id="address"></input></p>
                <p>Type :<select id="type">
                    <option value="daily">Daily</option>
                    <option value="weekly">Weekly</option>
                    <option value="montly">Montly</option>
                </select></p>
                <p> Start Date:<input type="date" id="startDate" onChange={() => {
                    const type = document.getElementById("type").nodeValue;
                    var newDate = document.getElementById("startDate").innerHTML;
                    if (type === "daily") {
                        newDate += 1;
                    } else if (type === "weekly") {
                        newDate += 7;
                    } else if (type === "monthly") {
                        newDate += 30;
                    }
                    document.getElementById("endDate").innerHTML = newDate;
                }}></input></p>
                <p> End Date:<input type="date" id="endDate" onChange={() => {
                    const type = document.getElementById("type").nodeValue;
                    var newDate = document.getElementById("endDate").innerHTML;
                    if (type === "daily") {
                        newDate += 1;
                    } else if (type === "weekly") {
                        newDate += 7;
                    } else if (type === "monthly") {
                        newDate += 30;
                    }
                    document.getElementById("startDate").innerHTML = newDate;
                }}></input></p>
                <p id="message" class="message"></p>
                <p>
                    <button onclick={async () => {
                        if (this.validateInput()) {
                            const requestOptions = {
                                method: 'POST',
                                headers: { 'Content-Type': 'application/json' },
                                body: JSON.stringify({
                                    address: document.getElementById("address"),
                                    type: document.getElementById("type"),
                                    startDate: document.getElementById("startDate"),
                                    endDate: document.getElementById("endDate")
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
        const address = document.getElementById("address");
        const startDate = document.getElementById("startDate");
        const endDate = document.getElementById("endDate");
        var message = "";
        const invalidFields = [];
        if (address === "") {
            invalidFields.add("address");
        }
        if (startDate === "") {
            invalidFields.add("startDate");
        }
        if (endDate === "") {
            invalidFields.add("endDate");
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

export default createPermit;
