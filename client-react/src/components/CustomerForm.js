import {Component} from "react";
import CustomerProxy from "../api/CustomerProxy";

export class CustomerForm extends Component{

    state = {
        type:"",
        name:"",
        contact:"",
        address:"",
        legalNotice:"",
        number:"",
        vin:"",
        make:"",
        model:"",
        trim:0,
        unit:"",
        dossier:{},
        errors:{}
    }

    changeValue(e){
        this.setState({[e.target.name] : e.target.value});
    }

    /*componentWillUnmount(){
        this.setState({
            type:"",
            name:"",
            contact:"",
            address:"",
            legalNotice:"",
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

    validateForm(){
        const {type,name,legalNotice,address,contact,number,vin,make,model,unit,trim} = this.state;
        let isValid = true;
        const errors = {};

        if(type.trim().length==0){
            errors.typeError = "Type de client requis. Ex: HOMME";
            isValid = false;
        }

        if(name.trim().length<2){
            errors.nameError = "Nom du client requis (2).";
            isValid = false;
        }

        if(legalNotice.trim().length<2){
            errors.legalError = "Mention légale du client requise !!! Ex: Profession | Statut";
            isValid = false;
        }

        if(contact.trim().length<2){
            errors.contactError = "Contact du client requis !!! Ex: Téléphone | Email";
            isValid = false;
        }

        if(address.trim().length<2){
            errors.addressError = "Adresse du client requise (2).";
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
        const {type,name,legalNotice,address,contact,number,vin,make,model,unit,trim} = this.state;
        
        const isValid = this.validateForm();
        
        if(isValid){      
            CustomerProxy
                .registrate({client:{type,name,legalNotice,contact,address},
                    automobile:{number,vin,make,model,trim,unit}})
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
        const {type,name,legalNotice,address,contact,number,vin,make,model,unit,trim,dossier,errors} = this.state;
        
        return(
            <form className="row g-3 needs-validation was-validated" novalidate>
                {dossier.reference ? <div class="container-fluid alert alert-success" role="alert">Un nouveau dossier ({dossier.reference}) a été ajouté.</div> : null}
                {errors.dossierError ? <div class="container-fluid alert alert-danger" role="alert">{errors.dossierError}</div> : null}
                <div className="row container-fluid">
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <select name="type" className="form-select" id="type" value={type} onChange={(e)=>this.changeValue(e)} required>
                            <option selected disabled value="">Type de client...</option>
                            <option value="HOMME">Homme</option>
                            <option value="FEMME">Femme</option>
                            <option value="ENTREPRISE">Entreprise</option>
                        </select>
                        <label htmlFor="type">Type</label>
                        { errors.typeError ? <div className="text-danger">{errors.typeError}</div> : null}
                    </div>
                    <div className="form-floating col-md-3 col-sm-6 mt-2 mb-2">
                        <input name="name" type="text" className="form-control" id="name" placeholder="Raison sociale" value={name} onChange={(e)=>this.changeValue(e)} required/>
                        <label htmlFor="name">Raison Sociale</label>
                        { errors.nameError ? <div className="text-danger">{errors.nameError}</div> : null}
                    </div>
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <input name="legalNotice" type="text" className="form-control" id="legalNotice" placeholder="Mention Légale" value={legalNotice} onChange={(e)=>this.changeValue(e)} required/>
                        <label htmlFor="legalNotice">Mention Légale</label>
                        { errors.legalError ? <div className="text-danger">{errors.legalError}</div> : null}
                    </div>
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <input name="contact" type="text" className="form-control" id="contact" placeholder="Contact" value={contact} onChange={(e)=>this.changeValue(e)} required/>
                        <label htmlFor="contact">Contact</label>
                        { errors.contactError ? <div className="text-danger">{errors.contactError}</div> : null}
                    </div>
                    <div className="form-floating col-md-3 col-sm mt-2 mb-2">
                        <input name="address" type="text" className="form-control" id="address" placeholder="Adresse" value={address} onChange={(e)=>this.changeValue(e)} required/>
                        <label htmlFor="address">Adresse</label>
                        { errors.addressError ? <div className="text-danger">{errors.addressError}</div> : null}
                    </div>
                </div>
                <div className="row container-fluid mt-4">
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <input name="number" type="text" className="form-control" id="number" placeholder="Immatriculation" value={number} onChange={(e)=>this.changeValue(e)} required/>
                        <label htmlFor="number">Immatriculation</label>
                        { errors.numberError ? <div className="text-danger">{errors.numberError}</div> : null}
                    </div>
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <input name="vin" type="text" className="form-control" id="vin" placeholder="Chassis" value={vin} onChange={(e)=>this.changeValue(e)} required/>
                        <label htmlFor="vin">Chassis</label>
                        { errors.vinError ? <div className="text-danger">{errors.vinError}</div> : null}
                    </div>
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <input name="make" type="text" className="form-control" id="make" placeholder="Marque" value={make} onChange={(e)=>this.changeValue(e)} required/>
                        <label htmlFor="make">Marque</label>
                        { errors.makeError ? <div className="text-danger">{errors.makeError}</div> : null }
                    </div>
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <input name="model" type="text" className="form-control" id="model" placeholder="Modèle" value={model} onChange={(e)=>this.changeValue(e)} required/>
                        <label htmlFor="model">Modèle</label>
                        { errors.modelError ? <div className="text-danger">{errors.modelError}</div> : null}
                    </div>
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <select name="unit" className="form-select" id="unit" placeholder="Unit" value={unit} onChange={(e)=>this.changeValue(e)} required>
                            <option selected disabled value="">Unité du compteur ...</option>
                            <option value="Km">Kilomètre</option>
                            <option value="Mi">Miles</option>
                        </select>
                        <label htmlFor="unit">Unité</label>
                        { errors.unitError ? <div className="text-danger">{errors.unitError}</div> : null}
                    </div>
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <input name="trim" type="text" className="form-control" id="trim" placeholder="Compteur" value={trim} onChange={(e)=>this.changeValue(e)} required/>
                        <label htmlFor="trim">Compteur</label>
                        { errors.trimError ? <div className="text-danger">{errors.trimError}</div> : null}
                    </div>
                </div>
                <div className="container-fluid d-flex justify-content-around mt-4 mb-2">
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