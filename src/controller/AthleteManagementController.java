package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Athlete;

public class AthleteManagementController {

    @FXML
    private TableView<Athlete> athleteTable;
    @FXML
    private TableColumn<Athlete, String> nameColumn;
    @FXML
    private TableColumn<Athlete, String> countryColumn;
    @FXML
    private TableColumn<Athlete, Integer> ageColumn;
    @FXML
    private TableColumn<Athlete, String> genderColumn;
    @FXML
    private TextField nameField;
    @FXML
    private TextField countryField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField genderField;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    private ObservableList<Athlete> athleteData;

    public void initialize() {
        // Initialize athlete table and populate with data
        athleteData = FXCollections.observableArrayList();
        athleteTable.setItems(athleteData);
        // Define cell value factories for columns
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        countryColumn.setCellValueFactory(cellData -> cellData.getValue().countryProperty());
        ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        genderColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
    }

    @FXML
    private void handleAddAthlete(ActionEvent event) {
        // Get input from text fields
        String name = nameField.getText();
        String country = countryField.getText();
        int age = Integer.parseInt(ageField.getText());
        String gender = genderField.getText();
        
        // Validate input
        if (name.isEmpty() || country.isEmpty() || gender.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }
        
        // Create new athlete and add to list
        Athlete newAthlete = new Athlete(name, country, age, gender);
        athleteData.add(newAthlete);

        // Clear input fields
        clearFields();
    }

    @FXML
    private void handleEditAthlete(ActionEvent event) {
        // Get selected athlete from table
        Athlete selectedAthlete = athleteTable.getSelectionModel().getSelectedItem();
        if (selectedAthlete == null) {
            showAlert("Please select an athlete to edit.");
            return;
        }

        // Update athlete details
        selectedAthlete.setName(nameField.getText());
        selectedAthlete.setCountry(countryField.getText());
        selectedAthlete.setAge(Integer.parseInt(ageField.getText()));
        selectedAthlete.setGender(genderField.getText());

        // Clear input fields
        clearFields();
    }

    @FXML
    private void handleDeleteAthlete(ActionEvent event) {
        // Get selected athlete from table
        Athlete selectedAthlete = athleteTable.getSelectionModel().getSelectedItem();
        if (selectedAthlete == null) {
            showAlert("Please select an athlete to delete.");
            return;
        }

        // Remove athlete from list
        athleteData.remove(selectedAthlete);

        // Clear input fields
        clearFields();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        nameField.clear();
        countryField.clear();
        ageField.clear();
        genderField.clear();
    }
}
