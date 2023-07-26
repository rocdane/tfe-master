import { Component } from "react";
import MaintenanceProxy from "../api/MaintenanceProxy";
import ReportProxy from "../api/ReportProxy";

export class RepairList extends Component{

    constructor(props){
        super(props)
        this.state = {
            repairs : []
        }
        this.printRepair = this.printRepair.bind(this);
        this.archiveRepair = this.archiveRepair.bind(this);
    }

    printRepair(id){
        ReportProxy.reportRepair(id).then((res) => {
            const link = document.createElement('a');
            const url = window.URL.createObjectURL(new Blob([res.data]));
            link.href = url;
            link.download = 'report_repair_'+id+'.pdf';
            link.click();
        }).catch((error)=>{
            console.error("Failed to download report : ",error);
        });
    }

    archiveRepair(id){
        MaintenanceProxy.getRepair(id).then((res) => {
            console.info(res.data);
        }).catch((error) => {
            console.error("Failed to archive repair : ",error);
        });
    }

    componentDidMount(){
        MaintenanceProxy.getRepairs().then((res) => {
            this.setState({ repairs : res.data});
        }).catch((error) => {
            console.error("Failed to get repair list : ",error);
        });
    }

    render(){
        return(
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
                        this.state.repairs.map((repair,index) => 
                            <tr>
                                <td>{index+1}</td>
                                <td>{repair.dossier}</td>
                                <td>{repair.reference}</td>
                                <td>{repair.description}</td>
                                <td>{repair.mileage}</td>
                                <td>{repair.profile}</td>
                                <td className="d-flex justify-content-center" onClick={ () => {this.printRepair(repair.id)}}>
                                    <button className="btn btn-sm bg-transparent">
                                        <img 
                                        className="img-fluid"
                                        width="24"
                                        height="24 em"
                                        src="/assets/icon/ico-printer.PNG"
                                        />
                                    </button>   
                                    <button className="btn btn-sm bg-transparent" onClick={ () => {this.archiveRepair(repair.id)}}>
                                        <img 
                                        className="img-fluid"
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