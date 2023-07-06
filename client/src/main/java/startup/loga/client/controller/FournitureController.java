package startup.loga.client.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;
import startup.loga.client.model.*;
import startup.loga.client.view.AlertConfirm;
import startup.loga.client.view.AlertError;
import startup.loga.client.view.AlertInfo;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class FournitureController implements Initializable
{
    long commandeID;
    List<Spare> fournitures = new ArrayList<>();
    List<Spare> lignecommandes = new ArrayList<>();
    List<Spare> lignelivraisons = new ArrayList<>();
    List<Spare> fournitureCommandes = new ArrayList<>();
    List<Furnisher> allFournisseur = new ArrayList<>();
    List<Repair> allReparation = new ArrayList<>();
    List<Order> allCommande = new ArrayList<>();
    Spare fournitureCopy;

    @FXML
    private AnchorPane content;

    @FXML
    private TextField f_id;

    @FXML
    private TextField f_raisonSociale;

    @FXML
    private TextField f_contact;

    @FXML
    private TextField f_adresse;

    @FXML
    private TableView<Furnisher> table_fournisseur;

    @FXML
    private TableColumn<Furnisher, Long> t_id;

    @FXML
    private TableColumn<Furnisher, String> t_raisonSociale;

    @FXML
    private TableColumn<Furnisher, String> t_contact;

    @FXML
    private TableColumn<Furnisher, String> t_adresse;

    @FXML
    private TabPane article_tab;

    @FXML
    private Tab tab_commande;

    @FXML
    private Tab tab_fournisseur;

    @FXML
    private AnchorPane commande_tab_content;

    @FXML
    private ComboBox<Repair> repair;

    @FXML
    private ComboBox<Furnisher> furnisher;

    @FXML
    private Button create_commande;

    @FXML
    private Button cancel_commande;

    @FXML
    private TableView<Spare> table_fourniture;

    @FXML
    private TableColumn<Spare, Long> id;

    @FXML
    private TableColumn<Spare, String> designation;

    @FXML
    private TableColumn<Spare, Double> prix;

    @FXML
    private TableColumn<Spare, Integer> quantite;

    @FXML
    private TableColumn<Spare, Double> montant;

    @FXML
    private GridPane new_article_form;

    @FXML
    private TextField article_designation;

    @FXML
    private TextField article_prix;

    @FXML
    private TextField article_quantite;

    @FXML
    private TextField article_montant;

    @FXML
    private Button commander;

    @FXML
    private TableView<Spare> ligne_commande;

    @FXML
    private TableColumn<Spare, Long> ligne_id;

    @FXML
    private TableColumn<Spare, String> ligne_designation;

    @FXML
    private TableColumn<Spare, Double> ligne_prix;

    @FXML
    private TableColumn<Spare, Integer> ligne_quantite;

    @FXML
    private TableColumn<Spare, Double> ligne_montant;

    @FXML
    private Tab tab_livraison;

    @FXML
    private AnchorPane livraison_tab_content;

    @FXML
    private ComboBox<Order> order;

    @FXML
    private Button create_livraison;

    @FXML
    private Button cancel_livraison;

    @FXML
    private TableView<Spare> table_article;

    @FXML
    private TableColumn<Spare, Long> commande_id;

    @FXML
    private TableColumn<Spare, String> commande_designation;

    @FXML
    private TableColumn<Spare, Double> commande_prix;

    @FXML
    private TableColumn<Spare, Integer> commande_quantite;

    @FXML
    private Button reception;

    @FXML
    private TableView<Spare> ligne_livraison;

    @FXML
    private TableColumn<Spare, Long> ligne_livraison_id;

    @FXML
    private TableColumn<Spare, String> ligne_livraison_designation;

    @FXML
    private TableColumn<Spare, Double> ligne_livraison_prix;

    @FXML
    private TableColumn<Spare, Integer> ligne_livraison_quantite;

    @FXML
    void saveFournisseur(ActionEvent event){
        if(!f_id.getText().equals("") && !f_raisonSociale.getText().equals("") && !f_contact.getText().equals("")){
            Furnisher fournisseur = new Furnisher();//todo:marketLogisticService.afficherFournisseur(Long.parseLong(f_id.getText().trim()));
            fournisseur.setName(f_raisonSociale.getText().trim());
            fournisseur.setContact(f_contact.getText().trim());
            fournisseur.setAddress(f_adresse.getText().trim());

            try {
                //todo:marketLogisticService.enregistrerFournisseur(fournisseur);
                AlertInfo.getInstance().setTitle("Info");
                AlertInfo.getInstance().setHeaderText("Enregistrement fournisseur");
                AlertInfo.getInstance().setContentText("Furnisher mis à jour avec succès");
                AlertInfo.getInstance().show();
                emptyFournisseurForm();
                //todo:table_fournisseur.setItems(FXCollections.observableArrayList(marketLogisticService.listFournisseur()));
            } catch (Exception e) {
                AlertError.getInstance().setTitle("Erreur");
                AlertError.getInstance().setHeaderText("Enregistrement fournisseur");
                AlertError.getInstance().setContentText("Echec lors de la mise à jour du Furnisher.");
                AlertError.getInstance().showAndWait();
                e.printStackTrace();
            }
        }else if(f_id.getText().equals("") && !f_raisonSociale.getText().equals("") && !f_contact.getText().equals("")){
            Furnisher fournisseur = new Furnisher();
            fournisseur.setName(f_raisonSociale.getText().trim());
            fournisseur.setContact(f_contact.getText().trim());
            fournisseur.setAddress(f_adresse.getText().trim());
            try {
                //todo:marketLogisticService.enregistrerFournisseur(fournisseur);
                AlertInfo.getInstance().setTitle("Info");
                AlertInfo.getInstance().setHeaderText("Enregistrement fournisseur");
                AlertInfo.getInstance().setContentText("Nouveau fournisseur enregistré avec succès.");
                AlertInfo.getInstance().show();
                emptyFournisseurForm();
                //todo:table_fournisseur.setItems(FXCollections.observableArrayList(marketLogisticService.listFournisseur()));
            } catch (Exception e) {
                AlertError.getInstance().setTitle("Erreur");
                AlertError.getInstance().setHeaderText("Enregistrement fournisseur");
                AlertError.getInstance().setContentText("Echec lors de l'enregistrement du fournisseur.\n"+e.getMessage());
                AlertError.getInstance().showAndWait();
                e.printStackTrace();
            }
        }
    }

    void emptyFournisseurForm(){
        f_raisonSociale.setText("");
        f_contact.setText("");
        f_adresse.setText("");
        f_id.setText("");
    }

    @FXML
    void cancelFournisseur(ActionEvent event){
        emptyFournisseurForm();
    }

    @FXML
    void deleteFournisseur(ActionEvent event){
        AlertConfirm.getInstance().setHeaderText("Furnisher");
        AlertConfirm.getInstance().setContentText("Voulez-vous supprimer le fournisseur? Cliquer sur OK pour supprimer le fournisseur sinon cliquer sur annuler.");
        if(AlertConfirm.getInstance().showAndWait().get().equals(ButtonType.OK)){
            try {
                //todo:marketLogisticService.supprimerFournisseur(table_fournisseur.getSelectionModel().getSelectedItem());
                //todo:table_fournisseur.setItems(FXCollections.observableArrayList(marketLogisticService.listFournisseur()));
                AlertInfo.getInstance().setHeaderText("Furnisher");
                AlertInfo.getInstance().setContentText("Furnisher supprimé avec succès");
                AlertInfo.getInstance().show();
            } catch (Exception e) {
                AlertError.getInstance().setHeaderText("Furnisher");
                AlertError.getInstance().setContentText("Ce fournisseur ne peut pas être supprimé. Contactez l'administrateur de votre système.");
                AlertError.getInstance().showAndWait();
                e.printStackTrace();
            }
        }
    }

    @FXML
    void article_montant(KeyEvent event) {
        if(!article_quantite.getText().isEmpty())
            article_prix.setText(String.valueOf(Double.parseDouble(article_montant.getText().trim()) / Integer.parseInt(article_quantite.getText().trim())));
    }

    @FXML
    void article_prix(KeyEvent event) {
        if(!article_quantite.getText().isEmpty())
            article_montant.setText(String.valueOf(Integer.parseInt(article_quantite.getText().trim()) * Double.parseDouble(article_prix.getText().trim())));
    }

    @FXML
    void article_quantite(KeyEvent event) {
        if(!article_prix.getText().isEmpty()) {
            article_montant.setText(String.valueOf(Integer.parseInt(article_quantite.getText().trim()) * Double.parseDouble(article_prix.getText().trim())));
        }else if(!article_montant.getText().isEmpty()){
            article_prix.setText(String.valueOf(Double.parseDouble(article_montant.getText().trim()) / Integer.parseInt(article_quantite.getText().trim())));
        }
    }

    void emptyField() {
        article_designation.setText("");
        article_prix.setText("");
        article_quantite.setText("");
        article_montant.setText("");
    }
    
    void reset_commande_form() {
        emptyField();
        table_fourniture.setItems(null);
        repair.setItems(null);
        furnisher.setItems(null);
        ligne_commande.setItems(null);
        fournitures.clear();
        lignecommandes.clear();
    }
    
    void reset_livraison_form() {
        emptyField();
        table_article.setItems(null);
        order.setItems(null);
        ligne_livraison.setItems(null);
        fournitureCommandes.clear();
        lignelivraisons.clear();
    }
    
    @FXML
    void cancel_commande(ActionEvent event) {
        reset_commande_form();
        AlertInfo.getInstance().setTitle("Info");
        AlertInfo.getInstance().setHeaderText("Order annulée");
        AlertInfo.getInstance().show();
    }
    
    @FXML
    void cancel_livraison(ActionEvent event) {
        reset_livraison_form();
    }
    
    @FXML
    void commander(ActionEvent event) {
        Spare spare = fournitureCopy;
        spare.setDesignation(article_designation.getText().trim());
        spare.setPrice(Float.parseFloat(article_prix.getText().trim()));
        spare.setQuantity(Integer.parseInt(article_quantite.getText().trim()));
        spare.setAmount(Float.parseFloat(article_montant.getText().trim()));

        lignecommandes.add(spare);

        if (table_fourniture.getItems().contains(fournitureCopy)) {
            ligne_commande.setItems(FXCollections.observableArrayList(lignecommandes));
            table_fourniture.getItems().remove(fournitureCopy);
        }

        emptyField();
        AlertInfo.getInstance().setTitle("Info");
        AlertInfo.getInstance().setHeaderText("Ajout d'une ligne commande.");
        AlertInfo.getInstance().show();
    }
    
    @FXML
    void create_commande(ActionEvent event) {
        Order cmd = new Order();
        cmd.setSpares(fournitureCommandes);
        cmd.setCreatedAt(new Date());
        cmd.setFurnisher(furnisher.getValue());
        cmd.setSpares(lignecommandes);

        try {
            //todo:cmd = marketLogisticService.enregistrerCommande(cmd);

            for (Spare spare:lignecommandes) {
                spare.setOrdered(true);
                spare.setOrder(cmd);
                //todo:marketLogisticService.modifierFourniture(spare);
            }

            //Report.getInstance().createReport("/jrxml/commande.jrxml",(int)cmd.getId());
            AlertInfo.getInstance().setTitle("Info");
            AlertInfo.getInstance().setHeaderText("Order de Spare");
            AlertInfo.getInstance().setContentText("Nouvelle commande enregistrée avec succès.");
            AlertInfo.getInstance().show();
            reset_commande_form();

        } catch (Exception e) {
            AlertError.getInstance().setTitle("Erreur");
            AlertError.getInstance().setHeaderText("Order de Spare");
            AlertError.getInstance().setContentText("Echec d'enregistrement de la commande.\n"+e.getMessage());
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
    }
    
    @FXML
    void create_livraison(ActionEvent event) {
        Delivery livraison = new Delivery();
        livraison.setOrder(order.getValue());
        livraison.setCreatedAt(new Date());

        try {
            //todo:livraison = marketLogisticService.enregistrerLivraison(livraison);

            for (Spare spare:lignelivraisons) {
                spare.setDelivered(true);
                spare.setDelivery(livraison);
                //todo:marketLogisticService.modifierFourniture(spare);
            }
            //todo:Report.getInstance().createReport("/jrxml/livraison.jrxml",(int)livraison.getId());
            AlertInfo.getInstance().setTitle("Info");
            AlertInfo.getInstance().setHeaderText("Delivery enregistrée avec succès.");
            AlertInfo.getInstance().show();
            reset_livraison_form();
        } catch (Exception e) {
            AlertError.getInstance().setTitle("Erreur");
            AlertError.getInstance().setHeaderText("Echec d'enregistrement de la commande.");
            AlertError.getInstance().setContentText(e.getMessage());
            AlertError.getInstance().show();
            e.printStackTrace();
        }
    }
    
    @FXML
    void receptionner(ActionEvent event) {
        Spare spare = null;//Todo:marketLogisticService.afficherFourniture(fournitureCopy.getId());
        lignelivraisons.add(spare);

        if (table_article.getItems().contains(fournitureCopy)) {
            ligne_livraison.setItems(FXCollections.observableArrayList(lignelivraisons));
            table_article.getItems().remove(fournitureCopy);
        }
        emptyField();
        AlertInfo.getInstance().setTitle("Info");
        AlertInfo.getInstance().setHeaderText("Ajout d'une ligne livraison.");
        AlertInfo.getInstance().show();
    }
    
    @FXML
    void search_commande(KeyEvent event) {
        FilteredList<Order> items = new FilteredList<>(FXCollections.observableArrayList(allCommande));
        items.setPredicate(item ->{
            String lower = order.getEditor().getText().toLowerCase();
            String upper = order.getEditor().getText().toUpperCase();

            if(item.getSpares().get(0).getRepair().getDossier().getAutomobile().getNumber().contains(upper) || item.getSpares().get(0).getRepair().getDossier().getAutomobile().getNumber().contains(lower))
                return true;
            else
                return item.getSpares().get(0).getRepair().getDossier().getAutomobile().getNumber().contains(upper) || item.getSpares().get(0).getRepair().getDossier().getAutomobile().getNumber().contains(lower);
        });
        SortedList<Order> sorted = new SortedList<>(items);
        order.setItems(FXCollections.observableArrayList(sorted));
    }
    
    @FXML
    void search_fournisseur(KeyEvent event) {
        FilteredList<Furnisher> items = new FilteredList<>(FXCollections.observableArrayList(allFournisseur));
        items.setPredicate(item ->{
            String lower = furnisher.getEditor().getText().toLowerCase();
            String upper = furnisher.getEditor().getText().toUpperCase();
            if(item.getName().contains(lower))
                return true;
            else
                return item.getName().contains(upper);
        });
        SortedList<Furnisher> sorted = new SortedList<>(items);
        furnisher.setItems(sorted);
    }
    
    @FXML
    void search_reparation(KeyEvent event) {
        FilteredList<Repair> items = new FilteredList<>(FXCollections.observableArrayList(allReparation));
        items.setPredicate(item ->{
            String lower = repair.getEditor().getText().toLowerCase();
            String upper = repair.getEditor().getText().toUpperCase();
            if(item.getDossier().getAutomobile().getNumber().contains(lower))
                return true;
            else
                return item.getDossier().getAutomobile().getNumber().contains(upper);
        });
        SortedList<Repair> sorted = new SortedList<>(items);
        repair.setItems(sorted);
    }
    
    @FXML
    void select_article(MouseEvent event) {
        fournitureCopy = table_article.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    void select_fourniture(MouseEvent event) {
        fournitureCopy = table_fourniture.getSelectionModel().getSelectedItem();
        article_designation.setText(fournitureCopy.getDesignation());
        article_prix.setText(String.valueOf(fournitureCopy.getPrice()));
        article_quantite.setText(String.valueOf(fournitureCopy.getQuantity()));
        article_montant.setText(String.valueOf(fournitureCopy.getAmount()));
    }

    public void selectTab(int i) {
        article_tab.getSelectionModel().select(getTab(i));
    }

    public Tab getTab(int i) {
        Tab tab = null;
        switch (i) {
            case 1: {
                tab = tab_fournisseur;
                break;
            }
            case 2: {
                tab = tab_commande;
                break;
            }
            case 3: {
                tab = tab_livraison;
                break;
            }
        }
        return tab;
    }

    void read_fournisseur(){
        //todo : allFournisseur = fournisseurRepository.findAll();
        table_fournisseur.setItems(FXCollections.observableArrayList(allFournisseur));
        furnisher.setItems(FXCollections.observableArrayList(allFournisseur));
    }

    void read_commande(){
        //todo : allCommande = commandeRepository.findAll();
        order.setItems(FXCollections.observableArrayList(allCommande));
    }

    void read_reparation(){
        //todo: allReparation = reparationRepository.findAll();
        repair.setItems(FXCollections.observableArrayList(allReparation));
    }

    public void initialize(URL location, ResourceBundle resources) {

        read_fournisseur();

        read_reparation();

        read_commande();

        repair.setConverter(new StringConverter<Repair>() {
            @Override
            public String toString(Repair object) {
                if(object==null){
                    return null;
                }
                return object.toString();
            }

            @Override
            public Repair fromString(String string) {
                String[] data = string.split("\\s");
                String id = data[0].trim();
                return null;
                        //todo : reparationRepository.findById(Long.parseLong(id));
            }
        });

        order.setConverter(new StringConverter<Order>() {
            @Override
            public String toString(Order object) {
                if(object==null){
                    return null;
                }
                return object.toString();
            }

            @Override
            public Order fromString(String string) {
                String[] data = string.split("\\s");
                String id = data[0].trim();
                return null;
                        //todo : commandeRepository.findById(Long.parseLong(id));
            }
        });

        furnisher.setConverter(new StringConverter<Furnisher>() {
            @Override
            public String toString(Furnisher object) {
                if(object==null){
                    return null;
                }
                return object.toString();
            }

            @Override
            public Furnisher fromString(String string) {
                String[] data = string.split("\\s");
                String id = data[0].trim();
                return null;
                        //todo:fournisseurRepository.findById(Long.parseLong(id));
            }
        });

        article_tab.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            public void changed(ObservableValue<? extends Tab> observableValue, Tab tab, Tab t1) {
                if (tab.getTabPane().getSelectionModel().getSelectedIndex() == 1) {
                    read_fournisseur();
                }
            }
        });

        t_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        t_raisonSociale.setCellValueFactory(new PropertyValueFactory<>("raisonSociale"));
        t_contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        t_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        designation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        montant.setCellValueFactory(new PropertyValueFactory<>("montant"));

        ligne_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        ligne_designation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        ligne_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        ligne_quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        ligne_montant.setCellValueFactory(new PropertyValueFactory<>("montant"));

        commande_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        commande_designation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        commande_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        commande_quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));

        ligne_livraison_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        ligne_livraison_designation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        ligne_livraison_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        ligne_livraison_quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));

        repair.addEventHandler(ActionEvent.ACTION, event -> {
            if (repair.getSelectionModel().getSelectedIndex() != -1) {
                fournitures.clear();
                for (Spare spare: repair.getValue().getSpares()) {
                    if(!spare.getOrdered()){
                        fournitures.add(spare);
                    }
                }
                table_fourniture.setItems(FXCollections.observableArrayList(fournitures));
            }
        });

        order.addEventHandler(ActionEvent.ACTION, event -> {
            if (order.getSelectionModel().getSelectedIndex() != -1) {
                fournitureCommandes.clear();
                for (Spare spare: order.getValue().getSpares()) {
                    if(!spare.getDelivered()){
                        fournitureCommandes.add(spare);
                    }
                }
                table_article.setItems(FXCollections.observableArrayList(fournitureCommandes));
            }
        });
    }
}
