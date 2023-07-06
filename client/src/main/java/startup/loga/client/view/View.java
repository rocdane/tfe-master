package startup.loga.client.view;

import javafx.stage.Stage;
import startup.loga.client.controller.GuiController;

public class View {

    static View instance;
    StageManager stageManager;
    Stage stage;

    private View() {
        stage = new Stage();
        stage.setResizable(true);
        stage.centerOnScreen();
        this.stageManager = new StageManager(stage);
    }

    public static View getInstance(){
        if (instance==null){
            instance = new View();
        }
        return instance;
    }

    public static void show(FxmlView view) {
        getInstance().getStageManager().switchScene(view);
    }

    public static void scene(FxmlView view){
        GuiController.getInstance().setContent(view.getFxmlFile());
        getInstance().getGui().setTitle(view.getTitle());
    }

    public Stage getGui() {
        return stage;
    }

    public StageManager getStageManager(){
        return this.stageManager;
    }
}
