import { Component } from "react";
import MaintenanceProxy from "../api/MaintenanceProxy";
import ReportProxy from "../api/ReportProxy";
import CustomerProxy from "../api/CustomerProxy";
import IntelligentProxy from "../api/IntelligentProxy";

let temp_factors = [];

class Factor extends Component{
    state = {
        entity:"",
        dysfunction:"",
        maintenance:"",
        factors:[],
        diagnoses:[],
        errors:{}
    }

    removeFactor(i){
        temp_factors.splice(i, 1);
        this.setState({ factors:temp_factors });
    }

    handleChange(i, e) {
        temp_factors[i][e.target.name] = e.target.value;
        this.setState({ factors:temp_factors });
    }

    changeValue(e){
        this.setState({[e.target.name] : e.target.value});
        if(e.target.name==="dysfunction"){
            IntelligentProxy
                .processDiagnosis(e.target.value)
                .then((res)=>{
                    let diagnoses = res.data;
                    this.setState({diagnoses});
                })
                .catch((error)=>{
                    let errors = {diagnosisError:"Impossible de traiter le diagnostic."}
                    console.log(errors.diagnosisError,error);
                });
        }
    }

    selectDiagnosis(e,i){
        e.preventDefault();
        let {diagnoses} = this.state;
        this.setState({dysfunction:diagnoses[i]['dysfunction'],
            maintenance:diagnoses[i]['maintenance']});
        this.setState({diagnoses:[]});
    }

    validateForm(){
        const {entity,dysfunction,maintenance} = this.state;
        let isValid = true;
        const errors = {};

        if(entity.trim().length < 2){
            errors.entityLength = "Choix de l'entité obligatoire.";
            isValid = false;
        }

        if(dysfunction.trim().length < 2){
            errors.dysfunctionLength = "Dysfonctionnement obligatoire.";
            isValid = false;
        }

        if(maintenance.trim().length < 2){
            errors.maintenanceLength = "Maintenance obligatoire.";
            isValid = false;
        }

        this.setState({errors});

        return isValid;
    }

    resetForm(){
        this.setState({dysfunction:"",maintenance:""});
    }

    addFactor(e){
        e.preventDefault();
        const isValid = this.validateForm();

        if(isValid){
            let factor = {
                entity:this.state.entity,
                dysfunction:this.state.dysfunction,
                maintenance:this.state.maintenance
            };
    
            temp_factors.push(factor);

            this.setState({ factors: temp_factors});
            
            this.resetForm();
        }else{
            e.stopPropagation();
        }
    }

