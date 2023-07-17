import {Component} from "react";
import {DiagnosisForm} from "./DiagnosisForm";
import {DiagnosisList} from "./DiagnosisList";

export class DiagnosisTab extends Component{

    render() {
        return (
            <div className="row">
                <nav>
                    <div className="nav nav-tabs" id="nav-tab" role="tablist">
                        <button className="nav-link active" id="nav-new-diagnosis-tab" data-bs-toggle="tab" data-bs-target="#nav-new-diagnosis" type="button" role="tab" aria-controls="nav-new-diagnosis" aria-selected="true">
                            <img 
                            className="img-fluid"
                            width="32"
                            height="32"
                            src="/assets/icon/ico-new.PNG"
                            />
                        </button>
                        <button className="nav-link" id="nav-list-diagnosis-tab" data-bs-toggle="tab" data-bs-target="#nav-list-diagnosis" type="button" role="tab" aria-controls="nav-list-diagnosis" aria-selected="false">
                            <img 
                            className="img-fluid"
                            width="32"
                            height="32"
                            src="/assets/icon/ico-list.PNG"
                            />
                        </button>
                    </div>
                </nav>
                <div className="tab-content" id="nav-tabContent">
                    <div className="tab-pane fade show active" id="nav-new-diagnosis" role="tabpanel" aria-labelledby="nav-new-diagnosis-tab" tabindex="0">
                        <h2 className="text-start">Enregistrer un diagnostic</h2>
                        <div className="row">
                            <DiagnosisForm/>
                        </div>
                    </div>
                    <div className="tab-pane fade" id="nav-list-diagnosis" role="tabpanel" aria-labelledby="nav-list-diagnosis-tab" tabindex="0">
                        <h2 className="text-start">Liste des diagnostics</h2>
                        <div className="row table-responsive">
                            <DiagnosisList/>
                        </div>
                    </div>
                </div>
            </div>      
        );
    }
}
