package startup.loga.client.controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import startup.loga.client.app.api.AutomobilePortal;
import startup.loga.client.app.api.ClientPortal;
import startup.loga.client.app.api.DossierPortal;
import startup.loga.client.model.Automobile;
import startup.loga.client.model.Client;
import startup.loga.client.model.Dossier;
import startup.loga.client.model.Unit;
import startup.loga.client.view.AlertConfirm;
import startup.loga.client.view.AlertError;
import startup.loga.client.view.AlertInfo;
import startup.loga.client.view.Popup;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AutomobileController implements Initializable
{
    private final AutomobilePortal automobilePortal;
    private final ClientPortal clientPortal;
    private final DossierPortal dossierPortal;

    List<Client> allClients;
    List<Automobile> allAutomobiles;
    Automobile currentAuto;
    Client currentClient;
    long clientID=0;

    @FXML
    private Text automobile_count;

    @FXML
    private AnchorPane content;

    @FXML
    private TabPane tabAutomobile;

    @FXML
    private Tab tabNew;

    @FXML
    private ComboBox<Client> client;

    @FXML
    private TextField number;

    @FXML
    private TextField make;

    @FXML
    private TextField model;

    @FXML
    private ComboBox<Unit> unit;

    @FXML
    private TextField trim;

    @FXML
    private TextField vin;

    @FXML
    private HBox btnArea;

    @FXML
    private Tab tabList;

    @FXML
    private TextField automobile;

    @FXML
    private TableView<Automobile> table_automobile;

    @FXML
    private TableColumn<Automobile, Long> column_id;

    @FXML
    private TableColumn<Automobile, String> column_number;

    @FXML
    private TableColumn<Automobile, String> column_vin;

    @FXML
    private TableColumn<Automobile, String> column_make;

    @FXML
    private TableColumn<Automobile, String> column_model;

    @FXML
    private TableColumn<Automobile, String> column_unit;

    @FXML
    private TableColumn<Automobile, Integer> column_trim;

    @FXML
    private Tab tabDetail;

    @FXML
    private TextField edit_number;

    @FXML
    private TextField edit_make;

    @FXML
    private TextField edit_model;

    @FXML
    private ComboBox<Unit> edit_unit;

    @FXML
    private TextField edit_trim;

    @FXML
    private TextField edit_vin;

    public AutomobileController() {
        this.automobilePortal = new AutomobilePortal();
        this.clientPortal = new ClientPortal();
        this.dossierPortal = new DossierPortal();
    }

    @FXML
    void apply(ActionEvent event) {
            try {
                Automobile automobile = currentAuto;
                automobile.setVin(edit_vin.getText().trim());
                automobile.setMake(edit_make.getText().trim());
                automobile.setTrim(Integer.parseInt(edit_trim.getText().trim()));
                automobile.setUnit(edit_unit.getSelectionModel().getSelectedItem().name());

                automobilePortal.edit(automobile,currentAuto.getId());

                AlertInfo.getInstance().setTitle("Info");
                AlertInfo.getInstance().setHeaderText("Enregistrement automobile");
                AlertInfo.getInstance().setContentText("Automobile mis à jour avec succès.");
                AlertInfo.getInstance().show();
            } catch (Exception e) {
                AlertError.getInstance().setTitle("Erreur");
                AlertError.getInstance().setHeaderText("Enregistrement automobile");
                AlertError.getInstance().setContentText("Echec lors de la mise à jour de l'Automobile.\n"+e.getMessage());
                AlertError.getInstance().showAndWait();
                e.printStackTrace();
            }
        emptyField();
        selectTab(2);
        readAll();
    }

    @FXML
    void cancel(ActionEvent event) {
        emptyField();
    }

    @FXML
    void delete(ActionEvent event) {
        if (table_automobile.getSelectionModel().getSelectedItem() != null) {
            AlertConfirm.getInstance().setTitle("Confirmation");
            AlertConfirm.getInstance().setHeaderText("Archivage d'automobile");
            AlertConfirm.getInstance().setContentText("Votre action supprimera l'automobile\n et son dossier. Voulez-vous continuer?");
            AlertConfirm.getInstance().showAndWait();
            try {
                automobilePortal.delete(currentAuto.getId());
                AlertInfo.getInstance().setTitle("Info");
                AlertInfo.getInstance().setHeaderText("Enregistrement automobile");
                AlertInfo.getInstance().setContentText("Automobile archivé avec succès");
                AlertInfo.getInstance().show();
                selectTab(2);
                readAll();
            } catch (Exception e) {
                AlertError.getInstance().setTitle("Erreur");
                AlertError.getInstance().setHeaderText("Suppression automobile");
                AlertError.getInstance().setContentText("Echec lors de la suppression de l'Automobile.\n"+e.getMessage());
                AlertError.getInstance().showAndWait();
                e.printStackTrace();
            }
        }
    }
    
    @FXML
    void edit(ActionEvent event) {
        edit_number.setText(currentAuto.getNumber());
        edit_vin.setText(currentAuto.getVin());
        edit_make.setText(currentAuto.getMake());
        edit_model.setText(currentAuto.getModel());
        edit_trim.setText(String.valueOf(currentAuto.getTrim()));
        selectTab(3);
    }

    @FXML
    void print(ActionEvent event) {
        AlertConfirm.getInstance().setTitle("Confirmation");
        AlertConfirm.getInstance().setHeaderText("Impression");
        AlertConfirm.getInstance().setContentText("Vous allez imprimer la liste des automobiles. Voulez-vous continuer?");
        AlertConfirm.getInstance().showAndWait();
    }

    @FXML
    void quit(ActionEvent event) {
        emptyField();
        selectTab(2);
    }

    @FXML
    void search_automobile(KeyEvent event) {
        FilteredList<Automobile> items = new FilteredList<>(FXCollections.observableArrayList(allAutomobiles));
        items.setPredicate(item ->{
            String lower = automobile.getText().toLowerCase();
            String upper = automobile.getText().toUpperCase();
            if(item.getNumber().contains(lower))
                return true;
            else
                return item.getNumber().contains(upper);
        });
        SortedList<Automobile> sorted = new SortedList<>(items);
        table_automobile.setItems(sorted);
    }

    @FXML
    void search_client(KeyEvent event) {
        FilteredList<Client> items = new FilteredList<>(FXCollections.observableArrayList(allClients));
        items.setPredicate(item ->{
            String lower = client.getEditor().getText().toLowerCase();
            String upper = client.getEditor().getText().toUpperCase();
            if(item.getName().contains(lower))
                return true;
            else
                return item.getName().contains(upper);
        });
        SortedList<Client> sorted = new SortedList<>(items);
        client.setItems(sorted);
    }

    @FXML
    void select_automobile(MouseEvent event) {
        currentAuto = table_automobile.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    void submit(ActionEvent event) {

        try {
            Client client = clientPortal.read(clientID);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        Automobile automobile = new Automobile();
        automobile.setNumber(number.getText().trim());
        automobile.setVin(vin.getText().trim());
        automobile.setMake(make.getText().trim());
        automobile.setModel(model.getText().trim());
        automobile.setUnit(unit.getSelectionModel().getSelectedItem().name());
        automobile.setTrim(Integer.parseInt(trim.getText().trim()));

        Dossier dossier = new Dossier();
        dossier.setAutomobile(automobile);
        dossier.setClient(client.getValue());
        try {
            dossierPortal.create(dossier);
            AlertInfo.getInstance().setTitle("Info");
            AlertInfo.getInstance().setHeaderText("Enregistrement automobile");
            AlertInfo.getInstance().setContentText("Automobile enregistré avec succès");
            AlertInfo.getInstance().show();
            selectTab(2);
            readAll();
            emptyField();
        } catch (Exception e) {
            AlertError.getInstance().setTitle("Erreur");
            AlertError.getInstance().setHeaderText("Enregistrement automobile");
            AlertError.getInstance().setContentText("Echec lors de l'enregistrement de l'Automobile.\n"+e.getMessage());
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
    }
    
    public void selectTab(int i) {
        tabAutomobile.getSelectionModel().select(getTab(i));
    }
    
    public Tab getTab(int i) {
        Tab tab = null;
        switch (i) {
            case 1: {
                tab = tabNew;
                break;
            }
            case 2: {
                tab = tabList;
                break;
            }
            case 3: {
                tab = tabDetail;
                break;
            }
        }
        return tab;
    }
    
    void emptyField() {
        client.getEditor().setText("");
        number.setText("");
        vin.setText("");
        make.setText("");
        model.setText("");
        trim.setText("");

        edit_number.setText("");
        edit_vin.setText("");
        edit_make.setText("");
        edit_model.setText("");
        edit_trim.setText("");
    }
    
    void readAll() {
        //GuiController.getInstance().setProgress(true);
        Popup.getInstance().show();

        javafx.concurrent.Service<Void> load = new javafx.concurrent.Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {

                        table_automobile.getItems().clear();

                        allClients = clientPortal.list();
                        client.setItems(FXCollections.observableArrayList(allClients));

                        allAutomobiles = automobilePortal.list();
                        table_automobile.setItems(FXCollections.observableArrayList(allAutomobiles));
                        automobile_count.setText(String.valueOf(allAutomobiles.size()));

                        return null;
                    }
                };
            }
        };

        load.stateProperty().addListener((ObservableValue<? extends Worker.State> observableValue, Worker.State oldValue, Worker.State newValue) -> {
            switch (newValue){
                case FAILED:
                case CANCELLED:
                case SUCCEEDED:
                    Popup.getInstance().hide();
                    //GuiController.getInstance().setProgress(false);
            }
        });

        load.start();
    }

    public void initialize(URL location, ResourceBundle resources) {

        readAll();

        column_id.setCellValueFactory((TableColumn.CellDataFeatures<Automobile, Long> r)->new ReadOnlyObjectWrapper<>(r.getValue().getId()));
        column_vin.setCellValueFactory((TableColumn.CellDataFeatures<Automobile, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getVin()));
        column_number.setCellValueFactory((TableColumn.CellDataFeatures<Automobile, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getNumber()));
        column_make.setCellValueFactory((TableColumn.CellDataFeatures<Automobile, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getMake()));
        column_model.setCellValueFactory((TableColumn.CellDataFeatures<Automobile, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getModel()));
        column_unit.setCellValueFactory((TableColumn.CellDataFeatures<Automobile, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getUnit()));
        column_trim.setCellValueFactory((TableColumn.CellDataFeatures<Automobile, Integer> r)->new ReadOnlyObjectWrapper<>(r.getValue().getTrim()));
        unit.getItems().setAll(Unit.values());
        edit_unit.getItems().setAll(Unit.values());
        selectTab(1);

        tabAutomobile.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            public void changed(ObservableValue<? extends Tab> observableValue, Tab tab, Tab t1) {
                if (tab.getTabPane().getSelectionModel().getSelectedIndex() == 1) {
                    readAll();
                }
            }
        });

        client.addEventHandler(ActionEvent.ACTION, event -> {
            if (client.getSelectionModel().getSelectedIndex() != -1) {
                clientID = client.getSelectionModel().getSelectedItem().getId();
                currentClient = client.getValue();
            }
        });

        client.setConverter(new StringConverter<Client>() {
            @Override
            public String toString(Client object) {
                if(object==null)
                    return null;
                return object.getName();
            }

            @Override
            public Client fromString(String string) {
                try {
                    return clientPortal.read(clientID);
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