    render() {
        const {entity,dysfunction,maintenance,factors,diagnoses,errors} = this.state;
        return (
            <fieldset className="row mt-3 mb-3">
                <legend className="col-form-label fw-bold text-decoration-underline col-sm pt-0">Facteurs de diagnostic</legend>
                <div className="container-fluid mt-2" id="diagnosis-factor">
                    <form className="row g-3 needs-validation was-validated" novalidate>
                        {factors.map((factor, index) => (
                            <div className="row mt-2 mb-2" key={index}>
                                <div className="col-md-3 col-sm-3">
                                    <input name="entity" type="text" className="form-control" value={factor.entity || ""} onChange={(e) => this.handleChange(index, e)}/>
                                </div>
                                <div className="col-md-4 col-sm-4">
                                    <input name="dysfunction" type="text" className="form-control" value={factor.dysfunction || ""} onChange={(e) => this.handleChange(index, e)}/>
                                </div>
                                <div className="col-md-4 col-sm-4">
                                    <input name="maintenance" type="text" className="form-control" value={factor.maintenance || ""} onChange={(e) => this.handleChange(index, e)}/>
                                </div>
                                <div className="col-md-1 col-sm-1">
                                    <button className="btn btn-sm" onClick={() => this.removeFactor(index)}>
                                        <img 
                                        className="img-fluid"
                                        width="32"
                                        height="32"
                                        src="/assets/icon/ico-remove.PNG"
                                        />
                                    </button>
                                </div>
                            </div>
                        ))}            
                        <div className="row mt-2 mb-2 bg-body-secondary">
                            <div className="form-floating col-md-3 col-sm-3">
                                <select name="entity" className="form-select" id="entity" aria-label="Default select example" value={entity} onChange={(e)=>this.changeValue(e)} required>
                                    <option selected value="">Entité...</option>
                                    <option value="Système de direction">Direction</option>
                                    <option value="Système de freinage">Freinage</option>
                                    <option value="Système de motorisation">Motorisation</option>
                                    <option value="Système de suspension">Suspension</option>
                                    <option value="Système de transmission">Transmission</option>
                                </select>
                                <label htmlFor="entity">Entité</label>
                                { errors.entityLength ? <div className="text-danger">{errors.entityLength}</div> : null}
                            </div>
                            <div className="form-floating col-md-4 col-sm-4">
                                <input data-bs-toggle="collapse" data-bs-target="#suggestion" aria-expanded="false" aria-controls="suggestion" name="dysfunction" type="text" className="form-control dysfunction" id="dysfunction" placeholder="Dysfonctionnement" value={dysfunction} onChange={(e)=>this.changeValue(e)} required/>
                                <label htmlFor="dysfunction">Dysfonctionnement</label>
                                { errors.dysfunctionLength ? <div className="text-danger">{errors.dysfunctionLength}</div> : null}
                                <div className="collapse" id="suggestion">
                                    <ul className="list-group">
                                        {diagnoses.map((diagnosis, index) => (
                                            <li className="list-group-item"><a class="dropdown-item" href="#" onClick={(e)=>this.selectDiagnosis(e,index)} key={index}>{diagnosis.dysfunction}</a></li>
                                        ))}
                                    </ul>
                                </div>
                            </div>
                            <div className="form-floating col-md-4 col-sm-4">
                                <input name="maintenance" type="text" className="form-control" id="maintenance" placeholder="Maintenance" value={maintenance} onChange={(e)=>this.changeValue(e)} required/>
                                <label htmlFor="maintenance">Maintenance</label> 
                                { errors.maintenanceLength ? <div className="text-danger">{errors.maintenanceLength}</div> : null}
                            </div>
                            <div className="col-md-1 col-sm-1 justify-content-center d-flex">
                                <button className="btn btn-sm bg-transparent" onClick={(e)=>this.addFactor(e)}>
                                    <img 
                                    className="img-fluid"
                                    width="32"
                                    height="32"
                                    src="/assets/icon/ico-add.PNG"
                                    />
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </fieldset>
        );
    }
}

export class DiagnosisForm extends Component{

    state = {
        profile:"",
        dossier:"",
        mileage:0,
        description:"",
        factors:temp_factors,
        dossiers:[],
        errors:{},
        diagnosis:null
    }

    componentDidMount(){
        CustomerProxy
            .getDossiers()
            .then((res) => {
                this.setState({ dossiers : res.data});
            }).catch((error) => {
                let errors = {diagnosisError:"Impossible de charger les dossiers client."}
                this.setState({errors});
                console.error(errors.diagnosisError,error);
            });
    }

    /*componentWillUnmount(){
        this.setState({
            profile:"",
            dossier:"",
            mileage:0,
            description:"",
            factors:temp_factors,
            dossiers:[],
            errors:{},
            diagnosis:null
        });
    }*/

    changeValue(e){
        this.setState({[e.target.name] : e.target.value});
        this.validateForm();
    }

    validateForm(){
        const {profile,dossier,mileage,description,factors} = this.state;
        let isValid = true;
        const errors = {};

        if(profile.trim().length < 2){
            errors.profileLength = "Nom du technicien requis.";
            isValid = false;
        }

        if(dossier.trim() === ""){
            errors.dossierLength = "Référence du dossier requis.";
            isValid = false;
        }

        if(isNaN(mileage) || mileage < 0){
            errors.mileageType = "Compteur est un nombre. Ex: 12345!";
            isValid = false;
        }

        if(description.trim().length < 2){
            errors.descriptionLength = "Description du diagnostic requis.";
            isValid = false;
        }

        if(factors.length===0){
            errors.factorsEmpty = "Les facteurs de diagnostic sont obligatoires.";
            isValid = false;
        }

        this.setState({errors});

        return isValid;
    }

