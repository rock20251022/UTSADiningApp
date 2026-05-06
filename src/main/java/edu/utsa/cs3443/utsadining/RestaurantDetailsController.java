package edu.utsa.cs3443.utsadining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.Objects;

public class RestaurantDetailsController {
    @FXML
    private Label nameLabel;
    @FXML
    private Label locationLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label hoursLabel;
    @FXML
    private ImageView restaurantImageView;
    @FXML
    private Button backToLocationsButton;
    @FXML
    private Button backToDashboardButton;
    private Restaurant selectedRestaurant;

    @FXML
    public void initailize() {
    }

    public void setRestaurant(Restaurant restaurant) {
        this.selectedRestaurant = restaurant;
        populateFields();
        loadRestaurantImage();
    }

    public void populateFields() {
        if (selectedRestaurant == null) return;
        nameLabel.setText(selectedRestaurant.getName());
        locationLabel.setText(selectedRestaurant.getLocation());
        descriptionLabel.setText(selectedRestaurant.getDescription());
        hoursLabel.setText(selectedRestaurant.getHours());
    }

    public void loadRestaurantImage() {
        if (selectedRestaurant == null) return;

        String path = "/data/images/" + selectedRestaurant.getImagePath();
        try (InputStream is = getClass().getResourceAsStream(path)) {
            if (is != null) {
                restaurantImageView.setImage(new Image(is));
            } else {
                System.err.println("Coule not find image at: " + path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void handleBackToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "dashboard-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) backToDashboardButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleBackToLocations(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "restaurants-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) backToLocationsButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
