import axios from 'axios';

const AUTHENTICATION_API_BASE_URL = "http://localhost:8001/authentication-service";

class AuthenticationProxy {

    signin(user){
        return axios.post(AUTHENTICATION_API_BASE_URL+'/signin',user);
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

export default new AuthenticationProxy();