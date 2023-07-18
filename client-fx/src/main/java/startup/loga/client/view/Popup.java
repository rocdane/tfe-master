package startup.loga.client.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import startup.loga.client.Main;

import java.io.IOException;
import java.util.Objects;

public class Popup {

    private final Stage popup;

    private static Popup instance;

    private Popup(){

        this.popup = new Stage();

        try {
            AnchorPane root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("fxml/popup.fxml")));
            popup.setTitle("LOGA | Opération");
            popup.setScene(new Scene(root,800,600));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Popup getInstance(){
        if(instance==null){
            instance = new Popup();
        }
        return instance;
    }

    public void show(){
        popup.show();
        popup.centerOnScreen();
    }

    public void hide(){
        popup.hide();
    }
}
