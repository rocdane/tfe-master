import Header from '../components/Header';

function NotFound() {
    return (
      <div className="App">
        <Header></Header>
        <div className="px-4 py-5 my-5 text-center">
            <h1 className="display-5 fw-bold text-body-emphasis">404</h1>
            <div className="col-lg-6 mx-auto">
                <p className="lead mb-4">La page que vous demandez est introuvable. Cliquez sur le bouton ci-dessous pour retourner à l'accueil.</p>
                <div className="d-grid gap-2 d-sm-flex justify-content-sm-center">
                    <a href="/" className="btn btn-outline-secondary btn-lg px-4">Accueil</a>
                </div>
            </div>
        </div>
      </div>
    );
  }
  
  export default NotFound;