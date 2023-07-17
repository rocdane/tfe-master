import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Header from '../components/Header';
import { AuthenticationProxy } from '../api/AuthenticationProxy';

function Authenticate() {
  const URL = "http://localhost:8001/authentication-service/signin";
  const authenticationProxy = new AuthenticationProxy();
  const navigate = useNavigate();
  let [username, setusername] = useState("");
  let [password, setpassword] = useState("");
  let [authenticated, setauthenticated] = useState(localStorage.getItem("authenticated") || false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    const spinner = document.getElementById("login-spinner"), 
    error = document.getElementById("login-failed");

    spinner.style.display = "inline-block";
    error.style.display = "none";

    const response = await authenticationProxy
      .signin({username:username, password:password});

    const session = response.data;
    
    if(session.closed===false){
      setauthenticated(true);
      localStorage.setItem("authenticated",authenticated);
      localStorage.setItem("token",session.token);
      navigate("/workspace");
    }else{
      spinner.style.display = "none";
      error.style.display = "block";
    }
  };
  
  useEffect(() => {
    const authenticated = localStorage.getItem("authenticated");
    if(authenticated){
      navigate("/workspace");
    }else{
      navigate("/authenticate");
    }
  },[]);

  return (
    <div className="App">
      <Header></Header>
      <div className="px-4 py-5 my-5 text-center">
          <h1 className="display-5 fw-bold text-body-emphasis">Contrôle d'accès</h1>
          <div className="row mt-4">
            <div className="col-md-6">
              <img 
                className="img-fluid"
                width="256"
                height="256"
                src="/logo.png"
              />
            </div>
            <div className="col-md-6 d-flex align-items-stretch align-middle bg-body-tertiary" id="authenticate-form">
              <div className="container-fluid mt-4">
                <div className="alert alert-danger" role="alert" id="login-failed">
                  Echec d'authentification !!! Utilisateur ou mot de passe erronée.
                </div>
                <form onSubmit={(e) => handleSubmit(e)}>
                  <div className="form-floating mb-3">
                      <input type="text" className="form-control" id="floatingInput" placeholder="Utilisateur" value={username} onChange={(e)=> setusername(e.target.value)}/>
                      <label for="floatingInput">Nom d'utilisateur</label>
                  </div>
                  <div className="form-floating mb-3">
                      <input type="password" className="form-control" id="floatingPassword" placeholder="Mot de passe" value={password} onChange={(e)=>setpassword(e.target.value)}/>
                      <label for="floatingPassword">Mot de passe</label>
                  </div>
                  <div>
                      <a className="mb-3" href="/register">Pas de compte ou Mot de passe oublié ?</a>
                  </div>
              
                  <button type="submit" className="btn btn-primary">
                      <span className="spinner-border spinner-border-sm" role="status" aria-hidden="true" id="login-spinner"></span>
                      Connexion
                  </button>
                </form>
              </div>
            </div>
          </div>
      </div>
    </div>
  );
}
  
export default Authenticate;