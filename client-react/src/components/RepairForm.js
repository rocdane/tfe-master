import { Component } from "react";
import CustomerProxy from "../api/CustomerProxy";
import MaintenanceProxy from "../api/MaintenanceProxy";
import ReportProxy from "../api/ReportProxy";

const temp_tasks=[], temp_spares=[];

class Task extends Component{
    state = {
        description:"",
        cost:0,
        duration:0,
        tasks:[],
        errors:{}
    }

    remove(i){
        temp_tasks.splice(i, 1);
        this.setState({ tasks:temp_tasks });
    }

    change(e){
        this.setState({[e.target.name] : e.target.value});
    }

    validate(){
        const {description,cost,duration} = this.state;
        let isValid = true;
        const errors = {};

        if(description.trim().length < 2){
            errors.descriptionError = "Description de la tâche obligatoire.";
            isValid = false;
        }

        if(isNaN(cost) && cost.type<0){
            errors.costError = "Le coût est un nombre supérieur à 0.";
            isValid = false;
        }

        if(isNaN(duration) && duration<0){
            errors.durationError = "La durée est un nombre supérieure à 0.";
            isValid = false;
        }

        this.setState({errors});

        return isValid;
    }

    reset(){
        this.setState({description:"",cost:0,duration:0});
    }

    add(e){
        e.preventDefault();
        const isValid = this.validate();

        if(isValid){
            let task = {
                description:this.state.description,
                cost:this.state.cost,
                duration:this.state.duration
            };
    
            temp_tasks.push(task);

            this.setState({ tasks: temp_tasks});
            
            this.reset();
        }else{
            e.stopPropagation();
        }
    }

