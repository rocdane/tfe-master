import axios from 'axios';

const REPORT_API_BASE_URL = "http://localhost:8006/report-service";

class ReportProxy {

    reportDiagnosis(id){
        return axios.get(REPORT_API_BASE_URL+'/diagnosis/'+id,{ responseType: 'blob' });
    }

    reportRepair(id){
        return axios.get(REPORT_API_BASE_URL+'/repair/'+id,{ responseType: 'blob' });
    }
}

export default new ReportProxy();