import { Component } from "react";
import {MaintenanceProxy} from "../api/MaintenanceProxy";

export class DiagnosisList extends Component{
    maintenanceProxy = new MaintenanceProxy()

    constructor(props){
        super(props);
        this.state = {
            diagnosis : []
        }

        this.printDiagnosis = this.printDiagnosis.bind(this);
        this.archiveDiagnosis = this.archiveDiagnosis.bind(this);
    }

    componentDidMount(){
        const response = this.maintenanceProxy.getDiagnosis();
        this.state.diagnosis = response.data;
    }

    componentDidUpdate(){
        const response = this.maintenanceProxy.getDiagnosis();
        this.state.diagnosis = response.data;
    }

    printDiagnosis(id){
        const response = this.maintenanceProxy.reportDiagnosis(id);
        console.log(response.data);
    }

    archiveDiagnosis(id){
        const response = this.maintenanceProxy.getDiagnosis(id);
        console.log(response.data);
    }

    render() {
        return (
            <table className="table">
                <thead>
                    <tr>
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
                        this.state.diagnosis.map(
                            diag => 
                            <tr key = {diag.id}>
                                <td>{diag.dossier}</td>
                                <td>{diag.reference}</td>
                                <td>{diag.description}</td>
                                <td>{diag.mileage}</td>
                                <td>{diag.profile}</td>
                                <td className="d-flex justify-content-center">
                                    <button className="btn btn-sm bg-transparent" onClick={ () => {}}>
                                        <img 
                                        class="img-fluid"
                                        width="24"
                                        height="24 em"
                                        src="/assets/icon/ico-printer.PNG"
                                        />
                                    </button>
                                    <button className="btn btn-sm bg-transparent" onClick={ () => {}}>
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