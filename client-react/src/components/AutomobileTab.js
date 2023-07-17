import { Component } from "react";
import { AutomobileForm } from "./AutomobileForm";
import {AutomobileList} from "./AutomobileList";

export class AutomobileTab extends Component{

    render() {
        return (
            <div className="row">
                <nav>
                    <div className="nav nav-tabs" id="nav-tab" role="tablist">
                        <button className="nav-link active" id="nav-new-automobile-tab" data-bs-toggle="tab" data-bs-target="#nav-new-automobile" type="button" role="tab" aria-controls="nav-new-automobile" aria-selected="true">
                            <img 
                            className="img-fluid"
                            width="32"
                            height="32"
                            src="/assets/icon/ico-new.PNG"
                            />
                        </button>
                        <button className="nav-link" id="nav-list-automobile-tab" data-bs-toggle="tab" data-bs-target="#nav-list-automobile" type="button" role="tab" aria-controls="nav-list-automobile" aria-selected="false">
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
                    <div className="tab-pane fade show active" id="nav-new-automobile" role="tabpanel" aria-labelledby="nav-new-automobile-tab" tabIndex="0">
                        <h2 className="text-start">Ajouter un automobile</h2>
                        <div className="row">
                            <AutomobileForm/>
                        </div>
                    </div>
                    <div className="tab-pane fade" id="nav-list-automobile" role="tabpanel" aria-labelledby="nav-list-automobile-tab" tabIndex="0">
                        <h2 className="text-start">Liste des automobiles</h2>
                        <div className="row table-responsive">
                            <AutomobileList></AutomobileList>
                        </div>
                    </div>
                </div>
            </div>      
        );
    }
}
