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
import javafx.stage.Stage;

import java.io.InputStream;

public class EventDetailsController {

    @FXML private Label titleLabel;
    @FXML private Label dateLabel;
    @FXML private Label timeLabel;
    @FXML private Label locationLabel;
    @FXML private Label descriptionLabel;
    @FXML private ImageView eventImageView;
    @FXML private Button backToEventsButton;
    @FXML private Button backToDashboardButton;

    private Event selectedEvent;

    @FXML
    public void initialize() {
    }

    public void setEvent(Event event) {
        this.selectedEvent = event;
    }

    public void populateFields() {
        if (selectedEvent == null) return;
        titleLabel.setText(selectedEvent.getTitle());
        dateLabel.setText(selectedEvent.getDate());
        timeLabel.setText(selectedEvent.getTime());
        locationLabel.setText(selectedEvent.getLocation());
        descriptionLabel.setText(selectedEvent.getDescription());
        loadEventImage();
    }

    public void loadEventImage() {
        if (selectedEvent == null || selectedEvent.getImagePath() == null
                || selectedEvent.getImagePath().isEmpty()) return;
        try {
            InputStream stream = getClass().getResourceAsStream(
                    "/data/images/" + selectedEvent.getImagePath());
            if (stream != null) {
                Image img = new Image(stream);
                if (!img.isError()) {
                    eventImageView.setImage(img);
                }
            } else {
                System.out.println("Image not found: " + selectedEvent.getImagePath());
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
    public void handleBackToEvents(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "events-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) backToEventsButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
