package startup.loga.client.controller;

import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import startup.loga.client.app.api.AuthPortal;
import startup.loga.client.model.AuthSession;
import startup.loga.client.model.User;
import startup.loga.client.view.AlertError;
import startup.loga.client.view.AlertWarning;
import startup.loga.client.view.FxmlView;
import startup.loga.client.view.View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AuthController implements Initializable {

    private final AuthPortal authPortal;

    @FXML
    private AnchorPane auth_area;

    @FXML
    private TextField signin_username;

    @FXML
    private PasswordField signin_password;

    @FXML
    private ProgressIndicator loader;

    @FXML
    private TextField signup_username;

    @FXML
    private PasswordField signup_password;

    @FXML
    private PasswordField signup_confirm_password;

    @FXML
    private ProgressIndicator loader_signup;

    @FXML
    void forgetPassword() {
        View.show(FxmlView.SIGNUP);
    }

    @FXML
    void login(){
        View.show(FxmlView.LOGIN);
    }

    @FXML
    void signin(ActionEvent event) {

        User user = new User(signin_username.getText().trim(),signin_password.getText().trim());

        loader.setVisible(true);

        javafx.concurrent.Service<Void> load = new javafx.concurrent.Service<>() {

            @Override
            protected Task<Void> createTask() {

                return new Task<Void>() {
                    @Override
                    protected Void call() {

                        try {
                            AuthSession authSession = authPortal.authenticate(user);

                            System.out.println(authSession.getToken());

                            if(authSession.getToken()!=null){
                                GuiController.setSession(authSession);
                            }else {
                                throw new RuntimeException("Session non valide");
                            }
                        } catch (IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        return null;
                    }
                };
            }
        };

        load.stateProperty().addListener((ObservableValue<? extends Worker.State> observableValue, Worker.State oldValue, Worker.State newValue) -> {
            switch (newValue){
                case FAILED:
                    loader.setVisible(false);
                    AlertError.getInstance().setHeaderText("Ouverture de session");
                    AlertError.getInstance().setContentText("Nom d'utilisateur / mot de passe incorrect ou utilisateur non autorisé!!!");
                    AlertError.getInstance().showAndWait();
                    break;
                case CANCELLED:
                    loader.setVisible(false);
                    AlertWarning.getInstance().setHeaderText("Ouverture de session");
                    AlertWarning.getInstance().setContentText("Opération avortée!!!");
                    AlertWarning.getInstance().showAndWait();
                    break;
                case SUCCEEDED:
                    View.show(FxmlView.MAIN);
            }
        });

        load.start();
    }

    @FXML
    void signup(ActionEvent event){

        if(signup_password.getText().trim().equals(signup_confirm_password.getText().trim())){

            loader_signup.setVisible(true);

            User user = new User(signup_username.getText().trim(),signup_password.getText().trim());

            javafx.concurrent.Service<Void> load = new javafx.concurrent.Service<Void>() {
                @Override
                protected Task<Void> createTask() {
                    return new Task<Void>() {
                        @Override
                        protected Void call() {
                            try {
                                authPortal.register(user);
                            } catch (IOException | InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            return null;
                        }
                    };
                }
            };

            load.stateProperty().addListener((ObservableValue<? extends Worker.State> observableValue, Worker.State oldValue, Worker.State newValue) -> {
                switch (newValue){
                    case FAILED:
                    case CANCELLED:
                        loader_signup.setVisible(false);
                        AlertError.getInstance().setHeaderText("Authentification");
                        AlertError.getInstance().setContentText("Le nom d'utilisateur n'existe pas!!!");
                        AlertError.getInstance().showAndWait();
                        break;
                    case SUCCEEDED:
                        View.show(FxmlView.LOGIN);
                }
            });

            load.start();

        }else {
            event.consume();
            AlertError.getInstance().setHeaderText("Authentification");
            AlertError.getInstance().setContentText("Les mots de passe ne sont pas identiques!!!");
            AlertError.getInstance().showAndWait();
        }
    }

    public AuthController(){
        this.authPortal = new AuthPortal();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
