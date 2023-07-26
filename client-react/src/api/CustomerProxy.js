import axios from 'axios';

const CUSTOMER_API_BASE_URL = "http://localhost:8002/customer-service";

class CustomerProxy {

    registrate(dossier){
        return axios.post(CUSTOMER_API_BASE_URL+'/dossiers',dossier);
    }

    getDossiers(){
        return axios.get(CUSTOMER_API_BASE_URL+'/dossiers');
    }

    getDossier(id){
        return axios.get(CUSTOMER_API_BASE_URL+'/dossiers/'+id);
    }

    getDossierWithReference(reference){
        return axios.get(CUSTOMER_API_BASE_URL+'/dossiers/reference/'+reference);
    }

    getClients(){
        return axios.get(CUSTOMER_API_BASE_URL+'/clients');
    }

    getClient(id){
        return axios.get(CUSTOMER_API_BASE_URL+'/clients/'+id);
    }

    getClientWithName(name){
        return axios.get(CUSTOMER_API_BASE_URL+'/clients/name/'+name);
    }

    getAutomobiles(){
        return axios.get(CUSTOMER_API_BASE_URL+'/automobiles');
    }
    
    getAutomobile(id){
        return axios.get(CUSTOMER_API_BASE_URL+'/automobiles/'+id);
    }

    getAutomobileWithNumber(number){
        return axios.get(CUSTOMER_API_BASE_URL+'/automobiles/number/'+number);
    }
}

export default new CustomerProxy();