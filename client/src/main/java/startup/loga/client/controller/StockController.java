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
import startup.loga.client.model.Article;
import startup.loga.client.model.Category;
import startup.loga.client.model.Purchase;
import startup.loga.client.model.Sale;
import startup.loga.client.vendor.io.Money;
import startup.loga.client.view.AlertError;
import startup.loga.client.view.AlertWarning;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class StockController implements Initializable {

    private List<Article> articles = new ArrayList<>();
    private List<Purchase> achats = new ArrayList<>();
    private List<Sale> ventes = new ArrayList<>();
    private Article article;
    private Article article_achat;
    private Article article_vente;
    private Date debut;
    private Date fin;

    @FXML
    private AnchorPane content;

    @FXML
    private TabPane stock_tab;

    @FXML
    private Tab tab_achat;

    @FXML
    private AnchorPane achat_tab_content;

    @FXML
    private ComboBox<Category> achat_categorie;

    @FXML
    private TextField achat_description;

    @FXML
    private TextField achat_prix;

    @FXML
    private ComboBox<Article> achat_designation;

    @FXML
    private Button ajouter_achat;

    @FXML
    private Button annuler_achat;

    @FXML
    private TextField achat_quantite;

    @FXML
    private TextField achat_fournisseur;

    @FXML
    private TableView<Purchase> table_achat;

    @FXML
    private TableColumn<Purchase, Long> table_achat_id;

    @FXML
    private TableColumn<Purchase, String> table_achat_date;

    @FXML
    private TableColumn<Purchase, String> table_achat_designation;

    @FXML
    private TableColumn<Purchase, String> table_achat_description;

    @FXML
    private TableColumn<Purchase, Integer> table_achat_quantite;

    @FXML
    private TableColumn<Purchase, Double> table_achat_prix;

    @FXML
    private TableColumn<Purchase, Double> table_achat_montant;

    @FXML
    private TableColumn<Purchase, String> table_achat_fournisseur;

    @FXML
    private Button stocker;

    @FXML
    private Tab tab_vente;

    @FXML
    private AnchorPane vente_tab_content;

    @FXML
    private TextField vente_description;

    @FXML
    private TextField vente_prix;

    @FXML
    private TextField vente_client;

    @FXML
    private ComboBox<Article> vente_designation;

    @FXML
    private Button ajouter_vente;

    @FXML
    private Button annuler_vente;

    @FXML
    private TextField vente_quantite;

    @FXML
    private TableView<Sale> table_vente;

    @FXML
    private TableColumn<Sale, Long> table_vente_id;

    @FXML
    private TableColumn<Sale, String> table_vente_date;

    @FXML
    private TableColumn<Sale, String> table_vente_designation;

    @FXML
    private TableColumn<Sale, String> table_vente_description;

    @FXML
    private TableColumn<Sale, Integer> table_vente_quantite;

    @FXML
    private TableColumn<Sale, Double> table_vente_prix;

    @FXML
    private TableColumn<Sale, Double> table_vente_montant;

    @FXML
    private TableColumn<Sale, String> table_vente_client;

    @FXML
    private Button sortir;

    @FXML
    private Tab tab_stock;

    @FXML
    private AnchorPane stock_tab_content;

    @FXML
    private TextField filtre;

    @FXML
    private TableView<Article> table_article;

    @FXML
    private TableColumn<Article, Long> table_article_id;

    @FXML
    private TableColumn<Article, String> table_article_designation;

    @FXML
    private TableColumn<Article, String> table_article_description;

    @FXML
    private TableColumn<Article, Integer> table_article_quantite;

    @FXML
    private TableColumn<Article, Double> table_article_prix;

    @FXML
    private Tab tab_article;

    @FXML
    private TextField article_reference;

    @FXML
    private TextField article_designation;

    @FXML
    private TextField article_prix;

    @FXML
    private TextField article_quantite;

    @FXML
    private ComboBox<Category> article_categorie;

    @FXML
    private TextArea article_description;

    @FXML
    private Tab tab_ventes;

    @FXML
    private DatePicker ventes_date_debut;

    @FXML
    private DatePicker ventes_date_fin;

    @FXML
    private TableView<Sale> table_ventes;

    @FXML
    private TableColumn<Sale, String> ventes_date;

    @FXML
    private TableColumn<Sale, Article> ventes_article;

    @FXML
    private TableColumn<Sale, String> ventes_client;

    @FXML
    private TableColumn<Sale, Double> ventes_prix;

    @FXML
    private TableColumn<Sale, Integer> ventes_quantite;

    @FXML
    private TableColumn<Sale, Double> ventes_montant;

    @FXML
    private TextField vente_total;

    @FXML
    private Tab tab_achats;

    @FXML
    private DatePicker achats_date_debut;

    @FXML
    private DatePicker achats_date_fin;

    @FXML
    private TableView<Purchase> table_achats;

    @FXML
    private TableColumn<Purchase, String> achats_date;

    @FXML
    private TableColumn<Purchase, Article> achats_article;

    @FXML
    private TableColumn<Purchase, String> achats_fournisseur;

    @FXML
    private TableColumn<Purchase, Double> achats_montant;

    @FXML
    private TableColumn<Purchase, Double> achats_prix;

    @FXML
    private TableColumn<Purchase, Integer> achats_quantite;

    @FXML
    private TextField achat_total;

    @FXML
    void afficher_article(MouseEvent event){
        article = table_article.getSelectionModel().getSelectedItem();
        article_reference.setText(article.getReference());
        article_quantite.setText(String.valueOf(article.getStock()));
        article_prix.setText(String.valueOf(article.getPrice()));
        article_designation.setText(article.getDesignation());
        article_description.setText(article.getDescription());
        article_categorie.getSelectionModel().select(Category.valueOf(article.getCategory()));
        selectTab(4);
    }

    void reset_article_form(){
        article_reference.setText("");
        article_designation.setText("");
        article_description.setText("");
        article_quantite.setText("");
        article_prix.setText("");
    }

    @FXML
    void ajouter_achat(ActionEvent event) {
        if(achat_designation.getEditor().getText().equals("") || achat_prix.getText().equals("") || achat_quantite.getText().equals("")){
            AlertWarning.getInstance().setHeaderText("Approvisionnement");
            AlertWarning.getInstance().setContentText("Vérifiez les informations que vous entrez.");
            AlertWarning.getInstance().showAndWait();
        }else{
            if(achat_designation.getSelectionModel().getSelectedItem()==null && achat_categorie.getSelectionModel().getSelectedItem()!=null){

                Article article = new Article();
                article.setDesignation(achat_designation.getEditor().getText());
                article.setDescription(achat_description.getText());
                article.setPrice(Double.parseDouble(achat_prix.getText()));
                article.setStock(Integer.parseInt(achat_quantite.getText()));
                article.setCategory(achat_categorie.getEditor().getText());
                //todo:article.setAtelier(garageService.readAtelier(1L));

                try {
                    //todo:article = stockService.enregistrerArticle(article);

                    Purchase achat = new Purchase();
                    achat.setArticle(article);
                    achat.setFurnisher(achat_fournisseur.getText());
                    achat.setCreatedAt(new Date());
                    achat.setPrice(Double.parseDouble(achat_prix.getText()));
                    achat.setQuantity(Integer.parseInt(achat_quantite.getText()));
                    achat.setAmount(achat.getPrice()*achat.getQuantity());
                    achats.add(achat);
                } catch (Exception e) {
                    AlertWarning.getInstance().setHeaderText("Approvisionnement");
                    AlertWarning.getInstance().setContentText("Vérifiez les informations que vous entrez.\n"+e.getMessage());
                    AlertWarning.getInstance().showAndWait();
                    e.printStackTrace();
                }
            }else{
                Purchase achat = new Purchase();
                achat.setArticle(article_achat);
                achat.setFurnisher(achat_fournisseur.getText());
                achat.setCreatedAt(new Date());
                achat.setPrice(Double.parseDouble(achat_prix.getText()));
                achat.setQuantity(Integer.parseInt(achat_quantite.getText()));
                achat.setAmount(achat.getPrice()*achat.getQuantity());
                achats.add(achat);
            }
            table_achat.setItems(FXCollections.observableArrayList(achats));
            reset_achat_form();
        }
    }

    @FXML
    void ajouter_vente(ActionEvent event) {
        if(article_vente == null || vente_client.getText().equals("") || vente_quantite.getText().equals("")){
            AlertWarning.getInstance().setHeaderText("Sale");
            AlertWarning.getInstance().setContentText("L'article n'existe pas pour la vente.");
            AlertWarning.getInstance().showAndWait();
            reset_vente_form();
        }else{
            if(article_vente.getStock() >= Integer.parseInt(vente_quantite.getText())){
                Sale vente = new Sale();
                vente.setClient(vente_client.getText());
                vente.setCreatedAt(new Date());
                vente.setArticle(article_vente);
                vente.setPrice(Double.parseDouble(vente_prix.getText().trim()));
                vente.setQuantity(Integer.parseInt(vente_quantite.getText()));
                vente.setAmount(vente.getPrice()*vente.getQuantity());
                ventes.add(vente);
                table_vente.setItems(FXCollections.observableArrayList(ventes));
            }else{
                AlertWarning.getInstance().setHeaderText("Sale");
                AlertWarning.getInstance().setContentText("L'article "+article_vente.toString()+" n'est pas en stock suffisant à la vente.");
                AlertWarning.getInstance().showAndWait();
            }
            reset_vente_form();
        }
    }

    public void reset_achat_form(){
        article_achat=null;
        achat_description.setText("");
        achat_designation.getEditor().setText("");
        achat_fournisseur.setText("");
        achat_prix.setText("");
        achat_quantite.setText("");
    }

    @FXML
    void annuler_achat(ActionEvent event) {
        reset_achat_form();
    }

    @FXML
    void annuler_recherche(ActionEvent event) {
        filtre.setText("");
        read_article();
    }

    @FXML
    void apply(ActionEvent event) {
        article.setPrice(Double.parseDouble(article_prix.getText()));
        article.setCategory(article_categorie.getEditor().getText());
        article.setReference(article_reference.getText());
        article.setDescription(article_description.getText());
        article.setDesignation(article_designation.getText());
        try {
            //todo:stockService.modifierArticle(article);
            reset_article_form();
            read_article();
            selectTab(3);
        } catch (Exception e) {
            AlertError.getInstance().setHeaderText("Article : Mise à jour d'information");
            AlertError.getInstance().setContentText("Impossible de mettre à jour l'article.\n"+e.getMessage());
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    void cancel_edit(ActionEvent event) {
        reset_article_form();
        selectTab(3);
    }

    public void reset_vente_form(){
        vente_client.setText("");
        vente_description.setText("");
        vente_designation.getEditor().setText("");
        vente_quantite.setText("");
        article_vente=null;
    }

    @FXML
    void annuler_vente(ActionEvent event) {
        reset_vente_form();
    }

    @FXML
    void chercher_article_achat(KeyEvent event) {
        FilteredList<Article> items = new FilteredList<>(FXCollections.observableArrayList(articles));
        items.setPredicate(item ->{
            String lower = achat_designation.getEditor().getText().toLowerCase();
            String upper = achat_designation.getEditor().getText().toUpperCase();
            if(item.getDesignation().contains(lower) || item.getDescription().contains(lower))
                return true;
            else
                return item.getDesignation().contains(upper) || item.getDescription().contains(upper);
        });
        SortedList<Article> sorted = new SortedList<>(items);
        achat_designation.setItems(sorted);
    }

    @FXML
    void chercher_article_vente(KeyEvent event) {
        FilteredList<Article> items = new FilteredList<>(FXCollections.observableArrayList(articles));
        items.setPredicate(item ->{
            String lower = vente_designation.getEditor().getText().toLowerCase();
            String upper = vente_designation.getEditor().getText().toUpperCase();
            if(item.getDesignation().contains(lower) || item.getDescription().contains(lower))
                return true;
            else
                return item.getDesignation().contains(upper) || item.getDescription().contains(upper);
        });
        SortedList<Article> sorted = new SortedList<>(items);
        vente_designation.setItems(sorted);
    }

    @FXML
    void ventes_date_debut(ActionEvent event) {
        LocalDate localDate = ventes_date_debut.getValue();

        ZoneId systemTimeZone = ZoneId.systemDefault();

        ZonedDateTime zonedDateTime = localDate.atStartOfDay(systemTimeZone);

        debut = Date.from(zonedDateTime.toInstant());

        //todo:List<Sale> ventes = saleService.listerVente(debut);
        read_vente(ventes);
    }

    @FXML
    void ventes_date_fin(ActionEvent event) {
        LocalDate localDate = ventes_date_fin.getValue();

        ZoneId systemTimeZone = ZoneId.systemDefault();

        ZonedDateTime zonedDateTime = localDate.atStartOfDay(systemTimeZone);

        fin = Date.from(zonedDateTime.toInstant());

        if(!(debut==null) && debut.before(fin) || Objects.equals(debut, fin)){
            //todo:List<Sale> ventes saleService.listerVente(debut,fin);
            read_vente(ventes);
        }else{
            AlertWarning.getInstance().setHeaderText("Ventes");
            AlertWarning.getInstance().setContentText("Une erreur s'est produite lors de la sélection des dates.\n Vérifiez et reessayez.");
            AlertWarning.getInstance().showAndWait();
        }
    }

    @FXML
    void achats_date_debut(ActionEvent event) {
        LocalDate localDate = achats_date_debut.getValue();

        ZoneId systemTimeZone = ZoneId.systemDefault();

        ZonedDateTime zonedDateTime = localDate.atStartOfDay(systemTimeZone);

        debut = Date.from(zonedDateTime.toInstant());

        //todo:List<Purchase> achats = purchaseService.listerAchat(debut);
        read_achat(achats);
    }

    @FXML
    void achats_date_fin(ActionEvent event) {
        LocalDate localDate = achats_date_fin.getValue();

        ZoneId systemTimeZone = ZoneId.systemDefault();

        ZonedDateTime zonedDateTime = localDate.atStartOfDay(systemTimeZone);

        fin = Date.from(zonedDateTime.toInstant());

        if(!(debut==null) && debut.before(fin) || Objects.equals(debut, fin)){
            //todo:List<Purchase> achats = purchaseService.listerAchat(debut,fin);
            read_achat(achats);
        }else{
            AlertWarning.getInstance().setHeaderText("Approvisionnements");
            AlertWarning.getInstance().setContentText("Une erreur s'est produite lors de la sélection des dates.\n Vérifiez et reessayez.");
            AlertWarning.getInstance().showAndWait();
        }
    }

    @FXML
    void fermerAchats(ActionEvent event) {
        achats_date_debut.getEditor().setText("");
        achats_date_fin.getEditor().setText("");
        //todo:List<Purchase> achats = purchaseService.listerAchat(new Date());
        table_achats.setItems(FXCollections.observableArrayList(achats));
    }

    @FXML
    void fermerVentes(ActionEvent event) {
        ventes_date_debut.getEditor().setText("");
        ventes_date_fin.getEditor().setText("");
        //todo:List<Sale> ventes = saleService.listerVente(new Date());
        table_ventes.setItems(FXCollections.observableArrayList(ventes));
    }

    @FXML
    void filtrer(KeyEvent event) {
        FilteredList<Article> items = new FilteredList<>(FXCollections.observableArrayList(articles));
        items.setPredicate(item ->{
            String lower = filtre.getText().toLowerCase();
            String upper = filtre.getText().toUpperCase();
            if(item.getDesignation().contains(lower) || item.getDescription().contains(lower))
                return true;
            else
                return item.getDesignation().contains(upper) || item.getDescription().contains(upper);
        });
        SortedList<Article> sorted = new SortedList<>(items);
        table_article.setItems(sorted);
    }

    @FXML
    void printAchats(ActionEvent event) {
        if(!(debut==null) && !(fin==null)){
            //todo:Report.getInstance().createReport("/jrxml/achat_periodique.jrxml",debut,fin);
        }else if(!(debut==null)){
            //Todo:Report.getInstance().createReport("/jrxml/achat.jrxml",debut);
        }else{
            //todo:Report.getInstance().createReport("/jrxml/achat.jrxml",new Date());
        }
    }

    @FXML
    void printVentes(ActionEvent event) {
        if(!(debut==null) && !(fin==null)){
            //todo:Report.getInstance().createReport("/jrxml/vente_periodique.jrxml",debut,fin);
        }else if(!(debut == null)){
            //todo:Report.getInstance().createReport("/jrxml/vente.jrxml",debut);
        }else{
            //todo:Report.getInstance().createReport("/jrxml/vente.jrxml",new Date());
        }
    }

    @FXML
    void printStock(ActionEvent event) {
    }

    public void read_article(){
        //todo:this.articles = stockService.listerArticle();
        table_article.setItems(FXCollections.observableArrayList(articles));
        achat_designation.setItems(FXCollections.observableArrayList(articles));
        vente_designation.setItems(FXCollections.observableArrayList(articles));
    }

    @FXML
    void sortir(ActionEvent event) {
        for(Sale vente : ventes){
            try {
                //todo:saleService.enregistrerVente(vente);
                Article up = vente.getArticle();
                up.setStock(up.getStock() - vente.getQuantity());
                up.setPrice(vente.getPrice());
                //todo:stockService.modifierArticle(up);
            } catch (Exception e) {
                AlertError.getInstance().setHeaderText("Sale");
                AlertError.getInstance().setContentText("Une erreur est survenue.\n"+e.getMessage());
                AlertError.getInstance().showAndWait();
                e.printStackTrace();
            }
        }
        table_vente.setItems(null);
        table_vente.refresh();
    }

    @FXML
    void stocker(ActionEvent event) {

        for(Purchase achat : achats){
            try {
                //todo:purchaseService.enregistrerAchat(achat);
                Article up = achat.getArticle();
                up.setStock(achat.getQuantity() + up.getStock());
                up.setPrice(up.getPrice());
                //todo:stockService.modifierArticle(up);
            } catch (Exception e) {
                AlertError.getInstance().setHeaderText("Approvisionnement");
                AlertError.getInstance().setContentText("Une erreur est survenue.\n"+e.getMessage());
                AlertError.getInstance().showAndWait();
                e.printStackTrace();
            }
        }
        table_achat.setItems(null);
        table_achat.refresh();
    }

    void read_vente(List<Sale> ventes){
        table_ventes.setItems(FXCollections.observableArrayList(ventes));
        double total = 0;
        for (Sale vente:ventes) {
            total+=vente.getAmount();
        }
        vente_total.setText(Money.getInstance().format(total)+" F (CFA)");
    }

    void read_achat(List<Purchase> achats){
        table_achats.setItems(FXCollections.observableArrayList(achats));
        double total = 0;
        for (Purchase achat:achats) {
            total+=achat.getAmount();
        }
        achat_total.setText(Money.getInstance().format(total)+" F (CFA)");
    }

    public void selectTab(int i) {
        stock_tab.getSelectionModel().select(getTab(i));
    }

    public Tab getTab(int i) {
        Tab tab = null;
        switch (i) {
            case 1: {
                tab = tab_achat;
                break;
            }
            case 2: {
                tab = tab_vente;
                break;
            }
            case 3: {
                tab = tab_stock;
                break;
            }
            case 4:{
                tab = tab_article;
            }
        }
        return tab;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        read_article();

        stock_tab.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            public void changed(ObservableValue<? extends Tab> observableValue, Tab tab, Tab t1) {
                switch (tab.getTabPane().getSelectionModel().getSelectedIndex()) {
                    case 0:{
                        table_achat.setItems(null);
                        reset_achat_form();
                        break;
                    }
                    case 1:{
                        table_vente.setItems(null);
                        reset_vente_form();
                        break;
                    }
                    case 2:{
                        table_article.setItems(FXCollections.observableArrayList(articles));
                        break;
                    }
                    case 4:{
                        List<Sale> ventes = null;//todo:saleService.listerVente(new Date());
                        read_vente(ventes);
                        break;
                    }
                    case 5:{
                        List<Purchase> achats = null;//todo:purchaseService.listerAchat(new Date());
                        read_achat(achats);
                        break;
                    }
                }
            }
        });

        achat_categorie.setItems(FXCollections.observableArrayList(Category.values()));

        article_categorie.setItems(FXCollections.observableArrayList(Category.values()));
        achat_designation.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Article>() {
            @Override
            public void changed(ObservableValue ov, Article old, Article current) {
                article_achat = current;
                achat_description.setText(current.getDescription());
                achat_prix.setText(String.valueOf(current.getPrice()));
            }
        });

        achat_designation.setConverter(new StringConverter<Article>() {
            @Override
            public String toString(Article object) {
                if(object==null){
                    return null;
                }
                return object.toString();
            }

            @Override
            public Article fromString(String string) {
                return null;//todo:stockService.afficherArticle(achat_designation.getEditor().getText().trim());
            }
        });

        vente_designation.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Article>() {
            @Override
            public void changed(ObservableValue ov, Article old, Article current) {
                article_vente = current;
                vente_description.setText(current.getDescription());
                vente_prix.setText(String.valueOf(current.getPrice()));
            }
        });

        vente_designation.setConverter(new StringConverter<Article>() {
            @Override
            public String toString(Article object) {
                if(object==null){
                    return null;
                }
                return object.toString();
            }

            @Override
            public Article fromString(String string) {
                return null;//todo:stockService.afficherArticle(vente_designation.getEditor().getText().trim());
            }
        });

        table_achat_id.setCellValueFactory((TableColumn.CellDataFeatures<Purchase, Long> r)->new ReadOnlyObjectWrapper<>(r.getValue().getArticle().getId()));
        table_achat_date.setCellValueFactory((TableColumn.CellDataFeatures<Purchase, String> r)->new ReadOnlyObjectWrapper<>(new SimpleDateFormat("dd-MM-yyyy").format(r.getValue().getCreatedAt())));
        table_achat_description.setCellValueFactory((TableColumn.CellDataFeatures<Purchase, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getArticle().getDescription()));
        table_achat_designation.setCellValueFactory((TableColumn.CellDataFeatures<Purchase, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getArticle().getDesignation()));
        table_achat_fournisseur.setCellValueFactory((TableColumn.CellDataFeatures<Purchase, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getFurnisher()));
        table_achat_quantite.setCellValueFactory((TableColumn.CellDataFeatures<Purchase, Integer> r)->new ReadOnlyObjectWrapper<>(r.getValue().getQuantity()));
        table_achat_montant.setCellValueFactory((TableColumn.CellDataFeatures<Purchase, Double> r)->new ReadOnlyObjectWrapper<>(r.getValue().getAmount()));
        table_achat_prix.setCellValueFactory((TableColumn.CellDataFeatures<Purchase, Double> r)->new ReadOnlyObjectWrapper<>(r.getValue().getPrice()));

        table_vente_id.setCellValueFactory((TableColumn.CellDataFeatures<Sale, Long> r)->new ReadOnlyObjectWrapper<>(r.getValue().getArticle().getId()));
        table_vente_client.setCellValueFactory((TableColumn.CellDataFeatures<Sale, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getClient()));
        table_vente_date.setCellValueFactory((TableColumn.CellDataFeatures<Sale, String> r)->new ReadOnlyObjectWrapper<>(new SimpleDateFormat("dd-MM-yyyy").format(r.getValue().getDate())));
        table_vente_description.setCellValueFactory((TableColumn.CellDataFeatures<Sale, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getArticle().getDescription()));
        table_vente_designation.setCellValueFactory((TableColumn.CellDataFeatures<Sale, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getArticle().getDesignation()));
        table_vente_prix.setCellValueFactory((TableColumn.CellDataFeatures<Sale, Double> r)->new ReadOnlyObjectWrapper<>(r.getValue().getPrice()));
        table_vente_quantite.setCellValueFactory((TableColumn.CellDataFeatures<Sale, Integer> r)->new ReadOnlyObjectWrapper<>(r.getValue().getQuantity()));
        table_vente_montant.setCellValueFactory((TableColumn.CellDataFeatures<Sale, Double> r)->new ReadOnlyObjectWrapper<>(r.getValue().getAmount()));

        table_article_id.setCellValueFactory((TableColumn.CellDataFeatures<Article, Long> r)->new ReadOnlyObjectWrapper<>(r.getValue().getId()));
        table_article_description.setCellValueFactory((TableColumn.CellDataFeatures<Article, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getDescription()));
        table_article_designation.setCellValueFactory((TableColumn.CellDataFeatures<Article, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getDesignation()));
        table_article_prix.setCellValueFactory((TableColumn.CellDataFeatures<Article, Double> r)->new ReadOnlyObjectWrapper<>(r.getValue().getPrice()));
        table_article_quantite.setCellValueFactory((TableColumn.CellDataFeatures<Article, Integer> r)->new ReadOnlyObjectWrapper<>(r.getValue().getStock()));

        achats_date.setCellValueFactory((TableColumn.CellDataFeatures<Purchase, String> r)->new ReadOnlyObjectWrapper<>(new SimpleDateFormat("dd-MM-yyyy").format(r.getValue().getCreatedAt())));
        achats_article.setCellValueFactory((TableColumn.CellDataFeatures<Purchase, Article> r)->new ReadOnlyObjectWrapper<>(r.getValue().getArticle()));
        achats_fournisseur.setCellValueFactory((TableColumn.CellDataFeatures<Purchase, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getFurnisher()));
        achats_quantite.setCellValueFactory((TableColumn.CellDataFeatures<Purchase, Integer> r)->new ReadOnlyObjectWrapper<>(r.getValue().getQuantity()));
        achats_montant.setCellValueFactory((TableColumn.CellDataFeatures<Purchase, Double> r)->new ReadOnlyObjectWrapper<>(r.getValue().getAmount()));
        achats_prix.setCellValueFactory((TableColumn.CellDataFeatures<Purchase, Double> r)->new ReadOnlyObjectWrapper<>(r.getValue().getPrice()));

        ventes_date.setCellValueFactory((TableColumn.CellDataFeatures<Sale, String> r)->new ReadOnlyObjectWrapper<>(new SimpleDateFormat("dd-MM-yyyy").format(r.getValue().getDate())));
        ventes_article.setCellValueFactory((TableColumn.CellDataFeatures<Sale, Article> r)->new ReadOnlyObjectWrapper<>(r.getValue().getArticle()));
        ventes_client.setCellValueFactory((TableColumn.CellDataFeatures<Sale, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getClient()));
        ventes_quantite.setCellValueFactory((TableColumn.CellDataFeatures<Sale, Integer> r)->new ReadOnlyObjectWrapper<>(r.getValue().getQuantity()));
        ventes_montant.setCellValueFactory((TableColumn.CellDataFeatures<Sale, Double> r)->new ReadOnlyObjectWrapper<>(r.getValue().getAmount()));
        ventes_prix.setCellValueFactory((TableColumn.CellDataFeatures<Sale, Double> r)->new ReadOnlyObjectWrapper<>(r.getValue().getPrice()));
    }
}

