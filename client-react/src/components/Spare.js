import { Component } from "react";

export class Spare extends Component{

    constructor(props){
        super(props)

        this.state = {
            spare : {
                "designation":"",
                "quantity":"",
                "price":"",
                "amount":""
            }
        }
    }

    render() {
        return (
            <div className="row mt-2 mb-2 spare-added">
                <div className="form-floating col-md-5 col-sm-5">
                    <input name="spare_designation" type="text" className="form-control"/>
                </div>
                <div className="form-floating col-md-2 col-sm-2">
                    <input name="spare_quantity" type="text" className="form-control"/>
                </div>
                <div className="form-floating col-md-2 col-sm-2">
                    <input name="spare_price" type="text" className="form-control"/>
                </div>
                <div className="form-floating col-md-2 col-sm-2">
                    <input name="spare_amount" type="text" className="form-control"/>
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