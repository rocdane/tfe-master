package startup.loga.client.controller;

import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.text.Text;
import lombok.Getter;
import startup.loga.client.app.api.MonitoringPortal;
import startup.loga.client.app.factory.*;
import startup.loga.client.view.Popup;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class DashboardController implements Initializable{

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private final MonitoringPortal monitoringPortal;

    private Dashboard dashboard;

    @FXML
    private Text count_dossier;

    @FXML
    private Text count_diagnosis;

    @FXML
    private Text count_repair;

    @FXML
    private Text count_spare;

    @Getter
    @FXML
    private AreaChart<String, Integer> chart_reparation;

    @FXML
    private CategoryAxis chart_reparation_x;

    @FXML
    private NumberAxis chart_reparation_y;

    public DashboardController() {
        this.monitoringPortal = new MonitoringPortal();
    }

    public void loadDashboard(){
        try {
            this.dashboard = monitoringPortal.load();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void processStatistic(){
        count_dossier.setText(String.valueOf(dashboard.getStats().getDossiers()));

        count_diagnosis.setText(String.valueOf(dashboard.getStats().getDiagnosis()));

        count_repair.setText(String.valueOf(dashboard.getStats().getTasks()));

        count_spare.setText(String.valueOf(dashboard.getStats().getSpares()));
    }

    public void processReparationParPeriode(){

        XYChart.Series<String,Integer> tacheParPeriode = new XYChart.Series<>();
        tacheParPeriode.setName("Prestations");

        XYChart.Series<String,Integer> fournitureParPeriode = new XYChart.Series<>();
        fournitureParPeriode.setName("Fournitures");

        for (Spares spares:dashboard.getSpares()){
            fournitureParPeriode.getData().add(new XYChart.Data<>(sdf.format(spares.getPeriod()),spares.getAmount()));
        }

        for (Tasks tasks:dashboard.getTasks()){
            tacheParPeriode.getData().add(new XYChart.Data<>(sdf.format(tasks.getPeriod()), tasks.getAmount()));
        }

        getChart_reparation().getData().add(fournitureParPeriode);
        getChart_reparation().getData().add(tacheParPeriode);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Popup.getInstance().show();

        javafx.concurrent.Service<Void> load = new javafx.concurrent.Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        loadDashboard();

                        processStatistic();

                        processReparationParPeriode();

                        return null;
                    }
                };
            }
        };

        load.stateProperty().addListener((ObservableValue<? extends Worker.State> observableValue, Worker.State oldValue, Worker.State newValue) -> {
            switch (newValue) {
                case FAILED, CANCELLED, SUCCEEDED -> Popup.getInstance().hide();
            }
        });

        load.start();
    }
}

