package edu.utsa.cs3443.utsadining;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AboutUsApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                AboutUsApplication.class.getResource("about-us-view.fxml")
        );

        Scene scene = new Scene(loader.load(), 1440, 900);

        URL cssUrl = AboutUsApplication.class.getResource("aboutus.css");

        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        }

        stage.setTitle("UTSA Dining App");
        stage.setScene(scene);
        stage.show();
    }
}