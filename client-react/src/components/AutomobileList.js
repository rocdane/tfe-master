import { Component } from "react";
import { CustomerProxy } from "../api/CustomerProxy";

export class AutomobileList extends Component{

    customerProxy = new CustomerProxy();

    constructor(props){
        super(props);
        this.state = {
            automobiles:[]
        }
    }

    componentDidMount(){
        const response = this.customerProxy.getAutomobiles();
        this.state.automobiles = response.data;
        console.log(this.state.automobiles);
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
                    <tr>
                        <th scope="row">1</th>
                        <td>AH2775RB</td>
                        <td>ABCDEFGHJKLMNPRST</td>
                        <td>Toyota</td>
                        <td>Carina 3</td>
                        <td>255366</td>
                        <td>Km</td>
                    </tr>
                </tbody>
            </table>
        );
    }
}