import axios from 'axios';

const AUTHENTICATION_API_BASE_URL = "http://localhost:8765/authentication-service";

export class AuthenticationProxy {

    signin(user){
        return axios.post(AUTHENTICATION_API_BASE_URL+'/signin',user,{
            method: 'POST',
            mode: 'no-cors',
            headers: {
              'Access-Control-Allow-Origin': '*',
              'Content-Type': 'application/json',
            },
            withCredentials: true,
            credentials: 'same-origin',
          });
    }

    register(user){
        return axios.post(AUTHENTICATION_API_BASE_URL+'/registrate',user);
    }

    signout(token){
        return axios.post(AUTHENTICATION_API_BASE_URL+'/logout/'+token);
    }

    check(token){
        return axios.get(AUTHENTICATION_API_BASE_URL+'/session/'+token);
    }
}