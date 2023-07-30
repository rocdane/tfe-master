import { Component } from 'react';
import MonitoringProxy from '../api/MonitoringProxy';
import { ChartDiagnosis } from './ChartDiagnosis';
import { ChartRepair } from './ChartRepair';
import { Chart } from './Chart';

export class Dashboard extends Component{

  state = {
    dashboard:{
      stats:{
        dossiers:0,
        diagnosis:0,
        tasks:0,
        spares:0
      },
      diagnoses:[],
      tasks:[],
      spares:[]
    },
    errors:{}
  }

  componentDidMount(){
    this.load();
  }

  componentDidUpdate(){
    this.load();
  }

  load(){
    setTimeout(() => {
      MonitoringProxy.load().then((res)=>{
        this.setState({dashboard:res.data});
      }).catch((err)=>{
        let errors = {loadError:"Failed to load data !!!"};
        this.setState({errors});
        console.error(errors.loadError,err);
      });
    }, 3000);
  }

  render() {
    const {dashboard,errors} = this.state;

    return(
      <div className="container-fluid">
        {errors.loadError? <div className="container-fluid alert alert-warning" role="alert">{errors.loadError}</div> :null}
        <div className="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
          <h1 className="h2">Tableau de bord</h1>
        </div>
        <div className="container-fluid d-inline-flex flex-wrap flex-md-nowrap align-items-center justify-content-between">
          <button type="button" className="btn btn-sm btn-outline-warning object-fit-contain">
            <img className="img-fluid" width="48" height="48" src="/assets/img/dossier.png"/>
            <span className="badge text-bg-warning">{dashboard.stats.dossiers||0}</span>
          </button>
          <button type="button" className="btn btn-sm btn-outline-primary">
            <img className="img-fluid" width="48" height="48" src="/assets/img/reception.png"/>
            <span className="badge text-bg-primary">{dashboard.stats.diagnosis||0}</span>
          </button>
          <button type="button" className="btn btn-sm btn-outline-info">
            <img className="img-fluid" width="48" height="48" src="/assets/img/reparation.png"/>
            <span className="badge text-bg-info">{dashboard.stats.tasks||0}</span>
          </button>
          <button type="button" className="btn btn-sm btn-outline-danger">
            <img className="img-fluid" width="48" height="48" src="/assets/img/article.PNG"/>
            <span className="badge text-bg-danger">{dashboard.stats.spares||0}</span>
          </button>
        </div>
        <ChartDiagnosis diagnoses={dashboard.diagnoses}/>
        <ChartRepair spares={dashboard.spares} tasks={dashboard.tasks}/>
        <Chart spares={dashboard.spares} tasks={dashboard.tasks}/>
      </div>
    );
  }
}