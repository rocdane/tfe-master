import Header from "../components/Header";

function Legal(){
    const notice = {
        'editor':{
            'name':'N2A.CC',
            'legal':'ESN',
            'turnover':'1.000.000 FCFA',
            'address':'Godomey-Togoudo, Abomey-Calavi, Atlantique, Bénin',
            'register':'RCCM',
            'number':'1201700578707',
            'phone':'(+229) 97947325',
            'email':'support@n2a.cc',
            'publisher':'N2A.CC'
        },
        'validity':'1 An'
    }
    
    return(
        <div className="App">
            <Header></Header>
            <div className="container-fluid d-flext text-start px-4 py-5 my-5">
            <>
                <h1>Mentions légales</h1>
                <p className="">Les mentions légales sont une obligation pour tous les sites internet édités par des particuliers ou des professionnels. Elles permettent de garantir la transparence et la légalité de la plateforme.</p>
            </>
            <> 
                <h2>Editeur du site</h2>
                <p className="">
                    Le présent site est édité par {notice.editor.name}, {notice.editor.legal} au capital de {notice.editor.turnover}, dont le siège social est situé à {notice.editor.address}, immatriculée au {notice.editor.register} sous le numéro {notice.editor.number}.
                </p>
                <p className="">Téléphone : {notice.editor.phone}</p>
                <p className="">Adresse e-mail : {notice.editor.email}</p>
                <p className="">Directeur de la publication : {notice.editor.publisher}</p>
            </>
            <> 
                <h2>Propriété intellectuelle</h2>
                <p className="">
                    Le contenu du présent site (structure, design, texte, images, animations, logos, marques, etc.) est la propriété exclusive de {notice.editor.name}, à l'exception des éléments émanant de partenaires ou clients de l'éditeur. Toute reproduction, représentation, modification, publication, transmission ou dénaturation, totale ou partielle du site ou de son contenu, par quelque procédé que ce soit, et sur quelque support que ce soit est interdite.
                </p>
            </>
            <> 
                <h2>Données personnelles</h2>
                <p className="">
                    Les informations recueillies sur le site font l'objet d'un traitement informatique destiné à répondre aux demandes des utilisateurs. Les données collectées seront conservées pendant une durée de {notice.validity}. Conformément à la loi "Informatique et libertés" du 6 janvier 1978 modifiée en 2018 et au Règlement Général sur la Protection des Données (RGPD), vous disposez d'un droit d'accès, de rectification, d'effacement, de limitation, de portabilité et d'opposition aux données vous concernant. Vous pouvez exercer ces droits en contactant {notice.editor.publisher} par e-mail à l'adresse {notice.editor.email}
                </p>
            </>
            <> 
                <h2>Cookies</h2>
                <p className="">
                    Le présent site utilise des cookies. Un cookie est un fichier texte susceptible d'être enregistré sur votre terminal à l'occasion de votre consultation d'un site internet. Les cookies sont utilisés pour améliorer les fonctionnalités et l'expérience utilisateur du site. Vous pouvez à tout moment refuser l'utilisation des cookies en configurant les paramètres de votre navigateur.
                </p>
            </>
            <> 
                <h2>Loi applicable et juridiction compétente</h2>
                <p className="">
                    Le présent site est soumis à la loi béninoise. En cas de litige, les tribunaux béninois seront seuls compétents.
                </p>
            </>
        </div>
        </div>
        
    );
}

export default Legal;