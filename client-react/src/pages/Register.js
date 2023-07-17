import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Header from '../components/Header';

function Register() {

  const navigate = useNavigate();
  const [username, setusername] = useState("");
  const [email, setemail] = useState("");
  const [password, setpassword] = useState("");
  const [confirmedPassword, setconfirmedpassword] = useState("");
  const [authenticated, setauthenticated] = useState(null);
  const users = [{username:"admin", password:"secret"}];
  const handleSubmit = (e) => {
    e.preventDefault();

    const spinner = document.getElementById("register-spinner"), 
    error = document.getElementById("register-failed");

    spinner.style.display = "inline-block";
    error.style.display = "none";

    const session = users.find((user) => user.username === username);
    
    if(session && session.password === password){
        setauthenticated(true)
        localStorage.setItem("authenticated", true);
        navigate("/workspace")
    }else{
        spinner.style.display = "none";
        error.style.display = "block";
    }
  };
  
  useEffect(() => {
    const session = localStorage.getItem("authenticated");
    if(session){
      setauthenticated(session);
      navigate("/workspace");
    }
  },[]);

  return (
    <div className="App">
        <Header></Header>
        <div className="px-4 py-5 my-5 text-center">
            <h1 className="display-5 fw-bold text-body-emphasis">Enregistrement d'informations d'accès</h1>
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
                        <div className="alert alert-danger" role="alert" id="register-failed">
                            Echec d'enregistrement !!! Vérifiez les informations que vous entrez.
                        </div>
                        <form onSubmit={handleSubmit}>
                            <div className="form-floating mb-3">
                                <input type="text" className="form-control" id="floatingInput" placeholder="Utilisateur" value={username} onChange={(e)=> setusername(e.target.value)}/>
                                <label for="floatingInput">Nom d'utilisateur</label>
                            </div>
                            <div className="form-floating mb-3">
                                <input type="email" className="form-control" id="floatingInput" placeholder="Email" value={email} onChange={(e)=> setemail(e.target.value)}/>
                                <label for="floatingInput">Email</label>
                            </div>
                            <div className="form-floating mb-3">
                                <input type="password" className="form-control" id="floatingPassword" placeholder="Mot de passe" value={password} onChange={(e)=>setpassword(e.target.value)}/>
                                <label for="floatingPassword">Mot de passe</label>
                            </div>
                            <div className="form-floating mb-3">
                                <input type="password" className="form-control" id="floatingPassword" placeholder="Confirmation du mot de passe" value={confirmedPassword} onChange={(e)=>setconfirmedpassword(e.target.value)}/>
                                <label for="floatingPassword">Confirmation du mot de passe</label>
                            </div>
                            <div>
                                <a className="mb-3" href="/authenticate">J'ai un compte</a>
                            </div>
                        
                            <button type="submit" className="btn btn-primary">
                                <span className="spinner-border spinner-border-sm" role="status" aria-hidden="true" id="register-spinner"></span>
                                Appliquer
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
  );
}
  
export default Register;