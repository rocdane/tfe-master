import React from "react";

export class AutomobileForm extends React.Component{
    
    constructor(props){
        super(props)
    }

    render () {
        return(
            <form className="row g-3 needs-validation" novalidate>
                <div className="form-floating col-md-12 col-sm-12">
                    <select name="typeClient" className="form-select" id="typeClient" placeholder="Client" required>
                        <option selected disabled value="">Choisir le client...</option>
                        <option value="HOMME">Homme</option>
                    </select>
                    <label htmlFor="typeClient">Client</label>
                    <div className="invalid-feedback">Chosissez le client !!!</div>
                </div>
                
                <div className="form-floating col-md-2 col-sm-6">
                    <input name="number" type="text" className="form-control" id="number" placeholder="Immatriculation" required/>
                    <label htmlFor="number">Immatriculation</label>
                    <div className="invalid-feedback">Immatriculation de l'automobile requise !!!</div>
                </div>
                <div className="form-floating col-md-2 col-sm-6">
                    <input name="vin" type="text" className="form-control" id="vin" placeholder="Chassis" required/>
                    <label htmlFor="vin">Chassis</label>
                    <div className="invalid-feedback">Numéro chassis de l'automobile requis !!!</div>
                </div>
                <div className="form-floating col-md-2 col-sm-6">
                    <input name="make" type="text" className="form-control" id="make" placeholder="Marque" required/>
                    <label htmlFor="make">Marque</label>
                    <div className="invalid-feedback">Marque de l'automobile requise !!!</div>
                </div>
                <div className="form-floating col-md-2 col-sm-6">
                    <input name="model" type="text" className="form-control" id="model" placeholder="Modèle" required/>
                    <label htmlFor="model">Modèle</label>
                    <div className="invalid-feedback">Modèle de l'automobile requis !!!</div>
                </div>
                <div className="form-floating col-md-2 col-sm-6">
                    <select name="unit" className="form-select" id="unit" placeholder="Unité" required>
                        <option selected disabled>Unité du compteur ...</option>
                        <option value="Km">Kilomètre</option>
                        <option value="Mi">Miles</option>
                    </select>
                    <label htmlFor="unit">Unité</label>
                    <div className="invalid-feedback">Chosissez l'unité de mesure du compteur !!!</div>
                </div>
                <div className="form-floating col-md-2 col-sm-6">
                    <input name="trim" type="text" className="form-control" id="trim" placeholder="Compteur" required/>
                    <label htmlFor="trim" className="form-label">Compteur</label>
                    <div className="invalid-feedback">Valeur du compteur de l'automobile requise !!!</div>
                </div>
                <div className="row container-fluid d-flex justify-content-around mt-4 mb-2">
                    <button className="btn btn-sm col" type="submit">
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