function Footer(){
    return(
        <footer className="py-3 my-4" id="footer">
            <ul className="nav justify-content-center border-bottom pb-3 mb-3">
                <li className="nav-item"><a href="#cover" className="nav-link px-2 text-body-secondary">Accueil</a></li>
                <li className="nav-item"><a href="#about" className="nav-link px-2 text-body-secondary">A Propos</a></li>
                <li className="nav-item"><a href="#feature" className="nav-link px-2 text-body-secondary">Fonctionnalités</a></li>
                <li className="nav-item"><a href="#perspective" className="nav-link px-2 text-body-secondary">Perspectives</a></li>
            </ul>
            <p className="text-center text-body-secondary"><a href="/legal" className="nav-link px-2 text-body-secondary">Mentions légales</a> Copyright © {(new Date).getFullYear()} .CC - Tous droits réservés</p>
        </footer>
    );
}

export default Footer;