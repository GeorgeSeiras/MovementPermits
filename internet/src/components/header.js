import React from 'react';
import Cookies from 'universal-cookie';
import './header.css';
class Header extends React.Component {
    constructor() {
        super();
        this.state = {
        }
    };

    logout() {
        const cookies = new Cookies();
        cookies.remove('token', { path: '/' });
    }

    render() {
        const path = window.location.href;
        if (path === process.env.REACT_APP_URL || path === process.env.REACT_APP_URL+"/"  || path === process.env.REACT_APP_URL+"/permits" ) {
            return (
                <div className="header">
                <button className="logoutButton" onClick={() => {
                    this.logout();
                    window.location.reload();
                }}>Logout</button>
                <button className="backButton" onClick={() => {
                    window.location.replace("../permits");
                }} style ={{"display":"none"}}>Back</button>
            </div>
            )
        }
        return (
            <div className="header">
                <button className="logoutButton" onClick={() => {
                    this.logout();
                    window.location.reload();
                }}>Logout</button>
                <button className="backButton" onClick={() => {
                    window.location.replace("../permits");
                }}>Back</button>
            </div>
        )
    }
}
export default Header;