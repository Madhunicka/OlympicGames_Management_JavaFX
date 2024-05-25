package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.AthleteManagementController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Load FXML files and set controllers
        FXMLLoader athleteLoader = new FXMLLoader(getClass().getResource("/ui/athlete_management.fxml"));
        AthleteManagementController athleteController = new AthleteManagementController();
        athleteLoader.setController(athleteController);
        Parent athleteRoot = athleteLoader.load();

        // Create scene and set it to the primary stage
        Scene scene = new Scene(athleteRoot); // Set the root of the scene to the FXML root
        primaryStage.setScene(scene);
        primaryStage.setTitle("Olympic Games Management Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
