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
        console.log(cookies.get('token'));
    }

    render() {
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