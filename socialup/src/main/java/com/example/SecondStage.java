package com.example;

import com.example.controller.LoginController;
import com.example.controller.SignUpController;

import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

@SuppressWarnings("unused")
public class SecondStage {
    private Stage stage;
    private LoginController loginController;
    private SignUpController signUpController;

    public SecondStage(Stage stage) {
        this.stage = stage;
        this.loginController = new LoginController(stage); // Initialize LoginController
        this.signUpController = new SignUpController(loginController); // Initialize SignUpController with LoginController reference
    }

    public void showSecondStage() {
        StackPane root = new StackPane();

        Font.loadFont(getClass().getResourceAsStream("/fonts/manrope-extrabold.otf"), 14);

        Image splashImage = new Image(getClass().getResourceAsStream("/secondstage/secondstage.png"));
        ImageView splashImageView = new ImageView(splashImage);

        Text text1 = new Text("Transform Your ");
        text1.setStyle("-fx-font-family: 'Manrope ExtraBold'; -fx-font-size: 30px; -fx-fill: #092A93;");

        Text text2 = new Text("Social Media");
        text2.setStyle("-fx-font-family: 'Manrope ExtraBold'; -fx-font-size: 30px; -fx-fill: #FFCB56;");

        HBox hBox = new HBox(text1, text2);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(4);

        Text text3 = new Text("Presence with Cutting-Edge");
        text3.setStyle("-fx-font-family: 'Manrope ExtraBold'; -fx-font-size: 30px; -fx-fill: #092A93;");

        Text text4 = new Text("Strategies");
        text4.setStyle("-fx-font-family: 'Manrope ExtraBold'; -fx-font-size: 30px; -fx-fill: #092A93;");

        Button button1 = new Button("Login");
        button1.setStyle("-fx-background-color: #092A93;" +     
                        " -fx-background-radius: 10;" + 
                        "-fx-padding: 10 20; " + 
                        "-fx-text-fill: white;" +
                        "-fx-font-family: 'Poppins';-fx-font-weight: semibold; -fx-font-size: 20px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 20, 0, 0, 10);");
        button1.setPrefWidth(170); 
        button1.setOnAction(event -> openLogin()); // Fixed lambda expression

        Button button2 = new Button("Register");
        button2.setStyle("-fx-background-color: #FFFFFF;" +     
                        " -fx-background-radius: 10;" + 
                        "-fx-padding: 10 20; " + 
                        "-fx-text-fill: black;" +
                        "-fx-font-family: 'Poppins';-fx-font-weight: semibold; -fx-font-size: 20px;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 20, 0, 0, 10);");
        button2.setPrefWidth(170); 
        button2.setOnAction(event -> openRegister());

        HBox hBox1 = new HBox(button1, button2);
        hBox1.setSpacing(30);
        hBox1.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(splashImageView, hBox, text3, text4, hBox1);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(3); 
        VBox.setMargin(splashImageView, new Insets(50, 0, 0, 0));
        VBox.setMargin(hBox, new Insets(40, 0, 0, 0));
        VBox.setMargin(hBox1, new Insets(90, 0, 0, 0));

        Image iamge9 = new Image(getClass().getResourceAsStream("/abstract.png"));
        ImageView imageView9 = new ImageView(iamge9);
        StackPane.setAlignment(imageView9, Pos.BOTTOM_RIGHT);

        Image iamge10 = new Image(getClass().getResourceAsStream("/abstract3.png"));
        ImageView imageView10 = new ImageView(iamge10);
        StackPane.setAlignment(imageView10, Pos.TOP_LEFT);

        root.getChildren().addAll(imageView10, imageView9, vBox);

        // Initial positions (outside of the scene)
        imageView9.setTranslateX(1920);
        imageView10.setTranslateX(-1920);

        // Create TranslateTransition for imageView9
        TranslateTransition transition9 = new TranslateTransition(Duration.seconds(2), imageView9);
        transition9.setToX(0);

        // Create TranslateTransition for imageView10
        TranslateTransition transition10 = new TranslateTransition(Duration.seconds(2), imageView10);
        transition10.setToX(0);

        // Start the transitions
        transition9.play();
        transition10.play();

        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.setTitle("Second Screen");
        stage.show();
    }

    private void openRegister() {
        Scene signupScene = signUpController.createSignupScene(stage);
        stage.setScene(signupScene);
        stage.setTitle("Signup");
    }

    private void openLogin() {
        loginController.showLoginScene();
    }

    public Scene getScene() {
        return stage.getScene();
    }

    public void showSecondStage(Stage primaryStage) {
        showSecondStage();
    }

    public void show() {
        showSecondStage();
    }

    public void showSignup() {
        Scene signupScene = signUpController.createSignupScene(stage);
        stage.setScene(signupScene);
        stage.setTitle("Signup");
    }
}
