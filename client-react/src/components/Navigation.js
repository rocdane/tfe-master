import { useNavigate } from "react-router-dom";
import { ReactDOM } from "react";
import { AuthenticationProxy } from "../api/AuthenticationProxy";

function Navigation(){

    const navigate = useNavigate();
    const authenticationProxy = new AuthenticationProxy();

    const logout = async (e) => {
        e.preventDefault();
        let token = localStorage.getItem("token");
        console.info(token);
        await authenticationProxy
            .signout(token)
                .then(res => {
                    console.log(res.status);
                })
                .catch((error) => {
                    console.error(error);
                });
        localStorage.removeItem("authenticated");
        localStorage.removeItem("token");
        navigate("/authenticate");
    }

    return(
        <nav className="navbar navbar-expand bg-body-tertiary sticky-top">
            <div className="container-fluid d-flex justify-content-around">
                <a className="nav-link" aria-current="page" href="/">
                    <img 
                        className="img-fluid"
                        width="24"
                        height="24"
                        src="/assets/icon/ico-home.PNG"
                    />
                </a>
                <a className="nav-link active" aria-current="page" href="/workspace" id="dashboard">
                    <img 
                    className="img-fluid"
                    width="32"
                    height="32"
                    src="/assets/icon/ico-dashboard.png"
                    />
                </a>
                <a className="nav-link" href="/customer" id="customer">
                    <img 
                    className="img-fluid"
                    width="32"
                    height="32"
                    src="/assets/img/dossier.png"
                    />
                </a>
                <a className="nav-link" href="/maintenance" id="maintenance">
                    <img 
                    className="img-fluid"
                    width="32"
                    height="32"
                    src="/assets/icon/service.png"
                    />
                </a>
                <a className="nav-link" href="#" onClick={logout}>
                    <img 
                        className="img-fluid"
                        width="32"
                        height="32"
                        src="/assets/icon/ico-logout.png"
                    />
                </a>
            </div>
        </nav>
    );
}

export default Navigation;