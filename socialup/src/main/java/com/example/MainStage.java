package com.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainStage {
    private Stage stage;

    public MainStage(Stage stage) {
        this.stage = stage;
    }

    public void showMainStage() {
        StackPane root = new StackPane();

        Font.loadFont(getClass().getResourceAsStream("/fonts/manrope-extrabold.otf"), 14);

        Text text1 = new Text();
        text1.setStyle("-fx-font-family: 'Manrope ExtraBold'; -fx-font-size: 90px; -fx-fill: #FFFFFF;");
        addTypingTransition(text1, "Take your ideas to the");

        Text text2 = new Text();
        text2.setStyle("-fx-font-family: 'Manrope ExtraBold'; -fx-font-size: 90px; -fx-fill: #FFFFFF;");
        addTypingTransition(text2, "next level");

        Text text3 = new Text("At SocialUp, we provide a comprehensive suite of tools designed to enhance your social media presence,");
        text3.setStyle("-fx-font-family: 'Poppins';-fx-font-weight: medium; -fx-font-size: 16px; -fx-fill: #FFFFFF;");
      //  addTypingTransition(text3, "At SocialUp, we provide a comprehensive suite of tools designed to enhance your social media presence,");

        Text text4 = new Text("engage your audience, and drive meaningful results.");
        text4.setStyle("-fx-font-family: 'Poppins';-fx-font-weight: medium; -fx-font-size: 15px; -fx-fill: #FFFFFF;");
        //addTypingTransition(text4, "engage your audience, and drive meaningful results.");

        Image image1 = new Image(getClass().getResourceAsStream("/mainstage/Frame 320.png"));
        ImageView imageView1 = new ImageView(image1);

        Text text5 = new Text("Get Started");
        text5.setStyle("-fx-font-family: 'Manrope ExtraBold'; -fx-font-size: 24px; -fx-fill: #3C6BFF;");

        Button button = new Button();
        button.setGraphic(text5);
        button.setMaxWidth(268);
        button.setMaxHeight(72);
        button.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 100; -fx-border-color: transparent;");
        button.setOnAction(event -> openSecondStage());

        StackPane.setMargin(text1, new Insets(100, 0, 800, 0));
        StackPane.setMargin(text2, new Insets(100, 0, 550, 0));
        StackPane.setMargin(text3, new Insets(100, 0, 350, 0));
        StackPane.setMargin(text4, new Insets(100, 0, 300, 0));
        StackPane.setMargin(button, new Insets(100, 0, 150, 0));

        root.getChildren().addAll(imageView1, text1, text2, text3, text4, button);

        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.setTitle("SocialUp");
        stage.show();
    }

    private void addTypingTransition(Text text, String content) {
        final int[] index = {0};
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), event -> {
            if (index[0] < content.length()) {
                text.setText(content.substring(0, index[0] + 1));
                index[0]++;
            }
        }));
        timeline.setCycleCount(content.length());
        timeline.play();
    }

    private void openSecondStage() {
        SecondStage secondStage = new SecondStage(stage);
        secondStage.showSecondStage();
    }
}
