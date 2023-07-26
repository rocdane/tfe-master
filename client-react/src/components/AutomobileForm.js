import {Component} from "react";
import CustomerProxy from "../api/CustomerProxy";

export class AutomobileForm extends Component{
    
    state = {
        clients:[],
        client:{},
        name:"",
        number:"",
        vin:"",
        make:"",
        model:"",
        trim:0,
        unit:"",
        dossier:null,
        errors:{}
    }

    componentDidMount(){
        CustomerProxy
            .getClients()
            .then((res) => {
                this.setState({ clients : res.data});
            }).catch((error) => {
                console.error("Failed to get customer list : ",error);
            });
    }

    /*componentWillUnmount(){
        this.setState({
            clients:[],
            client:{},
            name:"",
            number:"",
            vin:"",
            make:"",
            model:"",
            trim:0,
            unit:"",
            dossier:null,
            errors:{}
        });
    }*/

    changeValue(e){
        this.setState({[e.target.name] : e.target.value});
        if(e.target.name==="name"){
            CustomerProxy
            .getClientWithName(e.target.value)
            .then((res)=>{
                this.setState({client:res.data});
            })
            .catch((error)=>{
                let errors = {dossierError:`Failed to get client with ${e.target.value}`}
                this.setState({errors});
                console.log(errors.dossierError,error);
                e.stopPropagation();
            });
        }
    }

    validateForm(){
        const {name,client,number,vin,make,model,trim,unit} = this.state;
        let isValid = true;
        const errors = {};

        if(name.trim().length===0 && client.id===null){
            errors.nameError = "Le choix du client est requis.";
            isValid = false;
        }

        if(number.trim().length < 6){
            errors.numberError = "Immatriculation requis (6)!!! ex: AB1111."
            isValid = false;
        }

        if(vin.trim().length < 17 || vin.trim.length > 17){
            errors.vinError = "VIN requis (17)!!! ex: ABCDEFGHJKLMNPQRST."
            isValid = false;
        }

        if(make.trim().length < 2){
            errors.makeError = "Marque requis !!! ex: TOYOTA."
            isValid = false;
        }

        if(model.trim().length < 2){
            errors.modelError = "Modèle requis !!! ex: AVENSIS."
            isValid = false;
        }

        if(isNaN(trim) || trim<=0){
            errors.trimError = "Odomètre ou compte-tour est un nombre autre que 0."
            isValid = false;
        }

        if(unit.trim().length < 2){
            errors.unitError = "Unité du compte-tour ou odomètre requis."
            isValid = false;
        }

        this.setState({errors});

        return isValid;
    }

    submitForm(e){
        e.preventDefault();
        const {client,number,vin,make,model,unit,trim} = this.state;
        
        const isValid = this.validateForm();
        
        if(isValid){            
            CustomerProxy
                .registrate({client:client,automobile:{number,vin,make,model,trim,unit}})
                .then((res)=>{
                    let dossier = res.data;
                    this.setState({dossier});
                })
                .catch((error)=>{
                    let errors = {dossierError:"Echec lors de la création du dossier."}
                    this.setState({errors});
                    console.log(errors.dossierError,error);
                });
        }else{
           e.stopPropagation();
        }
    }

    render () {
        const {clients,name,number,vin,make,model,unit,trim,dossier,errors} = this.state;

        return(
            <form className="row g-3 needs-validation was-validated" novalidate>
                {dossier ? <div class="container-fluid alert alert-success" role="alert">Un nouveau dossier ({dossier.reference}) a été ajouté.</div> : null}
                {errors.dossierError ? <div class="container-fluid alert alert-danger" role="alert">{errors.dossierError}</div> : null}
                <div className="form-floating col-md-12 col-sm-12">
                    <select name="name" className="form-select" id="name" placeholder="Client" value={name} onChange={(e)=>this.changeValue(e)} required>
                        <option selected disabled value="">Choisir le client...</option>
                        {clients.map(item => ( <option value={item.name}>{item.name}</option>))}
                    </select>
                    <label htmlFor="name">Client</label>
                    { errors.nameError ? <div className="text-danger">{errors.nameError}</div> : null}
                </div>     
                <div className="form-floating col-md-2 col-sm-6">
                    <input name="number" type="text" className="form-control" id="number" placeholder="Immatriculation" value={number} onChange={(e)=>this.changeValue(e)} required/>
                    <label htmlFor="number">Immatriculation</label>
                    { errors.numberError ? <div className="text-danger">{errors.numberError}</div> : null}
                </div>
                <div className="form-floating col-md-2 col-sm-6">
                    <input name="vin" type="text" className="form-control" id="vin" placeholder="Chassis" value={vin} onChange={(e)=>this.changeValue(e)} required/>
                    <label htmlFor="vin">Chassis</label>
                    { errors.vinError ? <div className="text-danger">{errors.vinError}</div> : null}
                </div>
                <div className="form-floating col-md-2 col-sm-6">
                    <input name="make" type="text" className="form-control" id="make" placeholder="Marque" value={make} onChange={(e)=>this.changeValue(e)} required/>
                    <label htmlFor="make">Marque</label>
                    { errors.makeError ? <div className="text-danger">{errors.makeError}</div> : null }
                </div>
                <div className="form-floating col-md-2 col-sm-6">
                    <input name="model" type="text" className="form-control" id="model" placeholder="Modèle" value={model} onChange={(e)=>this.changeValue(e)} required/>
                    <label htmlFor="model">Modèle</label>
                    { errors.modelError ? <div className="text-danger">{errors.modelError}</div> : null}
                </div>
                <div className="form-floating col-md-2 col-sm-6">
                    <select name="unit" className="form-select" id="unit" placeholder="Unité" value={unit} onChange={(e)=>this.changeValue(e)} required>
                        <option selected disabled value="">Unité du compteur ...</option>
                        <option value="Km">Kilomètre</option>
                        <option value="Mi">Miles</option>
                    </select>
                    <label htmlFor="unit">Unité</label>
                    { errors.unitError ? <div className="text-danger">{errors.unitError}</div> : null}
                </div>
                <div className="form-floating col-md-2 col-sm-6">
                    <input name="trim" type="text" className="form-control" id="trim" placeholder="Compteur" value={trim} onChange={(e)=>this.changeValue(e)} required/>
                    <label htmlFor="trim" className="form-label">Compteur</label>
                    { errors.trimError ? <div className="text-danger">{errors.trimError}</div> : null}
                </div>
                <div className="container-fluid d-flex justify-content-around mt-4 mb-2 text-center">
                    <button className="btn btn-sm btn-outline-primary" type="submit" onClick={(e)=>this.submitForm(e)}>
                        <img 
                        className="img-fluid"
                        width="32"
                        height="32"
                        src="/assets/icon/ico-save.PNG"
                        />
                    </button>
                    <button className="btn btn-sm btn-outline-danger" type="cancel">
                        <img 
                        className="img-fluid"
                        width="32"
                        height="32"
                        src="/assets/icon/ico-cancel.PNG"
                        />
                    </button>
                </div>
            </form>
        );
    }
}