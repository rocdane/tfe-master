package startup.loga.client.controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import startup.loga.client.Main;
import startup.loga.client.app.api.AuthPortal;
import startup.loga.client.model.AuthSession;
import startup.loga.client.view.*;

import java.io.IOException;
import java.net.URL;
import java.time.YearMonth;
import java.util.Objects;
import java.util.ResourceBundle;

public class GuiController implements Initializable
{
    private static AuthPortal authPortal;
    private static GuiController instance;
    private static AuthSession session;

    public static GuiController getInstance() {
        return instance;
    }

    public static AuthSession getSession() {
        return session;
    }

    public static void setSession(AuthSession session) {
        GuiController.session = session;
    }

    public GuiController(){
        authPortal = new AuthPortal();
        instance = this;
    }

    @FXML
    private AnchorPane content;

    @FXML
    private Text navigation;

    @FXML
    private ProgressIndicator progress_indicator;

    @FXML
    void menu_admin(ActionEvent event) {
        if("ADMINISTRATEUR".equals(session.getUser().getRole())){
            View.scene(FxmlView.ADMIN);
        }else{
            AlertError.getInstance().setContentText("Violation d'accès !!!");
            AlertError.getInstance().showAndWait();
        }
    }

    @FXML
    void menu_automobile(ActionEvent event) {
        View.scene(FxmlView.AUTOMOBILE);
    }
    
    @FXML
    void menu_client(ActionEvent event) {
        View.scene(FxmlView.CLIENT);
    }
    
    @FXML
    void menu_reception(ActionEvent event) {
        View.scene(FxmlView.RECEPTION);
    }
    
    @FXML
    void menu_reparation(ActionEvent event) {
        if ("UTILISATEUR".equals(session.getUser().getRole())) {
            AlertError.getInstance().setContentText("Violation d'accès !!!");
            AlertError.getInstance().showAndWait();
        } else {
            View.scene(FxmlView.REPARATION);
        }
    }

    @FXML
    void menu_atelier_dossier(ActionEvent event) {
        View.scene(FxmlView.DOSSIER);
    }

    @FXML
    void versHome(ActionEvent event) {
        View.scene(FxmlView.HOME);
    }
    
    @FXML
    void versReparation(ActionEvent event) {
        if ("UTILISATEUR".equals(session.getUser().getRole())) {
            AlertError.getInstance().setContentText("Violation d'accès !!!");
            AlertError.getInstance().showAndWait();
        } else {
            View.scene(FxmlView.REPARATION);
        }
    }
    
    @FXML
    void versDashboard(ActionEvent event) {
        View.scene(FxmlView.DASHBOARD);
    }
    
    @FXML
    void versAutomobile(ActionEvent event) {
        View.scene(FxmlView.AUTOMOBILE);
    }
    
    @FXML
    void versDossier(ActionEvent event) {
        if("UTILISATEUR".equals(session.getUser().getRole())){
            AlertError.getInstance().setContentText("Violation d'accès !!!");
            AlertError.getInstance().showAndWait();
        }else {
            View.scene(FxmlView.DOSSIER);
        }
    }
    
    @FXML
    void versReception(ActionEvent event) {
        View.scene(FxmlView.RECEPTION);
    }

    @FXML
    void logout(ActionEvent event) {
        signout();
    }

    @FXML
    void help(ActionEvent event) {
        View.scene(FxmlView.SUPPORT);
    }
    
    public void emptyContent() {
        ObservableList<Node> nodes = content.getChildren();
        content.getChildren().removeAll(nodes);
    }
    
    public AnchorPane getContent() {
        return content;
    }
    
    public void setContent(String view) {
        emptyContent();
        try {
            AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(view)));
            fxml.setMinSize(content.getWidth(),content.getHeight());
            fxml.setPrefSize(content.getWidth(),content.getHeight());            fxml.setMaxSize(content.getWidth(),content.getHeight());
            content.getChildren().add(fxml);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setProgress(Boolean visible){
        progress_indicator.setVisible(visible);
    }

    public void signout(){

        javafx.concurrent.Service<Void> load = new javafx.concurrent.Service<>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        authPortal.logout(session.getToken());
                        return null;
                    }
                };
            }
        };

        load.stateProperty().addListener((ObservableValue<? extends Worker.State> observableValue, Worker.State oldValue, Worker.State newValue) -> {
            switch (newValue){
                case FAILED:
                case CANCELLED:
                    AlertWarning.getInstance().setHeaderText("Fermeture de session");
                    AlertWarning.getInstance().setContentText("Opération avortée !!!");
                    AlertWarning.getInstance().showAndWait();
                    break;
                case SUCCEEDED:
                    View.show(FxmlView.LOGIN);
            }
        });

        load.start();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        View.getInstance().getGui().maximizedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                View.getInstance().getGui().setMaximized(true);
            }
        });

        View.getInstance().getGui().setOnCloseRequest(event -> {
            AlertConfirm.getInstance().setTitle("Fermeture de l'application");
            AlertConfirm.getInstance().setContentText("Nous allons vous déconnecter de la session.");
            if(AlertConfirm.getInstance().showAndWait().get().equals(ButtonType.OK)){
                signout();
                System.exit(0);
            }else{
                event.consume();
            }
        });
    }
}
