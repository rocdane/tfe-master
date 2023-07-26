import { Component } from "react";

export class Modal extends Component{

    constructor(props){
        
        super(props);

        this.state = {
            title:props.title,
            alert:props.alert,
            message:props.message,
            action:props.action
        }
    }

    componentDidMount(){
        /*const btn = window.document.createElement('a');
        btn.setAttribute("data-bs-target","#modal");
        btn.setAttribute("data-bs-toggle","modal");
        btn.click();*/
    }

    render() {                       
        
        const {title,message,alert,action} = this.state;

        return (
            <div class="modal fade show" id="modal" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="modalLabel">{title}</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class={`alert alert-${alert}`} role="alert">
                                {message}
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" onClick={action}>Ok</button>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}