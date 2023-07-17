import { Component } from "react";

export class RepairForm extends Component{

    render() {
        return (
            <form className="row g-3 needs-validation">
                <div className="form-floating col-md-2 col-sm-4">
                    <input name="profile" type="text" className="form-control" id="profile" placeholder="Technicien" required/>
                    <label htmlFor="profile">Technicien</label>
                    <div className="valid-feedback">Technicien requis</div>
                </div>
                <div className="form-floating col-md-2 col-sm-4">
                    <input name="dossier" type="text" className="form-control" id="dossier" placeholder="Dossier" required/>
                    <label htmlFor="dossier">Dossier</label>
                    <div className="valid-feedback">Dossier requis !!!</div>
                </div>
                <div className="form-floating col-md-2 col-sm-4">
                    <input name="mileage" type="text" className="form-control" id="mileage" placeholder="Compteur" required/>
                    <label htmlFor="mileage" className="form-label">Compteur</label>
                    <div className="invalid-feedback">Valeur compteur requis !!!</div>
                </div>
                <div className="form-floating col-md-6 col-sm-12">
                    <input name="description" type="text" className="form-control" id="description" placeholder="Description" required/>
                    <label htmlFor="description">Description</label>
                    <div className="invalid-feedback">Description requis !!!</div>
                </div>
                <fieldset className="row mt-3 mb-3">
                    <legend className="col-form-label fw-bold text-decoration-underline col-sm-2 pt-0">Tâches de réparation</legend>
                    <div className="container-fluid mt-2" id="task-container">
                        <div className="row mt-2 mb-2 bg-body-secondary">
                            <div className="form-floating col-md-7 col-sm-7">
                                <input name="task_description" type="text" className="form-control" id="task_description" placeholder="Description" required/>
                                <label htmlFor="task_description">Description</label>
                                <div className="invalid-feedback">Description requise !!!</div>
                            </div>
                            <div className="form-floating col-md-2 col-sm-2">
                                <input name="task_duration" type="text" className="form-control" id="task_duration" placeholder="Durée" required/>
                                <label htmlFor="task_duration">Durée</label>
                                <div className="invalid-feedback">Durée requise !!!</div>
                            </div>
                            <div className="form-floating col-md-2 col-sm-2">
                                <input name="task_cost" type="text" className="form-control" id="task_cost" placeholder="Coût" required/>
                                <label htmlFor="task_cost">Coût</label>
                                <div className="invalid-feedback">Coût requis !!!</div>
                            </div>
                            <div className="col-md-1 col-sm-1 justify-content-center d-flex">
                                <button className="btn btn-sm bg-transparent">
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
                
                <fieldset className="row mb-3">
                    <legend className="col-form-label fw-bold text-decoration-underline col-sm-2 pt-0">Fournitures de réparation</legend>
                    <div className="container-fluid mt-2" id="spare-container">
                        <div className="row mt-2 mb-2 bg-body-secondary">
                            <div className="form-floating col-md-5 col-sm-5">
                                <input name="spare_designation" type="text" className="form-control" id="spare_designation" placeholder="Désignation" required/>
                                <label htmlFor="spare_designation">Désignation</label>
                                <div className="invalid-feedback">Désignation requise !!!</div>
                            </div>
                            <div className="form-floating col-md-2 col-sm-2">
                                <input name="spare_quantity" type="text" className="form-control" id="spare_quantity" placeholder="Quantité" required/>
                                <label htmlFor="spare_quantity">Quantité</label>
                                <div className="invalid-feedback">Quantité requis !!!</div>
                            </div>
                            <div className="form-floating col-md-2 col-sm-2">
                                <input name="spare_price" type="text" className="form-control" id="spare_price" placeholder="Prix" required/>
                                <label htmlFor="spare_price">Prix</label>
                                <div className="invalid-feedback">Prix requis !!!</div>
                            </div>
                            <div className="form-floating col-md-2 col-sm-2">
                                <input name="spare_amount" type="text" className="form-control" id="spare_amount" placeholder="Montant" required/>
                                <label htmlFor="spare_amount">Montant</label>
                                <div className="invalid-feedback">Montant requis !!!</div>
                            </div>
                            <div className="col-md-1 col-sm-1 justify-content-center d-flex">
                                <button className="btn btn-sm bg-transparent">
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