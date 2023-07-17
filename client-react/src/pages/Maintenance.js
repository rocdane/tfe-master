import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Navigation from '../components/Navigation';
import DiagnosisForm from "../components/DiagnosisForm";
import DiagnosisList from "../components/DiagnosisList";
import RepairForm from "../components/RepairForm";
import RepairList from "../components/RepairList";
import { RepairTab } from '../components/RepairTab';
import { DiagnosisTab } from '../components/DiagnosisTab';

function Maintenance(){
  
  const [authenticated, setauthenticated] = useState(null);
  const navigate = useNavigate();
  
  useEffect(() => {
    const session = localStorage.getItem("authenticated");
    if(session){
      setauthenticated(session);
    }else{
      navigate("/authenticate");
    }
  },[]);

  return (
    <div className="App">
        <Navigation></Navigation>
        <div className="container-fluid">
            <h1 className="h2 text-start">Gestion des maintenances</h1>
            <div className="row">
                <nav>
                    <div className="nav nav-tabs" id="nav-tab" role="tablist">
                        <button className="nav-link active" id="nav-diagnosis-tab" data-bs-toggle="tab" data-bs-target="#nav-diagnosis" type="button" role="tab" aria-controls="nav-diagnosis" aria-selected="true"> 
                            <img 
                            className="img-fluid"
                            width="32"
                            height="32"
                            src="/assets/img/reception.png"
                            />
                        </button>
                        <button className="nav-link" id="nav-repair-tab" data-bs-toggle="tab" data-bs-target="#nav-repair" type="button" role="tab" aria-controls="nav-repair" aria-selected="false">
                            <img 
                            className="img-fluid"
                            width="32"
                            height="32"
                            src="/assets/img/reparation.png"
                            />
                        </button>
                    </div>
                </nav>
                <div className="tab-content" id="nav-tabContent">
                    <div className="tab-pane fade show active" id="nav-diagnosis" role="tabpanel" aria-labelledby="nav-diagnosis-tab" tabIndex="0">
                        <DiagnosisTab/>
                    </div>
                    <div className="tab-pane fade" id="nav-repair" role="tabpanel" aria-labelledby="nav-repair-tab" tabIndex="0">
                        <RepairTab/>
                    </div>
                </div>
            </div>
        </div>
    </div>
  );
}

export default Maintenance;