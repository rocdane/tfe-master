package startup.loga.client.controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import startup.loga.client.model.*;
import startup.loga.client.view.AlertConfirm;
import startup.loga.client.view.AlertError;
import startup.loga.client.view.AlertInfo;
import startup.loga.client.view.Popup;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable
{
    Atelier currentAtelier;
    Space currentEspace;
    Position currentTitre;
    Department currentService;

    @FXML
    private AnchorPane content;

    @FXML
    private TextField f_username;

    @FXML
    private PasswordField f_password;

    @FXML
    private ComboBox<Role> f_role;

    @FXML
    private TextField f_id;

    @FXML
    private TableView<User> table_users;

    @FXML
    private TableColumn<User, Long> t_id;

    @FXML
    private TableColumn<User, String> t_username;

    @FXML
    private TableColumn<User, String> t_password;

    @FXML
    private TableColumn<User, String> t_role;

    @FXML
    private Tab tab_settings;

    @FXML
    private TextField atelier_raison_sociale;

    @FXML
    private TextField atelier_adresse;

    @FXML
    private TextField atelier_contact;

    @FXML
    private TextField atelier_mention_legale;

    @FXML
    private TextField code_espace;

    @FXML
    private TextField intitule_espace;

    @FXML
    private TableView<Space> table_espace;

    @FXML
    private TableColumn<Space, Long> espace_id;

    @FXML
    private TableColumn<Space, String> espace_code;

    @FXML
    private TableColumn<Space, String> espace_intitule;

    @FXML
    private TextField designation_service;

    @FXML
    private TableView<Department> table_service;

    @FXML
    private TableColumn<Department, Long> service_id;

    @FXML
    private TableColumn<Department, String> service_designation;

    @FXML
    private TextField designation_titre;

    @FXML
    private TableView<Position> table_titre;

    @FXML
    private TableColumn<Position, Long> titre_id;

    @FXML
    private TableColumn<Position, String> titre_designation;

    @FXML
    void cancel(ActionEvent event) {
        f_id.setText("");
        f_username.setText("");
        f_password.setText("");
    }

    @FXML
    void delete(ActionEvent event) {
        try {
            //TODO: delete user from controller
            // Manage.getInstance().supprimerUtilisateur(table_users.getSelectionModel().getSelectedItem());
            AlertInfo.getInstance().setHeaderText("Succès d'archivage !!!");
            AlertInfo.getInstance().setContentText("Utilisateur supprimé avec succès.");
            AlertInfo.getInstance().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        read();
    }

    @FXML
    void save(ActionEvent event) {

        if (f_username.getText().equals("") || f_password.getText().equals("")) {
            AlertError.getInstance().setHeaderText("Informations incomplètes");
            AlertError.getInstance().setContentText("Vous n'avez pas saisies toutes les informations.");
            AlertError.getInstance().show();
        }
        else {
            User user = new User("","");
            if (f_id.getText().equals("")) {
                try {
                    //todo:user = authenticationController.register(registrateRequest);
                    AlertInfo.getInstance().setHeaderText("Succès d'enregistrement !!!");
                    AlertInfo.getInstance().setContentText("Utilisateur enregistré avec succès.");
                    AlertInfo.getInstance().show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                user.setId(Long.parseLong(f_id.getText().trim()));
                try {
                    //todo:authenticationController.register(registrateRequest);
                    AlertInfo.getInstance().setHeaderText("Succès de mise à jour !!!");
                    AlertInfo.getInstance().setContentText("Utilisateur mis à jour avec succès.");
                    AlertInfo.getInstance().show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        read();
    }

    @FXML
    void annuler_espace(ActionEvent event) {
        if(currentEspace!=null){
            AlertConfirm.getInstance().setHeaderText("Space de travail");
            AlertConfirm.getInstance().setContentText("Voulez-vous supprimer cet Space de réparation ?");
            if(AlertConfirm.getInstance().getButtonTypes().equals(ButtonType.OK)){
                try {
                    //todo:manageResourceService.deleteSpace(currentEspace.getId());
                } catch (Exception e) {
                    AlertError.getInstance().setHeaderText("Space de travail");
                    AlertError.getInstance().setContentText("Echec lors de la suppression de l'Space de travail\n"+e.getMessage());
                    AlertError.getInstance().showAndWait();
                    e.printStackTrace();
                }
            }else{
                event.consume();
            }
        }
        readEspace();
        refresh();
    }

    @FXML
    void annuler_service(ActionEvent event) {
        if(currentService!=null){
            AlertConfirm.getInstance().setHeaderText("Department de l'entreprise");
            AlertConfirm.getInstance().setContentText("Voulez-vous supprimer ce Department de votre entreprise ?");
            if(AlertConfirm.getInstance().getButtonTypes().equals(ButtonType.OK)){
                try {
                    //todo:manageGarageService.deleteDepartment(currentService.getId());
                } catch (Exception e) {
                    AlertError.getInstance().setHeaderText("Department de l'entreprise");
                    AlertError.getInstance().setContentText("Echec lors de la suppression du Department\n"+e.getMessage());
                    AlertError.getInstance().showAndWait();
                    e.printStackTrace();
                }

            }else{
                event.consume();
            }
        }
        readService();
        resetService();
    }

    @FXML
    void annuler_titre(ActionEvent event) {
        if(currentTitre!=null){
            AlertConfirm.getInstance().setHeaderText("Position de l'employé");
            AlertConfirm.getInstance().setContentText("Voulez-vous supprimer ce Position d'employé ?");
            if(AlertConfirm.getInstance().getButtonTypes().equals(ButtonType.OK)){
                try {
                    //todo:manageGarageService.deletePosition(currentTitre.getId());
                } catch (Exception e) {
                    AlertError.getInstance().setHeaderText("Position de l'employé");
                    AlertError.getInstance().setContentText("Echec lors de la suppression du Position\n"+e.getMessage());
                    AlertError.getInstance().showAndWait();
                    e.printStackTrace();
                }
            }else{
                event.consume();
            }
        }
        readTitre();
        resetTitre();
    }

    @FXML
    void select_espace(MouseEvent event) {
        currentEspace = table_espace.getSelectionModel().getSelectedItem();
    }

    @FXML
    void select_service(MouseEvent event) {
        currentService = table_service.getSelectionModel().getSelectedItem();
    }

    @FXML
    void select_titre(MouseEvent event) {
        currentTitre = table_titre.getSelectionModel().getSelectedItem();
    }

    @FXML
    void valider_atelier(ActionEvent event) {
        Atelier atelier = new Atelier();
        //todo: atelier=manageGarageService.readAtelier(currentAtelier.getId());
        atelier.setName(atelier_raison_sociale.getText().trim());
        atelier.setLegalNotice(atelier_mention_legale.getText().trim());
        atelier.setContact(atelier_contact.getText().trim());
        atelier.setAddress(atelier_adresse.getText().trim());
        try {
            /*manageGarageService.editAtelier(
                    new ManageGarageRequest(
                            atelier_raison_sociale.getText().trim(),
                            atelier_mention_legale.getText().trim(),
                            atelier_adresse.getText().trim(),
                            atelier_contact.getText().trim(),
                            null,
                            null,
                            null,
                            null,
                            null
                    ),
                    currentAtelier.getId()
            );*/
            AlertInfo.getInstance().setHeaderText("Information de l'entreprise");
            AlertInfo.getInstance().setContentText("Informations mis à jour avec succès.");
            AlertInfo.getInstance().showAndWait();
        } catch (Exception e) {
            AlertError.getInstance().setHeaderText("Information de l'entreprise");
            AlertError.getInstance().setContentText("Echec lors de la mise à jour des informations.");
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    void valider_espace(ActionEvent event) {
        Space space = new Space();
                //todo:manageResourceService.findSpace(currentEspace.getId());
        try {
            if(space!=null){
                space.setCode(code_espace.getText().trim());
                space.setName(intitule_espace.getText().trim());
            }else {
                space=new Space();
                space.setCode(code_espace.getText().trim());
                space.setName(intitule_espace.getText().trim());
            }

            //todo:manageResourceService.createSpace(space);

            AlertInfo.getInstance().setHeaderText("Information de l'entreprise");
            AlertInfo.getInstance().setContentText("Informations mis à jour avec succès.");
            AlertInfo.getInstance().showAndWait();
        } catch (Exception e) {
            AlertError.getInstance().setHeaderText("Information de l'entreprise");
            AlertError.getInstance().setContentText("Echec lors de la mise à jour des informations.");
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
        readEspace();
        resetEspace();
    }

    @FXML
    void valider_service(ActionEvent event) {
        Department department = null;
        //todo:manageGarageService.readDepartment(currentService.getId());
        try {
            if(department!=null){
                department.setDesignation(designation_service.getText().trim());
                //todo:manageGarageService.createDepartment(department);
            }else {
                department = new Department();
                department.setDesignation(designation_service.getText().trim());
                //todo:manageGarageService.createDepartment(department);
            }
            AlertInfo.getInstance().setHeaderText("Information de l'entreprise");
            AlertInfo.getInstance().setContentText("Informations mis à jour avec succès.");
            AlertInfo.getInstance().showAndWait();
        } catch (Exception e) {
            AlertError.getInstance().setHeaderText("Information de l'entreprise");
            AlertError.getInstance().setContentText("Echec lors de la mise à jour des informations.");
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
        readService();
        resetService();
    }

    @FXML
    void valider_titre(ActionEvent event) {

        Position position = null;
        //todo: manageGarageService.readPosition(currentTitre.getId());

        if(position!=null){
            position.setDesignation(designation_titre.getText().trim());
        }else {
            position = new Position();
            position.setDesignation(designation_titre.getText().trim());
        }

        try {
            //todo:manageGarageService.createPosition(position);
            AlertInfo.getInstance().setHeaderText("Information de l'entreprise");
            AlertInfo.getInstance().setContentText("Informations mis à jour avec succès.");
            AlertInfo.getInstance().showAndWait();
        } catch (Exception e) {
            AlertError.getInstance().setHeaderText("Information de l'entreprise");
            AlertError.getInstance().setContentText("Echec lors de la mise à jour des informations.");
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
        readTitre();
        resetTitre();
    }
    
    public AdminController() {
    }

    public void read() {
        //todo:table_users.setItems(FXCollections.observableArrayList(Manage.getInstance().listerUtilisateur()));
    }

    public void readAtelier(){
        //todo:currentAtelier = manageGarageService.readAtelier(1L);
        atelier_raison_sociale.setText(currentAtelier.getName());
        atelier_adresse.setText(currentAtelier.getAddress());
        atelier_contact.setText(currentAtelier.getContact());
        atelier_mention_legale.setText(currentAtelier.getLegalNotice());
    }

    public void readEspace(){
        //todo:table_espace.setItems(FXCollections.observableArrayList(manageResourceService.listSpace()));
    }

    public void readService(){
        //todo:table_service.setItems(FXCollections.observableArrayList(manageGarageService.listDepartment(1L)));
    }

    public void readTitre(){
        //todo:table_titre.setItems(FXCollections.observableArrayList(manageGarageService.listPosition(1L)));
    }

    public void resetService(){
        currentService=null;
        designation_service.setText("");
    }

    public void resetTitre(){
        currentTitre=null;
        designation_titre.setText("");
    }

    public void resetEspace(){
        currentEspace=null;
        code_espace.setText("");
        intitule_espace.setText("");
    }

    public void refresh(){
        Popup.getInstance().show();

        javafx.concurrent.Service<Void> load = new javafx.concurrent.Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        read();

                        readAtelier();

                        readEspace();

                        readService();

                        readTitre();

                        return null;
                    }
                };
            }
        };

        load.stateProperty().addListener((ObservableValue<? extends Worker.State> observableValue,Worker.State oldValue,Worker.State newValue) -> {
            switch (newValue){
                case FAILED:
                case CANCELLED:
                case SUCCEEDED:
                    Popup.getInstance().hide();
            }
        });

        load.start();
    }
    
    public void initialize(URL location, ResourceBundle resources) {
        f_role.getItems().setAll(Role.values());

        t_id.setCellValueFactory((TableColumn.CellDataFeatures<User, Long> r)->new ReadOnlyObjectWrapper<>(r.getValue().getId()));
        t_username.setCellValueFactory((TableColumn.CellDataFeatures<User, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getUsername()));
        t_password.setCellValueFactory((TableColumn.CellDataFeatures<User, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getPassword()));
        t_role.setCellValueFactory((TableColumn.CellDataFeatures<User, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getRole().name()));

        espace_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        espace_code.setCellValueFactory(new PropertyValueFactory<>("code"));
        espace_intitule.setCellValueFactory(new PropertyValueFactory<>("intitule"));

        service_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        service_designation.setCellValueFactory(new PropertyValueFactory<>("designation"));

        titre_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        titre_designation.setCellValueFactory(new PropertyValueFactory<>("designation"));

        refresh();
    }
}
