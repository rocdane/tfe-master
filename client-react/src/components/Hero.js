
function Hero(){
    return(
        <section id="cover">
            <div className="container-fluid d-block w-300" id="cover-content">
                <div className="px-4 py-5 my-5 d-block w-300 text-center">
                    <h1 className="display-5 fw-bold text-body-emphasis">LoGA</h1>
                    <div className="col-lg-6 mx-auto">
                        <p className="lead mb-4">Une solution pour la gestion des maintenances automobiles.</p>
                        <div className="d-grid gap-2 d-sm-flex justify-content-sm-center">
                            <a href="/#about" className="btn btn-primary btn-lg px-4 gap-3">En savoir plus</a>
                            <a href="/workspace" className="btn btn-outline-warning btn-lg px-4">Workspace</a>
                        </div>
                    </div>
                </div>
            </div>
        </section> 
    )
}

export default Hero;