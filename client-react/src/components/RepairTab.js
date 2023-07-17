import { Component } from "react";
import {RepairForm} from "./RepairForm";
import RepairList from "./RepairList";

export class RepairTab extends Component{

    render() {
        return (
            <div className="row">
                <nav>
                    <div className="nav nav-tabs" id="nav-tab" role="tablist">
                        <button className="nav-link active" id="nav-new-tab" data-bs-toggle="tab" data-bs-target="#nav-new" type="button" role="tab" aria-controls="nav-new" aria-selected="true">
                            <img 
                            className="img-fluid"
                            width="32"
                            height="32"
                            src="/assets/icon/ico-new.PNG"
                            />
                        </button>
                        <button className="nav-link" id="nav-list-tab" data-bs-toggle="tab" data-bs-target="#nav-list" type="button" role="tab" aria-controls="nav-list" aria-selected="false">
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
                    <div className="tab-pane fade show active" id="nav-new" role="tabpanel" aria-labelledby="nav-new-tab" tabindex="0">
                        <h2 className="text-start">Enregistrer une réparation</h2>
                        <div className="row">
                            <RepairForm></RepairForm>
                        </div>
                    </div>
                    <div className="tab-pane fade" id="nav-list" role="tabpanel" aria-labelledby="nav-list-tab" tabindex="0">
                        <h2 className="text-start">Liste des réparations</h2>
                        <div className="row table-responsive">
                            <RepairList></RepairList>
                        </div>
                    </div>
                </div>
            </div>      
        );
    }
}
