package startup.loga.client.controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import startup.loga.client.model.*;
import startup.loga.client.vendor.io.Validation;
import startup.loga.client.view.AlertError;
import startup.loga.client.view.AlertInfo;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    List<Profile> allProfile = new ArrayList<>();
    List<Department> services = new ArrayList<>();
    List<Position> titres = new ArrayList<>();

    @FXML
    private ComboBox<Profile> filtre_profile;

    @FXML
    private Pane content;

    @FXML
    private TabPane profileTab;

    @FXML
    private Tab tabNew;

    @FXML
    private TextField newNom;

    @FXML
    private TextField newPrenom;

    @FXML
    private TextField newContact;

    @FXML
    private ComboBox<Position> newPoste;

    @FXML
    private ComboBox<Department> newService;

    @FXML
    private Tab tabList;

    @FXML
    private TableView<Profile> profileTable;

    @FXML
    private TableColumn<Profile, Long> id;

    @FXML
    private TableColumn<Profile, String> nom;

    @FXML
    private TableColumn<Profile, String> prenom;

    @FXML
    private TableColumn<Profile, String> contact;

    @FXML
    private TableColumn<Profile, String> department;

    @FXML
    private TableColumn<Profile, String> position;

    @FXML
    private Tab tabDetail;

    @FXML
    private TextField detailsNom;

    @FXML
    private TextField detailsPrenom;

    @FXML
    private TextField detailsContact;

    @FXML
    private ComboBox<Position> detailsPoste;

    @FXML
    private ComboBox<Department> detailsService;
    
    @FXML
    void submit(ActionEvent event) {
        if (Validation.is_empty_field(newNom)) {
            AlertError.getInstance().setTitle("Erreur");
            AlertError.getInstance().setHeaderText("Enregistrement du profile");
            AlertError.getInstance().setContentText("Formulaire d'enregistrement incomplet");
            AlertError.getInstance().showAndWait();
        } else {
            Profile newProfile = new Profile();
            newProfile.setSurname(newNom.getText().trim());
            newProfile.setName(newPrenom.getText().trim());
            newProfile.setContact(newContact.getText().trim());
            newProfile.setPosition(newPoste.getValue());
            newProfile.setHireAt(new Date());

            StringBuilder nomPrenom = new StringBuilder();
            nomPrenom.append(newProfile.getSurname());
            nomPrenom.append("\\s");
            nomPrenom.append(newProfile.getName());

            User user = new User(
                    newProfile.getName().toLowerCase()+""+newProfile.getSurname().toLowerCase(),
                    "Log@gmc+"
            );
            user.setRole(Role.MEMBER);

            newProfile.setUser(user);

            try {
                //todo:manageResourceService.createProfile(newProfile);

                AlertInfo.getInstance().setTitle("Info");
                AlertInfo.getInstance().setHeaderText("Enregistrement profile");
                AlertInfo.getInstance().setContentText("Nouveau profil : "+nomPrenom+" enregistré avec succès.");
                AlertInfo.getInstance().show();
                selectTab(2);
                readProfile();
                emptyField();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void annuler_filtre(ActionEvent event){
        //TODO: cancel filtre code
    }
    
    @FXML
    void apply(ActionEvent event) {
        Profile profile = profileTable.getSelectionModel().getSelectedItem();
        profile.setSurname(detailsNom.getText().trim());
        profile.setName(detailsPrenom.getText().trim());
        profile.setContact(detailsContact.getText().trim());
        profile.setPosition(detailsPoste.getValue());

        try {
            //todo:manageResourceService.createProfile(profile);
            AlertInfo.getInstance().setTitle("Info");
            AlertInfo.getInstance().setHeaderText("Enregistrement profile");
            AlertInfo.getInstance().setContentText("Profile mis à jour avec succès.");
            AlertInfo.getInstance().show();
            selectTab(2);
            readProfile();
            emptyField();
        } catch (Exception e) {
            AlertError.getInstance().setTitle("Error");
            AlertError.getInstance().setHeaderText("Enregistrement profile");
            AlertError.getInstance().setContentText("Nouveau profil:"+id+" enregistré avec succès.");
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
    }
    
    @FXML
    void archive(ActionEvent event) {
    }
    
    @FXML
    void delete(ActionEvent event) {
        if (profileTable.getSelectionModel().getSelectedItem() != null) {
            try {
                //todo:manageResourceService.deleteProfile(profileTable.getSelectionModel().getSelectedItem().getId());
                AlertInfo.getInstance().setTitle("Info");
                AlertInfo.getInstance().setHeaderText("Archivage profile");
                AlertInfo.getInstance().setContentText("Profil archivé avec succès.");
                AlertInfo.getInstance().show();
                selectTab(2);
                readProfile();
            } catch (Exception e) {
                AlertInfo.getInstance().setTitle("Erreur");
                AlertInfo.getInstance().setHeaderText("Archivage profile");
                AlertInfo.getInstance().setContentText("Erreur lors de l'archivage du profile.\n"+e.getMessage());
                AlertInfo.getInstance().showAndWait();
                e.printStackTrace();
            }
        }
    }
    
    @FXML
    void edit() {
        if (profileTable.getSelectionModel().getSelectedItem() != null) {
            Profile ed = profileTable.getSelectionModel().getSelectedItem();
            detailsNom.setText(ed.getSurname());
            detailsPrenom.setText(ed.getName());
            detailsContact.setText(ed.getContact());
            detailsPoste.getSelectionModel().select(ed.getPosition());
            selectTab(3);
        }
    }

    @FXML
    void filtrer_profil(KeyEvent event){
        FilteredList<Profile> items = new FilteredList<>(FXCollections.observableArrayList(allProfile));
        items.setPredicate(item ->{
            String lower = filtre_profile.getEditor().getText().toLowerCase();
            String upper = filtre_profile.getEditor().getText().toUpperCase();
            if(item.getName().contains(lower) || item.getSurname().contains(lower))
                return true;
            else
                return item.getName().contains(upper) || item.getSurname().contains(upper);
        });
        SortedList<Profile> sorted = new SortedList<>(items);
        filtre_profile.setItems(FXCollections.observableArrayList(sorted));
    }
    
    @FXML
    void print(ActionEvent event) {
    }

    @FXML
    void print_profile(ActionEvent event){
        //TODO: print profile code
    }
    
    @FXML
    void quit(ActionEvent event) {
    }
    
    @FXML
    void reset(ActionEvent event) {
    }

    @FXML
    void show_profile(MouseEvent event) {

    }
    
    public void selectTab(int i) {
        profileTab.getSelectionModel().select(getTab(i));
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
        newNom.setText("");
        newPrenom.setText("");
        newContact.setText("");
        detailsNom.setText("");
        detailsPrenom.setText("");
        detailsContact.setText("");
    }
    
    void readProfile() {
        //todo:this.allProfile = manageResourceService.listProfile();
        profileTable.setItems(FXCollections.observableArrayList(allProfile));
        filtre_profile.setItems(FXCollections.observableArrayList(allProfile));
    }

    void readService(){
        //todo:manageGarageService.listDepartment(1L);
        newService.setItems(FXCollections.observableArrayList(services));
        detailsService.setItems(FXCollections.observableArrayList(services));
    }

    void readTitre(){
        //Todo:manageGarageService.listPosition(1L);
        newPoste.setItems(FXCollections.observableArrayList(titres));
        detailsPoste.setItems(FXCollections.observableArrayList(titres));
    }
    
    public void initialize(URL location, ResourceBundle resources) {

        readProfile();

        readService();

        readTitre();

        id.setCellValueFactory((TableColumn.CellDataFeatures<Profile, Long> r)->new ReadOnlyObjectWrapper<>(r.getValue().getId()));
        nom.setCellValueFactory((TableColumn.CellDataFeatures<Profile, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getSurname()));
        prenom.setCellValueFactory((TableColumn.CellDataFeatures<Profile, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getName()));
        contact.setCellValueFactory((TableColumn.CellDataFeatures<Profile, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getContact()));
        department.setCellValueFactory((TableColumn.CellDataFeatures<Profile, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getPosition().getDepartment().getDesignation()));
        position.setCellValueFactory((TableColumn.CellDataFeatures<Profile, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getPosition().getDesignation()));

        filtre_profile.setConverter(new StringConverter<Profile>() {
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
                return null; //Todo:manageResourceService.findProfile(Long.parseLong(id));
            }
        });

        newPoste.setConverter(new StringConverter<Position>() {
            @Override
            public String toString(Position object) {
                if(object==null)
                    return null;
                return object.toString();
            }

            @Override
            public Position fromString(String string) {
                return null;//todo:manageGarageService.readPosition(string);
            }
        });

        detailsPoste.setConverter(new StringConverter<Position>() {
            @Override
            public String toString(Position object) {
                if(object==null)
                    return null;
                return object.toString();
            }

            @Override
            public Position fromString(String string) {
                return null; //Todo:manageGarageService.readPosition(string);
            }
        });
        newService.setConverter(new StringConverter<Department>() {
            @Override
            public String toString(Department object) {
                if(object==null)
                    return null;
                return object.toString();
            }

            @Override
            public Department fromString(String string) {
                return null; //todo:manageGarageService.readDepartment(string);
            }
        });

        detailsService.setConverter(new StringConverter<Department>() {
            @Override
            public String toString(Department object) {
                if(object==null)
                    return null;
                return object.toString();
            }

            @Override
            public Department fromString(String string) {
                return null;//todo:manageGarageService.readDepartment(string);
            }
        });
    }
}
