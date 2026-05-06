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

public class AboutDetailController {

    @FXML
    private Label topPageTitleLabel;

    @FXML
    private Label headingLabel;

    @FXML
    private Label introLabel;

    @FXML
    private Label focusPointsLabel;

    @FXML
    private Label whyItMattersLabel;

    public void setSection(AboutSection section) {
        topPageTitleLabel.setText(section.getPageTitle());
        headingLabel.setText(section.getHeading());
        introLabel.setText(section.getIntro());
        focusPointsLabel.setText(section.getFocusPoints());
        whyItMattersLabel.setText(section.getWhyItMatters());
    }

    @FXML
    private void goBackHome(ActionEvent event) throws IOException {
        URL fxmlUrl = getClass().getResource("about-us-view.fxml");

        if (fxmlUrl == null) {
            throw new IOException("FXML file not found: about-us-view.fxml");
        }

        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        Scene scene = new Scene(loader.load());

        URL cssUrl = getClass().getResource("aboutus.css");

        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("UTSA Dining App");
        stage.setScene(scene);
        stage.show();
    }
}