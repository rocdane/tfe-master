function RepairList() {
    return(
        <table className="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Dossier</th>
                    <th scope="col">Référence</th>
                    <th scope="col">Description</th>
                    <th scope="col">Odomètre</th>
                    <th scope="col">Technicien</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Dossier</td>
                    <td>Référence</td>
                    <td>Description</td>
                    <td>260234</td>
                    <td>Technicien</td>
                    <td className="d-flex justify-content-center">
                        <button className="btn btn-sm bg-transparent">
                            <img 
                            className="img-fluid"
                            width="24"
                            height="24 em"
                            src="/assets/icon/ico-printer.PNG"
                            />
                        </button>   
                        <button className="btn btn-sm bg-transparent">
                            <img 
                            className="img-fluid"
                            width="24 em"
                            height="24 em"
                            src="/assets/icon/ico-delete.PNG"
                            />
                        </button>   
                    </td>
                </tr>
            </tbody>
        </table>
    );
}

export default RepairList;