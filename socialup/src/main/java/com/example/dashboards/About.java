package com.example.dashboards;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class About {
    public Scene createScene() {
        // Create UI components for About page
        StackPane root = new StackPane();
        Label label = new Label("About Us Page");
        root.getChildren().add(label);

        // Set up scene and return it
        return new Scene(root, 800, 600);
    }
}