    render() {
        const {description,cost,duration,tasks,errors} = this.state;

        return (
            <fieldset className="row mt-3 mb-3">
                <legend className="col-form-label fw-bold text-decoration-underline col-sm-2 pt-0">Tâches de réparation</legend>
                <div className="container-fluid mt-2" id="task-container">
                    <form className="row g-3 needs-validation was-validated" novalidate>
                        {tasks.map((task,index)=>(
                            <div className="row mt-2 mb-2" key={index}>
                                <div className="col-md-7 col-sm-7">
                                    <input name="description" type="text" className="form-control" placeholder="Description" value={task.description||""}/>
                                </div>
                                <div className="col-md-2 col-sm-2">
                                    <input name="duration" type="text" className="form-control" placeholder="Durée" value={task.duration||""}/>
                                </div>
                                <div className="col-md-2 col-sm-2">
                                    <input name="cost" type="text" className="form-control" placeholder="Coût" value={task.cost||""}/>
                                </div>
                                <div className="col-md-1 col-sm-1 justify-content-center d-flex">
                                    <button className="btn btn-sm" onClick={() => this.remove(index)}>
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
                            <div className="form-floating col-md-7 col-sm-7">
                                <input name="description" type="text" className="form-control" id="description" placeholder="Description" value={description} onChange={(e)=>this.change(e)} required/>
                                <label htmlFor="description">Description</label>
                                { errors.descriptionError ? <div className="text-danger">{errors.descriptionError}</div> : null}
                            </div>
                            <div className="form-floating col-md-2 col-sm-2">
                                <input name="duration" type="text" className="form-control" id="duration" placeholder="Durée" value={duration} onChange={(e)=>this.change(e)} required/>
                                <label htmlFor="duration">Durée(Minute)</label>
                                { errors.durationError ? <div className="text-danger">{errors.durationError}</div> : null}
                            </div>
                            <div className="form-floating col-md-2 col-sm-2">
                                <input name="cost" type="text" className="form-control" id="cost" placeholder="Coût" value={cost} onChange={(e)=>this.change(e)} required/>
                                <label htmlFor="cost">Coût(Cfa)</label>
                                { errors.costError ? <div className="text-danger">{errors.costError}</div> : null}
                            </div>
                            <div className="col-md-1 col-sm-1 justify-content-center d-flex">
                                <button className="btn btn-sm bg-transparent" onClick={(e)=>this.add(e)}>
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

class Spare extends Component{
    state = {
        designation:"",
        price:0,
        amount:0,
        quantity:0,
        spares:[],
        errors:{}
    }

    remove(i){
        temp_spares.splice(i, 1);
        this.setState({ tasks:temp_spares});
    }

    change(e){
        this.setState({[e.target.name] : e.target.value});
    }

    validate(){
        const {designation,quantity,price,amount} = this.state;
        let isValid = true;
        const errors = {};

        if(designation.trim().length < 2){
            errors.designationError = "La désignation de la fourniture est obligatoire.";
            isValid = false;
        }

        if(isNaN(quantity) && quantity<=0){
            errors.quantityError = "La quantité est un nombre supérieur à 0.";
            isValid = false;
        }

        if(isNaN(price) && price<=0){
            errors.priceError = "Le prix est un nombre supérieure à 0.";
            isValid = false;
        }

        if(isNaN(amount) && amount<=0){
            errors.amountError = "Le montant est un nombre supérieure à 0.";
            isValid = false;
        }

        this.setState({errors});

        return isValid;
    }

    reset(){
        this.setState({designation:"",quantity:0,price:0,amount:0});
    }

    add(e){
        e.preventDefault();
        const isValid = this.validate();

        if(isValid){
            let spare = {
                designation:this.state.designation,
                quantity:this.state.quantity,
                price:this.state.price,
                amount:this.state.amount
            };
    
            temp_spares.push(spare);

            this.setState({ spares: temp_spares});
            
            this.reset();
        }else{
            e.stopPropagation();
        }
    }

    render() {
        const {designation,price,quantity,amount,spares,errors} = this.state;

        return (
            <fieldset className="row mb-3">
                <legend className="col-form-label fw-bold text-decoration-underline col-sm-2 pt-0">Fournitures de réparation</legend>
                <div className="container-fluid mt-2" id="spare-container">
                    <form className="row g-3 needs-validation was-validated" novalidate>
                        {spares.map((spare,index)=>(
                            <div className="row mt-2 mb-2" key={index}>
                                <div className="col-md-5 col-sm-5">
                                    <input name="designation" type="text" className="form-control" value={spare.designation||""}/>
                                </div>
                                <div className="col-md-2 col-sm-2">
                                    <input name="quantity" type="text" className="form-control" value={spare.quantity||""}/>
                                </div>
                                <div className="col-md-2 col-sm-2">
                                    <input name="price" type="text" className="form-control" value={spare.price||""}/>
                                </div>
                                <div className="col-md-2 col-sm-2">
                                    <input name="amount" type="text" className="form-control" value={spare.amount||""}/>
                                </div>
                                <div className="col-md-1 col-sm-1 justify-content-center d-flex">
                                    <button className="btn btn-sm" onClick={() => this.remove(index)}>
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
                            <div className="form-floating col-md-5 col-sm-5">
                                <input name="designation" type="text" className="form-control" id="designation" placeholder="Désignation" value={designation} onChange={(e)=>this.change(e)} required/>
                                <label htmlFor="designation">Désignation</label>
                                { errors.designationError ? <div className="text-danger">{errors.designationError}</div> : null}
                            </div>
                            <div className="form-floating col-md-2 col-sm-2">
                                <input name="quantity" type="text" className="form-control" id="quantity" placeholder="Quantité" value={quantity} onChange={(e)=>this.change(e)} required/>
                                <label htmlFor="quantity">Quantité</label>
                                { errors.quantityError ? <div className="text-danger">{errors.quantityError}</div> : null}
                            </div>
                            <div className="form-floating col-md-2 col-sm-2">
                                <input name="price" type="text" className="form-control" id="price" placeholder="Prix" value={price} onChange={(e)=>this.change(e)} required/>
                                <label htmlFor="price">Prix(Cfa)</label>
                                { errors.priceError ? <div className="text-danger">{errors.priceError}</div> : null}
                            </div>
                            <div className="form-floating col-md-2 col-sm-2">
                                <input name="amount" type="text" className="form-control" id="amount" placeholder="Montant" value={amount} onChange={(e)=>this.change(e)} required/>
                                <label htmlFor="amount">Montant(Cfa)</label>
                                { errors.amountError ? <div className="text-danger">{errors.amountError}</div> : null}
                            </div>
                            <div className="col-md-1 col-sm-1 justify-content-center d-flex">
                                <button className="btn btn-sm bg-transparent" onClick={(e)=>this.add(e)}>
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

export class RepairForm extends Component{

    state = {
        profile:"",
        dossier:"",
        mileage:0,
        description:"",
        spares:temp_spares,
        tasks:temp_tasks,
        dossiers:[],
        repair:null,
        errors:{}
    }

    componentDidMount(){
        CustomerProxy
            .getDossiers()
            .then((res) => {
                this.setState({ dossiers : res.data});
            }).catch((error) => {
                let errors = {repairError:"Impossible de charger les dossiers client."}
                this.setState({errors});
                console.error(errors.repairError,error);
            });
    }

    changeValue(e){
        this.setState({[e.target.name] : e.target.value});
        this.validateForm();
    }

    validateForm(){
        const {profile,dossier,mileage,description,spares,tasks} = this.state;
        let isValid = true;
        const errors = {};

        if(profile.trim().length < 2){
            errors.profileError = "Nom du technicien requis.";
            isValid = false;
        }

        if(dossier.trim() === ""){
            errors.dossierError = "Référence du dossier requis.";
            isValid = false;
        }

        if(isNaN(mileage) || mileage < 0){
            errors.mileageError = "Compteur est un nombre. Ex: 12345!";
            isValid = false;
        }

        if(description.trim().length < 2){
            errors.descriptionError = "Description du diagnostic requis.";
            isValid = false;
        }

        if(spares.length===0){
            errors.sparesEmpty = "Les fournitures de réparation sont obligatoires.";
            isValid = false;
        }

        if(tasks.length===0){
            errors.tasksEmpty = "Les tâches de réparation sont obligatoires.";
            isValid = false;
        }

        this.setState({errors});

        return isValid;
    }

    submitForm(e){
        e.preventDefault();
        const {profile,dossier,mileage,description,spares,tasks} = this.state;
        const isValid = this.validateForm();
        let errors = {};
        if(isValid){
            MaintenanceProxy
            .registrateRepair({
                profile:profile,
                dossier:dossier,
                mileage:mileage,
                description:description,
                spares:spares,
                tasks:tasks
            })
            .then((res)=>{
                let repair = res.data;
                this.setState({repair});
            }).catch((error)=>{
                errors.repairError = "Echec de la sauvegarde de la réparation";
                this.setState({errors});
                console.error(errors.repairError,error);
            });
        }else{
            errors.repairError = "Les données sont corrompues. Veuillez recommencer.";
            this.setState({errors});
            e.stopPropagation();
        }
    }

    printRepair(e,id){
        e.preventDefault();
        ReportProxy.reportRepair(id).then((res) => {
            const link = document.createElement('a');
            const url = window.URL.createObjectURL(new Blob([res.data]));
            link.href = url;
            link.download = 'report_repair_'+id+'.pdf';
            link.click();
        }).catch((error)=>{
            console.error("Failed to download report : ",error);
        });
    }

    render() {
        const {profile,dossier,mileage,description,dossiers,repair,errors} = this.state;

        return (
            <form className="row g-3 needs-validation was-validated">
                 {repair ? 
                    <div class="container-fluid alert alert-success" role="alert">Succès de la sauvegarde de la réparation. 
                        <button className="btn btn-sm bg-transparent" onClick={ (e) => this.printRepair(e,repair.id)}>
                            <img class="img-fluid" width="24" height="24" src="/assets/icon/ico-printer.PNG"/>
                        </button>
                    </div> 
                : null}
                {errors.repairError ? <div class="container-fluid alert alert-danger" role="alert">{errors.repairError}</div> : null}
                <div className="form-floating col-md-2 col-sm-4">
                    <input name="profile" type="text" className="form-control" id="profile" placeholder="Technicien" value={profile} onChange={(e)=>this.changeValue(e)} required/>
                    <label htmlFor="profile">Technicien</label>
                    { errors.profileError ? <div className="text-danger">{errors.profileError}</div> : null}
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
                    { errors.mileageError ? <div className="text-danger">{errors.mileageError}</div> : null}
                </div>
                <div className="form-floating col-md-6 col-sm-12">
                    <input name="description" type="text" className="form-control" id="description" placeholder="Description" value={description} onChange={(e)=>this.changeValue(e)} required/>
                    <label htmlFor="description">Description</label>
                    { errors.descriptionError ? <div className="text-danger">{errors.descriptionError}</div> : null}
                </div>
                { errors.tasksEmpty ? <div className="row text-danger">{errors.tasksEmpty}</div> : null}             
                <Task></Task>
                { errors.sparesEmpty ? <div className="row text-danger">{errors.sparesEmpty}</div> : null}
                <Spare></Spare>
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