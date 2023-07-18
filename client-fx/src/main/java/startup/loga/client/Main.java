package startup.loga.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import startup.loga.client.view.*;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		View.show(FxmlView.LOGIN);
	}

	@Override
	public void stop() {
		Platform.exit();
	}
}
