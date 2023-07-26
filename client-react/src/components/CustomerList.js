import { Component } from "react";
import CustomerProxy from "../api/CustomerProxy";

export class CustomerList extends Component{

    constructor(props){
        super(props);
        this.state = {
            client : {},
            dossier : {},
            clients : []
        }
    }

    componentDidMount(){
        CustomerProxy.getClients().then((res) => {
            this.setState({ clients : res.data});
        }).catch((error) => {
            console.error("Failed to get customer list : ",error);
        });
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
                    {
                        this.state.clients.map((client,index) => 
                            <tr>
                                <td>{index+1}</td>
                                <td>{client.name}</td>
                                <td>{client.type}</td>
                                <td>{client.legalNotice}</td>
                                <td>{client.contact}</td>
                                <td>{client.address}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        );
    }
}