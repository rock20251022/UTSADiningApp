package edu.utsa.cs3443.utsadining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {

    @FXML
    private Label selectedPlanLabel;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private Label messageLabel;

    private String selectedPlan = "UTSA Meal Plan";

    public void setSelectedPlan(String selectedPlan) {
        if (selectedPlan != null && !selectedPlan.trim().isEmpty()) {
            this.selectedPlan = selectedPlan;
            selectedPlanLabel.setText("Thank you for choosing the " + selectedPlan + ".");
        }
    }

    @FXML
    private void submitSignUp() {
        String name = nameField.getText();
        String email = emailField.getText();

        if (name == null || name.trim().isEmpty()) {
            messageLabel.setText("Please enter your full name.");
            return;
        }

        if (email == null || email.trim().isEmpty()) {
            messageLabel.setText("Please enter your UTSA email.");
            return;
        }

        messageLabel.setText(
                "Thank you, " + name.trim() + "! Your sign up request for the "
                        + selectedPlan + " has been received."
        );
    }

    @FXML
    private void goBackToMealPlans(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("meal-plans-view.fxml"));
        Scene scene = new Scene(loader.load());

        scene.getStylesheets().add(
                getClass().getResource("mealplans.css").toExternalForm()
        );

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("UTSA Meal Plans Page");
        stage.setScene(scene);
        stage.show();
    }
}
