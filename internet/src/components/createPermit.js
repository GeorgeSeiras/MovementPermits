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
                <p> Start Date:<input type="date"></input></p>
                <p> End Date:<input type="date"></input></p>
                <p>
                    <button >Submit</button>
                </p>
            </div>
        )
    }
}
export default createPermit;
