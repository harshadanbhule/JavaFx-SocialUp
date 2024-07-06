package com.example.dashboards;

import com.example.controller.LoginController;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Profile {

    private Stage stage; // Stage for the next page

    public Profile(Stage stage) {
        this.stage = stage;
    }

    public Scene createScene() {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(50));

        Label welcomeLabel = new Label("Welcome, " + LoginController.key + "!");
        welcomeLabel.setFont(Font.font("Poppins", FontWeight.BOLD, 24));
        welcomeLabel.setTextFill(Color.web("#092A93"));

        Button backButton = new Button("Back to Home");
        backButton.setOnAction(event -> backToUserPage());

        layout.getChildren().addAll(welcomeLabel,backButton);

        return new Scene(layout, 1920, 1080);
    }

    private void backToUserPage() {
        UserPage userPage = new UserPage(stage);
        userPage.initUserScene(); // Re-initialize the UserPage scene
        stage.setScene(userPage.getUserScene()); // Set the UserPage scene
        stage.setTitle("User Dashboard");
    }
}
