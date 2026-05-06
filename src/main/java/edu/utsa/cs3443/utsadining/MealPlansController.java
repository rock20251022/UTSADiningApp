package edu.utsa.cs3443.utsadining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MealPlansController {

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

    private void openDetail(ActionEvent event, MealPlan plan) throws IOException {
        URL fxmlUrl = getClass().getResource("plan-detail-view.fxml");

        if (fxmlUrl == null) {
            throw new IOException("FXML file not found: plan-detail-view.fxml");
        }

        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        Scene scene = new Scene(loader.load());

        URL cssUrl = getClass().getResource("mealplans.css");

        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        }

        PlanDetailController controller = loader.getController();
        controller.setMealPlan(plan);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(plan.getPageTitle());
        stage.setScene(scene);
        stage.show();
    }

    private void goToSignIn(ActionEvent event) throws IOException {
        Scene scene = loadScene("ms-sign-in-view.fxml");

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("UTSA Meal Plans Sign In Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("UTSA Dining Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void showSilver(ActionEvent event) throws IOException {
        openDetail(event, new MealPlan(
                "UTSA Silver Plan Page",
                "Silver Plan",
                "$2375.00 annually.",
                "A budget friendly plan that provides consistent access to campus dining locations.",
                "· Limited dining hall access per week\n" +
                        "· Moderate dollar allowance\n" +
                        "· Access to select campus dining locations\n" +
                        "· Flexible usage throughout the week",
                "Best for students who mix dining on campus with cooking or off-campus meals."
        ));
    }

    @FXML
    private void showGold(ActionEvent event) throws IOException {
        openDetail(event, new MealPlan(
                "UTSA Gold Plan Page",
                "Gold Plan",
                "$2565.00 annually.",
                "A balanced plan that offers strong flexibility and value for students who regularly dine on campus.",
                "· Frequent dining hall access\n" +
                        "· Generous dollar allowance\n" +
                        "· Access to multiple dining locations\n" +
                        "· Occasional guest meal passes\n" +
                        "· Flexible weekly usage",
                "Best for students who eat on campus most days but want slightly more flexibility."
        ));
    }

    @FXML
    private void showPlatinum(ActionEvent event) throws IOException {
        openDetail(event, new MealPlan(
                "UTSA Platinum Plan Page",
                "Platinum Plan",
                "$2715.00 annually.",
                "Our most comprehensive meal plan. Designed for students or staff who want the maximum flexibility and convenience throughout the week.",
                "· Unlimited dining hall access\n" +
                        "· Highest dollar allowance\n" +
                        "· Priority to campus dining events\n" +
                        "· Flexible meals across all locations\n" +
                        "· Guest meal prices included",
                "Best for students who eat on campus daily and want the most options with no restrictions."
        ));
    }

    @FXML
    private void showRowdy150(ActionEvent event) throws IOException {
        openDetail(event, new MealPlan(
                "UTSA Rowdy 150 Plan Page",
                "Rowdy 150 Plan",
                "$1875.00 annually.",
                "A flexible block plan that gives students control over when and how meals are used.",
                "· 200 meals a semester\n" +
                        "· Dining dollars included\n" +
                        "· Meals usable at any time\n" +
                        "· Access to all major dining locations",
                "Best for students who want flexibility without committing to daily dining."
        ));
    }

    @FXML
    private void showRowdy120(ActionEvent event) throws IOException {
        openDetail(event, new MealPlan(
                "UTSA Rowdy 120 Plan Page",
                "Rowdy 120 Plan",
                "$1670.00 annually.",
                "A smaller block plan designed for lighter campus dining needs.",
                "· 160 meals a semester\n" +
                        "· Smallest dining dollar balance\n" +
                        "· Flexible meals usage\n" +
                        "· Access to multiple dining locations",
                "Best for students who occasionally eat on campus and want a lower-cost option."
        ));
    }

    @FXML
    private void showDiningDollars(ActionEvent event) throws IOException {
        openDetail(event, new MealPlan(
                "UTSA Dining Dollars Page",
                "Add Dining Dollars",
                "",
                "Supplement your meal plan with dining dollars for more flexibility across campus dining locations.",
                "· Use at all participating dining locations\n" +
                        "· No meal restrictions\n" +
                        "· Easy reload options",
                ""
        ));
    }

    @FXML
    private void showEmployeeMeal(ActionEvent event) throws IOException {
        openDetail(event, new MealPlan(
                "UTSA Employee Meal Page",
                "Employee Dining Options",
                "",
                "Flexible dining plans designed for faculty and staff who want convenient and affordable meal options on campus.",
                "· Discounted meal bundles\n" +
                        "· Dining dollar options\n" +
                        "· Flexible usage across campus",
                ""
        ));
    }

    @FXML
    private void signUp(ActionEvent event) throws IOException {
        goToSignIn(event);
    }
}