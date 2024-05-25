package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Athlete;
import model.Event;
import model.Result;

public class ResultRecordingController {
    @FXML
    private TableView<Result> resultTable;
    @FXML
    private TableColumn<Result, String> eventColumn;
    @FXML
    private TableColumn<Result, String> athleteColumn;
    @FXML
    private TableColumn<Result, String> scoreColumn;
    @FXML
    private TableColumn<Result, String> medalColumn;
    @FXML
    private ComboBox<Event> eventComboBox;
    @FXML
    private ComboBox<Athlete> athleteComboBox;
    @FXML
    private TextField scoreField;
    @FXML
    private ComboBox<String> medalComboBox;
    @FXML
    private Button recordButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    private ObservableList<Result> resultData;
    private ObservableList<String> medalOptions;

//    private ObservableList<Result> resultData;
    private ObservableList<Event> eventData;
    private ObservableList<Athlete> athleteData;
//    private ObservableList<String> medalOptions;

    public void initialize() {
        // Initialize result table and populate with data
    	resultData = FXCollections.observableArrayList();
        resultTable.setItems(resultData);
        // Define cell value factories for columns
        eventColumn.setCellValueFactory(cellData -> cellData.getValue().eventProperty());
        athleteColumn.setCellValueFactory(cellData -> cellData.getValue().athleteProperty());
        scoreColumn.setCellValueFactory(cellData -> cellData.getValue().scoreProperty());
        medalColumn.setCellValueFactory(cellData -> cellData.getValue().medalProperty());

        // Initialize combo boxes
        eventData = FXCollections.observableArrayList(); // Populate this list with available events
        eventComboBox.setItems(eventData);

        athleteData = FXCollections.observableArrayList(); // Populate this list with available athletes
        athleteComboBox.setItems(athleteData);

        medalOptions = FXCollections.observableArrayList("Gold", "Silver", "Bronze");
        medalComboBox.setItems(medalOptions);
    }

    @FXML
    private void handleRecordResult(ActionEvent event) {
        // Get input from combo boxes and text field
        Event selectedEvent = eventComboBox.getValue();
        Athlete selectedAthlete = athleteComboBox.getValue();
        String score = scoreField.getText();
        String medal = medalComboBox.getValue();
        
        // Validate input
        if (selectedEvent == null || selectedAthlete == null || score.isEmpty() || medal.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }
        
        // Create new result and add to list
        Result newResult = new Result(selectedEvent, selectedAthlete, score, medal);
        resultData.add(newResult);

        // Clear input fields
        clearFields();
    }

    @FXML
    private void handleEditResult(ActionEvent event) {
        // Get selected result from table
        Result selectedResult = resultTable.getSelectionModel().getSelectedItem();
        if (selectedResult == null) {
            showAlert("Please select a result to edit.");
            return;
        }

        // Update result details
        selectedResult.setScore(scoreField.getText());
        selectedResult.setMedal(medalComboBox.getValue());

        // Clear input fields
        clearFields();
    }

    @FXML
    private void handleDeleteResult(ActionEvent event) {
        // Get selected result from table
        Result selectedResult = resultTable.getSelectionModel().getSelectedItem();
        if (selectedResult == null) {
            showAlert("Please select a result to delete.");
            return;
        }

        // Remove result from list
        resultData.remove(selectedResult);

        // Clear input fields
        clearFields();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        scoreField.clear();
        medalComboBox.getSelectionModel().clearSelection();
    }
}


