package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public TextField obseName;
    public TextField observeCountry;
    public TextField observeYear;
    public TextField observeArea;


    public TextField siteLongitude;
    public TextField eventYear;
    public TextField siteLatitude;

    public void addObservatory(Event event) throws IOException {
        String name = obseName.textProperty().get();
        String country = observeCountry.textProperty().get();
        String year = observeYear.textProperty().get();
        String area = observeArea.textProperty().get();
        backHome(event);
    }

    public void addGalamseyEvent(Event event) throws IOException {
        String latitude = siteLatitude.textProperty().get();
        String longitude = siteLatitude.textProperty().get();
        String yearEvent = eventYear.textProperty().get();
        String area = eventYear.textProperty().get();
        backHome(event);
        System.out.println(latitude+longitude+area);
    }


    @FXML
    private TableView<Observatory> observeList;


    @FXML
    private TableColumn<Observatory, String> observeName;

    @FXML
    private TableColumn<Observatory, Integer> numberOfEvents;



    public void changeToAddObserve(Event event) throws IOException {
        Parent addObse = FXMLLoader.load(getClass().getResource("addObserve.fxml"));
        Scene addObseScene = new Scene(addObse);
        Stage addObserStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        addObserStage.setScene(addObseScene);
        addObserStage.show();
    }

    public void changeToAddGalamsey(Event event) throws IOException {
        Parent addGalamsy = FXMLLoader.load(getClass().getResource("addGalam.fxml"));
        Scene addGalamScene = new Scene(addGalamsy);
        Stage addGalamStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        addGalamStage.setScene(addGalamScene);
        addGalamStage.show();
    }

    public void goToRecords(Event event) throws IOException {
        Parent records = FXMLLoader.load(getClass().getResource("records.fxml"));
        Scene recordsScene = new Scene(records);
        Stage recordsStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        recordsStage.setScene(recordsScene);
        recordsStage.show();
    }


    public void backHome(Event event) throws IOException {
        Parent back = FXMLLoader.load(getClass().getResource("galamHome.fxml"));
        Scene homeScene = new Scene(back);
        Stage homeStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        homeStage.setScene(homeScene);
        homeStage.show();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

      //observeName.setCellValueFactory(new PropertyValueFactory<Observatory, String>("name"));
      //numberOfEvents.setCellValueFactory(new PropertyValueFactory<Observatory, Integer>("numberOfGalamseyEvents"));

      //observeList.setItems(getObservatories());

    }

    private ObservableList<Observatory> getObservatories() {

        ObservableList<Observatory> ob = FXCollections.observableArrayList();

        ob.addAll(Monitoring.observatories);

        return ob;
    }
}
