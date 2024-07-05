package com.example;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        SplashScreen splashScreen = new SplashScreen(primaryStage);
        splashScreen.showSplashScreen();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
