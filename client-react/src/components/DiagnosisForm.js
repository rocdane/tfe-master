import React, { Component, createElement, useState } from "react";
import { createPortal } from 'react-dom';
import { Factor } from "./Factor";
import { ReactDOM } from "react";

export class DiagnosisForm extends Component{

    factors = [];
    
    form = {
        entity:"",
        dysfunction:"",
        maintenance:""
    };

    constructor(props){
        super(props);

        this.state = {
            diagnosis: {
                profile:"",
                dossier:"",
                mileage:0,
                description:"",
                factors:[]
            }
        }

        this.setProfile = this.setProfile.bind(this);
        this.setDossier = this.setDossier.bind(this);
        this.setMileage = this.setMileage.bind(this);
        this.setDescription = this.setDescription.bind(this);
        this.setEntity = this.setEntity.bind(this);
        this.setDysfunction = this.setDysfunction.bind(this);
        this.setMaintenance = this.setMaintenance.bind(this);
        this.resetForm = this.resetForm.bind(this);
        this.addFactor = this.addFactor.bind(this);
    }

    componentDidMount(){
        
    }

    setProfile(event){
        event.preventDefault();
        this.state.diagnosis.profile=event.target.value;
    }

    setDossier(event){
        event.preventDefault();
        this.state.diagnosis.dossier=event.target.value;
    }

    setMileage(event){
        event.preventDefault();
        this.state.diagnosis.mileage=event.target.value;
    }

    setDescription(event){
        event.preventDefault();
        this.state.diagnosis.description=event.target.value;
    }

    setEntity(event){
        event.preventDefault();
        this.form.entity = event.target.value;
    }

    setDysfunction(event){
        event.preventDefault();
        this.form.dysfunction = event.target.value;
    }

    setMaintenance(event){
        event.preventDefault();
        this.form.maintenance = event.target.value;
    }

    resetForm(){
        this.form.entity = "";
        this.form.dysfunction = "";
        this.form.maintenance = "";
    }

    addFactor(e){
        e.preventDefault();
        
        const container = document.getElementById("factor-container");

        const factor = {
            entity:this.form.entity,
            dysfunction:this.form.dysfunction,
            maintenance:this.form.maintenance
        }

        this.factors.push(factor);

        alert(JSON.stringify(this.factors));

        //const factor = <Factor entity={this.state.form.entity} dysfunction={this.state.form.dysfunction} maintenance={this.state.form.maintenance} />

        //createPortal=(factor,container);
        //container.appendChild(factor);
    }

    submitForm(event){
        event.preventDefault();

        this.state.factors = this.factors;

        alert(JSON.stringify(this.state.diagnosis));
    }

    render() {
        return (
            <form className="row g-3 needs-validation">
                <div className="form-floating col-md-2 col-sm-4">
                    <input name="profile" type="text" className="form-control" id="profile" placeholder="Technicien" onChange={(e)=>this.setProfile(e)} required/>
                    <label htmlFor="profile">Technicien</label>
                    <div className="valid-feedback">Technicien requis</div>
                </div>
                <div className="form-floating col-md-2 col-sm-4">
                    <input name="dossier" type="text" className="form-control" id="dossier" placeholder="Dossier" onChange={(e)=>this.setDossier(e)} required/>
                    <label htmlFor="dossier">Dossier</label>
                    <div className="valid-feedback">Dossier requis !!!</div>
                </div>
                <div className="form-floating col-md-2 col-sm-4">
                    <input name="mileage" type="text" className="form-control" id="mileage" placeholder="Compteur" onChange={(e)=>this.setMileage(e)} required/>
                    <label htmlFor="mileage" className="form-label">Compteur</label>
                    <div className="invalid-feedback">Valeur compteur requis !!!</div>
                </div>
                <div className="form-floating col-md-6 col-sm-12">
                    <input name="description" type="text" className="form-control" id="description" placeholder="Description" onChange={(e)=>this.setDescription(e)} required/>
                    <label htmlFor="description">Description</label>
                    <div className="invalid-feedback">Description requis !!!</div>
                </div>
                <fieldset className="row mt-3 mb-3">
                    <legend className="col-form-label fw-bold text-decoration-underline col-sm-2 pt-0">Facteurs de diagnostic</legend>
                    <div className="container-fluid mt-2" id="factor-container">
                        <div className="row mt-2 mb-2 bg-body-secondary">
                            <div className="form-floating col-md-3 col-sm-3">
                                <select name="entity" className="form-select" id="entity" aria-label="Default select example" onChange={(e)=>this.setEntity(e)} required>
                                    <option value="Système de direction">Direction</option>
                                    <option value="Système de freinage">Freinage</option>
                                    <option value="Système de motorisation">Motorisation</option>
                                    <option value="Système de suspension">Suspension</option>
                                    <option value="Système de transmission">Transmission</option>
                                </select>
                                <label htmlFor="entity">Entité</label>
                                <div className="invalid-feedback">Entité requise !!!</div>
                            </div>
                            <div className="form-floating col-md-4 col-sm-4">
                                <input name="dysfunction" type="text" className="form-control" id="dysfunction" placeholder="Dysfonctionnement" onChange={(e)=>this.setDysfunction(e)}/>
                                <label htmlFor="dysfunction">Dysfonctionnement</label>
                                <div className="invalid-feedback">Dysfonctionnement requis !!!</div>
                            </div>
                            <div className="form-floating col-md-4 col-sm-4">
                                <input name="maintenance" type="text" className="form-control" id="maintenance" placeholder="Maintenance" onChange={(e)=>this.setMaintenance(e)}/>
                                <label htmlFor="maintenance">Maintenance</label>
                                <div className="invalid-feedback">Maintenance requise !!!</div>
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
                    </div>
                </fieldset>
                
                <div className="row container-fluid d-flex justify-content-between mt-4 mb-2">
                    <button className="btn btn-sm col" type="submit" onClick={(e)=>this.submitForm(e)}>
                        <img 
                        className="img-fluid"
                        width="32"
                        height="32"
                        src="/assets/icon/ico-save.PNG"
                        />
                    </button>
                    <button className="btn btn-sm col" type="cancel">
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