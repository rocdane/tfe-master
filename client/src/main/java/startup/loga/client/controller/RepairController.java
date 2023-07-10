package startup.loga.client.controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import startup.loga.client.app.api.DossierPortal;
import startup.loga.client.app.api.RepairPortal;
import startup.loga.client.model.*;
import startup.loga.client.vendor.io.Money;
import startup.loga.client.vendor.io.NumberToWords;
import startup.loga.client.view.AlertConfirm;
import startup.loga.client.view.AlertError;
import startup.loga.client.view.AlertInfo;
import startup.loga.client.view.AlertWarning;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class RepairController implements Initializable {

    private final RepairPortal repairPortal;
    private final DossierPortal dossierPortal;

    Dossier currentDossier;

    Repair currentRepair;

    List<Dossier> allDossier = new ArrayList<>();

    List<Repair> allRepairs = new ArrayList<>();

    List<Repair> allOrderedTasks = new ArrayList<>();

    private List<Spare> temp_spares = new ArrayList<>();

    private List<Task> temp_tasks = new ArrayList<>();

    private List<Spare> spares = new ArrayList<>();

    private List<Task> tasks = new ArrayList<>();

    private double totalTask;

    private double totalSpare;

    @FXML
    private AnchorPane content;

    @FXML
    private TabPane reparationTab;

    @FXML
    private Tab tab_reparations;

    @FXML
    private TableView<Repair> table_repair;

    @FXML
    private TableColumn<Repair, Long> column_repair_id;

    @FXML
    private TableColumn<Repair, String> column_repair_date;

    @FXML
    private TableColumn<Repair, String> column_repair_dossier;

    @FXML
    private TableColumn<Repair, String> column_repair_description;

    @FXML
    private TableColumn<Repair, Integer> column_repair_mileage;

    @FXML
    private TableColumn<Repair, String> column_repair_profile;

    @FXML
    private Tab tab_new_reparation;

    @FXML
    private ComboBox<Dossier> new_repair_dossier;

    @FXML
    private TextField edit_repair_profile;

    @FXML
    private TextArea new_repair_description;

    @FXML
    private TextField new_repair_mileage;

    @FXML
    private ComboBox<Spare> new_spare_designation;

    @FXML
    private TextField new_repair_profile;

    @FXML
    private TextField new_spare_price;

    @FXML
    private TextField new_spare_quantity;

    @FXML
    private TextField new_spare_amount;

    @FXML
    private TableView<Spare> table_new_spare;

    @FXML
    private TableColumn<Spare, String> column_new_spare_designation;

    @FXML
    private TableColumn<Spare, Float> column_new_spare_price;

    @FXML
    private TableColumn<Spare, Integer> column_new_spare_quantity;

    @FXML
    private TableColumn<Spare, Float> column_new_spare_amount;

    @FXML
    private ComboBox<Task> new_task_description;

    @FXML
    private TextField new_task_hourly;

    @FXML
    private TextField new_task_rate;

    @FXML
    private TextField new_task_cost;

    @FXML
    private TableView<Task> table_new_task;

    @FXML
    private TableColumn<Task, String> column_new_task_description;

    @FXML
    private TableColumn<Task, Float> column_new_task_hourly;

    @FXML
    private TableColumn<Task, Float> column_new_task_rate;

    @FXML
    private TableColumn<Task, Float> column_new_task_cost;

    @FXML
    private Tab tab_ordre_reparation;

    @FXML
    private Tab tab_controle_qualite;

    @FXML
    private ComboBox<Repair> edit_repair;

    @FXML
    private TextArea edit_repair_description;

    @FXML
    private ComboBox<Spare> edit_spare_designation;

    @FXML
    private TextField repair_reference;

    @FXML
    private TextField edit_spare_price;

    @FXML
    private TextField edit_spare_quantity;

    @FXML
    private TextField edit_spare_amount;

    @FXML
    private TableView<Spare> table_edit_spare;

    @FXML
    private TableColumn<Spare, Long> column_edit_spare_id;

    @FXML
    private TableColumn<Spare, String> column_edit_spare_designation;

    @FXML
    private TableColumn<Spare, Float> column_edit_spare_price;

    @FXML
    private TableColumn<Spare, Integer> column_edit_spare_quantity;

    @FXML
    private TableColumn<Spare, Float> column_edit_spare_amount;

    @FXML
    private TextArea total_spare;

    @FXML
    private ComboBox<Task> edit_task_description;

    @FXML
    private TextField edit_task_hourly;

    @FXML
    private TextField edit_task_rate;

    @FXML
    private TextField edit_task_cost;

    @FXML
    private TableView<Task> table_edit_task;

    @FXML
    private TableColumn<Task, Long> column_edit_task_id;

    @FXML
    private TableColumn<Task, String> column_edit_task_description;

    @FXML
    private TableColumn<Task, Float> column_edit_task_hourly;

    @FXML
    private TableColumn<Task, Float> column_edit_task_rate;

    @FXML
    private TableColumn<Task, Float> column_edit_task_cost;

    @FXML
    private TextArea total_task;

    @FXML
    private ComboBox<Repair> ordre_reparation;

    @FXML
    void add_spare(ActionEvent event) {
        Spare fourniture = new Spare();
        fourniture.setDesignation(new_spare_designation.getEditor().getText().trim());
        fourniture.setPrice(Float.parseFloat(new_spare_price.getText().trim()));
        fourniture.setQuantity(Integer.parseInt(new_spare_quantity.getText()));
        fourniture.setAmount(Float.parseFloat(new_spare_amount.getText()));
        this.temp_spares.add(fourniture);
        table_new_spare.setItems(FXCollections.observableArrayList(temp_spares));
        new_spare_designation.getEditor().setText("");
        new_spare_price.setText("");
        new_spare_quantity.setText("");
        new_spare_amount.setText("");
    }

    @FXML
    void apply_spare(ActionEvent event) {
        Spare fourniture = new Spare();
        fourniture.setDesignation(edit_spare_designation.getEditor().getText().trim());
        fourniture.setPrice(Float.parseFloat(edit_spare_price.getText().trim()));
        fourniture.setAmount(Float.parseFloat(edit_spare_amount.getText().trim()));
        fourniture.setQuantity(Integer.parseInt(edit_spare_quantity.getText().trim()));
        fourniture.setRepair(currentRepair);

        try {
            repairPortal.editSpare(fourniture,fourniture.getId());
        } catch (Exception e) {
            AlertError.getInstance().setTitle("Erreur");
            AlertError.getInstance().setHeaderText("Réparation automobile");
            AlertError.getInstance().setContentText("Echec lors de l'enregistrement de la réparation.\n"+e.getMessage());
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
        read_ordre_reparation_fourniture(currentRepair);
        edit_spare_designation.getEditor().setText("");
        edit_spare_price.setText("");
        edit_spare_amount.setText("");
        edit_spare_quantity.setText("");
    }

    @FXML
    void apply(ActionEvent event) throws IOException, InterruptedException {

        Repair reparation = repairPortal.read(currentRepair.getId());
        reparation.setReference(repair_reference.getText().trim());
        reparation.setDescription(edit_repair_description.getText().trim());

        if(!reparation.getApproved()){
            reparation.setTotalSpare(reparation.getTotalSpare());
            reparation.setTotalTask(reparation.getTotalTask());
            reparation.setTotal(reparation.getTotal());
            reparation.setTotalLetter(NumberToWords.convert(reparation.getTotal().longValue()));
        }

        try {
            repairPortal.edit(reparation,currentRepair.getId());
        } catch (IOException | InterruptedException e) {
            AlertError.getInstance().setTitle("Echec");
            AlertError.getInstance().setHeaderText("Ordre de réparation");
            AlertError.getInstance().setContentText("Echec lors de la mise à jour de la réparation.\n"+e.getMessage());
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    void apply_task(ActionEvent event) {

        Task sub = new Task();
        sub.setHourly(Float.parseFloat(edit_task_hourly.getText().trim()));
        sub.setRate(Float.parseFloat(edit_task_rate.getText().trim()));
        sub.setRepair(currentRepair);

        try {
            repairPortal.editTask(sub,table_edit_task.getSelectionModel().getSelectedItem().getId());
        } catch (Exception e) {
            AlertError.getInstance().setTitle("Erreur");
            AlertError.getInstance().setHeaderText("Réparation automobile");
            AlertError.getInstance().setContentText("Echec lors de l'enregistrement de la réparation.\n"+e.getMessage());
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }

        read_ordre_reparation_tache(currentRepair);
        edit_task_description.getEditor().setText("");
        edit_task_cost.setText("");
        edit_task_hourly.setText("");
        edit_task_rate.setText("");
    }

    @FXML
    void add_qualite(ActionEvent event) {

    }

    @FXML
    void submit(ActionEvent event) {

        if (this.temp_spares.isEmpty() || this.temp_tasks.isEmpty()) {
            AlertInfo.getInstance().setTitle("Attention");
            AlertInfo.getInstance().setHeaderText("Réparation automobile");
            AlertInfo.getInstance().setContentText("Impossible de créer une réparation sans des tâches ou fournitures.");
            AlertInfo.getInstance().show();
        } else {
            Repair repair = new Repair();
            repair.setApproved(false);
            repair.setDossier(new_repair_dossier.getValue());
            repair.setDescription(new_repair_description.getText().trim());
            repair.setMileage(Integer.parseInt(new_repair_mileage.getText().trim()));
            repair.setProfile(new_repair_profile.getText().trim());

            try {
                repairPortal.create(repair);

                editRepair(repair);

                reset_new_reparation_form();
                AlertInfo.getInstance().setTitle("Succès");
                AlertInfo.getInstance().setHeaderText("Réparation automobile");
                AlertInfo.getInstance().setContentText("Réparation automobile enregistrée avec succès.");
                AlertInfo.getInstance().showAndWait();
            } catch (Exception e) {
                AlertError.getInstance().setTitle("Erreur");
                AlertError.getInstance().setHeaderText("Réparation automobile");
                AlertError.getInstance().setContentText("Echec lors de l'enregistrement de la réparation.\n"+e.getMessage());
                AlertError.getInstance().showAndWait();
                e.printStackTrace();
            }
            read_reparation();
        }
    }

    @FXML
    void add_task(ActionEvent event) {
        Task tache = new Task();
        tache.setRate(Float.parseFloat(new_task_rate.getText()));
        tache.setHourly(Float.parseFloat(new_task_hourly.getText()));
        this.temp_tasks.add(tache);
        table_new_task.setItems(FXCollections.observableArrayList(temp_tasks));
        new_task_hourly.setText("");
        new_task_cost.setText("");
        new_task_rate.setText("");
        new_task_description.getEditor().setText("");
    }

    @FXML
    void cancel_ordre(ActionEvent event) {
        reset_edit_repair_form();
    }

    @FXML
    void cancel_qualite(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {
        reset_new_reparation_form();
    }

    @FXML
    void delete_spare(ActionEvent event) {

        try {
            repairPortal.deleteSpare(table_edit_spare.getSelectionModel().getSelectedItem().getId());
        } catch (Exception e) {
            AlertError.getInstance().setTitle("Erreur");
            AlertError.getInstance().setHeaderText("Réparation automobile");
            AlertError.getInstance().setContentText("Echec lors de la mise à jour de la réparation.\n"+e.getMessage());
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
        read_edit_reparation_fourniture();
    }

    @FXML
    void delete_repair(ActionEvent event) {
        AlertConfirm.getInstance().setTitle("Erreur");
        AlertConfirm.getInstance().setHeaderText("Réparation automobile");
        AlertConfirm.getInstance().setContentText("Voulez-vous supprimer la réparation ?");

        if(AlertConfirm.getInstance().showAndWait().get().equals(ButtonType.OK)){
            try {
                repairPortal.delete(currentRepair.getId());
            } catch (Exception e) {
                AlertError.getInstance().setTitle("Erreur");
                AlertError.getInstance().setHeaderText("Réparation automobile");
                AlertError.getInstance().setContentText("Echec lors de la suppression de la réparation.\n"+e.getMessage());
                AlertError.getInstance().showAndWait();
                e.printStackTrace();
            }
            reset_edit_repair_form();
            read_reparation();
        }
    }

    @FXML
    void delete_task(ActionEvent event) {
        try {
            repairPortal.deleteTask(table_edit_task.getSelectionModel().getSelectedItem().getId());
        } catch (Exception e) {
            AlertError.getInstance().setTitle("Erreur");
            AlertError.getInstance().setHeaderText("Réparation automobile");
            AlertError.getInstance().setContentText("Echec lors de la mise à jour de la réparation.\n"+e.getMessage());
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
        read_edit_reparation_tache();
    }

    @FXML
    void dossier_automobile(KeyEvent event) {
        FilteredList<Dossier> items = new FilteredList<>(FXCollections.observableArrayList(allDossier));
        items.setPredicate(item ->{
            String lower = new_repair_dossier.getEditor().getText().toLowerCase();
            String upper = new_repair_dossier.getEditor().getText().toUpperCase();
            if(item.getAutomobile().getVin().contains(lower))
                return true;
            else
                return item.getAutomobile().getVin().contains(upper);
        });
        SortedList<Dossier> sorted = new SortedList<>(items);
        new_repair_dossier.setItems(sorted);
    }

    @FXML
    void new_cout(KeyEvent event) {
        if(!new_task_hourly.getText().isEmpty())
            new_task_rate.setText(String.valueOf(Float.parseFloat(new_task_cost.getText().trim())/Float.parseFloat(new_task_hourly.getText().trim())));
    }

    @FXML
    void new_montant(KeyEvent event) {
        if(!new_spare_quantity.getText().isEmpty())
            new_spare_price.setText(String.valueOf(Double.parseDouble(new_spare_amount.getText().trim()) / Integer.parseInt(new_spare_quantity.getText().trim())));
    }

    @FXML
    void new_prix(KeyEvent event) {
        if(!new_spare_quantity.getText().isEmpty())
            new_spare_amount.setText(String.valueOf(Integer.parseInt(new_spare_quantity.getText().trim()) * Double.parseDouble(new_spare_price.getText().trim())));
    }

    @FXML
    void new_quantite(KeyEvent event) {
        if(!new_spare_price.getText().isEmpty()) {
            new_spare_amount.setText(String.valueOf(Integer.parseInt(new_spare_quantity.getText().trim()) * Double.parseDouble(new_spare_price.getText().trim())));
        }else if(!new_spare_amount.getText().isEmpty()){
            new_spare_price.setText(String.valueOf(Double.parseDouble(new_spare_amount.getText().trim()) / Integer.parseInt(new_spare_quantity.getText().trim())));
        }
    }

    @FXML
    void new_search_article(KeyEvent event) {
        FilteredList<Spare> items = new FilteredList<>(FXCollections.observableArrayList(spares));
        items.setPredicate(item ->{
            String lower = new_spare_designation.getEditor().getText().toLowerCase();
            String upper = new_spare_designation.getEditor().getText().toUpperCase();
            if(item.getDesignation().contains(lower))
                return true;
            else
                return item.getDesignation().contains(upper);
        });
        SortedList<Spare> sorted = new SortedList<>(items);
        new_spare_designation.setItems(sorted);
    }

    @FXML
    void new_search_tache(KeyEvent event) {
        FilteredList<Task> items = new FilteredList<>(FXCollections.observableArrayList(tasks));
        items.setPredicate(item ->{
            String lower = new_task_description.getEditor().getText().toLowerCase();
            String upper = new_task_description.getEditor().getText().toUpperCase();
            if(item.getDescription().contains(lower))
                return true;
            else
                return item.getDescription().contains(upper);
        });
        SortedList<Task> sorted = new SortedList<>(items);
        new_task_description.setItems(sorted);
    }

    @FXML
    void new_taux(KeyEvent event) {
        if(!new_task_rate.getText().isEmpty())
            new_task_cost.setText(String.valueOf(Float.parseFloat(new_task_rate.getText()) * Float.parseFloat(new_task_hourly.getText().trim())));
    }

    @FXML
    void new_temps(KeyEvent event) {
        if(!new_task_rate.getText().isEmpty()) {
            new_task_cost.setText(String.valueOf(Float.parseFloat(new_task_rate.getText().trim()) * Float.parseFloat(new_task_hourly.getText().trim())));
        }else if(!new_task_hourly.getText().isEmpty()){
            new_task_rate.setText(String.valueOf(Float.parseFloat(new_task_cost.getText().trim())/Float.parseFloat(new_task_hourly.getText().trim())));
        }
    }

    @FXML
    void ordre_cout(KeyEvent event) {
        if(!edit_task_hourly.getText().isEmpty())
            edit_task_rate.setText(String.valueOf(Float.parseFloat(edit_task_cost.getText().trim())/Float.parseFloat(edit_task_hourly.getText().trim())));
    }

    @FXML
    void ordre_montant(KeyEvent event) {
        if(!edit_spare_quantity.getText().isEmpty())
            edit_spare_price.setText(String.valueOf(Double.parseDouble(edit_spare_amount.getText().trim()) / Integer.parseInt(edit_spare_quantity.getText().trim())));
    }

    @FXML
    void ordre_prix(KeyEvent event) {
        if(!edit_spare_quantity.getText().isEmpty())
            edit_spare_amount.setText(String.valueOf(Integer.parseInt(edit_spare_quantity.getText().trim()) * Double.parseDouble(edit_spare_price.getText().trim())));
    }

    @FXML
    void ordre_quantite(KeyEvent event) {
        if(!edit_spare_price.getText().isEmpty()) {
            edit_spare_amount.setText(String.valueOf(Integer.parseInt(edit_spare_quantity.getText().trim()) * Double.parseDouble(edit_spare_price.getText().trim())));
        }else if(!edit_spare_amount.getText().isEmpty()){
            edit_spare_price.setText(String.valueOf(Double.parseDouble(edit_spare_amount.getText().trim()) / Integer.parseInt(edit_spare_quantity.getText().trim())));
        }
    }

    @FXML
    void ordre_reparation(KeyEvent event){
        ObservableList<String> results = FXCollections.observableArrayList();

        List<Repair> reparations = null;//Todo:repairTaskService.listRepair(ordre_reparation.getEditor().getText());

        for (Repair reparation:reparations) {
            StringBuilder string = new StringBuilder();
            string.append(reparation.getId());
            string.append(" / ");
            string.append(reparation.getDossier().getAutomobile().getNumber());
            string.append(" / ");
            string.append(reparation.getDossier().getReference());
            string.append(" / ");
            string.append(reparation.getCreatedAt());
            results.add(string.toString());
        }
    }

    @FXML
    void ordre_search_article(KeyEvent event) {
        FilteredList<Spare> items = new FilteredList<>(FXCollections.observableArrayList(spares));
        items.setPredicate(item ->{
            String lower = edit_spare_designation.getEditor().getText().toLowerCase();
            String upper = edit_spare_designation.getEditor().getText().toUpperCase();
            if(item.getDesignation().contains(lower))
                return true;
            else
                return item.getDesignation().contains(upper);
        });
        SortedList<Spare> sorted = new SortedList<>(items);
        edit_spare_designation.setItems(sorted);
    }

    @FXML
    void ordre_search_tache(KeyEvent event) {
        FilteredList<Task> items = new FilteredList<>(FXCollections.observableArrayList(tasks));
        items.setPredicate(item ->{
            String lower = edit_task_description.getEditor().getText().toLowerCase();
            String upper = edit_task_description.getEditor().getText().toUpperCase();
            if(item.getDescription().contains(lower))
                return true;
            else
                return item.getDescription().contains(upper);
        });
        SortedList<Task> sorted = new SortedList<>(items);
        edit_task_description.setItems(sorted);
    }

    @FXML
    void ordre_taux_horaire(KeyEvent event) {
        if(!edit_task_rate.getText().isEmpty())
            edit_task_cost.setText(String.valueOf(Float.parseFloat(edit_task_rate.getText()) * Float.parseFloat(edit_task_hourly.getText().trim())));
    }

    @FXML
    void ordre_temps(KeyEvent event) {
        if(!edit_task_rate.getText().isEmpty()) {
            edit_task_cost.setText(String.valueOf(Float.parseFloat(edit_task_rate.getText().trim()) * Float.parseFloat(edit_task_hourly.getText().trim())));
        }else if(!edit_task_hourly.getText().isEmpty()){
            edit_task_rate.setText(String.valueOf(Float.parseFloat(edit_task_cost.getText().trim()) / Float.parseFloat(edit_task_hourly.getText().trim())));
        }
    }

    @FXML
    void printDevis(ActionEvent event) throws Exception {
        //todo:Report.getInstance().createReport("/jrxml/devis.jrxml",(int)currentTask.getId());
    }

    @FXML
    void printFacture(ActionEvent event) throws Exception {
        //todo:Report.getInstance().createReport("/jrxml/facture.jrxml",(int)currentTask.getId());
    }

    @FXML
    void printOrdre(ActionEvent event) throws Exception {
        //todo:Report.getInstance().createReport("/jrxml/ordre.jrxml",(int)currentTask.getId());
    }

    @FXML
    void remove_spare(ActionEvent event) {
        Spare fourniture = table_new_spare.getSelectionModel().getSelectedItem();
        if (this.temp_spares.contains(fourniture)) {
            this.temp_spares.remove(fourniture);
            table_new_spare.setItems(FXCollections.observableArrayList(temp_spares));
        }
    }

    @FXML
    void remove_task(ActionEvent event) {
        Task tache = table_new_task.getSelectionModel().getSelectedItem();
        if (this.temp_tasks.contains(tache)) {
            this.temp_tasks.remove(tache);
            table_new_task.setItems(FXCollections.observableArrayList(temp_tasks));
        }
    }

    @FXML
    void search_repair(KeyEvent event) {
        FilteredList<Repair> items = new FilteredList<>(FXCollections.observableArrayList(allOrderedTasks));
        items.setPredicate(item ->{
            String lower = edit_repair.getEditor().getText().toLowerCase();
            String upper = edit_repair.getEditor().getText().toUpperCase();
            if(item.getDossier().getAutomobile().getNumber().contains(lower))
                return true;
            else
                return item.getDossier().getAutomobile().getNumber().contains(upper);
        });
        SortedList<Repair> sorted = new SortedList<>(items);
        edit_repair.setItems(sorted);
    }

    @FXML
    void new_repair(ActionEvent event){
        selectTab(2);
    }

    @FXML
    void show_repair(ActionEvent event){
        if(currentRepair !=null){
            edit_repair.setValue(currentRepair);
            edit_repair.getEditor().setText(currentRepair.toString());
            edit_repair_profile.setText(currentRepair.getProfile().toString());
            edit_repair_description.setText(currentRepair.getDescription());
            read_edit_reparation_tache();
            read_edit_reparation_fourniture();
            selectTab(3);
        }else{
            AlertWarning.getInstance().setTitle("Erreur");
            AlertWarning.getInstance().setHeaderText("Réparation");
            AlertWarning.getInstance().setContentText("Aucune ligne sélectionné");
            AlertWarning.getInstance().showAndWait();
        }
    }

    @FXML
    void archive_repair(ActionEvent event){
        AlertConfirm.getInstance().setTitle("Confirmation");
        AlertConfirm.getInstance().setHeaderText("Suppression réparation");
        AlertConfirm.getInstance().setContentText("Vous allez supprimer la réparation. Cliquer sur OK pour confirmer votre action ou ANNULER pour abandonner.");
        if (AlertConfirm.getInstance().showAndWait().get()==ButtonType.OK){
            try {
                repairPortal.delete(currentRepair.getId());
                AlertInfo.getInstance().setTitle("Succès");
                AlertInfo.getInstance().setHeaderText("Suppression réparation");
                AlertInfo.getInstance().setContentText("Réparation supprimé avec succès");
                AlertInfo.getInstance().showAndWait();
                read_reparation();
            } catch (Exception e) {
                AlertError.getInstance().setTitle("Erreur");
                AlertError.getInstance().setHeaderText("Suppression réparation");
                AlertError.getInstance().setContentText("Erreur lors de la suppression de la réparation");
                AlertError.getInstance().showAndWait();
                e.printStackTrace();
            }
        }
    }

    @FXML
    void control_repair(ActionEvent event){
        if(table_repair.getSelectionModel().getSelectedItem()!=null){
            selectTab(4);
        }else{
            AlertWarning.getInstance().setTitle("Erreur");
            AlertWarning.getInstance().setHeaderText("Réparation");
            AlertWarning.getInstance().setContentText("Aucune ligne sélectionné");
            AlertWarning.getInstance().showAndWait();
        }
    }

    @FXML
    void select_reparation(MouseEvent event){
        this.currentRepair = table_repair.getSelectionModel().getSelectedItem();
        AlertConfirm.getInstance().setHeaderText("Rapport de réparation");
        AlertConfirm.getInstance().setContentText("Voulez-afficher la réparation?");
        if(AlertConfirm.getInstance().showAndWait().get().equals(ButtonType.OK)){
            if(currentRepair.getApproved()){
                //todo:Report.getInstance().createReport("/jrxml/ordre.jrxml",(int)currentTask.getId());
            }else {
                AlertWarning.getInstance().setHeaderText("Réparation non autorisée");
                AlertWarning.getInstance().setContentText("Cette réparation n'a pas été autorisée.");
                AlertWarning.getInstance().show();
                //todo:Report.getInstance().createReport("/jrxml/reparation.jrxml",(int)currentTask.getId());
            }
        }else {
            event.consume();
        }
    }

    public void selectTab(int i) {
        reparationTab.getSelectionModel().select(getTab(i));
    }

    public Tab getTab(int i) {
        Tab tab = null;
        switch (i) {
            case 1: {
                tab = tab_reparations;
                break;
            }
            case 2: {
                tab = tab_new_reparation;
                break;
            }
            case 3: {
                tab = tab_ordre_reparation;
                break;
            }
            case 4:{
                tab=tab_controle_qualite;
            }
        }
        return tab;
    }

    void read_ordre(){
        //todo:ordre_reparation.setItems(FXCollections.observableArrayList(repairTaskService.listRepair()));
    }

    void read_reparation(){
        try {
            this.allRepairs = repairPortal.list();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        show_reparation(this.allRepairs);
        edit_repair.setItems(FXCollections.observableArrayList(allRepairs));
    }

    void read_ordered_reparation(){
        allOrderedTasks = new ArrayList<>();
        for (Repair reparation: allRepairs) {
            if(reparation.getApproved()){
                allOrderedTasks.add(reparation);
            }
        }
        edit_repair.setItems(FXCollections.observableArrayList(allOrderedTasks));
    }

    void read_article(){
        //todo:this.articles = marketStockService.listerSpare();
        //new_spare_designation.setItems(FXCollections.observableArrayList(articles));
        //edit_spare_designation.setItems(FXCollections.observableArrayList(articles));
    }

    void read_fourniture(){
        //todo:this.fournitures = fournitureRepository.findAll();
    }

    void read_tache(){
        //todo:this.taches = tacheRepository.find();
        //new_task_description.setItems(FXCollections.observableArrayList(tasks));
    }

    void read_dossier() {
        try {
            this.allDossier = dossierPortal.read();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        SortedList<Dossier> sorted = new SortedList<>(FXCollections.observableArrayList(allDossier));
        new_repair_dossier.setItems(sorted);
    }

    void read_edit_reparation_fourniture(){
        try {
            Repair reparation = repairPortal.read(currentRepair.getId());
            table_edit_spare.setItems(FXCollections.observableArrayList(reparation.getSpares()));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void read_edit_reparation_tache(){
        try {
            Repair reparation = repairPortal.read(currentRepair.getId());
            table_edit_task.setItems(FXCollections.observableArrayList(reparation.getTasks()));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void read_ordre_reparation_fourniture(Repair repair){
        table_edit_spare.setItems(FXCollections.observableArrayList(repair.getSpares()));
        this.totalSpare = 0.0;
        for (Spare fourniture : repair.getSpares()) {
            this.totalSpare += fourniture.getAmount();
        }
        total_spare.setText(Money.getInstance().format(this.totalSpare) + " F(CFA)");
    }

    void read_ordre_reparation_tache(Repair repair){
        Repair reparation;
        try {
            reparation = repairPortal.read(repair.getId());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        table_edit_task.setItems(FXCollections.observableArrayList(reparation.getTasks()));
        this.totalTask = 0.0;
        for (Task tache : reparation.getTasks()) {
            this.totalTask += tache.getCost();
        }
        total_task.setText(Money.getInstance().format(this.totalTask) + " F(CFA)");
    }

    void reset_new_reparation_form() {
        new_repair_dossier.getEditor().setText("");
        new_repair_description.setText("");
        new_repair_mileage.setText("");

        new_spare_designation.getEditor().setText("");
        new_spare_quantity.setText("");
        new_spare_price.setText("");
        new_spare_amount.setText("");
        table_new_spare.setItems(null);

        new_task_description.getEditor().setText("");
        new_task_hourly.setText("");
        new_task_rate.setText("");
        new_task_cost.setText("");
        table_new_task.setItems(null);
        temp_spares.clear();
        temp_tasks.clear();
    }

    void reset_edit_repair_form() {
        edit_repair.getEditor().getText();
        edit_repair_description.setText("");
        repair_reference.setText("");
        edit_spare_designation.getEditor().setText("");
        edit_spare_quantity.setText("");
        edit_spare_price.setText("");
        edit_spare_amount.setText("");
        table_edit_spare.setItems(null);
        edit_task_description.getEditor().setText("");
        edit_task_hourly.setText("");
        edit_task_rate.setText("");
        edit_task_cost.setText("");
        table_edit_task.setItems(null);
        total_task.setText("");
        total_spare.setText("");
    }

    void show_reparation(List<Repair> reparations){
        table_repair.setItems(FXCollections.observableArrayList(reparations));
        table_repair.refresh();
    }

    void reset_qualite_reparation_form() {
        currentRepair = null;
    }

    void editRepair(Repair repair){
        Repair reparation;
        try {
            reparation = repairPortal.read(repair.getId());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        edit_repair.setValue(reparation);
        edit_repair_description.setText(reparation.getDescription());
        repair_reference.setText(reparation.getReference());
        read_ordre_reparation_tache(reparation);
        read_ordre_reparation_fourniture(reparation);
        selectTab(3);
    }

    public RepairController(){
        this.repairPortal = new RepairPortal();
        this.dossierPortal = new DossierPortal();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.temp_spares = FXCollections.observableArrayList();
        this.temp_tasks = FXCollections.observableArrayList();
        this.totalSpare = 0.0;
        this.totalTask = 0.0;

        read_dossier();

        read_article();

        read_fourniture();

        read_tache();

        read_ordre();

        read_reparation();

        read_ordered_reparation();

        column_repair_id.setCellValueFactory((TableColumn.CellDataFeatures<Repair, Long> r)->new ReadOnlyObjectWrapper<>(r.getValue().getId()));
        column_repair_date.setCellValueFactory((TableColumn.CellDataFeatures<Repair, String> r)->new ReadOnlyObjectWrapper<>(new SimpleDateFormat("dd/MM/yyyy").format(r.getValue().getCreatedAt())));
        column_repair_description.setCellValueFactory((TableColumn.CellDataFeatures<Repair, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getDescription()));
        column_repair_dossier.setCellValueFactory((TableColumn.CellDataFeatures<Repair, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getDossier().getAutomobile().getNumber()));
        column_repair_mileage.setCellValueFactory((TableColumn.CellDataFeatures<Repair, Integer> r)->new ReadOnlyObjectWrapper<>(r.getValue().getMileage()));
        column_repair_profile.setCellValueFactory((TableColumn.CellDataFeatures<Repair, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getProfile()));

        column_new_spare_designation.setCellValueFactory((TableColumn.CellDataFeatures<Spare, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getDesignation()));
        column_new_spare_price.setCellValueFactory((TableColumn.CellDataFeatures<Spare, Float> r)->new ReadOnlyObjectWrapper<>(r.getValue().getPrice()));
        column_new_spare_quantity.setCellValueFactory((TableColumn.CellDataFeatures<Spare, Integer> r)->new ReadOnlyObjectWrapper<>(r.getValue().getQuantity()));
        column_new_spare_amount.setCellValueFactory((TableColumn.CellDataFeatures<Spare, Float> r)->new ReadOnlyObjectWrapper<>(r.getValue().getAmount()));

        column_new_task_description.setCellValueFactory((TableColumn.CellDataFeatures<Task, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getDescription()));
        column_new_task_hourly.setCellValueFactory((TableColumn.CellDataFeatures<Task, Float> r)->new ReadOnlyObjectWrapper<>(r.getValue().getHourly()));
        column_new_task_rate.setCellValueFactory((TableColumn.CellDataFeatures<Task, Float> r)->new ReadOnlyObjectWrapper<>(r.getValue().getRate()));
        column_new_task_cost.setCellValueFactory((TableColumn.CellDataFeatures<Task, Float> r)->new ReadOnlyObjectWrapper<>(r.getValue().getCost()));

        column_edit_spare_id.setCellValueFactory((TableColumn.CellDataFeatures<Spare, Long> r)->new ReadOnlyObjectWrapper<>(r.getValue().getId()));
        column_edit_spare_designation.setCellValueFactory((TableColumn.CellDataFeatures<Spare, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getDesignation()));
        column_edit_spare_price.setCellValueFactory((TableColumn.CellDataFeatures<Spare, Float> r)->new ReadOnlyObjectWrapper<>(r.getValue().getPrice()));
        column_edit_spare_quantity.setCellValueFactory((TableColumn.CellDataFeatures<Spare, Integer> r)->new ReadOnlyObjectWrapper<>(r.getValue().getQuantity()));
        column_edit_spare_amount.setCellValueFactory((TableColumn.CellDataFeatures<Spare, Float> r)->new ReadOnlyObjectWrapper<>(r.getValue().getAmount()));

        column_edit_task_id.setCellValueFactory((TableColumn.CellDataFeatures<Task, Long> r)->new ReadOnlyObjectWrapper<>(r.getValue().getId()));
        column_edit_task_description.setCellValueFactory((TableColumn.CellDataFeatures<Task, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getDescription()));
        column_edit_task_hourly.setCellValueFactory((TableColumn.CellDataFeatures<Task, Float> r)->new ReadOnlyObjectWrapper<>(r.getValue().getHourly()));
        column_edit_task_rate.setCellValueFactory((TableColumn.CellDataFeatures<Task, Float> r)->new ReadOnlyObjectWrapper<>(r.getValue().getRate()));
        column_edit_task_cost.setCellValueFactory((TableColumn.CellDataFeatures<Task, Float> r)->new ReadOnlyObjectWrapper<>(r.getValue().getCost()));

        new_repair_dossier.setConverter(new StringConverter<Dossier>() {
            @Override
            public String toString(Dossier object) {
                if(object==null) return null;
                return object.toString();
            }

            @Override
            public Dossier fromString(String string) {
                String[] data = string.split("/");
                String auto = data[0].trim();
                try {
                    return dossierPortal.read(auto);
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        edit_repair.setConverter(new StringConverter<Repair>() {
            @Override
            public String toString(Repair object) {
                if(object==null){
                    return null;
                }
                return object.toString();
            }

            @Override
            public Repair fromString(String string) {
                String[] data = string.split("/");
                String id = data[0].trim();
                try {
                    return repairPortal.read(Long.parseLong(id));
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        ordre_reparation.setConverter(new StringConverter<Repair>() {
            @Override
            public String toString(Repair object) {
                if(object==null){
                    return null;
                }
                return object.toString();
            }

            @Override
            public Repair fromString(String string) {
                String[] data = string.split("/");
                String id = data[0].trim();
                try {
                    return repairPortal.read(Long.parseLong(id));
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        new_repair_dossier.addEventHandler(ActionEvent.ACTION, event -> {
            if (new_repair_dossier.getSelectionModel().getSelectedIndex() != -1) {
                this.currentDossier = new_repair_dossier.getValue();
            }
        });

        edit_repair.addEventHandler(ActionEvent.ACTION, event -> {
            if (edit_repair.getSelectionModel().getSelectedIndex() != -1) {
                this.currentRepair = edit_repair.getValue();
                edit_repair_profile.setText(currentRepair.getProfile().toString());
                edit_repair_description.setText(currentRepair.getDescription());
                repair_reference.setText(currentRepair.getReference());
                read_ordre_reparation_tache(currentRepair);
                read_ordre_reparation_fourniture(currentRepair);
            }
        });

        ordre_reparation.addEventHandler(ActionEvent.ACTION, event -> {
            if (ordre_reparation.getSelectionModel().getSelectedIndex() != -1) {
                this.currentRepair = ordre_reparation.getValue();
            }
        });

        new_spare_designation.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Spare>() {
            @Override
            public void changed(ObservableValue<? extends Spare> observable, Spare oldValue, Spare newValue) {
                new_spare_price.setText(String.valueOf(newValue.getPrice()));
            }
        });

        edit_spare_designation.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Spare>() {
            @Override
            public void changed(ObservableValue<? extends Spare> observable, Spare oldValue, Spare newValue) {
                edit_spare_price.setText(String.valueOf(newValue.getPrice()));
            }
        });

        reparationTab.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            public void changed(ObservableValue<? extends Tab> observableValue, Tab tab, Tab t1) {
                try {
                    allRepairs = repairPortal.list();
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}