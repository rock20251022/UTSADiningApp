package edu.utsa.cs3443.utsadining;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class LoginController {

    @FXML
    private Button forgetButtonPressed;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordTextBox;

    @FXML
    private TextField userNameTextBox;

    private static final String USERS_CSV_RESOURCE = "/data/users.csv";

    @FXML
    void forgetPasswordClicked(MouseEvent event) {
        showAlert(Alert.AlertType.INFORMATION,
                "Forgot Password",
                "Please contact UTSA Dining administration to reset your credentials.");
    }

    @FXML
    void loginButtonPressed(MouseEvent event) {
        String username = safeTrim(userNameTextBox.getText());
        String password = safeTrim(passwordTextBox.getText());

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Missing Info", "Please enter both username and password.");
            return;
        }

        if (credentialsMatch(username, password)) {
            loadDashboard(event);
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
    }

    private boolean credentialsMatch(String username, String password) {
        try (InputStream is = getClass().getResourceAsStream(USERS_CSV_RESOURCE)) {
            if (is == null) {
                System.err.println("Could not find " + USERS_CSV_RESOURCE);
                return false;
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) continue;

                    String[] parts = line.split(",", -1);
                    if (parts.length < 2) continue;

                    String fileUser = parts[0].trim();
                    String filePass = parts[1].trim();

                    if (fileUser.equals(username) && filePass.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void loadDashboard(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Navigation Error", "Could not load the dashboard screen.");
        }
    }

    private static String safeTrim(String s) {
        return (s == null) ? "" : s.trim();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
