package startup.loga.client.controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import startup.loga.client.model.*;
import startup.loga.client.view.AlertError;
import startup.loga.client.view.AlertInfo;
import startup.loga.client.view.Popup;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable
{
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

    public AdminController() {
    }

    public void read() {
        //todo:table_users.setItems(FXCollections.observableArrayList(Manage.getInstance().listerUtilisateur()));
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

        refresh();
    }
}
