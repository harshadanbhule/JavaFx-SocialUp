package com.example.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

import com.example.firebaseConfig.DataService;

@SuppressWarnings("unused")
public class SignUpController {

    private LoginController loginController; // Reference to LoginController for navigation

    // Constructor to initialize the SignupController with the LoginController reference
    public SignUpController(LoginController loginController2) {
        this.loginController = loginController2;
    }

    // Method to create the signup scene
    public Scene createSignupScene(Stage primaryStage) {
        // Create UI components
        TextField userTextField = new TextField();
        userTextField.setMinWidth(400);
        userTextField.setPromptText("Email");
        userTextField.setPrefHeight(64);
        userTextField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3);");
        userTextField.setOnMouseClicked(event -> {
            userTextField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-border-color: #092A93; -fx-border-width: 2; -fx-border-radius: 10;");
        });
        userTextField.setOnMouseExited(event -> {
            userTextField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3);");
        });

        TextField usernameField = new TextField();
        usernameField.setMinWidth(400);
        usernameField.setPromptText("Username");
        usernameField.setPrefHeight(64);
        usernameField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3);");
        usernameField.setOnMouseClicked(event -> {
            usernameField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-border-color: #092A93; -fx-border-width: 2; -fx-border-radius: 10;");
        });
        usernameField.setOnMouseExited(event -> {
            usernameField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3);");

        });

        TextField mobileField = new TextField();
        mobileField.setMinWidth(400);
        mobileField.setPromptText("Mobile Number");
        mobileField.setPrefHeight(64);
        mobileField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3);");
        mobileField.setOnMouseClicked(event -> {
            mobileField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-border-color: #092A93; -fx-border-width: 2; -fx-border-radius: 10;");
        });
        mobileField.setOnMouseExited(event -> {
            mobileField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3);");

        });

        TextField professionField = new TextField();
        professionField.setMinWidth(400);
        professionField.setPromptText("Profession");
        professionField.setPrefHeight(64);
        professionField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3);");
        professionField.setOnMouseClicked(event -> {
            professionField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-border-color: #092A93; -fx-border-width: 2; -fx-border-radius: 10;");
        });
        professionField.setOnMouseExited(event -> {
            professionField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3);");

        });

        TextField socialmediaField = new TextField();
        socialmediaField.setMinWidth(400);
        socialmediaField.setPromptText("Social Media Link");
        socialmediaField.setPrefHeight(64);
        socialmediaField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3);");
        socialmediaField.setOnMouseClicked(event -> {
            socialmediaField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-border-color: #092A93; -fx-border-width: 2; -fx-border-radius: 10;");
        });
        socialmediaField.setOnMouseExited(event -> {
            socialmediaField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3);");

        });

        PasswordField passField = new PasswordField();
        passField.setMaxWidth(400);
        passField.setPromptText("Password");
        passField.setPrefHeight(64);
        passField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3);");
        passField.setOnMouseClicked(event -> {
            passField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-border-color: #092A93; -fx-border-width: 2; -fx-border-radius: 10;");
        });
        passField.setOnMouseExited(event -> {
            passField.setStyle("-fx-background-radius: 10; -fx-background-color: #F1F4FF; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3);");
        });

        Button loginButton = new Button("Sign up");
        loginButton.setFont(Font.font("Poppins", FontWeight.BOLD, 20));
        loginButton.setTextFill(Color.WHITE);
        loginButton.setStyle("-fx-background-color: #092A93; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3);");
        loginButton.setPrefSize(320, 60);
        loginButton.setOnAction(event -> handleSignup(primaryStage, userTextField.getText(),usernameField.getText(),mobileField.getText(),professionField.getText(),socialmediaField.getText(), passField.getText()));

        Label loginLabel = new Label("Create Account");
        loginLabel.setFont(Font.font("Poppins", FontWeight.BOLD, 30));
        loginLabel.setTextFill(Color.web("#092A93"));

        Label welcomeLabel = new Label("Create an account so you can explore\n          all the available plans");
        welcomeLabel.setFont(Font.font("Poppins", FontWeight.BOLD, 16));

        

        Label createAccountLabel = new Label("Already have an account");
        createAccountLabel.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
        createAccountLabel.setTextFill(Color.web("#494949"));
        Button lButton = new Button();
        lButton.setGraphic(createAccountLabel);
        lButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        lButton.setOnAction(event -> loginController.showLoginScene());

        Label continueWithLabel = new Label("Or continue with");
        continueWithLabel.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
        continueWithLabel.setTextFill(Color.web("#092A93"));

        Image googleImage = new Image("/login/google.png");
        ImageView googleImageView = new ImageView(googleImage);
        googleImageView.setFitWidth(24);
        googleImageView.setFitHeight(24);
        Button googleButton = new Button();
        googleButton.setGraphic(googleImageView);
        googleButton.setStyle("-fx-background-color: #ECECEC; -fx-background-radius: 10;");
        googleButton.setPrefSize(60, 44);

        Image facebookImage = new Image("/login/facebook.png");
        ImageView facebookImageView = new ImageView(facebookImage);
        facebookImageView.setFitWidth(24);
        facebookImageView.setFitHeight(24);
        Button facebookButton = new Button();
        facebookButton.setGraphic(facebookImageView);
        facebookButton.setStyle("-fx-background-color: #ECECEC; -fx-background-radius: 10;");
        facebookButton.setPrefSize(60, 44);

        Image appleImage = new Image("/login/apple.png");
        ImageView appleImageView = new ImageView(appleImage);
        appleImageView.setFitWidth(24);
        appleImageView.setFitHeight(24);
        Button appleButton = new Button();
        appleButton.setGraphic(appleImageView);
        appleButton.setStyle("-fx-background-color: #ECECEC; -fx-background-radius: 10;");
        appleButton.setPrefSize(60, 44);

        HBox socialButtons = new HBox(15, googleButton, facebookButton, appleButton);
        socialButtons.setAlignment(Pos.CENTER);
        Image loginImage=new Image("/register.png");
        ImageView loImageView=new ImageView(loginImage);


        Image loginImage2 = new Image("/Arrow-Left.png");
        ImageView loImageView2 = new ImageView(loginImage2);

        Button backButton = new Button();
        backButton.setGraphic(loImageView2);
        backButton.setLayoutX(30);
        backButton.setLayoutY(40);
        backButton.setOnAction(event -> loginController.showLoginScene());
        Group stackPane=new Group(loImageView,backButton);
        backButton.setStyle("-fx-background-color: transparent; -fx-padding: 0;");

       

        VBox mainLayout = new VBox(20);
        mainLayout.setStyle("-fx-padding: 0 35 60 35;");
        mainLayout.getChildren().addAll(
            loginLabel,
            welcomeLabel,
            userTextField,
            usernameField,
            mobileField,
                professionField,
                socialmediaField,
            passField,
            loginButton,
            lButton,
            continueWithLabel,
            socialButtons
        );
        mainLayout.setAlignment(Pos.CENTER);
        VBox.setMargin(welcomeLabel, new Insets(30, 0, 0, 0));
        VBox.setMargin(userTextField, new Insets(30, 0, 0, 0));
        VBox.setMargin(usernameField, new Insets(15, 0, 0, 0));
        VBox.setMargin(professionField, new Insets(15, 0, 0, 0));
        VBox.setMargin(socialmediaField, new Insets(15, 0, 0, 0));
        VBox.setMargin(passField, new Insets(15, 0, 0, 0));
        VBox.setMargin(mobileField, new Insets(15, 0, 0, 0));
        VBox.setMargin(continueWithLabel, new Insets(40, 0, 0, 0));

        HBox hbox = new HBox(stackPane,mainLayout);
        HBox.setMargin(mainLayout, new Insets(0, 0, 0, 200));
        HBox.setMargin(loImageView, new Insets(0, 0, 0, 200));
        HBox.setMargin(backButton, new Insets(30, 0, 0, 30));

        return new Scene(hbox, 1920, 1080); // Adjust width and height as needed
    }

    // Method to handle signup action
    private void handleSignup(Stage primaryStage, String username, String username2,String mobilenum,String profession,String socialmedia,String password) {
        DataService dataService; // Local instance of DataService
        try {
            dataService = new DataService(); // Initialize DataService instance
            // Create a map to hold user data
            Map<String, Object> data = new HashMap<>();
            data.put("password", password);
            data.put("username", username);
            data.put("username2", username2);
            data.put("mobilenum", mobilenum);
            data.put("profession", profession);
            data.put("socialmedia", socialmedia);
            // Add user data to Firestore
            dataService.addData("users", username, data);
            System.out.println("User registered successfully");

            // Navigate back to the login scene
            loginController.showLoginScene();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}