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
import model.SportsDiscipline;

public class SportDisciplineController {
    @FXML
    private TableView<SportsDiscipline> disciplineTable;
    @FXML
    private TableColumn<SportsDiscipline, String> nameColumn;
    @FXML
    private TextField nameField;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    private ObservableList<SportsDiscipline> disciplineData;

    public void initialize() {
        // Initialize discipline table and populate with data
        disciplineData = FXCollections.observableArrayList();
        disciplineTable.setItems(disciplineData);
        // Define cell value factories for columns
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    }

    @FXML
    private void handleAddDiscipline(ActionEvent event) {
        // Get input from text field
        String name = nameField.getText();
        
        // Validate input
        if (name.isEmpty()) {
            showAlert("Please enter a discipline name.");
            return;
        }
        
        // Create new discipline and add to list
        SportsDiscipline newDiscipline = new SportsDiscipline(name);
        disciplineData.add(newDiscipline);

        // Clear input field
        clearFields();
    }

    @FXML
    private void handleEditDiscipline(ActionEvent event) {
        // Get selected discipline from table
        SportsDiscipline selectedDiscipline = disciplineTable.getSelectionModel().getSelectedItem();
        if (selectedDiscipline == null) {
            showAlert("Please select a discipline to edit.");
            return;
        }

        // Update discipline name
        selectedDiscipline.setName(nameField.getText());

        // Clear input field
        clearFields();
    }

    @FXML
    private void handleDeleteDiscipline(ActionEvent event) {
        // Get selected discipline from table
        SportsDiscipline selectedDiscipline = disciplineTable.getSelectionModel().getSelectedItem();
        if (selectedDiscipline == null) {
            showAlert("Please select a discipline to delete.");
            return;
        }

        // Remove discipline from list
        disciplineData.remove(selectedDiscipline);

        // Clear input field
        clearFields();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        nameField.clear();
    }
}
