import axios from 'axios';

const MAINTENANCE_API_BASE_URL = "http://localhost:8003/maintenance-service";

class MaintenanceProxy {

    processDiagnosis(words){
        return axios.get(MAINTENANCE_API_BASE_URL+'/resolve/'+words);
    }

    registrateDiagnosis(diagnosis){
        return axios.post(MAINTENANCE_API_BASE_URL+'/diagnosis',diagnosis);
    }

    getDiagnoses(){
        return axios.get(MAINTENANCE_API_BASE_URL+'/diagnosis');
    }

    getDiagnosis(id){
        return axios.get(MAINTENANCE_API_BASE_URL+'/diagnosis/'+id);
    }

    reportDiagnosis(id){
        return axios.get(MAINTENANCE_API_BASE_URL+'/report/diagnosis/'+id);
    }

    registrateRepair(repair){
        return axios.post(MAINTENANCE_API_BASE_URL+'/repairs',repair);
    }

    getRepairs(){
        return axios.get(MAINTENANCE_API_BASE_URL+'/repairs');
    }

    getRepair(id){
        return axios.get(MAINTENANCE_API_BASE_URL+'/repairs/'+id);
    }

    reportRepair(id){
        return axios.get(MAINTENANCE_API_BASE_URL+'/report/repair/'+id);
    }
}

export default new MaintenanceProxy();