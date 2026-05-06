package edu.utsa.cs3443.utsadining;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AboutUsController {

    private Scene loadScene(String fxmlFile) throws IOException {
        URL fxmlUrl = getClass().getResource(fxmlFile);

        if (fxmlUrl == null) {
            throw new IOException("FXML file not found: " + fxmlFile);
        }

        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        Scene scene = new Scene(loader.load());

        URL cssUrl = getClass().getResource("aboutus.css");

        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        }

        return scene;
    }

    @FXML
    private void goToDashboard(ActionEvent event) throws IOException {
        Scene scene = loadScene("dashboard-view.fxml");

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("UTSA Dining Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    private void openDetailPage(ActionEvent event, AboutSection section) throws IOException {
        URL fxmlUrl = getClass().getResource("about-detail-view.fxml");

        if (fxmlUrl == null) {
            throw new IOException("FXML file not found: about-detail-view.fxml");
        }

        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        Scene scene = new Scene(loader.load());

        URL cssUrl = getClass().getResource("aboutus.css");

        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        }

        AboutDetailController controller = loader.getController();
        controller.setSection(section);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(section.getPageTitle());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void openQualityPage(ActionEvent event) throws IOException {
        AboutSection section = new AboutSection(
                "UTSA Quality Dining",
                "Committed to excellence in every meal we provide",
                "We prioritize every aspect of campus dining. Our goal is to provide meals that are reliable and satisfying for every student.",
                "• Reliable service across all locations\n" +
                        "• Clean and welcoming dining environments\n" +
                        "• High-quality food choices",
                "Quality dining ensures that students can depend on their meals every day. We want to help students remain energized and focused throughout the day."
        );

        openDetailPage(event, section);
    }

    @FXML
    private void openBalancedPage(ActionEvent event) throws IOException {
        AboutSection section = new AboutSection(
                "UTSA Balanced Choices",
                "Supporting healthier lifestyles through better options",
                "We offer a variety of balanced options to support different needs and preferences. Our goal is to make every student's meal choice easier.",
                "• Nutritionally balanced meal options\n" +
                        "• Vegetarian and plant-based selections\n" +
                        "• Allergen-aware food choices",
                "Balanced meals help students improve focus and support overall well-being throughout their academic journey."
        );

        openDetailPage(event, section);
    }

    @FXML
    private void openEvolvingPage(ActionEvent event) throws IOException {
        AboutSection section = new AboutSection(
                "UTSA Evolving Dining Experience",
                "Continually improving to meet student needs",
                "We regularly update our menus and look for ways to improve our dining spaces using student feedback. Our dining experience is always evolving to better serve students.",
                "• Regular menu updates and new food options\n" +
                        "• Improved dining spaces and environments\n" +
                        "• Student input and feedback",
                "An evolving dining experience ensures that campus dining stays exciting and aligned with student expectations."
        );

        openDetailPage(event, section);
    }
}