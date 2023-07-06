package startup.loga.client.controller;

import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import startup.loga.client.model.Calendar;
import startup.loga.client.model.Profile;
import startup.loga.client.model.Space;
import startup.loga.client.view.AlertError;
import startup.loga.client.view.AlertInfo;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AgendaController implements Initializable
{
    static AgendaController instance;

    List<Space> allEspace;
    List<Profile> allProfile;
    Date debut,fin;

    public AgendaController(){
        instance = this;
    }

    public static AgendaController getInstance(){
        return instance;
    }

    @FXML
    private AnchorPane content;

    @FXML
    private TabPane agenda_tab;

    @FXML
    private Tab tab_calendrier;

    @FXML
    private AnchorPane calendrier_tab_content;

    @FXML
    private TextField titre;

    @FXML
    private TextArea contenu;

    @FXML
    private ComboBox<Space> espace;

    @FXML
    private ComboBox<Profile> ouvrier;

    @FXML
    private DatePicker date_debut;

    @FXML
    private DatePicker date_fin;

    @FXML
    private Button enregistrer;

    @FXML
    private Button annuler;

    @FXML
    private Tab tab_agenda;

    @FXML
    AnchorPane agenda_tab_content;

    @FXML
    VBox calendar;
    
    @FXML
    void cancel(ActionEvent event) {
        titre.setText("");
        contenu.setText("");
        espace.setItems(null);
        ouvrier.setItems(null);
        date_debut.getEditor().setText("");
        date_fin.getEditor().setText("");
    }
    
    @FXML
    void enregistrer_calendrier(ActionEvent event) {
        Calendar calendrier = new Calendar();
        calendrier.setTitle(titre.getText().trim());
        calendrier.setContent(contenu.getText().trim());
        calendrier.setProfile(ouvrier.getValue());
        calendrier.setSpace(espace.getValue());
        calendrier.setStartAt(debut);
        calendrier.setEndAt(fin);

        try {
            //todo:manageResourceService.createCalendar(calendrier);
            AlertInfo.getInstance().setHeaderText("Calendar de planification");
            AlertInfo.getInstance().setContentText("Calendar mis à jour avec succès.");
            AlertInfo.getInstance().showAndWait();
        } catch (Exception e) {
            AlertError.getInstance().setHeaderText("Calendar de planification");
            AlertError.getInstance().setContentText("Une erreur s'est produite sur le calendrier.\n"+e.getMessage());
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    void select_date_debut(ActionEvent event){
        LocalDate localDate = date_debut.getValue();

        ZoneId systemTimeZone = ZoneId.systemDefault();

        ZonedDateTime zonedDateTime = localDate.atStartOfDay(systemTimeZone);

        debut = Date.from(zonedDateTime.toInstant());
    }

    @FXML
    void select_date_fin(ActionEvent event){
        LocalDate localDate = date_fin.getValue();

        ZoneId systemTimeZone = ZoneId.systemDefault();

        ZonedDateTime zonedDateTime = localDate.atStartOfDay(systemTimeZone);

        fin = Date.from(zonedDateTime.toInstant());
    }

    @FXML
    void search_espace(KeyEvent event) {
        FilteredList<Space> items = new FilteredList<>(FXCollections.observableArrayList(allEspace));
        items.setPredicate(item ->{
            String lower = espace.getEditor().getText().toLowerCase();
            String upper = espace.getEditor().getText().toUpperCase();
            if(item.getName().contains(lower))
                return true;
            else
                return item.getName().contains(upper);
        });
        SortedList<Space> sorted = new SortedList<>(items);
        espace.setItems(sorted);
    }
    
    @FXML
    void search_profile(KeyEvent event) {
        FilteredList<Profile> items = new FilteredList<>(FXCollections.observableArrayList(allProfile));
        items.setPredicate(item ->{
            String lower = ouvrier.getEditor().getText().toLowerCase();
            String upper = ouvrier.getEditor().getText().toUpperCase();
            if(item.getSurname().contains(lower) || item.getName().contains(lower))
                return true;
            else
                return item.getSurname().contains(upper) || item.getName().contains(upper);
        });
        SortedList<Profile> sorted = new SortedList<>(items);
        ouvrier.setItems(sorted);
    }

    public AnchorPane getAgendaTabContent(){
        return agenda_tab_content;
    }

    public VBox getCalendar(){
        return calendar;
    }

    public void initialize(URL location, ResourceBundle resources) {
        //todo:allProfile = manageResourceService.listProfile();

        //todo:allEspace = manageResourceService.listSpace();

        ouvrier.setConverter(new StringConverter<Profile>() {
            @Override
            public String toString(Profile object) {
                if(object==null)
                    return null;
                return object.toString();
            }

            @Override
            public Profile fromString(String string) {
                String[] data = string.split("\\s");
                String id = data[0].trim();
                return null;//todo:manageResourceService.findProfile(Long.parseLong(id));
            }
        });

        espace.setConverter(new StringConverter<Space>() {
            @Override
            public String toString(Space object) {
                if(object==null)
                    return null;
                return object.toString();
            }

            @Override
            public Space fromString(String string) {
                String[] data = string.split("\\s");
                String id = data[0].trim();
                return null;//todo:manageResourceService.findSpace(Long.parseLong(id));
            }
        });
    }
}
