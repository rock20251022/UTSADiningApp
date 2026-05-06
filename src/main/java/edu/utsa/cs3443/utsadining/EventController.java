package edu.utsa.cs3443.utsadining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EventController {

    @FXML private Button tacoTuesdayButton;
    @FXML private Button waffleWednesdayButton;
    @FXML private Button fiestaEventButton;
    @FXML private Button earthDayButton;
    @FXML private Button nationalBurritoDayButton;
    @FXML private Button fiestaCookieButton;
    @FXML private Button backToDashboard;

    private EventDetails eventDetails;

    @FXML
    public void initialize() {
        eventDetails = new EventDetails();
        eventDetails.loadEventsFromFile("events.csv");
    }

    @FXML
    public void handleTacoTuesdayClick(ActionEvent event) {
        openEventDetailsPage("Taco Tuesday");
    }

    @FXML
    public void handleWaffleWednesdayClick(ActionEvent event) {
        openEventDetailsPage("National Waffle Day");
    }

    @FXML
    public void handleFiestaEventClick(ActionEvent event) {
        openEventDetailsPage("Fiesta");
    }

    @FXML
    public void handleEarthDayClick(ActionEvent event) {
        openEventDetailsPage("Earth Day");
    }

    @FXML
    public void handleNationalBurritoDayClick(ActionEvent event) {
        openEventDetailsPage("National Burrito Day");
    }

    @FXML
    public void handleFiestaCookieClick(ActionEvent event) {
        openEventDetailsPage("Fiesta Cookie Decorating Contest");
    }

    @FXML
    public void handleBackToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "dashboard-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) backToDashboard.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openEventDetailsPage(String selectedTitle) {
        try {
            Event selectedEvent = eventDetails.getEventByTitle(selectedTitle);
            if (selectedEvent == null) return;

            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "event-details-view.fxml"));
            Parent root = loader.load();

            EventDetailsController controller = loader.getController();
            controller.setEvent(selectedEvent);
            controller.populateFields();

            Stage stage = (Stage) tacoTuesdayButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
