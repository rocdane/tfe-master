import { Component } from "react";

export class Factor extends Component{
    
    constructor(props){
        super(props);

        this.removeFactor = this.removeFactor.bind(this);
    }

    removeFactor(){

    }

    render() {
        return (
            <div className="row mt-2 mb-2 factor-added">
                <div className="col-md-2 col-sm-2">
                    <input name="entity" type="text" value={this.props.entity} className="form-control"/>
                </div>
                <div className="col-md-4 col-sm-4">
                    <input name="dysfunction" type="text" value={this.props.dysfunction} className="form-control"/>
                </div>
                <div className="col-md-4 col-sm-4">
                    <input name="maintenance" type="text" value={this.props.maintenance} className="form-control"/>
                </div>
                <div className="col-md-2 col-sm-2">
                    <button className="btn btn-sm" onClick={this.removeFactor}>
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