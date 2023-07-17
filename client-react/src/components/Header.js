function Header(){

    return(
        <header className="px-3 py-3 mb-4" id="header">
            <nav className="navbar text-white fixed-top bg-body-tertiary">
                <div className="container-fluid">
                    <button className="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#menu" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="offcanvas offcanvas-start" tabindex="-1" id="menu" aria-labelledby="offcanvasNavbarLabel">
                        <div className="offcanvas-header">
                            <h5 className="offcanvas-title" id="offcanvasNavbarLabel">LoGA</h5>
                            <button type="button" className="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                        </div>
                        <div className="offcanvas-body">
                            <ul className="navbar-nav justify-content-end flex-grow-1 pe-3">
                                <li className="nav-item">
                                    <a className="nav-link active" aria-current="cover" href="/#cover">Accueil</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="/#about">A propos</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="/#feature">Fonctionnalités</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="/#perspective">Perspectives</a>
                                </li>
                            </ul>
                        </div>
                        <div className="offcanvas-footer">
                            <p className="text-center text-body-secondary"><a href="/legal" className="nav-link px-2 text-body-secondary">Mentions légales</a> Copyright © {(new Date).getFullYear()} N2A.CC - Tous droits réservés</p>
                        </div> 
                    </div>
                    <a className="navbar-brand" href="/">
                        <img
                            alt=""
                            src="/logo.png"
                            width="48"
                            height="48"
                            className="d-inline-block align-top"
                        />{' '}
                    </a>
                    <a className="btn btn-warning" href="/authenticate">Workspace</a>
                </div>
            </nav>
        </header>
    );
}

export default Header;