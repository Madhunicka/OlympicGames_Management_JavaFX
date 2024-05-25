package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Athlete;
import model.Event;

import java.time.LocalDate;

public class EventManagementController {
    @FXML
    private TableView<Event> eventTable;
    @FXML
    private TableColumn<Event, String> sportColumn;
    @FXML
    private TableColumn<Event, String> venueColumn;
    @FXML
    private TableColumn<Event, LocalDate> dateColumn;
    @FXML
    private TextField sportField;
    @FXML
    private TextField venueField;
    @FXML
    private DatePicker dateField;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    private ObservableList<Event> eventData;

    public void initialize() {
        // Initialize event table and populate with data
        eventData = FXCollections.observableArrayList();
        eventTable.setItems(eventData);
        // Define cell value factories for columns
        sportColumn.setCellValueFactory(cellData -> cellData.getValue().sportProperty());
        venueColumn.setCellValueFactory(cellData -> cellData.getValue().venueProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
    }

    @FXML
    private void handleAddEvent(ActionEvent event) {
        // Get input from text fields
        String sport = sportField.getText();
        String venue = venueField.getText();
        LocalDate date = dateField.getValue();
        
        // Validate input
        if (sport.isEmpty() || venue.isEmpty() || date == null) {
            showAlert("Please fill in all fields.");
            return;
        }
        
        // Create new event and add to list
        Event newEvent = new Event(sport, venue, date);
        eventData.add(newEvent);

        // Clear input fields
        clearFields();
    }

    @FXML
    private void handleEditEvent(ActionEvent event) {
        // Get selected event from table
        Event selectedEvent = eventTable.getSelectionModel().getSelectedItem();
        if (selectedEvent == null) {
            showAlert("Please select an event to edit.");
            return;
        }

        // Update event details
        selectedEvent.setSport(sportField.getText());
        selectedEvent.setVenue(venueField.getText());
        selectedEvent.setDate(dateField.getValue());

        // Clear input fields
        clearFields();
    }

    @FXML
    private void handleDeleteEvent(ActionEvent event) {
        // Get selected event from table
        Event selectedEvent = eventTable.getSelectionModel().getSelectedItem();
        if (selectedEvent == null) {
            showAlert("Please select an event to delete.");
            return;
        }

        // Remove event from list
        eventData.remove(selectedEvent);

        // Clear input fields
        clearFields();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        sportField.clear();
        venueField.clear();
        dateField.setValue(null);
    }
}
