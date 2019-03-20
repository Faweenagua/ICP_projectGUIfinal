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
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public TextField obseName = new TextField();
    public TextField observeCountry;
    public TextField observeYear;
    public TextField observeArea;


    public TextField siteLongitude;
    public TextField eventYear;
    public TextField siteLatitude;

    public ChoiceBox<String> selectObservatory = new ChoiceBox<>();
    public ChoiceBox<String> vegetationColour = new ChoiceBox<>();
    public Label biggestColorValue = new Label();
    public Label maxGalamObservatory = new Label();
    public ChoiceBox<String> somethingThan = new ChoiceBox<String>();
    public ChoiceBox<String> colourValue = new ChoiceBox<String>();

    public void addObservatory(Event event) throws IOException {
        String name = obseName.textProperty().get();
        String country = observeCountry.textProperty().get();
        String year = observeYear.textProperty().get();
        String area = observeArea.textProperty().get();

        Observatory observatory = new Observatory();
        observatory.setName(name);
        observatory.setCountry(country);
        observatory.setYearStarted(Integer.parseInt(year));
        observatory.setAreaInSquareMeters(Double.parseDouble(area));

        Monitoring.observatories.add(observatory);

        backHome(event);
    }

    public void showGalamseyEvents(Event event){
        String relationOption = somethingThan.getSelectionModel().getSelectedItem();
        String colourType = colourValue.getSelectionModel().getSelectedItem();


    }

    public void addGalamseyEvent(Event event) throws IOException {
        String observatoryName = selectObservatory.getSelectionModel().getSelectedItem();
        String colourOfVegetation = vegetationColour.getSelectionModel().getSelectedItem();
        String latitude = siteLatitude.textProperty().get();
        String longitude = siteLatitude.textProperty().get();
        String yearOfEvent = eventYear.textProperty().get();

        Galamsey galamsey = new Galamsey();
        galamsey.setVegetationLatitude(Double.parseDouble(latitude));
        galamsey.setVegetationLongitude(Double.parseDouble(longitude));
        galamsey.setVegetationColour(colourOfVegetation);
        galamsey.setEventYear(Integer.parseInt(yearOfEvent));



        Monitoring.observatories.get(getIndexOfObservatory(observatoryName)).addEvent(galamsey);

        System.out.println();

        backHome(event);
    }


    @FXML private TableView<Observatory> observeList = new TableView<>();


    @FXML private TableColumn<Observatory, String> observeName = new TableColumn<>();

    @FXML private TableColumn<Observatory, Integer> numberOfEvents = new TableColumn<>();



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


    private ObservableList<String> observa;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        observa = FXCollections.observableArrayList();

        obsList();
        selectObservatory.setItems(observa);
        selectObservatory.setValue("Select an Observatory");

        vegetationColour.getItems().addAll("Select a colour","Yellow", "Green", "Brown");
        vegetationColour.setValue("Select a colour");

        somethingThan.getItems().addAll("Select option","Greater than","Equal to", "Less than");
        somethingThan.setValue("Select option");

        colourValue.getItems().addAll("Select a colour","Yellow", "Green", "Brown");
        colourValue.setValue("Select a colour");


      observeName.setCellValueFactory(new PropertyValueFactory<Observatory, String>("name"));
      numberOfEvents.setCellValueFactory(new PropertyValueFactory<Observatory, Integer>("numberOfGalamseyEvents"));

      observeList.setItems(getObservatories());

        biggestColorValue.setText(Integer.toString(Monitoring.getLargestGalamseyColourValueEverRecorded()));

        if(!(Monitoring.getObservatoryWithLargestNumberOfEvents() == null)) {
            maxGalamObservatory.setText(Monitoring.getObservatoryWithLargestNumberOfEvents().getName());
        }else {
            maxGalamObservatory.setText("Empty");
        }


        /*if(Monitoring.observatories.isEmpty()){
            biggestColorValue.setText("0");
            maxGalamObservatory.setText("Empty");
        }else if (Monitoring.observatories.get(0).getEvents().isEmpty()){
            biggestColorValue.setText(Integer.toString(Monitoring.getLargestGalamseyColourValueEverRecorded()));
            maxGalamObservatory.setText(Monitoring.getObservatoryWithLargestAverage().getName());
        }else {
            biggestColorValue.setText(Integer.toString(Monitoring.getLargestGalamseyColourValueEverRecorded()));
            //maxGalamObservatory.setText(Monitoring.getObservatoryWithLargestAverage().getName());
        }*/
    }

    private ObservableList<Observatory> getObservatories() {

        ObservableList<Observatory> ob = FXCollections.observableArrayList();

        ob.addAll(Monitoring.observatories);

        return ob;
    }

    private void obsList(){
        observa.add("Select an Observatory");
        for (Observatory ob: Monitoring.observatories){
            observa.add(ob.getName());
        }
    }

    private int getIndexOfObservatory(String observatoryName){
        int count = 0;
        int index = 0;
        for(Observatory observatory1: Monitoring.observatories){
            if(observatory1.getName().equals(observatoryName)){
                index = count;
                break;
            }
            count = count +1;
        }
        return index;
    }
}
