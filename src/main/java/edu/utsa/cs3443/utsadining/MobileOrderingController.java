package edu.utsa.cs3443.utsadining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MobileOrderingController {

    @FXML private Button backToDashboardButton;

    private MobileOrdering mobileOrdering;

    @FXML
    public void initialize() {
        mobileOrdering = new MobileOrdering();
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
}