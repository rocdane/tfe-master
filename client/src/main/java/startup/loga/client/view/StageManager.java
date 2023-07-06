package startup.loga.client.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import startup.loga.client.Main;

import java.util.Objects;

public class StageManager {
	private final Stage primaryStage;

	public StageManager(Stage stage) {
		this.primaryStage = stage;
	}

	public void switchScene(FxmlView view) {
		Parent viewRootNodeHierarchy = loadViewNodeHierarchy(view.getFxmlFile());
		show(viewRootNodeHierarchy,view.getTitle());
	}
	
	private Parent loadViewNodeHierarchy(String fxmlFile) {
		Parent rootNode = null;
		try {
			rootNode = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(fxmlFile)));
			Objects.requireNonNull(rootNode,"A Root FXML node must not be null");
		}catch(Exception exception) {
			logAndExit("Unable to load FXML view \t"+fxmlFile,exception);
		}

		return rootNode;
	}

	private void logAndExit(String msg, Exception exception) {
		throw new RuntimeException(msg,exception);
	}

	public void show(final Parent rootnode,String title){
		Scene scene = prepareScene(rootnode);
		
		primaryStage.setTitle(title);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.centerOnScreen();
		
		try {
			primaryStage.show();
		}catch(Exception exception) {
			logAndExit("Unable to show scene for title "+title,exception);
		}
	} 

	private Scene prepareScene(Parent rootnode) {
		Scene scene = primaryStage.getScene();
		if(scene==null) {
			scene = new Scene(rootnode);
		}
		scene.setRoot(rootnode);
		return scene;
	}
}
