package edu.utsa.cs3443.utsadining;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MealPlansApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                MealPlansApplication.class.getResource("meal-plans-view.fxml")
        );

        Scene scene = new Scene(loader.load(), 1440, 900);
        scene.getStylesheets().add(
                MealPlansApplication.class.getResource("mealplans.css").toExternalForm()
        );

        stage.setTitle("UTSA Meal Plans Page");
        stage.setScene(scene);
        stage.show();
    }
}

