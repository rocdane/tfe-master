import React from "react";

export default class CustomerForm extends React.Component{

    constructor(props){
        super(props);
    }

    render () {
        return(
            <form className="row g-3 needs-validation" novalidate>
                <div className="row container-fluid">
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <select name="typeClient" className="form-select" id="typeClient" required>
                            <option selected disabled value="">Type de client...</option>
                            <option value="HOMME">Homme</option>
                            <option value="FEMME">Femme</option>
                            <option value="ENTREPRISE">Entreprise</option>
                        </select>
                        <label htmlFor="typeClient">Type</label>
                        <div className="invalid-feedback">Chosissez le type de client !!!</div>
                    </div>
                    <div className="form-floating col-md-3 col-sm-6 mt-2 mb-2">
                        <input name="name" type="text" className="form-control" id="name" placeholder="Raison sociale" required/>
                        <label htmlFor="name">Raison Sociale</label>
                        <div className="invalid-feedback">Nom du client requis !!!</div>
                    </div>
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <input name="legalNotice" type="text" className="form-control" id="legalNotice" placeholder="Mention Légale" required/>
                        <label htmlFor="legalNotice">Mention Légale</label>
                        <div className="invalid-feedback">Mention légale du client requis !!! Ex: Profession | Statut</div>
                    </div>
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <input name="contact" type="text" className="form-control" id="contact" placeholder="Contact" required/>
                        <label htmlFor="contact">Contact</label>
                        <div className="invalid-feedback">Contact du client requis !!! Ex: Téléphone | Email</div>
                    </div>
                    <div className="form-floating col-md-3 col-sm mt-2 mb-2">
                        <input name="address" type="text" className="form-control" id="address" placeholder="Adresse" required/>
                        <label htmlFor="address">Adresse</label>
                        <div className="invalid-feedback">Adresse du client requise !!!</div>
                    </div>
                </div>
                <div className="row container-fluid mt-4">
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <input name="number" type="text" className="form-control" id="number" placeholder="Immatriculation" required/>
                        <label htmlFor="number">Immatriculation</label>
                        <div className="invalid-feedback">Immatriculation de l'automobile requise !!!</div>
                    </div>
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <input name="vin" type="text" className="form-control" id="vin" placeholder="Chassis" required/>
                        <label htmlFor="vin">Chassis</label>
                        <div className="invalid-feedback">Numéro chassis de l'automobile requis !!!</div>
                    </div>
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <input name="make" type="text" className="form-control" id="make" placeholder="Marque" required/>
                        <label htmlFor="make">Marque</label>
                        <div className="invalid-feedback">Marque de l'automobile requise !!!</div>
                    </div>
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <input name="model" type="text" className="form-control" id="model" placeholder="Modèle" required/>
                        <label htmlFor="model">Modèle</label>
                        <div className="invalid-feedback">Modèle de l'automobile requis !!!</div>
                    </div>
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <select name="unit" className="form-select" id="unit" placeholder="Unit" required>
                            <option selected disabled value="">Unité du compteur ...</option>
                            <option value="Km">Kilomètre</option>
                            <option value="Mi">Miles</option>
                        </select>
                        <label htmlFor="unit">Unité</label>
                        <div className="invalid-feedback">Unité de mesure requise !!! Ex: Kilomètre | Miles</div>
                    </div>
                    <div className="form-floating col-md-2 col-sm-6 mt-2 mb-2">
                        <input name="trim" type="text" className="form-control" id="trim" placeholder="Compteur" required/>
                        <label htmlFor="trim">Compteur</label>
                        <div className="invalid-feedback">Valeur du compteur de l'automobile requise !!!</div>
                    </div>
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