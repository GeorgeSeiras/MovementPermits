import { useState } from "react";
import Cookies from 'universal-cookie';


export default function Token() {
    const cookies = new Cookies();
    const getToken = () => {
        return cookies.get('token');
    }

    const [token, setToken] = useState(getToken());

    const saveToken = userToken => {
        cookies.set('token', userToken, { path: '/', maxAge: 31536000 });
        setToken(userToken.token)
    };
    return {
        setToken: saveToken,
        token
    }
}