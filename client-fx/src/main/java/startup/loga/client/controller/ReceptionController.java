package startup.loga.client.controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import startup.loga.client.app.api.*;
import startup.loga.client.app.factory.Diagnosis;
import startup.loga.client.model.*;
import startup.loga.client.view.AlertConfirm;
import startup.loga.client.view.AlertError;
import startup.loga.client.view.AlertInfo;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ReceptionController implements Initializable
{
    private static ReceptionController instance;
    private final DossierPortal dossierPortal;
    private final ReceptionPortal receptionPortal;
    private final DiagnosticPortal diagnosticPortal;
    private final ReportPortal reportPortal;
    private List<Diagnosis> diagnoses;
    private Set<String> dysfunctions, maintenances;
    private List<Notice> newEtats = new ArrayList<>();
    private List<Notice> list_etat = new ArrayList<>();
    AtomicInteger rowNbr;
    private List<Factor> list_factor = new ArrayList<>();
    private List<Dossier> allDossier = new ArrayList<>();
    long dossierID, receptionID;

    String etat111 = "OK",etat112="OK",etat113="OK",etat114="OK",etat115="OK",etat116="OK",etat117="OK",etat221="OK",etat222="OK",etat223="OK",etat224="OK",etat225="OK",
            etat331="OK",etat332="OK",etat333="OK",etat334="OK",etat441="OK",etat442="OK",etat443="OK",etat444="OK",etat511="OK",etat512="OK",etat513="OK",etat514="OK",
            etat521="OK",etat522="OK",etat523="OK",etat524="OK",etat531="OK",etat532="OK",etat533="OK",etat534="OK",etat541="OK",etat542="OK",etat543="OK",etat544="OK",
            etat661="OK",etat662="OK",etat663="OK",etat664="OK",etat665="OK";

    @FXML
    private TextField etat7;

    @FXML
    private TextArea etat8;

    @FXML
    private TextField reception_mileage;

    @FXML
    private TitledPane etat1;

    @FXML
    private Label etat111_description;

    @FXML
    private Label etat112_description;

    @FXML
    private Label etat113_description;

    @FXML
    private Label etat114_description;

    @FXML
    private Label etat115_description;

    @FXML
    private Label etat116_description;

    @FXML
    private Label etat117_description;

    @FXML
    private RadioButton etat111_ok;

    @FXML
    private RadioButton etat111_warning;

    @FXML
    private RadioButton etat111_danger;

    @FXML
    private RadioButton etat112_ok;

    @FXML
    private RadioButton etat112_warning;

    @FXML
    private RadioButton etat112_danger;

    @FXML
    private RadioButton etat113_ok;

    @FXML
    private RadioButton etat113_warning;

    @FXML
    private RadioButton etat113_danger;

    @FXML
    private RadioButton etat114_ok;

    @FXML
    private RadioButton etat114_warning;

    @FXML
    private RadioButton etat114_danger;

    @FXML
    private RadioButton etat115_ok;

    @FXML
    private RadioButton etat115_warning;

    @FXML
    private RadioButton etat115_danger;

    @FXML
    private RadioButton etat116_ok;

    @FXML
    private RadioButton etat116_warning;

    @FXML
    private RadioButton etat116_danger;

    @FXML
    private RadioButton etat117_ok;

    @FXML
    private RadioButton etat117_warning;

    @FXML
    private RadioButton etat117_danger;

    @FXML
    private TitledPane etat2;

    @FXML
    private RadioButton etat222_ok;

    @FXML
    private RadioButton etat222_warning;

    @FXML
    private RadioButton etat222_danger;

    @FXML
    private RadioButton etat223_ok;

    @FXML
    private RadioButton etat223_warning;

    @FXML
    private RadioButton etat223_danger;

    @FXML
    private RadioButton etat224_ok;

    @FXML
    private RadioButton etat224_warning;

    @FXML
    private RadioButton etat224_danger;

    @FXML
    private RadioButton etat225_ok;

    @FXML
    private RadioButton etat225_warning;

    @FXML
    private RadioButton etat225_danger;

    @FXML
    private RadioButton etat221_ok;

    @FXML
    private RadioButton etat221_warning;

    @FXML
    private RadioButton etat221_danger;

    @FXML
    private TitledPane etat3;

    @FXML
    private RadioButton etat331_ok;

    @FXML
    private RadioButton etat331_warning;

    @FXML
    private RadioButton etat331_danger;

    @FXML
    private RadioButton etat332_ok;

    @FXML
    private RadioButton etat332_warning;

    @FXML
    private RadioButton etat332_danger;

    @FXML
    private RadioButton etat333_ok;

    @FXML
    private RadioButton etat333_warning;

    @FXML
    private RadioButton etat333_danger;

    @FXML
    private RadioButton etat334_ok;

    @FXML
    private RadioButton etat334_warning;

    @FXML
    private RadioButton etat334_danger;

    @FXML
    private TitledPane etat4;

    @FXML
    private RadioButton etat441_ok;

    @FXML
    private RadioButton etat441_warning;

    @FXML
    private RadioButton etat441_danger;

    @FXML
    private RadioButton etat442_ok;

    @FXML
    private RadioButton etat442_warning;

    @FXML
    private RadioButton etat442_danger;

    @FXML
    private RadioButton etat443_ok;

    @FXML
    private RadioButton etat443_warning;

    @FXML
    private RadioButton etat443_danger;

    @FXML
    private RadioButton etat444_ok;

    @FXML
    private RadioButton etat444_warning;

    @FXML
    private RadioButton etat444_danger;

    @FXML
    private TitledPane etat5;

    @FXML
    private RadioButton etat511_ok;

    @FXML
    private RadioButton etat511_warning;

    @FXML
    private RadioButton etat511_danger;

    @FXML
    private RadioButton etat512_ok;

    @FXML
    private RadioButton etat512_warning;

    @FXML
    private RadioButton etat512_danger;

    @FXML
    private RadioButton etat513_ok;

    @FXML
    private RadioButton etat513_warning;

    @FXML
    private RadioButton etat513_danger;

    @FXML
    private RadioButton etat514_ok;

    @FXML
    private RadioButton etat514_warning;

    @FXML
    private RadioButton etat514_danger;

    @FXML
    private RadioButton etat521_ok;

    @FXML
    private RadioButton etat521_warning;

    @FXML
    private RadioButton etat521_danger;

    @FXML
    private RadioButton etat522_ok;

    @FXML
    private RadioButton etat522_warning;

    @FXML
    private RadioButton etat522_danger;

    @FXML
    private RadioButton etat523_ok;

    @FXML
    private RadioButton etat523_warning;

    @FXML
    private RadioButton etat523_danger;

    @FXML
    private RadioButton etat524_ok;

    @FXML
    private RadioButton etat524_warning;

    @FXML
    private RadioButton etat524_danger;

    @FXML
    private RadioButton etat531_ok;

    @FXML
    private RadioButton etat531_warning;

    @FXML
    private RadioButton etat531_danger;

    @FXML
    private RadioButton etat532_ok;

    @FXML
    private RadioButton etat532_warning;

    @FXML
    private RadioButton etat532_danger;

    @FXML
    private RadioButton etat533_ok;

    @FXML
    private RadioButton etat533_warning;

    @FXML
    private RadioButton etat533_danger;

    @FXML
    private RadioButton etat534_ok;

    @FXML
    private RadioButton etat534_warning;

    @FXML
    private RadioButton etat534_danger;

    @FXML
    private RadioButton etat541_ok;

    @FXML
    private RadioButton etat541_warning;

    @FXML
    private RadioButton etat541_danger;

    @FXML
    private RadioButton etat542_ok;

    @FXML
    private RadioButton etat542_warning;

    @FXML
    private RadioButton etat542_danger;

    @FXML
    private RadioButton etat544_ok;

    @FXML
    private RadioButton etat544_warning;

    @FXML
    private RadioButton etat544_danger;

    @FXML
    private RadioButton etat543_ok;

    @FXML
    private RadioButton etat543_warning;

    @FXML
    private RadioButton etat543_danger;

    @FXML
    private TitledPane etat6;

    @FXML
    private RadioButton etat665_ok;

    @FXML
    private RadioButton etat665_warning;

    @FXML
    private RadioButton etat665_danger;

    @FXML
    private RadioButton etat664_ok;

    @FXML
    private RadioButton etat664_warning;

    @FXML
    private RadioButton etat664_danger;

    @FXML
    private RadioButton etat663_ok;

    @FXML
    private RadioButton etat663_warning;

    @FXML
    private RadioButton etat663_danger;

    @FXML
    private RadioButton etat662_ok;

    @FXML
    private RadioButton etat662_warning;

    @FXML
    private RadioButton etat662_danger;

    @FXML
    private RadioButton etat661_ok;

    @FXML
    private RadioButton etat661_warning;

    @FXML
    private RadioButton etat661_danger;

    @FXML
    private AnchorPane content;
    @FXML
    private TabPane receptionTab;
    @FXML
    private Tab tab_reception;
    @FXML
    private AnchorPane newTabContent;
    @FXML
    private TextField diagnostic_profile;
    @FXML
    private TextField reception_profile;
    @FXML
    private ComboBox<Dossier> reception_dossier;
    @FXML
    private Tab tab_diagnostic;
    @FXML
    private AnchorPane detailTabContent;
    @FXML
    private ComboBox<Dossier> diagnostic_dossier;
    @FXML
    private TextField diagnostic_mileage;
    @FXML
    private TextArea diagnostic_description;
    @FXML
    private ComboBox<Entity> factor_entity;
    @FXML
    private ComboBox<String> factor_dysfunction;
    @FXML
    private ComboBox<String> factor_maintenance;
    @FXML
    private TableView<Factor> table_factor;
    @FXML
    private TableColumn<Factor, String> column_factor_entity;
    @FXML
    private TableColumn<Factor, String> column_factor_dysfunction;
    @FXML
    private TableColumn<Factor, String> column_factor_maintenance;

    @FXML
    void save_diagnostic() {
        if (list_factor.isEmpty()) {
            AlertInfo.getInstance().setTitle("Info");
            AlertInfo.getInstance().setHeaderText("Enregistrement diagnostic");
            AlertInfo.getInstance().setContentText("Le diagnostic doit comporter au moins un défaut");
            AlertInfo.getInstance().show();
        }
        else {
            startup.loga.client.model.Diagnosis diagnosis = new startup.loga.client.model.Diagnosis();
            diagnosis.setDescription(diagnostic_description.getText());
            diagnosis.setMileage(Integer.parseInt(diagnostic_mileage.getText().trim()));
            diagnosis.setDossier(diagnostic_dossier.getValue());

            if(!diagnostic_profile.getText().isEmpty())
                diagnosis.setProfile(diagnostic_profile.getText().trim());

            diagnosis.setFactors(list_factor);

            try {
                diagnosis = diagnosticPortal.create(diagnosis);

                System.out.println(diagnosis.getId());

                AlertInfo.getInstance().setTitle("Info");
                AlertInfo.getInstance().setHeaderText("Enregistrement diagnostic.");
                AlertInfo.getInstance().setContentText("Nouveau diagnostic enregistré avec succès.\n Téléchargez le rapport de diagnostic ?");
                if (AlertInfo.getInstance().showAndWait().get().equals(ButtonType.OK)){
                    reportPortal.reportById("diagnosis",diagnosis.getId());
                }
                reset_diagnostic_form();
            } catch (Exception e) {
                AlertError.getInstance().setTitle("Erreur");
                AlertError.getInstance().setHeaderText("Enregistrement diagnostic.");
                AlertError.getInstance().setContentText("Echec lors de l'enregistrement du diagnostic.\n"+e.getMessage());
                AlertError.getInstance().showAndWait();
                e.printStackTrace();
            }
        }
    }

    @FXML
    void cancel_diagnostic() {
        reset_diagnostic_form();
    }
    
    @FXML
    void add_factor() {
        Factor factor = new Factor();
        factor.setEntity(factor_entity.getSelectionModel().getSelectedItem().getEntity());
        factor.setDysfunction(factor_dysfunction.getEditor().getText().trim());
        factor.setMaintenance(factor_maintenance.getEditor().getText().trim());
        list_factor.add(factor);
        table_factor.setItems(FXCollections.observableArrayList(list_factor));

        factor_maintenance.getEditor().setText("");
        factor_dysfunction.getEditor().setText("");
    }
    
    @FXML
    void remove_factor() {
        Factor factor = table_factor.getSelectionModel().getSelectedItem();
        list_factor.remove(factor);
        table_factor.setItems(FXCollections.observableArrayList(list_factor));
    }
    @FXML
    void cancel_reception(ActionEvent event) {
        reset_reception_form();
    }

    @FXML
    void save_reception(ActionEvent event) {

        Notice etat = new Notice("etat111","Siège avant gauche",etat111);
        newEtats.add(etat);

        etat=new Notice("etat112","Siège arrière gauche",etat112);
        newEtats.add(etat);

        etat=new Notice("etat113","Siège Avant droit",etat113);
        newEtats.add(etat);

        etat=new Notice("etat114","Siège arrière droit",etat114);
        newEtats.add(etat);

        etat=new Notice("etat115","Banquettes",etat115);
        newEtats.add(etat);

        etat=new Notice("etat116","Moquettes",etat116);
        newEtats.add(etat);

        etat=new Notice("etat117","Ciel de toit",etat117);
        newEtats.add(etat);

        etat=new Notice("etat221","Livret de bord",etat221);
        newEtats.add(etat);

        etat=new Notice("etat222","Kit de secours",etat222);
        newEtats.add(etat);

        etat=new Notice("etat223","Roue de secours",etat223);
        newEtats.add(etat);

        etat=new Notice("etat224","Triangle de signalisation",etat224);
        newEtats.add(etat);

        etat=new Notice("etat225","Extincteur",etat225);
        newEtats.add(etat);

        etat=new Notice("etat331","Courroies d'entraînement",etat331);
        newEtats.add(etat);

        etat=new Notice("etat332","Batterie / Câbles / Colliers",etat331);
        newEtats.add(etat);

        etat=new Notice("etat333","Notice du liquide de refroidissement",etat333);
        newEtats.add(etat);

        etat=new Notice("etat334","Radiateur / Durites / Colliers",etat334);
        newEtats.add(etat);

        etat=new Notice("etat441","Huile à moteur",etat441);
        newEtats.add(etat);

        etat=new Notice("etat442","Huile boîte de vitesses",etat442);
        newEtats.add(etat);

        etat=new Notice("etat443","Liquide de frein",etat443);
        newEtats.add(etat);

        etat=new Notice("etat444","Huile de direction assistée",etat444);
        newEtats.add(etat);

        etat=new Notice("etat511","Pneu Roue Avant Gauche",etat511);
        newEtats.add(etat);

        etat=new Notice("etat512","Disque Roue Avant Gauche",etat512);
        newEtats.add(etat);

        etat=new Notice("etat513","Etrier Roue Avant Gauche",etat513);
        newEtats.add(etat);

        etat=new Notice("etat514","Canalisation / flexibles Roue Avant Gauche",etat514);
        newEtats.add(etat);

        etat=new Notice("etat521","Pneu Roue Arrière Gauche",etat521);
        newEtats.add(etat);

        etat=new Notice("etat522","Disque Roue Arrière Gauche",etat522);
        newEtats.add(etat);

        etat=new Notice("etat523","Etrier Roue Arrière Gauche",etat523);
        newEtats.add(etat);

        etat=new Notice("etat524","Canalisation / flexibles Roue Arrière Gauche",etat524);
        newEtats.add(etat);

        etat=new Notice("etat531","Pneu Roue Avant Droit",etat531);
        newEtats.add(etat);

        etat=new Notice("etat532","Disque Roue Avant Droit",etat532);
        newEtats.add(etat);

        etat=new Notice("etat533","Etrier Roue Avant Droit",etat533);
        newEtats.add(etat);

        etat=new Notice("etat534","Canalisation / flexibles Roue Avant Droit",etat534);
        newEtats.add(etat);

        etat=new Notice("etat541","Pneu Roue Arrière Droit",etat541);
        newEtats.add(etat);

        etat=new Notice("etat542","Disque Roue Arrière Droit",etat542);
        newEtats.add(etat);

        etat=new Notice("etat543","Etrier Roue Arrière Droit",etat543);
        newEtats.add(etat);

        etat=new Notice("etat544","Canalisation / flexibles Roue Arrière Droit",etat544);
        newEtats.add(etat);

        etat=new Notice("etat661","Elements de la directions",etat661);
        newEtats.add(etat);

        etat=new Notice("etat662","Elements de la suspension",etat662);
        newEtats.add(etat);

        etat=new Notice("etat663","Amortisseurs",etat663);
        newEtats.add(etat);

        etat=new Notice("etat664","Jambes de suspension",etat664);
        newEtats.add(etat);

        etat=new Notice("etat665","Système d'échappement",etat665);
        newEtats.add(etat);

        etat = new Notice("etat7","Niveau de carburant",etat7.getText());
        newEtats.add(etat);

        Reception reception = new Reception();
        //reception.setDossier(reception_dossier.getValue());
        reception.setNotices(newEtats);

        if(!etat8.getText().isEmpty())
            reception.setDescription(etat8.getText());

        if(!reception_profile.getText().isEmpty())
            reception.setProfile(reception_profile.getText().trim());

        if(!reception_mileage.getText().isEmpty())
            reception.setMileage(Integer.parseInt(reception_mileage.getText().trim()));

        try {
            reception = receptionPortal.create(reception);

            AlertInfo.getInstance().setTitle("Info");
            AlertInfo.getInstance().setHeaderText("Réception automobile");
            AlertInfo.getInstance().setContentText("Réception enregistrée avec succès.");
            AlertInfo.getInstance().show();
            reset_reception_form();

            AlertConfirm.getInstance().setTitle("Confirmation");
            AlertConfirm.getInstance().setHeaderText("Réception automobile");
            AlertConfirm.getInstance().setContentText("Réception enregistrée avec succès. Souhaitez-vous enregistrer un contrôle diagnostic pour le même véhicule?");

            if(AlertConfirm.getInstance().showAndWait().get().equals(ButtonType.OK)){
                diagnostic_mileage.setText(String.valueOf(reception.getMileage()));
                diagnostic_profile.setText(reception.getProfile());
                diagnostic_dossier.setValue(reception.getDossier());
                selectTab(2);
            }else {
                //todo:Report.getInstance().createReport("/jrxml/reception.jrxml",(int)reception.getId());
            }

            reset_reception_form();
        } catch (Exception e) {
            AlertInfo.getInstance().setTitle("Erreur");
            AlertInfo.getInstance().setHeaderText("Réception automobile");
            AlertInfo.getInstance().setContentText("Echec lors de l'enregistrement de la réception.\n"+e.getMessage());
            AlertInfo.getInstance().showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    void search_dossier_reception(KeyEvent event){
        FilteredList<Dossier> items = new FilteredList<>(FXCollections.observableArrayList(allDossier));
        items.setPredicate(item ->{
            String lower = reception_dossier.getEditor().getText().toLowerCase();
            String upper = reception_dossier.getEditor().getText().toUpperCase();
            if(item.getAutomobile().getNumber().contains(lower))
                return true;
            else
                return item.getAutomobile().getNumber().contains(upper);
        });
        SortedList<Dossier> sorted = new SortedList<>(items);
        reception_dossier.setItems(FXCollections.observableArrayList(sorted));
    }

    @FXML
    void search_dossier_diagnostic(KeyEvent event){
        FilteredList<Dossier> items = new FilteredList<>(FXCollections.observableArrayList(allDossier));
        items.setPredicate(item ->{
            String lower = reception_dossier.getEditor().getText().toLowerCase();
            String upper = reception_dossier.getEditor().getText().toUpperCase();
            if(item.getAutomobile().getNumber().contains(lower))
                return true;
            else
                return item.getAutomobile().getNumber().contains(upper);
        });
        SortedList<Dossier> sorted = new SortedList<>(items);
        reception_dossier.setItems(FXCollections.observableArrayList(sorted));
    }

    @FXML
    void etat111_danger(MouseEvent event) {
        if(etat111_danger.isSelected()){
            etat111_ok.setSelected(false);
            etat111_warning.setSelected(false);
            etat111="MAUVAIS";
        }
    }

    @FXML
    void etat111_ok(MouseEvent event) {
        if(etat111_ok.isSelected()){
            etat111_danger.setSelected(false);
            etat111_warning.setSelected(false);
            etat111="OK";
        }
    }

    @FXML
    void etat111_warning(MouseEvent event) {
        if(etat111_warning.isSelected()){
            etat111_danger.setSelected(false);
            etat111_ok.setSelected(false);
            etat111="ATTENTION";
        }
    }

    @FXML
    void etat112_danger(MouseEvent event) {
        if(etat112_danger.isSelected()){
            etat112_ok.setSelected(false);
            etat112_warning.setSelected(false);
            etat112="MAUVAIS";
        }
    }

    @FXML
    void etat112_ok(MouseEvent event) {
        if(etat112_ok.isSelected()){
            etat112_danger.setSelected(false);
            etat112_warning.setSelected(false);
            etat112="OK";
        }
    }

    @FXML
    void etat112_warning(MouseEvent event) {
        if(etat112_warning.isSelected()){
            etat112_danger.setSelected(false);
            etat112_ok.setSelected(false);
            etat112="ATTENTION";
        }
    }

    @FXML
    void etat113_danger(MouseEvent event) {
        if(etat113_danger.isSelected()){
            etat113_ok.setSelected(false);
            etat113_warning.setSelected(false);
            etat113="MAUVAIS";
        }
    }

    @FXML
    void etat113_ok(MouseEvent event) {
        if(etat113_ok.isSelected()){
            etat113_danger.setSelected(false);
            etat113_warning.setSelected(false);
            etat113="OK";
        }
    }

    @FXML
    void etat113_warning(MouseEvent event) {
        if(etat113_warning.isSelected()){
            etat113_danger.setSelected(false);
            etat113_ok.setSelected(false);
            etat113="ATTENTION";
        }
    }

    @FXML
    void etat114_danger(MouseEvent event) {
        if(etat114_danger.isSelected()){
            etat114_ok.setSelected(false);
            etat114_warning.setSelected(false);
            etat114="MAUVAIS";
        }
    }

    @FXML
    void etat114_ok(MouseEvent event) {
        if(etat114_ok.isSelected()){
            etat114_danger.setSelected(false);
            etat114_warning.setSelected(false);
            etat114="OK";
        }
    }

    @FXML
    void etat114_warning(MouseEvent event) {
        if(etat114_warning.isSelected()){
            etat114_danger.setSelected(false);
            etat114_ok.setSelected(false);
            etat114="ATTENTION";
        }
    }

    @FXML
    void etat115_danger(MouseEvent event) {
        if(etat115_danger.isSelected()){
            etat115_ok.setSelected(false);
            etat115_warning.setSelected(false);
            etat115="MAUVAIS";
        }
    }

    @FXML
    void etat115_ok(MouseEvent event) {
        if(etat115_ok.isSelected()){
            etat115_danger.setSelected(false);
            etat115_warning.setSelected(false);
            etat115="OK";
        }
    }

    @FXML
    void etat115_warning(MouseEvent event) {
        if(etat115_warning.isSelected()){
            etat115_danger.setSelected(false);
            etat115_ok.setSelected(false);
            etat115="ATTENTION";
        }
    }

    @FXML
    void etat116_danger(MouseEvent event) {
        if(etat116_danger.isSelected()){
            etat116_ok.setSelected(false);
            etat116_warning.setSelected(false);
            etat116="MAUVAIS";
        }
    }

    @FXML
    void etat116_ok(MouseEvent event) {
        if(etat116_ok.isSelected()){
            etat116_danger.setSelected(false);
            etat116_warning.setSelected(false);
            etat116="OK";
        }
    }

    @FXML
    void etat116_warning(MouseEvent event) {
        if(etat116_warning.isSelected()){
            etat116_danger.setSelected(false);
            etat116_ok.setSelected(false);
            etat116="ATTENTION";
        }
    }

    @FXML
    void etat117_danger(MouseEvent event) {
        if(etat117_danger.isSelected()){
            etat117_ok.setSelected(false);
            etat117_warning.setSelected(false);
            etat117="MAUVAIS";
        }
    }

    @FXML
    void etat117_ok(MouseEvent event) {
        if(etat117_ok.isSelected()){
            etat117_danger.setSelected(false);
            etat117_warning.setSelected(false);
            etat117="OK";
        }
    }

    @FXML
    void etat117_warning(MouseEvent event) {
        if(etat117_warning.isSelected()){
            etat117_danger.setSelected(false);
            etat117_ok.setSelected(false);
            etat117="ATTENTION";
        }
    }

    @FXML
    void etat221_danger(MouseEvent event) {
        if(etat221_danger.isSelected()){
            etat221_ok.setSelected(false);
            etat221_warning.setSelected(false);
            etat221="MAUVAIS";
        }
    }

    @FXML
    void etat221_ok(MouseEvent event) {
        if(etat221_ok.isSelected()){
            etat221_danger.setSelected(false);
            etat221_warning.setSelected(false);
            etat221="OK";
        }
    }

    @FXML
    void etat221_warning(MouseEvent event) {
        if(etat221_warning.isSelected()){
            etat221_danger.setSelected(false);
            etat221_ok.setSelected(false);
            etat221="ATTENTION";
        }
    }

    @FXML
    void etat222_danger(MouseEvent event) {
        if(etat222_danger.isSelected()){
            etat222_ok.setSelected(false);
            etat222_warning.setSelected(false);
            etat222="MAUVAIS";
        }
    }

    @FXML
    void etat222_ok(MouseEvent event) {
        if(etat222_ok.isSelected()){
            etat222_danger.setSelected(false);
            etat222_warning.setSelected(false);
            etat222="OK";
        }
    }

    @FXML
    void etat222_warning(MouseEvent event) {
        if(etat222_warning.isSelected()){
            etat222_danger.setSelected(false);
            etat222_ok.setSelected(false);
            etat222="ATTENTION";
        }
    }

    @FXML
    void etat223_danger(MouseEvent event) {
        if(etat223_danger.isSelected()){
            etat223_ok.setSelected(false);
            etat223_warning.setSelected(false);
            etat223="MAUVAIS";
        }
    }

    @FXML
    void etat223_ok(MouseEvent event) {
        if(etat223_ok.isSelected()){
            etat223_danger.setSelected(false);
            etat223_warning.setSelected(false);
            etat223="OK";
        }
    }

    @FXML
    void etat223_warning(MouseEvent event) {
        if(etat223_warning.isSelected()){
            etat223_danger.setSelected(false);
            etat223_ok.setSelected(false);
            etat223="ATTENTION";
        }
    }

    @FXML
    void etat224_danger(MouseEvent event) {
        if(etat224_danger.isSelected()){
            etat224_ok.setSelected(false);
            etat224_warning.setSelected(false);
            etat224="MAUVAIS";
        }
    }

    @FXML
    void etat224_ok(MouseEvent event) {
        if(etat224_ok.isSelected()){
            etat224_danger.setSelected(false);
            etat224_warning.setSelected(false);
            etat224="OK";
        }
    }

    @FXML
    void etat224_warning(MouseEvent event) {
        if(etat224_warning.isSelected()){
            etat224_danger.setSelected(false);
            etat224_ok.setSelected(false);
            etat224="ATTENTION";
        }
    }

    @FXML
    void etat225_danger(MouseEvent event) {
        if(etat225_danger.isSelected()){
            etat225_ok.setSelected(false);
            etat225_warning.setSelected(false);
            etat225="MAUVAIS";
        }
    }

    @FXML
    void etat225_ok(MouseEvent event) {
        if(etat225_ok.isSelected()){
            etat225_danger.setSelected(false);
            etat225_warning.setSelected(false);
            etat225="OK";
        }
    }

    @FXML
    void etat225_warning(MouseEvent event) {
        if(etat225_warning.isSelected()){
            etat225_danger.setSelected(false);
            etat225_ok.setSelected(false);
            etat225="ATTENTION";
        }
    }

    @FXML
    void etat331_danger(MouseEvent event) {
        if(etat331_danger.isSelected()){
            etat331_warning.setSelected(false);
            etat331_ok.setSelected(false);
            etat331="MAUVAIS";
        }
    }

    @FXML
    void etat331_ok(MouseEvent event) {
        if(etat331_ok.isSelected()){
            etat331_danger.setSelected(false);
            etat331_warning.setSelected(false);
            etat331="OK";
        }
    }

    @FXML
    void etat331_warning(MouseEvent event) {
        if(etat331_warning.isSelected()){
            etat331_danger.setSelected(false);
            etat331_ok.setSelected(false);
            etat331="ATTENTION";
        }
    }

    @FXML
    void etat332_danger(MouseEvent event) {
        if(etat332_danger.isSelected()){
            etat332_warning.setSelected(false);
            etat332_ok.setSelected(false);
            etat332="MAUVAIS";
        }
    }

    @FXML
    void etat332_ok(MouseEvent event) {
        if(etat332_ok.isSelected()){
            etat332_warning.setSelected(false);
            etat332_danger.setSelected(false);
            etat332="OK";
        }
    }

    @FXML
    void etat332_warning(MouseEvent event) {
        if(etat332_warning.isSelected()){
            etat332_danger.setSelected(false);
            etat332_ok.setSelected(false);
            etat332="ATTENTION";
        }
    }

    @FXML
    void etat333_danger(MouseEvent event) {
        if(etat333_danger.isSelected()){
            etat333_warning.setSelected(false);
            etat333_ok.setSelected(false);
            etat333="MAUVAIS";
        }
    }

    @FXML
    void etat333_ok(MouseEvent event) {
        if(etat333_ok.isSelected()){
            etat333_warning.setSelected(false);
            etat333_danger.setSelected(false);
            etat333="OK";
        }
    }

    @FXML
    void etat333_warning(MouseEvent event) {
        if(etat333_warning.isSelected()){
            etat333_danger.setSelected(false);
            etat333_ok.setSelected(false);
            etat333="ATTENTION";
        }
    }

    @FXML
    void etat334_danger(MouseEvent event) {
        if(etat334_danger.isSelected()){
            etat334_warning.setSelected(false);
            etat334_ok.setSelected(false);
            etat334="MAUVAIS";
        }
    }

    @FXML
    void etat334_ok(MouseEvent event) {
        if(etat334_ok.isSelected()){
            etat334_danger.setSelected(false);
            etat334_warning.setSelected(false);
            etat334="OK";
        }
    }

    @FXML
    void etat334_warning(MouseEvent event) {
        if(etat334_warning.isSelected()){
            etat334_danger.setSelected(false);
            etat334_ok.setSelected(false);
            etat334="ATTENTION";
        }
    }

    @FXML
    void etat441_danger(MouseEvent event) {
        if(etat441_danger.isSelected()){
            etat441_warning.setSelected(false);
            etat441_ok.setSelected(false);
            etat441="MAUVAIS";
        }
    }

    @FXML
    void etat441_ok(MouseEvent event) {
        if(etat441_ok.isSelected()){
            etat441_warning.setSelected(false);
            etat441_danger.setSelected(false);
            etat441="OK";
        }
    }

    @FXML
    void etat441_warning(MouseEvent event) {
        if(etat441_warning.isSelected()){
            etat441_ok.setSelected(false);
            etat441_danger.setSelected(false);
            etat441="ATTENTION";
        }
    }

    @FXML
    void etat442_danger(MouseEvent event) {
        if(etat442_danger.isSelected()){
            etat442_warning.setSelected(false);
            etat442_ok.setSelected(false);
            etat442="MAUVAIS";
        }
    }

    @FXML
    void etat442_ok(MouseEvent event) {
        if(etat442_ok.isSelected()){
            etat442_warning.setSelected(false);
            etat442_danger.setSelected(false);
            etat442="OK";
        }
    }

    @FXML
    void etat442_warning(MouseEvent event) {
        if(etat442_warning.isSelected()){
            etat442_ok.setSelected(false);
            etat442_danger.setSelected(false);
            etat442="ATTENTION";
        }
    }

    @FXML
    void etat443_danger(MouseEvent event) {
        if(etat443_danger.isSelected()){
            etat443_warning.setSelected(false);
            etat443_ok.setSelected(false);
            etat443="MAUVAIS";
        }
    }

    @FXML
    void etat443_ok(MouseEvent event) {
        if(etat443_ok.isSelected()){
            etat443_warning.setSelected(false);
            etat443_danger.setSelected(false);
            etat443="OK";
        }
    }

    @FXML
    void etat443_warning(MouseEvent event) {
        if(etat443_warning.isSelected()){
            etat443_danger.setSelected(false);
            etat443_ok.setSelected(false);
            etat443="ATTENTION";
        }
    }

    @FXML
    void etat444_danger(MouseEvent event) {
        if(etat444_danger.isSelected()){
            etat444_warning.setSelected(false);
            etat444_ok.setSelected(false);
            etat444="MAUVAIS";
        }
    }

    @FXML
    void etat444_ok(MouseEvent event) {
        if(etat444_ok.isSelected()){
            etat444_warning.setSelected(false);
            etat444_danger.setSelected(false);
            etat444="OK";
        }
    }

    @FXML
    void etat444_warning(MouseEvent event) {
        if(etat444_warning.isSelected()){
            etat444_danger.setSelected(false);
            etat444_ok.setSelected(false);
            etat444="ATTENTION";
        }
    }

    @FXML
    void etat511_danger(MouseEvent event) {
        if(etat511_danger.isSelected()){
            etat511_warning.setSelected(false);
            etat511_ok.setSelected(false);
            etat511="MAUVAIS";
        }
    }

    @FXML
    void etat511_ok(MouseEvent event) {
        if(etat511_ok.isSelected()){
            etat511_warning.setSelected(false);
            etat511_danger.setSelected(false);
            etat511="OK";
        }
    }

    @FXML
    void etat511_warning(MouseEvent event) {
        if(etat511_warning.isSelected()){
            etat511_ok.setSelected(false);
            etat511_danger.setSelected(false);
            etat511="ATTENTION";
        }
    }

    @FXML
    void etat512_danger(MouseEvent event) {
        if(etat512_danger.isSelected()){
            etat512_warning.setSelected(false);
            etat512_ok.setSelected(false);
            etat512="MAUVAIS";
        }
    }

    @FXML
    void etat512_ok(MouseEvent event) {
        if(etat512_ok.isSelected()){
            etat512_warning.setSelected(false);
            etat512_danger.setSelected(false);
            etat512="OK";
        }
    }

    @FXML
    void etat512_warning(MouseEvent event) {
        if(etat512_warning.isSelected()){
            etat512_ok.setSelected(false);
            etat512_danger.setSelected(false);
            etat512="ATTENTION";
        }
    }

    @FXML
    void etat513_danger(MouseEvent event) {
        if(etat513_danger.isSelected()){
            etat513_warning.setSelected(false);
            etat513_ok.setSelected(false);
            etat513="MAUVAIS";
        }
    }

    @FXML
    void etat513_ok(MouseEvent event) {
        if(etat513_ok.isSelected()){
            etat513_warning.setSelected(false);
            etat513_danger.setSelected(false);
            etat513="OK";
        }
    }

    @FXML
    void etat513_warning(MouseEvent event) {
        if(etat513_warning.isSelected()){
            etat513_ok.setSelected(false);
            etat513_danger.setSelected(false);
            etat513="ATTENTION";
        }
    }

    @FXML
    void etat514_danger(MouseEvent event) {
        if(etat514_danger.isSelected()){
            etat514_warning.setSelected(false);
            etat514_ok.setSelected(false);
            etat514="MAUVAIS";
        }
    }

    @FXML
    void etat514_ok(MouseEvent event) {
        if(etat514_ok.isSelected()){
            etat514_warning.setSelected(false);
            etat514_danger.setSelected(false);
            etat514="OK";
        }
    }

    @FXML
    void etat514_warning(MouseEvent event) {
        if(etat514_warning.isSelected()){
            etat514_ok.setSelected(false);
            etat514_danger.setSelected(false);
            etat514="ATTENTION";
        }
    }

    @FXML
    void etat521_danger(MouseEvent event) {
        if(etat521_danger.isSelected()){
            etat521_warning.setSelected(false);
            etat521_ok.setSelected(false);
            etat521="MAUVAIS";
        }
    }

    @FXML
    void etat521_ok(MouseEvent event) {
        if(etat521_ok.isSelected()){
            etat521_warning.setSelected(false);
            etat521_danger.setSelected(false);
            etat521="OK";
        }
    }

    @FXML
    void etat521_warning(MouseEvent event) {
        if(etat521_warning.isSelected()){
            etat521_ok.setSelected(false);
            etat521_danger.setSelected(false);
            etat521="ATTENTION";
        }
    }

    @FXML
    void etat522_danger(MouseEvent event) {
        if(etat522_danger.isSelected()){
            etat522_warning.setSelected(false);
            etat522_ok.setSelected(false);
            etat522="MAUVAIS";
        }
    }

    @FXML
    void etat522_ok(MouseEvent event) {
        if(etat522_ok.isSelected()){
            etat522_warning.setSelected(false);
            etat522_danger.setSelected(false);
            etat522="OK";
        }
    }

    @FXML
    void etat522_warning(MouseEvent event) {
        if(etat522_warning.isSelected()){
            etat522_ok.setSelected(false);
            etat522_danger.setSelected(false);
            etat522="ATTENTION";
        }
    }

    @FXML
    void etat523_danger(MouseEvent event) {
        if(etat523_danger.isSelected()){
            etat523_warning.setSelected(false);
            etat523_ok.setSelected(false);
            etat523="MAUVAIS";
        }
    }

    @FXML
    void etat523_ok(MouseEvent event) {
        if(etat523_ok.isSelected()){
            etat523_warning.setSelected(false);
            etat523_danger.setSelected(false);
            etat523="OK";
        }
    }

    @FXML
    void etat523_warning(MouseEvent event) {
        if(etat523_warning.isSelected()){
            etat523_ok.setSelected(false);
            etat523_danger.setSelected(false);
            etat523="ATTENTION";
        }
    }

    @FXML
    void etat524_danger(MouseEvent event) {
        if(etat524_danger.isSelected()){
            etat524_warning.setSelected(false);
            etat524_ok.setSelected(false);
            etat524="MAUVAIS";
        }
    }

    @FXML
    void etat524_ok(MouseEvent event) {
        if(etat524_ok.isSelected()){
            etat524_warning.setSelected(false);
            etat524_danger.setSelected(false);
            etat524="OK";
        }
    }

    @FXML
    void etat524_warning(MouseEvent event) {
        if(etat524_warning.isSelected()){
            etat524_ok.setSelected(false);
            etat524_danger.setSelected(false);
            etat524="ATTENTION";
        }
    }

    @FXML
    void etat531_danger(MouseEvent event) {
        if(etat531_danger.isSelected()){
            etat531_warning.setSelected(false);
            etat531_ok.setSelected(false);
            etat531="MAUVAIS";
        }
    }

    @FXML
    void etat531_ok(MouseEvent event) {
        if(etat531_ok.isSelected()){
            etat531_warning.setSelected(false);
            etat531_danger.setSelected(false);
            etat531="OK";
        }
    }

    @FXML
    void etat531_warning(MouseEvent event) {
        if(etat531_warning.isSelected()){
            etat531_ok.setSelected(false);
            etat531_danger.setSelected(false);
            etat531="ATTENTION";
        }
    }

    @FXML
    void etat532_danger(MouseEvent event) {
        if(etat532_danger.isSelected()){
            etat532_warning.setSelected(false);
            etat532_ok.setSelected(false);
            etat532="MAUVAIS";
        }
    }

    @FXML
    void etat532_ok(MouseEvent event) {
        if(etat532_ok.isSelected()){
            etat532_warning.setSelected(false);
            etat532_danger.setSelected(false);
            etat532="OK";
        }
    }

    @FXML
    void etat532_warning(MouseEvent event) {
        if(etat532_warning.isSelected()){
            etat532_ok.setSelected(false);
            etat532_danger.setSelected(false);
            etat532="ATTENTION";
        }
    }

    @FXML
    void etat533_danger(MouseEvent event) {
        if(etat533_danger.isSelected()){
            etat533_warning.setSelected(false);
            etat533_ok.setSelected(false);
            etat533="MAUVAIS";
        }
    }

    @FXML
    void etat533_ok(MouseEvent event) {
        if(etat533_ok.isSelected()){
            etat533_warning.setSelected(false);
            etat533_danger.setSelected(false);
            etat533="OK";
        }
    }

    @FXML
    void etat533_warning(MouseEvent event) {
        if(etat533_warning.isSelected()){
            etat533_ok.setSelected(false);
            etat533_danger.setSelected(false);
            etat533="ATTENTION";
        }
    }

    @FXML
    void etat534_danger(MouseEvent event) {
        if(etat534_danger.isSelected()){
            etat534_warning.setSelected(false);
            etat534_ok.setSelected(false);
            etat534="MAUVAIS";
        }
    }

    @FXML
    void etat534_ok(MouseEvent event) {
        if(etat534_ok.isSelected()){
            etat534_warning.setSelected(false);
            etat534_danger.setSelected(false);
            etat534="OK";
        }
    }

    @FXML
    void etat534_warning(MouseEvent event) {
        if(etat534_warning.isSelected()){
            etat534_ok.setSelected(false);
            etat534_danger.setSelected(false);
            etat534="ATTENTION";
        }
    }

    @FXML
    void etat541_danger(MouseEvent event) {
        if(etat541_danger.isSelected()){
            etat541_warning.setSelected(false);
            etat541_ok.setSelected(false);
            etat541="MAUVAIS";
        }
    }

    @FXML
    void etat541_ok(MouseEvent event) {
        if(etat541_ok.isSelected()){
            etat541_warning.setSelected(false);
            etat541_danger.setSelected(false);
            etat541="OK";
        }
    }

    @FXML
    void etat541_warning(MouseEvent event) {
        if(etat541_warning.isSelected()){
            etat541_ok.setSelected(false);
            etat541_danger.setSelected(false);
            etat541="ATTENTION";
        }
    }

    @FXML
    void etat542_danger(MouseEvent event) {
        if(etat542_danger.isSelected()){
            etat542_warning.setSelected(false);
            etat542_ok.setSelected(false);
            etat542="MAUVAIS";
        }
    }

    @FXML
    void etat542_ok(MouseEvent event) {
        if(etat542_ok.isSelected()){
            etat542_warning.setSelected(false);
            etat542_danger.setSelected(false);
            etat542="OK";
        }
    }

    @FXML
    void etat542_warning(MouseEvent event) {
        if(etat542_warning.isSelected()){
            etat542_ok.setSelected(false);
            etat542_danger.setSelected(false);
            etat542="ATTENTION";
        }
    }

    @FXML
    void etat543_danger(MouseEvent event) {
        if(etat543_danger.isSelected()){
            etat543_warning.setSelected(false);
            etat543_ok.setSelected(false);
            etat543="MAUVAIS";
        }
    }

    @FXML
    void etat543_ok(MouseEvent event) {
        if(etat543_ok.isSelected()){
            etat543_warning.setSelected(false);
            etat543_danger.setSelected(false);
            etat543="OK";
        }
    }

    @FXML
    void etat543_warning(MouseEvent event) {
        if(etat543_warning.isSelected()){
            etat543_ok.setSelected(false);
            etat543_danger.setSelected(false);
            etat543="ATTENTION";
        }
    }

    @FXML
    void etat544_danger(MouseEvent event) {
        if(etat544_danger.isSelected()){
            etat544_warning.setSelected(false);
            etat544_ok.setSelected(false);
            etat544="MAUVAIS";
        }
    }

    @FXML
    void etat544_ok(MouseEvent event) {
        if(etat544_ok.isSelected()){
            etat544_warning.setSelected(false);
            etat544_danger.setSelected(false);
            etat544="OK";
        }
    }

    @FXML
    void etat544_warning(MouseEvent event) {
        if(etat544_warning.isSelected()){
            etat544_ok.setSelected(false);
            etat544_danger.setSelected(false);
            etat544="ATTENTION";
        }
    }

    @FXML
    void etat661_danger(MouseEvent event) {
        if(etat661_danger.isSelected()){
            etat661_warning.setSelected(false);
            etat661_ok.setSelected(false);
            etat661="MAUVAIS";
        }
    }

    @FXML
    void etat661_ok(MouseEvent event) {
        if(etat661_ok.isSelected()){
            etat661_warning.setSelected(false);
            etat661_danger.setSelected(false);
            etat661="OK";
        }
    }

    @FXML
    void etat661_warning(MouseEvent event) {
        if(etat661_warning.isSelected()){
            etat661_ok.setSelected(false);
            etat661_danger.setSelected(false);
            etat661="ATTENTION";
        }
    }

    @FXML
    void etat662_danger(MouseEvent event) {
        if(etat662_danger.isSelected()){
            etat662_warning.setSelected(false);
            etat662_ok.setSelected(false);
            etat662="MAUVAIS";
        }
    }

    @FXML
    void etat662_ok(MouseEvent event) {
        if(etat662_ok.isSelected()){
            etat662_warning.setSelected(false);
            etat662_danger.setSelected(false);
            etat662="OK";
        }
    }

    @FXML
    void etat662_warning(MouseEvent event) {
        if(etat662_warning.isSelected()){
            etat662_ok.setSelected(false);
            etat662_danger.setSelected(false);
            etat662="ATTENTION";
        }
    }

    @FXML
    void etat663_danger(MouseEvent event) {
        if(etat663_danger.isSelected()){
            etat663_warning.setSelected(false);
            etat663_ok.setSelected(false);
            etat663="MAUVAIS";
        }
    }

    @FXML
    void etat663_ok(MouseEvent event) {
        if(etat663_ok.isSelected()){
            etat663_warning.setSelected(false);
            etat663_danger.setSelected(false);
            etat663="OK";
        }
    }

    @FXML
    void etat663_warning(MouseEvent event) {
        if(etat663_warning.isSelected()){
            etat663_ok.setSelected(false);
            etat663_danger.setSelected(false);
            etat663="ATTENTION";
        }
    }

    @FXML
    void etat664_danger(MouseEvent event) {
        if(etat664_danger.isSelected()){
            etat664_warning.setSelected(false);
            etat664_ok.setSelected(false);
            etat664="MAUVAIS";
        }
    }

    @FXML
    void etat664_ok(MouseEvent event) {
        if(etat664_ok.isSelected()){
            etat664_warning.setSelected(false);
            etat664_danger.setSelected(false);
            etat664="OK";
        }
    }

    @FXML
    void etat664_warning(MouseEvent event) {
        if(etat664_warning.isSelected()){
            etat664_ok.setSelected(false);
            etat664_danger.setSelected(false);
            etat664="ATTENTION";
        }
    }

    @FXML
    void etat665_danger(MouseEvent event) {
        if(etat665_danger.isSelected()){
            etat665_warning.setSelected(false);
            etat665_ok.setSelected(false);
            etat665="MAUVAIS";
        }
    }

    @FXML
    void etat665_ok(MouseEvent event) {
        if(etat665_ok.isSelected()){
            etat665_warning.setSelected(false);
            etat665_danger.setSelected(false);
            etat665="OK";
        }
    }

    @FXML
    void etat665_warning(MouseEvent event) {
        if(etat665_warning.isSelected()){
            etat665_ok.setSelected(false);
            etat665_danger.setSelected(false);
            etat665="ATTENTION";
        }
    }

    @FXML
    void factor_dysfunction_entry(KeyEvent event) {
        diagnoses.clear();
        dysfunctions.clear();
        maintenances.clear();
        String entry = factor_dysfunction.getEditor().getText().trim();
        try {
            diagnoses = diagnosticPortal.processDiagnosis(entry);
            for (Diagnosis diagnosis:diagnoses) {
                dysfunctions.add(diagnosis.getDysfunction());
                maintenances.add(diagnosis.getMaintenance());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        getInstance().factor_dysfunction.setItems(FXCollections.observableArrayList(dysfunctions));
        getInstance().factor_maintenance.setItems(FXCollections.observableArrayList(maintenances));
    }

    public ReceptionController() {
        instance = this;
        this.dossierPortal = new DossierPortal();
        this.receptionPortal = new ReceptionPortal();
        this.diagnosticPortal = new DiagnosticPortal();
        this.reportPortal = new ReportPortal();
        diagnoses = new ArrayList<>();
        dysfunctions = new HashSet<>();
        maintenances = new HashSet<>();
        rowNbr = new AtomicInteger(0);
    }

    public static ReceptionController getInstance() {
        return instance;
    }

    public void initialize(URL location, ResourceBundle resources) {

        getDossiers();

        factor_entity.setItems(FXCollections.observableArrayList(Entity.values()));

        column_factor_entity.setCellValueFactory((TableColumn.CellDataFeatures<Factor, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getEntity()));
        column_factor_dysfunction.setCellValueFactory((TableColumn.CellDataFeatures<Factor, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getDysfunction()));
        column_factor_maintenance.setCellValueFactory((TableColumn.CellDataFeatures<Factor, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getMaintenance()));

        receptionTab.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            public void changed(ObservableValue<? extends Tab> observableValue, Tab tab, Tab t1) {
                if (tab.getTabPane().getSelectionModel().getSelectedIndex() == 2) {
                    readAll();
                }
            }
        });

        reception_dossier.setConverter(new StringConverter<Dossier>() {
            @Override
            public String toString(Dossier object) {
                if(object==null){
                    return null;
                }
                return object.getReference();
            }

            @Override
            public Dossier fromString(String string) {
                FilteredList<Dossier> items = new FilteredList<>(FXCollections.observableArrayList(allDossier));
                items.setPredicate(item -> item.getReference().contains(string));
                SortedList<Dossier> sorted = new SortedList<>(items);
                return sorted.get(0);
            }
        });

        diagnostic_dossier.setConverter(new StringConverter<Dossier>() {
            @Override
            public String toString(Dossier object) {
                if(object==null){
                    return null;
                }
                return object.getReference();
            }

            @Override
            public Dossier fromString(String string) {
                FilteredList<Dossier> items = new FilteredList<>(FXCollections.observableArrayList(allDossier));
                items.setPredicate(item -> item.getReference().contains(string));
                SortedList<Dossier> sorted = new SortedList<>(items);
                return sorted.get(0);
            }
        });
    }

    void reset_diagnostic_form() {
        dossierID=0;
        diagnostic_dossier.getEditor().setText("");
        diagnostic_mileage.setText("");
        factor_dysfunction.getEditor().setText("");
        factor_dysfunction.setItems(null);
        factor_maintenance.getEditor().setText("");
        factor_maintenance.setItems(null);
        list_factor.clear();
        table_factor.setItems(null);
        diagnoses.clear();
        dysfunctions.clear();
        maintenances.clear();
    }

    void reset_reception_form() {
        list_etat.clear();
        dossierID = 0;
        receptionID = 0;
    }

    void readAll() {
        try {
            Reception reception = receptionPortal.read(receptionID);
            list_etat = FXCollections.observableArrayList(reception.getNotices());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectTab(int i) {
        receptionTab.getSelectionModel().select(getTab(i));
    }

    public Tab getTab(int i) {

        Tab tab = null;

        switch (i) {
            case 1 -> {
                tab = tab_reception;
            }
            case 2 -> {
                tab = tab_diagnostic;
            }
        }
        return tab;
    }

    public void getDossiers(){
        try {
            this.allDossier = dossierPortal.read();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        diagnostic_dossier.setItems(FXCollections.observableArrayList(this.allDossier));
        reception_dossier.setItems(FXCollections.observableArrayList(this.allDossier));
    }
}
