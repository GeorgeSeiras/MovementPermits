import React from 'react';
import Token from './token';
import './header.css';
class Header extends React.Component {
    constructor() {
        super();
        this.state = {
        }
    };
    render() {
        return (
           <div className="header">
               <button className="logoutButton" onClick={() => {
                    Token.deleteToken();
                }}>Logout</button>
                <button className="backButton" onClick={() => {
                    window.location.replace("../permits");
                }}>Back</button>
            </div>
        )
    }
}
export default Header;