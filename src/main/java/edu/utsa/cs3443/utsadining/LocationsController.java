package edu.utsa.cs3443.utsadining;

import com.opencsv.CSVReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class LocationsController {
    private ArrayList<Restaurant> restaurants;
    @FXML
    private VBox buttonContainer;

    public void initialize() {
        loadRestaurantsFromFile("/data/restaurants.csv");
    }

    public void loadRestaurantsFromFile(String filename) {
        this.restaurants = new ArrayList<>();

        InputStream is = getClass().getResourceAsStream(filename);

        if (is == null) {
            System.err.println("Error: could not find file" + filename);
        }

        try (CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            String[] nextLine = null;

            while ((nextLine = reader.readNext()) != null) {
                String name = nextLine[0];
                String location = nextLine[1];
                String description = nextLine[2].replace("|", "\n");
                String hours = nextLine[3].replace("|", "\n");
                String imagePath = nextLine[4];

                System.out.println("Heading row: " + nextLine[0]);
                for (int i = 0; i < nextLine.length; i++) {
                    System.out.println("Index [" + i + "]: " + nextLine[i]);
                }

                Restaurant restaurant = new Restaurant(name, location, description, hours, imagePath);
                restaurants.add(restaurant);

                Button restButton = createRestaurantButton(restaurant);

                buttonContainer.getChildren().add(restButton);
            }
        } catch (Exception e) {
            System.err.println("Error loading CSV file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private Button createRestaurantButton(Restaurant restaurant) {
        String fullPath = "/data/images/" + restaurant.getImagePath();
        InputStream isImage = getClass().getResourceAsStream(fullPath);
        if (isImage == null) {
            System.err.println("The image could not be found at " + fullPath);
        }
        Button button = new Button();
        button.setMaxWidth(Double.MAX_VALUE);
        button.setStyle("-fx-background-color: #E0E0E0; -fx-cursor: hand;");

        HBox hbox= new HBox(20);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPadding(new Insets(10));

        VBox textData = new VBox(5);
        Label name = new Label(restaurant.getName());
        name.setStyle("-fx-font-size: 20px; -fx-font-family: 'Serif'; -fx-text-fill: #000080; -fx-font-weight: bold;");
        Label location = new Label(restaurant.getLocation());
        textData.getChildren().addAll(name, location);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        ImageView iv = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/data/images/" + restaurant.getImagePath()))));
        iv.setFitHeight(80);
        iv.setPreserveRatio(true);

        hbox.getChildren().addAll(textData, spacer, iv);
        button.setGraphic(hbox);

        button.setOnAction(event -> openRestaurantDetailsPage(event, restaurant));

        return button;
    }
    @FXML
    public Restaurant getRestaurantByName(String name) {

        return null;
    }
    @FXML
    public void handleRestaurantClick(MouseEvent event) {

    }
    @FXML
    public void openRestaurantDetailsPage(ActionEvent event, Restaurant selectedRestaurant) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("restaurant-details-view.fxml"));
            Parent root = loader.load();

            RestaurantDetailsController detailsController = loader.getController();
            detailsController.setRestaurant(selectedRestaurant);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void handleBackToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    }

