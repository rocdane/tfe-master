package startup.loga.client.controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import startup.loga.client.app.api.DossierPortal;
import startup.loga.client.model.Diagnosis;
import startup.loga.client.model.Dossier;
import startup.loga.client.model.Reception;
import startup.loga.client.model.Repair;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

public class DossierController implements Initializable
{
    final DossierPortal dossierPortal;

    List<Dossier> allDossier;

    Dossier dossierCurrent;

    @FXML
    private ComboBox<Dossier> dossiers;

    @FXML
    private TextField number;

    @FXML
    private TextField make;

    @FXML
    private TextField model;

    @FXML
    private TextField trim;

    @FXML
    private TextField unit;

    @FXML
    private TextField vin;

    @FXML
    private TextField client;

    @FXML
    private TextField reference;

    @FXML
    private TableView<Reception> table_reception;

    @FXML
    private TableColumn<Reception, Long> column_reception_id;

    @FXML
    private TableColumn<Reception, String> column_reception_date;

    @FXML
    private TableColumn<Reception, String> column_reception_description;

    @FXML
    private TableColumn<Reception, String> column_reception_profile;

    @FXML
    private TableView<Diagnosis> table_diagnostic;

    @FXML
    private TableColumn<Diagnosis, Long> column_diagnostic_id;

    @FXML
    private TableColumn<Diagnosis, String> column_diagnostic_date;

    @FXML
    private TableColumn<Diagnosis, String> column_diagnostic_description;

    @FXML
    private TableColumn<Diagnosis, String> column_diagnostic_profile;

    @FXML
    private TableView<Repair> table_repair;

    @FXML
    private TableColumn<Repair, Long> column_repair_id;

    @FXML
    private TableColumn<Repair, String> column_repair_date;

    @FXML
    private TableColumn<Repair, String> column_repair_reference;

    @FXML
    private TableColumn<Repair, String> column_repair_description;

    @FXML
    private TableColumn<Repair, String> column_repair_profile;

    @FXML
    void archive(ActionEvent event){

    }

    @FXML
    void print_diagnostic(MouseEvent event) {
        //todo:Report.getInstance().createReport("/jrxml/diagnostic.jrxml", (int) table_diagnostic.getSelectionModel().getSelectedItem().getId());
    }

    @FXML
    void print_reception(MouseEvent event) {
        //todo:Report.getInstance().createReport("/jrxml/reception.jrxml",(int) table_reception.getSelectionModel().getSelectedItem().getId());
    }

    @FXML
    void print_reparation(MouseEvent event) {
        //todo:Report.getInstance().createReport("/jrxml/reparation.jrxml",(int) table_reparation.getSelectionModel().getSelectedItem().getId());
    }

    @FXML
    void search_dossier(KeyEvent event) {
        FilteredList<Dossier> items = new FilteredList<>(FXCollections.observableArrayList(allDossier));
        items.setPredicate(item ->{
            String lower = dossiers.getEditor().getText().toLowerCase();
            String upper = dossiers.getEditor().getText().toUpperCase();
            if(item.getAutomobile().getVin().contains(lower))
                return true;
            else
                return item.getAutomobile().getVin().contains(upper);
        });
        SortedList<Dossier> sorted = new SortedList<>(items);
        dossiers.setItems(sorted);
    }

    void readInformation(Dossier dossier) {
        reference.setText(dossier.getReference());
        client.setText(dossier.getClient().getName()+" | "+dossier.getClient().getContact());
        number.setText(dossier.getAutomobile().getNumber());
        vin.setText(dossier.getAutomobile().getVin());
        make.setText(dossier.getAutomobile().getMake());
        model.setText(dossier.getAutomobile().getModel());
        trim.setText(String.valueOf(dossier.getAutomobile().getTrim()));
        unit.setText(dossier.getAutomobile().getUnit());
    }

    void readReception(Dossier dossier) {
        //List<Reception> receptions = dossier.getReceptions();
        //table_reception.setItems(FXCollections.observableArrayList(receptions));
    }

    void readDiagnostic(Dossier dossier) {
        //List<Diagnosis> diagnoses = dossier.getDiagnoses();
        //table_diagnostic.setItems(FXCollections.observableArrayList(diagnoses));
    }

    void readReparation(Dossier dossier) {
        //List<Repair> reparations = dossier.getRepairs();
        //table_repair.setItems(FXCollections.observableArrayList(reparations));
    }

    void readDossiers(){
        try {
            this.allDossier = dossierPortal.read();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        dossiers.setItems(FXCollections.observableArrayList(allDossier));
    }

    public DossierController(){
        this.dossierPortal = new DossierPortal();
    }
    
    public void initialize(URL location, ResourceBundle resources) {

        readDossiers();

        column_reception_id.setCellValueFactory((TableColumn.CellDataFeatures<Reception, Long> r)->new ReadOnlyObjectWrapper<>(r.getValue().getId()));
        column_reception_date.setCellValueFactory((TableColumn.CellDataFeatures<Reception, String> r)->new ReadOnlyObjectWrapper<>(new SimpleDateFormat("dd-MM-YYYY").format(r.getValue().getCreatedAt())));
        column_reception_description.setCellValueFactory((TableColumn.CellDataFeatures<Reception, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getDescription()));
        column_reception_profile.setCellValueFactory((TableColumn.CellDataFeatures<Reception, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getDescription()));

        column_diagnostic_id.setCellValueFactory((TableColumn.CellDataFeatures<Diagnosis, Long> r)->new ReadOnlyObjectWrapper<>(r.getValue().getId()));
        column_diagnostic_date.setCellValueFactory((TableColumn.CellDataFeatures<Diagnosis, String> r)->new ReadOnlyObjectWrapper<>(new SimpleDateFormat("dd-MM-YYYY").format(r.getValue().getCreatedAt())));
        column_diagnostic_description.setCellValueFactory((TableColumn.CellDataFeatures<Diagnosis, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getDescription()));
        column_diagnostic_profile.setCellValueFactory((TableColumn.CellDataFeatures<Diagnosis, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getDescription()));

        column_repair_id.setCellValueFactory((TableColumn.CellDataFeatures<Repair, Long> r)->new ReadOnlyObjectWrapper<>(r.getValue().getId()));
        column_repair_date.setCellValueFactory((TableColumn.CellDataFeatures<Repair, String> r)->new ReadOnlyObjectWrapper<>(new SimpleDateFormat("dd-MM-YYYY").format(r.getValue().getCreatedAt())));
        column_repair_description.setCellValueFactory((TableColumn.CellDataFeatures<Repair, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getDescription()));
        column_repair_reference.setCellValueFactory((TableColumn.CellDataFeatures<Repair, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getReference()));
        column_repair_profile.setCellValueFactory((TableColumn.CellDataFeatures<Repair, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getProfile()));

        dossiers.addEventHandler(ActionEvent.ACTION, event -> {
            if (dossiers.getSelectionModel().getSelectedIndex() != -1) {
                dossierCurrent = dossiers.getValue();
                readInformation(dossierCurrent);
                readReception(dossierCurrent);
                readDiagnostic(dossierCurrent);
                readReparation(dossierCurrent);
            }
        });

        dossiers.setConverter(new StringConverter<Dossier>() {
            @Override
            public String toString(Dossier object) {
                if(object==null) return null;
                return object.getReference();
            }

            @Override
            public Dossier fromString(String string) {
                String[] data = string.split("/");
                String auto = data[0].trim();
                try {
                    return dossierPortal.read(dossierCurrent.getId());
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
