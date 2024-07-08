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

import com.example.dashboards.UserPage;
import com.example.firebaseConfig.DataService;
import com.example.SecondStage;

public class LoginController {

    private Stage primaryStage; 
    private static Scene loginScene; 
    private Scene userScene; 
    private DataService dataService; 
    public static String key; 

    
    public LoginController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        dataService = new DataService(); 
        initScenes(); 
    }

    
    private void initScenes() {
        initLoginScene(); 
    }

    
    public void initLoginScene() {
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
                handleLogin(userTextField.getText(), passField.getText()); 
                userTextField.clear(); 
                passField.clear(); 
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
                showSignupScene(); 
                userTextField.clear(); 
                passField.clear(); 
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

        Image loginImage = new Image("/login/login.png");
        ImageView loImageView = new ImageView(loginImage);

        Image loginImage2 = new Image("/Arrow-Left.png");
        ImageView loImageView2 = new ImageView(loginImage2);

        Button backButton = new Button();
        backButton.setGraphic(loImageView2);
        backButton.setOnAction(event -> {
            openSecondStage();
        });
        


        backButton.setStyle("-fx-background-color: transparent; -fx-padding: 0;");


        HBox hbox = new HBox(backButton, mainLayout, loImageView);
        HBox.setMargin(mainLayout, new Insets(0, 0, 0, 200));
        HBox.setMargin(loImageView, new Insets(0, 0, 0, 200));
        HBox.setMargin(backButton, new Insets(30, 0, 0, 30));


        loginScene = new Scene(hbox, 1920, 1080);
    }

    private void openSecondStage() {
        SecondStage secondStage = new SecondStage(primaryStage);
        secondStage.showSecondStage(); 
    }
    
   
    public static Scene getLoginScene() {
        return loginScene;
    }

   
    public void showLoginScene() {
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    
    private void handleLogin(String username, String password) {
        try {
         
            if (dataService.authenticateUser(username, password)) {
              
                key = username;
                showUserScene();
            } else {
             
                showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Login Error", "Error while logging in. Please try again later.");
        }
    }

 
    private void showUserScene() {
        UserPage userPage = new UserPage(primaryStage);
        userScene = userPage.getUserScene();
        primaryStage.setScene(userScene);
        primaryStage.setTitle("User Dashboard");
        primaryStage.show();
    }


    private void showSignupScene() {
        SecondStage secondStage = new SecondStage(primaryStage);
        secondStage.showSignup(); 
    }
    

  
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}
