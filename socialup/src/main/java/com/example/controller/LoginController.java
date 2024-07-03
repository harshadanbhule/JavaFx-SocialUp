package com.example.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

import java.util.concurrent.ExecutionException;

import com.example.SecondStage;
import com.example.dashboards.UserPage;
import com.example.firebaseConfig.DataService;

public class LoginController {

    private Stage primaryStage; // The primary stage for displaying scenes
    private Scene loginScene; // Scene for the login page
    private Scene userScene; // Scene for the user dashboard
    private DataService dataService; // Service to interact with Firestore
    public static String key; // Static key to store the logged-in username

    // Constructor to initialize the LoginController with the primary stage
    public LoginController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        dataService = new DataService(); // Initialize DataService instance
        initScenes(); // Initialize scenes
    }

    // Method to initialize all scenes
    private void initScenes() {
        initLoginScene(); // Initialize the login scene
    }

    // Method to initialize the login scene
    private void initLoginScene() {
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

        Button loginButton = new Button("Sign in");
        loginButton.setFont(Font.font("Poppins", FontWeight.BOLD, 20));
        loginButton.setTextFill(Color.WHITE);
        loginButton.setStyle("-fx-background-color: #092A93; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3);");
        loginButton.setPrefSize(320, 60);
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleLogin(userTextField.getText(), passField.getText()); // Handle login
                userTextField.clear(); // Clear username field
                passField.clear(); // Clear password field
            }
        });

        Label loginLabel = new Label("Login here");
        loginLabel.setFont(Font.font("Poppins", FontWeight.BOLD, 30));
        loginLabel.setTextFill(Color.web("#092A93"));

        Label welcomeLabel = new Label("Welcome back you’ve \n      been missed!");
        welcomeLabel.setFont(Font.font("Poppins", FontWeight.BOLD, 20));

        Label forgotPasswordLabel = new Label("Forgot your password?");
        forgotPasswordLabel.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
        forgotPasswordLabel.setTextFill(Color.web("#092A93"));

        Label createAccountLabel = new Label("Create new account");
        createAccountLabel.setFont(Font.font("Poppins", FontWeight.BOLD, 14));
        createAccountLabel.setTextFill(Color.web("#494949"));
        Button lButton = new Button();
        lButton.setGraphic(createAccountLabel);
        lButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        lButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showSignupScene(); // Show signup scene
                userTextField.clear(); // Clear username field
                passField.clear(); // Clear password field
            }
        });

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

        VBox mainLayout = new VBox(20);
        mainLayout.setStyle("-fx-padding: 0 35 60 35;");
        mainLayout.getChildren().addAll(
                loginLabel,
                welcomeLabel,
                userTextField,
                passField,
                forgotPasswordLabel,
                loginButton,
                lButton,
                continueWithLabel,
                socialButtons
        );
        mainLayout.setAlignment(Pos.CENTER);
        VBox.setMargin(welcomeLabel, new Insets(30, 0, 0, 0));
        VBox.setMargin(userTextField, new Insets(30, 0, 0, 0));
        VBox.setMargin(passField, new Insets(15, 0, 0, 0));
        VBox.setMargin(continueWithLabel, new Insets(40, 0, 0, 0));

        Image loginImage=new Image("/login/login.png");
        ImageView loImageView=new ImageView(loginImage);

        Image loginImage2 = new Image("/Arrow-Left.png");
        ImageView loImageView2 = new ImageView(loginImage2);

        Button backButton = new Button();
        backButton.setGraphic(loImageView2);
        backButton.setOnAction(event -> openSecondStage());


        backButton.setStyle("-fx-background-color: transparent; -fx-padding: 0;");


        HBox hbox = new HBox(backButton,mainLayout,loImageView);
        HBox.setMargin(mainLayout, new Insets(0, 0, 0, 200));
        HBox.setMargin(loImageView, new Insets(0, 0, 0, 200));
        HBox.setMargin(backButton, new Insets(30, 0, 0, 30));


        loginScene = new Scene(hbox, 1920, 1080);
    }

    // Method to initialize the user scene
    private void initUserScene() {
        UserPage userPage = new UserPage(dataService); // Create UserPage instance
        userScene = new Scene(userPage.createUserScene(this::handleLogout), 1920, 1080); // Create user scene
    }

    // Method to get the login scene
    public Scene getLoginScene() {
        return loginScene;
    }

    // Method to show the login scene
    public void showLoginScene() {
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    // Method to handle login action
    private void handleLogin(String username, String password) {
        try {
            // Authenticate user
            if (dataService.authenticateUser(username, password)) {
                key = username; // Store the username in the static key
                initUserScene(); // Initialize user scene
                primaryStage.setScene(userScene); // Show user scene
                primaryStage.setTitle("User Dashboard");
            } else {
                showAlert("Invalid credentials", "The email or password you entered is incorrect.");
                key = null;
            }
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    // Method to show the signup scene
    private void showSignupScene() {
        SignUpController signupController = new SignUpController(this); // Create SignupController instance
        Scene signupScene = signupController.createSignupScene(primaryStage); // Create signup scene
        primaryStage.setScene(signupScene);
        primaryStage.setTitle("Signup");
        primaryStage.show();
    }

    // Method to handle logout action
    private void handleLogout() {
        primaryStage.setScene(loginScene); // Show login scene
        primaryStage.setTitle("Login");
    }

    // Method to open the second stage or navigate to it
    // Method to open the second stage or navigate to it
private void openSecondStage() {
    SecondStage secondStage = new SecondStage(primaryStage); // Pass primaryStage to SecondStage constructor
    secondStage.showSecondStage(); // Call the method to show the SecondStage
}

private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}

}
