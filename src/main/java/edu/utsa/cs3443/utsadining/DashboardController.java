package edu.utsa.cs3443.utsadining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    void handleAboutUsClick(ActionEvent event) {
        loadScreen(event, "about-us-view.fxml", "About Us");
    }

    @FXML
    void handleEventsClick(ActionEvent event) {
        loadScreen(event, "events-view.fxml", "Events");
    }

    @FXML
    void handleLogOutClick(ActionEvent event) {
        loadScreen(event, "login-view.fxml", "Login");
    }

    @FXML
    void handleMealPlansClick(ActionEvent event) {
        loadScreen(event, "meal-plans-view.fxml", "Meal Plans");
    }

    @FXML
    void handleOrderingClick(ActionEvent event) {
        loadScreen(event, "mobile-ordering-view.fxml", "Ordering");
    }

    @FXML
    void handleRestaurantsClick(ActionEvent event) {
        loadScreen(event, "restaurants-view.fxml", "Restaurants");
    }

    private void loadScreen(ActionEvent event, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Navigation Error");
            alert.setHeaderText(null);
            alert.setContentText("Could not load " + title + " screen. Ensure " + fxmlPath + " exists.");
            alert.showAndWait();
        }
    }


}
