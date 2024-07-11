package com.example.dashboards;

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

import com.example.controller.LoginController;

@SuppressWarnings("unused")
public class UserPage {
    private VBox vb;
    private Stage primaryStage; // The primary stage for displaying scenes
    private Scene userScene; // Scene for the user dashboard

    // Constructor to initialize the UserPage with the primary stage
    public UserPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initUserScene(); // Initialize the user scene
    }

    // Method to initialize the user scene
    void initUserScene() {
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

        Label aboutLabel = new Label("About Us");
        aboutLabel.setTextFill(Color.web("#092A93"));
        aboutLabel.setFont(Font.font(16));
        Button aboutButton = new Button();
        aboutButton.setGraphic(aboutLabel);
        aboutButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        aboutButton.setOnAction(event -> openNextPage());
        

        Label serviceLabel = new Label("Our Service");
        serviceLabel.setTextFill(Color.web("#092A93"));
        serviceLabel.setFont(Font.font(16));
        Button serviceButton = new Button();
        serviceButton.setGraphic(serviceLabel);
        serviceButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        serviceButton.setOnAction(event -> openService());

        Label newsLabel = new Label("News");
        newsLabel.setTextFill(Color.web("#092A93"));
        newsLabel.setFont(Font.font(16));
        Button newsButton = new Button();
        newsButton.setGraphic(newsLabel);
        newsButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        newsButton.setOnAction(event -> openNews());

        Label contactLabel = new Label("Contact us");
        contactLabel.setTextFill(Color.web("#092A93"));
        contactLabel.setFont(Font.font(16));
        Button contactButton = new Button();
        contactButton.setGraphic(contactLabel);
        contactButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        contactButton.setOnAction(event -> openContact());

        Image cartImage = new Image(getClass().getResource("/Home/cart.png").toExternalForm());
        ImageView cartImageView = new ImageView(cartImage);
        Button cartButton = new Button();
        cartButton.setGraphic(cartImageView);
        cartButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        cartButton.setOnAction(event -> openCart());

        Image profileImage = new Image(getClass().getResource("/Home/profile.png").toExternalForm());
        ImageView profileImageView = new ImageView(profileImage);
        Button profileButton = new Button();
        profileButton.setGraphic(profileImageView);
        profileButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        profileButton.setOnAction(event -> openProfile());

        Image logoutImage = new Image(getClass().getResource("/Home/logout.png").toExternalForm());
        ImageView logoutImageView = new ImageView(logoutImage);
        Button logoutButton = new Button();
        logoutButton.setGraphic(logoutImageView);
        logoutButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        logoutButton.setOnAction(event -> handleLogout());

        HBox hbox1 = new HBox(text, homeButton, aboutButton, serviceButton, newsButton, contactButton,profileButton,logoutButton);
        hbox1.setLayoutX(0);
        hbox1.setLayoutY(0);
        HBox.setMargin(text, new Insets(10,0,0,50));
        HBox.setMargin(homeButton, new Insets(20,0,0,820));
        HBox.setMargin(aboutButton, new Insets(20,0,0,50));
        HBox.setMargin(serviceButton, new Insets(20,0,0,50));
        HBox.setMargin(newsButton, new Insets(20,0,0,50));
        HBox.setMargin(contactButton, new Insets(20,0,0,50));
       // HBox.setMargin(cartButton, new Insets(10,0,0,50));
        HBox.setMargin(profileButton, new Insets(10,0,0,50));
        HBox.setMargin(logoutButton, new Insets(15,0,0,50));

        Button button = new Button("Our Services");
        button.setFont(Font.font("Poppins", FontWeight.BOLD, 24));
        button.setTextFill(Color.WHITE);
        button.setStyle("-fx-background-color: #092A93; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3);");
        button.setPrefSize(296.63, 79.55);
        button.setOnAction(event -> openService());

        Image image1 = new Image(getClass().getResource("/Home/Group 14582613-1.png").toExternalForm());
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(1920);
        imageView1.setFitHeight(1080);
        imageView1.setPreserveRatio(true);

        Image image2 = new Image(getClass().getResource("/Home/Home1.png").toExternalForm());
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(1920);
        imageView2.setFitHeight(1080);
        imageView2.setPreserveRatio(true);

        StackPane stackPane = new StackPane(imageView2, hbox1,button);
        StackPane.setMargin(button, new Insets(600,1230,0,0));

        vb = new VBox(stackPane, imageView1);
        vb.setStyle("-fx-background-color: #FFFFF;");

        vb.setOnScroll(event -> handleScroll(event));
        userScene = new Scene(vb, 1920, 1080);
    }

    // Method to get the user scene
    public Scene getUserScene() {
        return userScene;
    }

    // Method to handle logout action
    private void handleLogout() {
        LoginController.key = null; // Clear the logged-in username
        primaryStage.setScene(LoginController.getLoginScene()); // Show the login scene
        primaryStage.setTitle("Login");
    }

    // Method to open the next page or stage
    private void openNextPage() {
        About nextPage = new About(primaryStage);
        Scene nextScene = nextPage.createScene();
        primaryStage.setScene(nextScene);
        primaryStage.setTitle("Next Page");
    }
    

    private void openService() {
       
        Service nextPage = new Service(primaryStage);
        Scene nextScene = nextPage.createScene();
        primaryStage.setScene(nextScene);
        primaryStage.setTitle("Service");
    }

    private void openCart() {
        Cart nextPage = new Cart(primaryStage);
        Scene nextScene = nextPage.createScene();
        primaryStage.setScene(nextScene);
        primaryStage.setTitle("Cart");
    }

    private void openContact() {
        Contact nextPage = new Contact(primaryStage);
        Scene nextScene = nextPage.createScene();
        primaryStage.setScene(nextScene);
        primaryStage.setTitle("Contact");
    }
    private void openNews() {
        News nextPage = new News(primaryStage, null);
        Scene nextScene = nextPage.createScene();
        primaryStage.setScene(nextScene);
        primaryStage.setTitle("News");
    }

    private void openProfile() {
        Profile nextPage = new Profile(primaryStage,LoginController.key);
        Scene nextScene = nextPage.createScene();
        primaryStage.setScene(nextScene);
        primaryStage.setTitle("Profile");
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