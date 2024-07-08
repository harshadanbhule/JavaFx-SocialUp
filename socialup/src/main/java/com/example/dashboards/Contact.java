package com.example.dashboards;

import com.example.SecondStage;
import com.example.controller.LoginController;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Contact {

    private Stage stage;
    VBox vb;

    public Contact(Stage stage) {
        this.stage = stage;
    }

    public Scene createScene() {
       Font.loadFont(getClass().getResourceAsStream("/fonts/POPPINS-SEMIBOLD.TTF"), 14);
        Font.loadFont(getClass().getResourceAsStream("/fonts/manrope-extrabold.otf"), 14);

        Label text = new Label("SocialUP");
        text.setTextFill(Color.web("#2A4ECA"));
        text.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: bold; -fx-font-size: 32px; -fx-fill: #2A4ECA;");

        Label homLabel = new Label("Home");
        homLabel.setTextFill(Color.web("#092A93"));
        homLabel.setFont(Font.font(16));
        Button homeButton = new Button();
        homeButton.setGraphic(homLabel);
        homeButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        homeButton.setOnAction(event->backToUserPage());

        Label aboutLabel = new Label("About Us");
        aboutLabel.setTextFill(Color.web("#092A93"));
        aboutLabel.setFont(Font.font(16));
        Button aboutButton = new Button();
        aboutButton.setGraphic(aboutLabel);
        aboutButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        aboutButton.setOnAction(event->openAbout());
        

        Label serviceLabel = new Label("Our Service");
        serviceLabel.setTextFill(Color.web("#092A93"));
        serviceLabel.setFont(Font.font(16));
        Button serviceButton = new Button();
        serviceButton.setGraphic(serviceLabel);
        serviceButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        serviceButton.setOnAction(event->openService());

        Label newsLabel = new Label("News");
        newsLabel.setTextFill(Color.web("#092A93"));
        newsLabel.setFont(Font.font(16));
        Button newsButton = new Button();
        newsButton.setGraphic(newsLabel);
        newsButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        newsButton.setOnAction(event->openNews());

        Label contactLabel = new Label("Contact us");
        contactLabel.setTextFill(Color.web("#092A93"));
        contactLabel.setFont(Font.font(16));
        Button contactButton = new Button();
        contactButton.setGraphic(contactLabel);
        contactButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");

        Image cartImage = new Image(getClass().getResource("/Home/cart.png").toExternalForm());
        ImageView cartImageView = new ImageView(cartImage);
        Button cartButton = new Button();
        cartButton.setGraphic(cartImageView);
        cartButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        cartButton.setOnAction(event->openCart());

        Image profileImage = new Image(getClass().getResource("/Home/profile.png").toExternalForm());
        ImageView profileImageView = new ImageView(profileImage);
        Button profileButton = new Button();
        profileButton.setGraphic(profileImageView);
        profileButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        profileButton.setOnAction(event->openProfile());

        Image logoutImage = new Image(getClass().getResource("/Home/logout.png").toExternalForm());
        ImageView logoutImageView = new ImageView(logoutImage);
        Button logoutButton = new Button();
        logoutButton.setGraphic(logoutImageView);
        logoutButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        logoutButton.setOnAction(event->handleLogout());

        HBox hbox1 = new HBox(text, homeButton, aboutButton, serviceButton, newsButton, contactButton, cartButton,profileButton,logoutButton);
        hbox1.setLayoutX(0);
        hbox1.setLayoutY(0);
        HBox.setMargin(text, new Insets(10,0,0,50));
        HBox.setMargin(homeButton, new Insets(20,0,0,670));
        HBox.setMargin(aboutButton, new Insets(20,0,0,50));
        HBox.setMargin(serviceButton, new Insets(20,0,0,50));
        HBox.setMargin(newsButton, new Insets(20,0,0,50));
        HBox.setMargin(contactButton, new Insets(20,0,0,50));
        HBox.setMargin(cartButton, new Insets(10,0,0,50));
        HBox.setMargin(profileButton, new Insets(10,0,0,50));
        HBox.setMargin(logoutButton, new Insets(15,0,0,50));



        vb = new VBox(hbox1);
        vb.setStyle("-fx-fill: #E7E9ED;");

        vb.setOnScroll(event -> handleScroll(event));

        return new Scene(vb, 1920, 1080);
    }

    private void backToUserPage() {
        UserPage userPage = new UserPage(stage);
        userPage.initUserScene();
        stage.setScene(userPage.getUserScene());
        stage.setTitle("User Dashboard");
    }

    private void openCart() {
        Cart cart = new Cart(stage);
        stage.setScene(cart.createScene());
        stage.setTitle("Cart");
    }

    private void openAbout() {
        About cart = new About(stage);
        stage.setScene(cart.createScene());
        stage.setTitle("Service");
    }

    private void openProfile() {
        Profile profile = new Profile(stage);
        stage.setScene(profile.createScene());
        stage.setTitle("Profile");
    }
    private void openService() {
        Service cart = new Service(stage);
        stage.setScene(cart.createScene());
        stage.setTitle("Service");
    }

    private void openNews() {
        News cart = new News(stage, null);
        stage.setScene(cart.createScene());
        stage.setTitle("News");
    }
    private void handleLogout() {
        LoginController loginController = new LoginController(stage);
        loginController.showLoginScene();
    }

     private void handleScroll(ScrollEvent event) {
        double deltaY = event.getDeltaY();
        double newTranslateY = vb.getTranslateY() + deltaY;
        double contentHeight = vb.getBoundsInParent().getHeight();

        if (newTranslateY > 0) {
            newTranslateY = 0;
        } else if (newTranslateY < -(contentHeight - vb.getHeight())) {
            newTranslateY = -(contentHeight - vb.getHeight());
        }

        vb.setTranslateY(newTranslateY);
    }
}