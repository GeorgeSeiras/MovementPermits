import { useState } from "react";

export default function Token() {
    const getToken = () => {
        const tokenString = localStorage.getItem('token');
        const token = JSON.parse(tokenString);
        return token?.token;
    }

    const [token, setToken] = useState(getToken());

    const saveToken = userToken => {
        localStorage.setItem('token', JSON.stringify(userToken));
        setToken(userToken.token);
    };
    const deleteToken = () => {
        localStorage.removeItem('token');
    }
    return {
        setToken: saveToken,
        deleteToken: deleteToken,
        token
    }


}