    printDiagnosis(e,id){
        e.preventDefault();
        ReportProxy.reportDiagnosis(id).then((res) => {
            const link = document.createElement('a');
            const url = window.URL.createObjectURL(new Blob([res.data]));
            link.href = url;
            link.download = 'report_diagnosis_'+id+'.pdf';
            link.click();
        }).catch((error)=>{
            let errors = {}
            errors.diagnosisError = "Echec de production du rapport de diagnostic."
            this.setState({errors});
            console.error("Failed to download report : ",error);
            e.stopPropagation();
        });
    }

    submitForm(e){
        e.preventDefault();
        const {profile,dossier,mileage,description,factors} = this.state;
        const isValid = this.validateForm();
        let errors = {};
        if(isValid){
            MaintenanceProxy
            .registrateDiagnosis({
                profile:profile,
                dossier:dossier,
                mileage:mileage,
                description:description,
                factors:factors
            })
            .then((res)=>{
                let diagnosis = res.data;
                this.setState({diagnosis});
            })
            .catch((error)=>{
                errors.diagnosisError = "Echec de la sauvegarde du diagnostic";
                this.setState({errors});
                console.error(errors.diagnosisError,error);
            });
        }else{
            errors.diagnosisError = "Il semble que les données soient corrompues";
            this.setState({errors});
            e.stopPropagation();
        }
    }

    render() {
        const {profile,dossier,mileage,description,errors,dossiers,diagnosis} = this.state;
        return (
            <form className="g-3 needs-validation was-validated" novalidate>
                {diagnosis ? 
                    <div class="container-fluid alert alert-success" role="alert">Succès de la sauvegarde du diagnostic. 
                        <button className="btn btn-sm bg-transparent" onClick={ (e) => this.printDiagnosis(e,diagnosis.id)}>
                            <img class="img-fluid" width="24" height="24" src="/assets/icon/ico-printer.PNG"/>
                        </button>
                    </div> 
                : null}
                {errors.diagnosisError ? <div class="container-fluid alert alert-danger" role="alert">{errors.diagnosisError}</div> : null}
                <fieldset className="row mt-3 mb-3">
                    <legend className="col-form-label fw-bold text-decoration-underline col-sm pt-0">Informations de diagnostic</legend>
                    <div className="container-fluid mt-2" id="diagnosis-info">
                        <form className="row g-3 needs-validation was-validated" novalidate>
                            <div className="form-floating col-md-2 col-sm-4">
                                <input name="profile" type="text" className="form-control" id="profile" placeholder="Technicien" value={profile} onChange={(e)=>this.changeValue(e)} required/>
                                <label htmlFor="profile">Technicien</label>
                                { errors.profileLength ? <div className="text-danger">{errors.profileLength}</div> : null }
                            </div>
                            <div className="form-floating col-md-2 col-sm-4">
                                <select name="dossier" className="form-select" id="dossier" placeholder="Dossier" value={dossier} onChange={(e)=>this.changeValue(e)} required>
                                    <option selected disabled value="">Choisir le dossier...</option>
                                    {dossiers.map(item => ( <option value={item.reference}>{item.automobile.number+"|"+item.client.name}</option>))}
                                </select>
                                <label htmlFor="name">Dossier</label>
                                { errors.dossierLength ? <div className="text-danger">{errors.dossierLength}</div> : null }
                            </div>
                            <div className="form-floating col-md-2 col-sm-4">
                                <input name="mileage" type="text" className="form-control" id="mileage" placeholder="Compteur" value={mileage} onChange={(e)=>this.changeValue(e)} required/>
                                <label htmlFor="mileage" className="form-label">Compteur</label>
                                { errors.mileageType ? <div className="text-danger">{errors.mileageType}</div> : null}
                            </div>
                            <div className="form-floating col-md-6 col-sm-12">
                                <input name="description" type="text" className="form-control" id="description" placeholder="Description" value={description} onChange={(e)=>this.changeValue(e)} required/>
                                <label htmlFor="description">Description</label>
                                { errors.descriptionLength ? <div className="text-danger">{errors.descriptionLength}</div> : null}
                            </div>
                        </form>
                    </div>
                </fieldset>
                { errors.factorsEmpty ? <div class="container-fluid alert alert-danger" role="alert">{errors.factorsEmpty}</div>: null}
                <Factor/>
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