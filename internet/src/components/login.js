import React, { useState } from 'react';
import './login.css';
import PropTypes from 'prop-types';

async function loginUser(username, password) {
    const result = await fetch(process.env.REACT_APP_API+'/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "username": username,
            "password": password
        })
    });
    if (result.status === 401) {
        document.getElementById("loginMessage").innerHTML = "Incorrect username or password";
        return null;
    }else if(result.status === 403){
        document.getElementById("loginMessage").innerHTML = "You do not have the permission to access this. Please contact a system admininistrator if you think you should have the permission.";
    } else if (result.ok) {
        return result.json();
    }
}
export default function Login({ setToken }) {
    const [username, setUserName] = useState();
    const [password, setPassword] = useState();

    const handleSubmit = async e => {
        e.preventDefault();
        const token = await loginUser(username, password);
        if(token !== null && token !== undefined){
            setToken(token.jwt);
            window.location.replace(".");
        }
    }

    return (
        <div className="login-wrapper">
            <h1>Log In</h1>
            <form onSubmit={handleSubmit}>
                <label>
                    <p>Username</p>
                    <input type="text" onChange={e => setUserName(e.target.value)} />
                </label>
                <label>
                    <p>Password</p>
                    <input type="password" onChange={e => setPassword(e.target.value)} />
                </label>
                <div>
                    <button type="submit">Submit</button>
                </div>
            </form>
            <p id="loginMessage" style={{ "color": "red" }}></p>
        </div>
    )
}

Login.propTypes = {
    setToken: PropTypes.func.isRequired
}