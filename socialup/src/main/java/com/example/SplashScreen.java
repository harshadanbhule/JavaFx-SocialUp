package com.example;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashScreen {
    private Stage stage;

    public SplashScreen(Stage stage) {
        this.stage = stage;
    }

    public void showSplashScreen() {
        Group root = new Group();

        Image splashImage = new Image(getClass().getResourceAsStream("/Logo.png"));
        ImageView splashImageView = new ImageView(splashImage);
        splashImageView.setLayoutX(855.68);
        splashImageView.setLayoutY(387.68);
        splashImageView.setOpacity(0); // Initially set to transparent

        Image Image1 = new Image(getClass().getResourceAsStream("/Rock.png"));
        ImageView vImage1 = new ImageView(Image1);
        vImage1.setLayoutX(0);
        vImage1.setLayoutY(0);

        Image Image2 = new Image(getClass().getResourceAsStream("/Rock1.png"));
        ImageView vImage2 = new ImageView(Image2);
        vImage2.setLayoutX(1558);
        vImage2.setLayoutY(0);

        Image Image3 = new Image(getClass().getResourceAsStream("/Rock2.png"));
        ImageView vImage3 = new ImageView(Image3);
        vImage3.setLayoutX(1574.31);
        vImage3.setLayoutY(300);

        Image Image4 = new Image(getClass().getResourceAsStream("/Rock3.png"));
        ImageView vImage4 = new ImageView(Image4);
        vImage4.setLayoutX(167);
        vImage4.setLayoutY(850);

        Text text = new Text("SocialUP");
        text.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: bold; -fx-font-size: 24px;-fx-fill: #2A4ECA;");
        text.setLayoutX(930);
        text.setLayoutY(670);
        text.setOpacity(0); 

        root.getChildren().addAll(splashImageView, vImage1, vImage2, vImage3, vImage4, text);

        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.setTitle("SocialUp");
        stage.show();

       
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(4), splashImageView);
        fadeIn.setFromValue(0); 
        fadeIn.setToValue(1);
        fadeIn.play();

       
        FadeTransition textFadeIn = new FadeTransition(Duration.seconds(4), text);
        textFadeIn.setFromValue(0); 
        textFadeIn.setToValue(1); 
        textFadeIn.play();

        new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                MainStage mainStage = new MainStage(stage);
                mainStage.showMainStage();
            });
        }).start();
    }
}
