import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Navigation from '../components/Navigation';
import {CustomerTab} from "../components/CustomerTab";
import {AutomobileTab} from "../components/AutomobileTab";

function Customer(){
  
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
            <h1 className="h2 text-start">Gestion des dossiers clients</h1>
            <div className="row">
                <nav>
                    <div className="nav nav-tabs" id="nav-tab" role="tablist">
                        <button className="nav-link active" id="nav-client-tab" data-bs-toggle="tab" data-bs-target="#nav-client" type="button" role="tab" aria-controls="nav-client" aria-selected="true">
                            <img 
                            className="img-fluid"
                            width="32"
                            height="32"
                            src="/assets/img/client.png"
                            />
                        </button>
                        <button className="nav-link" id="nav-automobile-tab" data-bs-toggle="tab" data-bs-target="#nav-automobile" type="button" role="tab" aria-controls="nav-automobile" aria-selected="false">
                            <img 
                            className="img-fluid"
                            width="32"
                            height="32"
                            src="/assets/img/automobile.png"
                            />
                        </button>
                    </div>
                </nav>
                <div className="tab-content" id="nav-tabContent">
                    <div className="tab-pane fade show active" id="nav-client" role="tabpanel" aria-labelledby="nav-client-tab" tabIndex="0">
                        <CustomerTab></CustomerTab>
                    </div>
                    <div className="tab-pane fade" id="nav-automobile" role="tabpanel" aria-labelledby="nav-automobile-tab" tabIndex="0">
                        <AutomobileTab></AutomobileTab>
                    </div>
                </div>
            </div>
        </div>
    </div>
  );
}

export default Customer;