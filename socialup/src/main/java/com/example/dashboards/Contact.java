package com.example.dashboards;

import java.net.URI;

import com.example.SecondStage;
import com.example.controller.LoginController;

import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import java.awt.Desktop;
import java.net.URI;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("unused")
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
         Image india = new Image("/images/contact.png");
        ImageView india_v = new ImageView(india);
        // Create the Rectangle
        Rectangle rect = new Rectangle(350, 616);
        rect.setFill(Color.WHITE); 
        rect.setArcWidth(35); // Set the arc width for rounded corners
        rect.setArcHeight(35);
        rect.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 20, 0, 0, 10);");

        // Create the Text
        Text nameText = new Text("First & Last Name");
        nameText.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: bold; -fx-font-size: 18px; -fx-fill: #092A93;");
        nameText.setTranslateX(910); // Move right by 230 pixels
        nameText.setTranslateY(320); // Move down by 190 pixels
        
        TextField userTextField = new TextField();
        userTextField.setMaxWidth(300);
        userTextField.setTranslateX(910); // Move right by 230 pixels
        userTextField.setTranslateY(350);
        userTextField.setPromptText("i.e. Harshad Anbhule");
        userTextField.setPrefHeight(64);
        userTextField.setStyle("-fx-background-radius: 10; -fx-background-color: #EBF0FA; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3); -fx-prompt-text-fill: #9498A3;");
        userTextField.setOnMouseClicked(event -> {
            userTextField.setStyle("-fx-background-radius: 10; -fx-background-color: #EBF0FA; -fx-border-color: #092A93; -fx-border-width: 2; -fx-border-radius: 10; -fx-prompt-text-fill: #9498A3;");
        });
        userTextField.setOnMouseExited(event -> {
            userTextField.setStyle("-fx-background-radius: 10; -fx-background-color: #EBF0FA; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3); -fx-prompt-text-fill: #9498A3;");
        });

        
        Text nameText_2 = new Text("Email");
        nameText_2.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: bold; -fx-font-size: 18px; -fx-fill: #092A93;");
        nameText_2.setTranslateX(910); // Move right by 230 pixels
        nameText_2.setTranslateY(425);

        TextField userTextField_2= new TextField();
        userTextField_2.setMaxWidth(300);
        userTextField_2.setTranslateX(910); // Move right by 230 pixels
        userTextField_2.setTranslateY(455);
        userTextField_2.setPromptText("i.e. harshad@mail.com");
        userTextField_2.setPrefHeight(64);
        userTextField_2.setStyle("-fx-background-radius: 10; -fx-background-color: #EBF0FA; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3); -fx-prompt-text-fill: #9498A3;");
        userTextField_2.setOnMouseClicked(event -> {
            userTextField_2.setStyle("-fx-background-radius: 10; -fx-background-color: #EBF0FA; -fx-border-color: #092A93; -fx-border-width: 2; -fx-border-radius: 10; -fx-prompt-text-fill: #9498A3;");
        });
        userTextField_2.setOnMouseExited(event -> {
            userTextField_2.setStyle("-fx-background-radius: 10; -fx-background-color: #EBF0FA; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3); -fx-prompt-text-fill: #9498A3;");
        });


        Text nameText_3 = new Text("Subject");
        nameText_3.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: bold; -fx-font-size: 18px; -fx-fill: #092A93;");
        nameText_3.setTranslateX(910); // Move right by 230 pixels
        nameText_3.setTranslateY(530);

        TextField userTextField_3= new TextField();
        userTextField_3.setMaxWidth(300);
        userTextField_3.setTranslateX(910); // Move right by 230 pixels
        userTextField_3.setTranslateY(560);
        userTextField_3.setPromptText("i.e. I need help");
        userTextField_3.setPrefHeight(64);
        userTextField_3.setStyle("-fx-background-radius: 10; -fx-background-color: #EBF0FA; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3); -fx-prompt-text-fill: #9498A3;");
        userTextField_3.setOnMouseClicked(event -> {
            userTextField_3.setStyle("-fx-background-radius: 10; -fx-background-color: #EBF0FA; -fx-border-color: #092A93; -fx-border-width: 2; -fx-border-radius: 10; -fx-prompt-text-fill: #9498A3;");
        });
        userTextField_3.setOnMouseExited(event -> {
            userTextField_3.setStyle("-fx-background-radius: 10; -fx-background-color: #EBF0FA; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3); -fx-prompt-text-fill: #9498A3;");
        });


        Text nameText_4 = new Text("Message");
        nameText_4.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: bold; -fx-font-size: 18px; -fx-fill: #092A93;");
        nameText_4.setTranslateX(910); // Move right by 230 pixels
        nameText_4.setTranslateY(635);

        TextField userTextField_4= new TextField();
        userTextField_4.setMaxWidth(300);
        userTextField_4.setTranslateX(910); // Move right by 230 pixels
        userTextField_4.setTranslateY(665);
        userTextField_4.setPromptText("Type your message");
        userTextField_4.setPrefHeight(64);
        userTextField_4.setStyle("-fx-background-radius: 10; -fx-background-color: #EBF0FA; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3); -fx-prompt-text-fill: #9498A3;");
        userTextField_4.setOnMouseClicked(event -> {
            userTextField_4.setStyle("-fx-background-radius: 10; -fx-background-color: #EBF0FA; -fx-border-color: #092A93; -fx-border-width: 2; -fx-border-radius: 10; -fx-prompt-text-fill: #9498A3;");
        });
        userTextField_4.setOnMouseExited(event -> {
            userTextField_4.setStyle("-fx-background-radius: 10; -fx-background-color: #EBF0FA; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.15), 5, 0, 0, 3); -fx-prompt-text-fill: #9498A3;");
        });


        Button send = new Button("Send");
        send.setTranslateX(910);
        send.setTranslateY(800);
        send.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; -fx-text-fill: WHITE; " +
            "-fx-background-color: #092A93; -fx-cursor: hand; " +
             "-fx-background-radius:100;-fx-pref-height: 72px;-fx-pref-width: 309px;");
        send.setOnMouseEntered(event -> {
            send.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; -fx-text-fill: WHITE; " +
            "-fx-background-color: #5c75c4; -fx-cursor: hand; " +
             "-fx-background-radius:100;-fx-pref-height: 72px;-fx-pref-width: 309px;"
            );
        });
        send.setOnMouseClicked(event -> {
            userTextField.clear();
            userTextField_2.clear();
            userTextField_3.clear();
            userTextField_4.clear();
        });
        
        send.setOnMouseExited(event -> {
            send.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; -fx-text-fill: WHITE; " +
            "-fx-background-color: #092A93; -fx-cursor: hand; " +
             "-fx-background-radius:100;-fx-pref-height: 72px;-fx-pref-width: 309px;"
            );
        });

        Image icon1= new Image("/images/Icon (1).png");
        ImageView icon1_v = new ImageView(icon1);
        icon1_v.setTranslateX(1560);
        icon1_v.setTranslateY(298);

        Hyperlink our_mail = new Hyperlink("support@socialup.com\ncontact@socialup.com");
        our_mail.setTranslateX(1600);
        our_mail.setTranslateY(291);
        our_mail.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 19px; -fx-font-weight: REGULAR;-fx-text-fill: #161C2D;");

        Image icon2= new Image("/images/Icon.png");
        ImageView icon2_v = new ImageView(icon2);
        icon2_v.setTranslateX(1565);
        icon2_v.setTranslateY(376);


        Hyperlink our_location = new Hyperlink("Sinhagad campus ,\n"+ //
                        "Vadgaon, Pune,Maharashtra,\nIndia 411041");
        our_location.setTranslateX(1600);
        our_location.setTranslateY(367);
        our_location.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 19px; -fx-font-weight: REGULAR;-fx-text-fill: #161C2D;");


        Hyperlink our_insta = new Hyperlink("https://www.instagram.com/socialup80");
        our_insta.setTranslateX(1600);
        our_insta.setTranslateY(455);
        our_insta.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 19px; -fx-font-weight: REGULAR;-fx-text-fill: #161C2D;");
        our_insta.setOnAction(event -> {
            String url = our_insta.getText();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error opening hyperlink: " + e.getMessage());
                }
            }
        });

        // Set the alignment and translation for the text
        StackPane.setAlignment(nameText, Pos.TOP_LEFT); // Align to the top left
        StackPane.setAlignment(nameText_2, Pos.TOP_LEFT);
        StackPane.setAlignment(nameText_3, Pos.TOP_LEFT);
        StackPane.setAlignment(nameText_4, Pos.TOP_LEFT);
        StackPane.setAlignment(send, Pos.TOP_LEFT);
        StackPane.setAlignment(userTextField, Pos.TOP_LEFT);
        StackPane.setAlignment(userTextField_2, Pos.TOP_LEFT);
        StackPane.setAlignment(userTextField_3, Pos.TOP_LEFT);
        StackPane.setAlignment(userTextField_4, Pos.TOP_LEFT);
        StackPane.setAlignment(icon1_v, Pos.TOP_LEFT);
        StackPane.setAlignment(icon2_v, Pos.TOP_LEFT);
        StackPane.setAlignment(our_mail, Pos.TOP_LEFT);
        StackPane.setAlignment(our_location, Pos.TOP_LEFT);
        StackPane.setAlignment(our_insta, Pos.TOP_LEFT);
        // Create a StackPane to overlay the Rectangle and ImageView
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(india_v, rect, nameText, userTextField, nameText_2,userTextField_2, nameText_3,userTextField_3, nameText_4,userTextField_4, send,icon1_v,icon2_v,our_mail,our_location,our_insta);
        StackPane.setMargin(india_v, new Insets(120, 0, 0, 100));
        StackPane.setMargin(rect, new Insets(141, 0, 0, 200));
        



        vb = new VBox(hbox1,stackPane);
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
        Profile profile = new Profile(stage,LoginController.key);
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