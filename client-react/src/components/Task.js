import { Component } from "react";

export class Task extends Component{

    constructor(props){
        super(props)

        this.state = {
            task : {
                "description":"",
                "duration":"",
                "cost":""
            }
        }
    }

    render() {
        return (
            <div className="row mt-2 mb-2 task-added">
                <div className="col-md-7 col-sm-7">
                    <input name="task_description" type="text" className="form-control" />
                </div>
                <div className="col-md-2 col-sm-2">
                    <input name="task_duration" type="text" className="form-control" />
                </div>
                <div className="col-md-2 col-sm-2">
                    <input name="task_cost" type="text" className="form-control"/>
                </div>
                <div className="col-md-1 col-sm-1 justify-content-center d-flex">
                    <button className="btn btn-sm bg-transparent">
                        <img 
                        className="img-fluid"
                        width="32"
                        height="32"
                        src="/assets/icon/ico-remove.PNG"
                        />
                    </button>       
                </div>
            </div>
        );
    }
}