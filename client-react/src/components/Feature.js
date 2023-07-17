function Feature(){
    return (
        <section id="feature">
            <div className="container-fluid px-4 py-5" id="marketing-content">
                <h1 className="display-5 fw-bold text-body-emphasis">Fonctionnalités</h1>

                <div className="row g-4 py-5 row-cols-1 row-cols-lg-4">
                    <div className="feature col">
                        <div className="text-center px-3 py-3 mx-auto">
                            <img 
                                className="img-fluid img-thumbnail"
                                width="128"
                                height="128"
                                src="/assets/img/client.png"
                            />
                        </div>
                        
                        <h2 className="text-uppercase">Client</h2>
                        <p className="text-capitalize">Gestion informatisée des informations clients</p>
                    </div>
                    <div className="feature col">
                    <   div className="text-center px-3 py-3 mx-auto">
                            <img 
                                className="img-fluid img-thumbnail"
                                width="128"
                                height="128"
                                src="/assets/img/reparation.png"
                            />
                        </div>
                        <h2 className="text-uppercase">Maintenance</h2>
                        <p className="text-capitalize">Gestion informatisée des informations de maintenance</p>
                    </div>
                    <div className="feature col">
                        <div className="text-center px-3 py-3 mx-auto">
                            <img 
                                className="img-fluid img-thumbnail"
                                width="128"
                                height="128"
                                src="/assets/img/ia.png"
                            />
                        </div>
                        <h2 className="text-uppercase">Intelligence</h2>
                        <p className="text-capitalize">Service intelligent d'Aide au diagnostic automobile</p>
                    </div>
                    <div className="feature col">
                        <div className="text-center px-3 py-3 mx-auto">
                            <img 
                                className="img-fluid img-thumbnail"
                                width="128"
                                height="128"
                                src="/assets/img/monitoring.png"
                            />
                        </div>
                        <h2 className="text-uppercase">Monitoring</h2>
                        <p className="text-capitalize">Monitoring et reporting des informations de gestion</p>
                    </div>
                </div>
            </div>
        </section>
    );
}

export default Feature;