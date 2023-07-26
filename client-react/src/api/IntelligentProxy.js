import axios from 'axios';

const INTELLIGENT_API_BASE_URL = "http://localhost:8005/intelligent-service";

class IntelligentProxy {

    processDiagnosis(words){
        return axios.get(INTELLIGENT_API_BASE_URL+'/resolve/'+words);
    }
}

export default new IntelligentProxy();