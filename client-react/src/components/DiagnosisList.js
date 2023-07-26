import { Component } from "react";
import MaintenanceProxy from "../api/MaintenanceProxy";
import ReportProxy from "../api/ReportProxy";

export class DiagnosisList extends Component{

    constructor(props){
        super(props);
        this.state = {
            diagnoses : []
        }

        this.printDiagnosis = this.printDiagnosis.bind(this);
        this.archiveDiagnosis = this.archiveDiagnosis.bind(this);
    }

    componentDidMount(){
        MaintenanceProxy.getDiagnoses().then((res) => {
            this.setState({ diagnoses : res.data});
        }).catch((error) => {
            console.error("Failed to get diagnosis list : ",error);
        });
    }

    printDiagnosis(id){
        ReportProxy.reportDiagnosis(id).then((res) => {
            const link = document.createElement('a');
            const url = window.URL.createObjectURL(new Blob([res.data]));
            link.href = url;
            link.download = 'report_diagnosis_'+id+'.pdf';
            link.click();
        }).catch((error)=>{
            console.error("Failed to download report : ",error);
        });
    }

    archiveDiagnosis(id){
        MaintenanceProxy.getDiagnosis(id).then((res) => {
            console.info(res.data);
        }).catch((error) => {
            console.error("Failed to archive diagnosis : ",error);
        });
    }

    render() {
        return (
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Dossier</th>
                        <th scope="col">Référence</th>
                        <th scope="col">Description</th>
                        <th scope="col">Odomètre</th>
                        <th scope="col">Technicien</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.diagnoses.map((diag, index) => 
                            <tr key = {index}>
                                <td>{index+1}</td>
                                <td>{diag.dossier}</td>
                                <td>{diag.reference}</td>
                                <td>{diag.description}</td>
                                <td>{diag.mileage}</td>
                                <td>{diag.profile}</td>
                                <td className="d-flex justify-content-center">
                                    <button className="btn btn-sm bg-transparent" onClick={ () => {this.printDiagnosis(diag.id)}}>
                                        <img 
                                        class="img-fluid"
                                        width="24"
                                        height="24 em"
                                        src="/assets/icon/ico-printer.PNG"
                                        />
                                    </button>
                                    <button className="btn btn-sm bg-transparent" onClick={ () => {this.archiveDiagnosis(diag.id)}}>
                                        <img 
                                        class="img-fluid"
                                        width="24 em"
                                        height="24 em"
                                        src="/assets/icon/ico-delete.PNG"
                                        />
                                    </button>   
                                </td>
                            </tr>
                        )
                    }
                    
                </tbody>
            </table>
        );
    }
}