import axios from 'axios';

const MONITORING_API_BASE_URL = "http://localhost:8004/monitoring-service";

class MonitoringProxy {
    
    load(){
        return axios.get(MONITORING_API_BASE_URL+'/load');
    }
}

export default new MonitoringProxy();