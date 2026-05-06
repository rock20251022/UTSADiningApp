package edu.utsa.cs3443.utsadining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class PlanDetailController {

    @FXML
    private Label topPageTitleLabel;

    @FXML
    private Label planTitleLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label includedLabel;

    @FXML
    private Label bestForLabel;

    public void setMealPlan(MealPlan plan) {
        topPageTitleLabel.setText(plan.getPageTitle());
        planTitleLabel.setText(plan.getPlanTitle());
        priceLabel.setText(plan.getPrice());
        descriptionLabel.setText(plan.getDescription());
        includedLabel.setText(plan.getIncluded());
        bestForLabel.setText(plan.getBestFor());
    }

    private Scene loadScene(String fxmlFile) throws IOException {
        URL fxmlUrl = getClass().getResource(fxmlFile);

        if (fxmlUrl == null) {
            throw new IOException("FXML file not found: " + fxmlFile);
        }

        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        Scene scene = new Scene(loader.load());

        URL cssUrl = getClass().getResource("mealplans.css");

        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        }

        return scene;
    }

    @FXML
    private void goBackHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("meal-plans-view.fxml"));
        Scene scene = new Scene(loader.load());

        URL cssUrl = getClass().getResource("mealplans.css");
        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("UTSA Meal Plans Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToSignIn(ActionEvent event) throws IOException {
        Scene scene = loadScene("ms-sign-in-view.fxml");

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("UTSA Meal Plans Sign In Page");
        stage.setScene(scene);
        stage.show();
    }
}