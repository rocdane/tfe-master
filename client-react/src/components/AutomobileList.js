import { Component } from "react";
import CustomerProxy from "../api/CustomerProxy";

export class AutomobileList extends Component{

    constructor(props){
        super(props);
        this.state = {
            automobiles : []
        }
    }

    componentDidMount(){
        CustomerProxy.getAutomobiles().then((res) => {
            this.setState({ automobiles : res.data});
        }).catch((error) => {
            console.error("Failed to get automobile list : ",error);
        });
    }

    render() {
        return(
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Immatriculation</th>
                        <th scope="col">VIN</th>
                        <th scope="col">Marque</th>
                        <th scope="col">Modèle</th>
                        <th scope="col">Compteur</th>
                        <th scope="col">Unité</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.automobiles.map((auto,index) => 
                            <tr>
                                <td>{index+1}</td>
                                <td>{auto.number}</td>
                                <td>{auto.vin}</td>
                                <td>{auto.make}</td>
                                <td>{auto.model}</td>
                                <td>{auto.trim}</td>
                                <td>{auto.unit}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        );
    }
}