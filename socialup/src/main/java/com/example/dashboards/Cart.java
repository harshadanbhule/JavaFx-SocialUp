package com.example.dashboards;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Cart {

    private Stage stage; // Stage for the next page

    public Cart(Stage stage) {
        this.stage = stage;
    }

    public Scene createScene() {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(50));

        Button backButton = new Button("Back to Home");
        backButton.setOnAction(event -> backToUserPage());

        layout.getChildren().addAll(backButton);

        return new Scene(layout, 1920, 1080);
    }

    private void backToUserPage() {
        UserPage userPage = new UserPage(stage);
        userPage.initUserScene(); // Re-initialize the UserPage scene
        stage.setScene(userPage.getUserScene()); // Set the UserPage scene
        stage.setTitle("User Dashboard");
    }
}
