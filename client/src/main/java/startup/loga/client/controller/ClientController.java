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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import startup.loga.client.app.api.ClientPortal;
import startup.loga.client.app.api.DossierPortal;
import startup.loga.client.model.*;
import startup.loga.client.view.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ClientController implements Initializable
{
    final ClientPortal clientPortal;
    final DossierPortal dossierPortal;
    List<Client> allClients;

    Client currentClient;

    @FXML
    private TextField keyword;

    @FXML
    private Text client_count;

    @FXML
    private AnchorPane content;

    @FXML
    private TabPane clientTab;

    @FXML
    private Tab tabNew;
    @FXML
    private GridPane newClientForm;

    @FXML
    private ComboBox<Type> type;

    @FXML
    private TextField name;

    @FXML
    private TextField legal_notice;

    @FXML
    private TextField address;

    @FXML
    private TextField contact;

    @FXML
    private GridPane newAutoForm;

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
    private TableView<Client> table_client;

    @FXML
    private TableColumn<Client, Long> column_id;

    @FXML
    private TableColumn<Client, String> column_type;

    @FXML
    private TableColumn<Client, String> column_name;

    @FXML
    private TableColumn<Client, String> column_legal_notice;

    @FXML
    private TableColumn<Client, String> column_address;

    @FXML
    private TableColumn<Client, String> column_contact;

    @FXML
    private Tab tabDetail;

    @FXML
    private GridPane newClientForm1;

    @FXML
    private ComboBox<Type> edit_type;

    @FXML
    private TextField edit_name;

    @FXML
    private TextField edit_legal_notice;

    @FXML
    private TextField edit_address;

    @FXML
    private TextField edit_contact;

    @FXML
    private TextField clientId;

    public ClientController() {
        this.clientPortal = new ClientPortal();
        this.dossierPortal = new DossierPortal();
    }

    @FXML
    void apply(ActionEvent event) {
        Client client = new Client();
        client.setName(edit_name.getText().trim());
        client.setType(edit_type.getValue().name());
        client.setLegalNotice(edit_legal_notice.getText().trim());
        client.setAddress(edit_address.getText().trim());
        client.setContact(edit_contact.getText().trim());

        try {
            clientPortal.edit(client, currentClient.getId());

            AlertInfo.getInstance().setTitle("Modification réussie");
            AlertInfo.getInstance().setHeaderText("Succès de mise à jour");
            AlertInfo.getInstance().setContentText("Client mis à jour avec succès.");
            AlertInfo.getInstance().showAndWait();
            selectTab(2);
            readAll();
            emptyField();
        } catch (Exception e) {
            AlertError.getInstance().setTitle("Echec de modification");
            AlertError.getInstance().setHeaderText("Echec de modification du client");
            AlertError.getInstance().setContentText("La modification est terminé avec échec\n"+e.getMessage());
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
    }
    
    @FXML
    void archive(ActionEvent event) {
        AlertConfirm.getInstance().setTitle("Confirmation");
        AlertConfirm.getInstance().setHeaderText("Archivage de client");
        AlertConfirm.getInstance().setContentText("Cette action supprimera le client. Voulez-vous continuer ?");
        if(AlertConfirm.getInstance().showAndWait().get().equals(ButtonType.OK)){
            if (currentClient != null) {
                try {
                    clientPortal.delete(currentClient.getId());
                    AlertInfo.getInstance().setTitle("Opération réussie");
                    AlertInfo.getInstance().setHeaderText("Succès d'archivage");
                    AlertInfo.getInstance().setContentText(currentClient.getName()+" archivé avec succès.");
                    AlertInfo.getInstance().show();
                    selectTab(2);
                    readAll();
                } catch (Exception e) {
                    AlertWarning.getInstance().setTitle("Attention à la suppression");
                    AlertWarning.getInstance().setHeaderText("Impossible de procéder à l'archivage");
                    AlertWarning.getInstance().setContentText("Le client possède au moins un automobile\n"+e.getMessage());
                    AlertWarning.getInstance().showAndWait();
                    e.printStackTrace();
                }
            }
        }else {
            event.consume();
        }
    }

    @FXML
    void cancel(ActionEvent event) {
        emptyField();
    }

    @FXML
    void close(ActionEvent event) {
        emptyField();
        readAll();
        selectTab(2);
    }

    @FXML
    void delete(ActionEvent event) {
        AlertConfirm.getInstance().setTitle("Confirmation");
        AlertConfirm.getInstance().setHeaderText("Archivage de client");
        AlertConfirm.getInstance().setContentText("Cette action supprimera le client. Voulez-vous continuer ?");
        if(AlertConfirm.getInstance().showAndWait().get().equals(ButtonType.OK)){
            if (currentClient != null) {
                try {
                    clientPortal.delete(currentClient.getId());
                    AlertInfo.getInstance().setTitle("Opération réussie");
                    AlertInfo.getInstance().setHeaderText("Succès d'archivage");
                    AlertInfo.getInstance().setContentText(currentClient.getName()+" archivé avec succès.");
                    AlertInfo.getInstance().show();
                    selectTab(2);
                    readAll();
                } catch (Exception e) {
                    AlertWarning.getInstance().setTitle("Attention à la suppression");
                    AlertWarning.getInstance().setHeaderText("Impossible de procéder à l'archivage");
                    AlertWarning.getInstance().setContentText("Le client possède au moins un automobile\n"+e.getMessage());
                    AlertWarning.getInstance().showAndWait();
                    e.printStackTrace();
                }
            }
        }else {
            event.consume();
        }
    }
    
    @FXML
    void edit(ActionEvent event) {
        //edit_type.getSelectionModel().select(Type.valueOf(currentClient.getType()));
        edit_name.setText(currentClient.getName());
        edit_legal_notice.setText(currentClient.getLegalNotice());
        edit_address.setText(currentClient.getAddress());
        edit_contact.setText(currentClient.getContact());
        clientId.setText(String.valueOf(currentClient.getId()));
        selectTab(3);
    }

    @FXML
    void print(ActionEvent event) {
        AlertConfirm.getInstance().setTitle("Confirmation");
        AlertConfirm.getInstance().setHeaderText("Impression de liste des clients");
        AlertConfirm.getInstance().setContentText("Voulez-vous imprimer la liste des clients?");
        AlertConfirm.getInstance().showAndWait();
    }

    @FXML
    void search_client(KeyEvent event) {
        FilteredList<Client> items = new FilteredList<>(FXCollections.observableArrayList(allClients));
        items.setPredicate(item ->{
            String lower = keyword.getText().toLowerCase();
            String upper = keyword.getText().toUpperCase();
            if(item.getName().contains(lower))
                return true;
            else
                return item.getName().contains(upper);
        });
        SortedList<Client> sorted = new SortedList<>(items);
        table_client.setItems(sorted);
    }

    @FXML
    void select_client(MouseEvent event) {
        currentClient = table_client.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    void submit(ActionEvent event) {

        Automobile automobile = new Automobile();
        automobile.setVin(vin.getText().trim());
        automobile.setNumber(number.getText().trim());
        automobile.setMake(make.getText().trim());
        automobile.setModel(model.getText().trim());
        automobile.setUnit(unit.getSelectionModel().getSelectedItem().name());
        automobile.setTrim(Integer.parseInt(trim.getText().trim()));

        Client client = new Client();
        client.setContact(contact.getText().trim());
        client.setAddress(address.getText().trim());
        client.setName(name.getText().trim());
        client.setType(type.getValue().name());
        client.setLegalNotice(legal_notice.getText().trim());

        Dossier dossier = new Dossier();
        dossier.setReference(client.getName().trim()+automobile.getNumber().trim());
        dossier.setAutomobile(automobile);
        dossier.setClient(client);

        try {
            dossierPortal.create(dossier);
            AlertInfo.getInstance().setTitle("Succès d'enregistrement");
            AlertInfo.getInstance().setHeaderText("Nouveau dossier client enregistré");
            AlertInfo.getInstance().setContentText(automobile.getVin()+" de "+client.getName()+" enregistré avec succès.");
            AlertInfo.getInstance().show();
            selectTab(2);
            readAll();
            emptyField();
        } catch (Exception e) {
            AlertError.getInstance().setTitle("Echec de l'enregistrement");
            AlertError.getInstance().setHeaderText("Echec de l'enregistrement du nouveau client");
            AlertError.getInstance().setContentText("L'enregistrement est terminé avec échec\n"+e.getMessage());
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
    }
    
    public void selectTab(int i) {
        clientTab.getSelectionModel().select(getTab(i));
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
        name.setText("");
        legal_notice.setText("");
        address.setText("");
        contact.setText("");
        number.setText("");
        vin.setText("");
        make.setText("");
        model.setText("");
        trim.setText("");
        edit_name.setText("");
        edit_legal_notice.setText("");
        edit_address.setText("");
        edit_contact.setText("");
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

                        table_client.getItems().clear();

                        allClients = clientPortal.list();

                        table_client.setItems(FXCollections.observableArrayList(allClients));

                        client_count.setText(String.valueOf(allClients.size()));

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

        type.setItems(FXCollections.observableArrayList(Type.values()));
        edit_type.setItems(FXCollections.observableArrayList(Type.values()));
        unit.setItems(FXCollections.observableArrayList(Unit.values()));

        column_id.setCellValueFactory((TableColumn.CellDataFeatures<Client, Long> r)->new ReadOnlyObjectWrapper<>(r.getValue().getId()));
        column_type.setCellValueFactory((TableColumn.CellDataFeatures<Client, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getType()));
        column_name.setCellValueFactory((TableColumn.CellDataFeatures<Client, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getName()));
        column_address.setCellValueFactory((TableColumn.CellDataFeatures<Client, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getAddress()));
        column_contact.setCellValueFactory((TableColumn.CellDataFeatures<Client, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getContact()));
        column_legal_notice.setCellValueFactory((TableColumn.CellDataFeatures<Client, String> r)->new ReadOnlyObjectWrapper<>(r.getValue().getLegalNotice()));

        clientTab.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            public void changed(ObservableValue<? extends Tab> observableValue, Tab tab, Tab t1) {
                if (tab.getTabPane().getSelectionModel().getSelectedIndex() == 1) {
                    readAll();
                }
            }
        });
    }
}
