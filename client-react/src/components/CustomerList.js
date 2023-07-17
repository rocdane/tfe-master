import { Component } from "react";
import { CustomerProxy } from "../api/CustomerProxy";

export class CustomerList extends Component{
    customerProxy = new CustomerProxy();

    constructor(props){
        super(props);
        this.state = {
            client:{},
            dossier:{},
            clients:[]
        }
    }

    componentDidMount(){
        const response = this.customerProxy.getClient();
        this.state.clients = response.data;
        console.log(this.state.clients);
    }

    render() {
        return(
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Raison sociale</th>
                        <th scope="col">Type</th>
                        <th scope="col">Mention Légale</th>
                        <th scope="col">Contact</th>
                        <th scope="col">Adresse</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>S. Rochdane</td>
                        <td>Homme</td>
                        <td>Freelance IT</td>
                        <td>rocdanesabi@n2a.cc</td>
                        <td>Afrique</td>
                    </tr>
                </tbody>
            </table>
        );
    }
}