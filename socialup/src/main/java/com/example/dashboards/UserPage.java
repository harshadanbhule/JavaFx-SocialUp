package com.example.dashboards;

import com.google.cloud.firestore.DocumentSnapshot;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import com.example.controller.LoginController;
import com.example.firebaseConfig.DataService;

public class UserPage {
    static String userName; // Static variable to store the username
    private DataService dataService; // Service to interact with Firestore
    VBox vb; // VBox to hold the user scene components

    // Constructor to initialize the UserPage with the DataService instance
    public UserPage(DataService dataService) {
        this.dataService = dataService;
    }

    // Method to create the user scene
    public VBox createUserScene(Runnable logoutHandler) {
        Button logoutButton = new Button("Logout"); // Button to trigger logout action
        Label dataLabel = new Label(); // Label to display the username

        try {
            String key = LoginController.key; // Get the username key from LoginController
            System.out.println("Value of key: " + key);
            DocumentSnapshot dataObject = dataService.getData("users", key);
            userName = dataObject.getString("username"); // Fetch the username from the dataObject

            System.out.println("username fetched: " + userName);
            dataLabel.setText("Welcome, " + userName); // Set the username in the label
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            // Set action for the logout button
            logoutButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    logoutHandler.run(); // Run the logout handler
                }
            });

            Text message = new Text("Welcome " + dataLabel.getText()); // Text to display welcome message
            message.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 60"); // Style the message text

            vb = new VBox(350, message, logoutButton);
            vb.setStyle("-fx-background-color: DARKGREY"); // Set background color for the VBox
        
            return vb; // Return the VBox to be used in the scene
    }
}