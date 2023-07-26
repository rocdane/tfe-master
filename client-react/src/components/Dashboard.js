import { Component } from 'react';
import CustomerProxy from '../api/CustomerProxy';
import MaintenanceProxy from '../api/MaintenanceProxy';
import {Chart} from './Chart';

export class Dashboard extends Component{

  state = {
    customer:0,
    automobile:0,
    diagnosis:0,
    repair:0
  }

  componentDidMount(){

    CustomerProxy.getAutomobiles().then((res)=>{
      let automobiles = res.data;
      this.setState(({automobile:automobiles.length}));
    });

    CustomerProxy.getClients().then((res)=>{
      let customers = res.data;
      this.setState(({customer:customers.length}));
    });

    MaintenanceProxy.getDiagnoses().then((res)=>{
      let diagnosis = res.data;
      this.setState(({diagnosis:diagnosis.length}));
    });

    MaintenanceProxy.getRepairs().then((res)=>{
      let repairs = res.data;
      this.setState(({repair:repairs.length}));
    });
  }

  render() {
    const {customer,automobile,diagnosis,repair} = this.state;

    return(
      <div className="container-fluid">
        <div className="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
          <h1 className="h2">Tableau de bord</h1>
        </div>
        <div className="container-fluid d-inline-flex flex-wrap flex-md-nowrap align-items-center justify-content-between">
          <button type="button" className="btn btn-sm btn-outline-warning object-fit-contain">
            <img className="img-fluid" width="48" height="48" src="/assets/img/client.png"/>
            <span className="badge text-bg-warning">{customer||0}</span>
          </button>
          <button type="button" className="btn btn-sm btn-outline-secondary">
            <img className="img-fluid" width="48" height="48" src="/assets/img/automobile.png"/>
            <span className="badge text-bg-secondary">{automobile||0}</span>
          </button>
          <button type="button" className="btn btn-sm btn-outline-primary">
            <img className="img-fluid" width="48" height="48" src="/assets/img/reception.png"/>
            <span className="badge text-bg-primary">{diagnosis||0}</span>
          </button>
          <button type="button" className="btn btn-sm btn-outline-info">
            <img className="img-fluid" width="48" height="48" src="/assets/img/reparation.png"/>
            <span className="badge text-bg-info">{repair||0}</span>
          </button>
        </div>
        <Chart />
      </div>
    );
  }
}