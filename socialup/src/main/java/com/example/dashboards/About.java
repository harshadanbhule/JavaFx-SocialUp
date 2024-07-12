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
import javafx.scene.text.Text;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class About {

    private Stage stage;
    VBox vb;

    public About(Stage stage) {
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
        contactButton.setOnAction(event -> openContact());

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


         Text meet = new Text("Meet Our Team");
        meet.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 48px; -fx-font-weight: BOLD;-fx-text-fill: BLACK;");
        meet.setTranslateX(820);
        meet.setTranslateY(157);

        Text txt2 = new Text("Get to Know the Team Driving SocialUp Forward");
        txt2.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 19px; -fx-font-weight: REGULAR;-fx-text-fill: #161C2D;");
        txt2.setTranslateX(790);
        txt2.setTranslateY(240);

        // Create the first person image and name
        Rectangle person1 = new Rectangle();
        person1.setWidth(267);
        person1.setHeight(356);
        person1.setArcWidth(35);
        person1.setArcHeight(35);

        Image person1_Image = new Image("/profile/harshad.jpg");
        ImageView person1_Image_v = new ImageView(person1_Image);
        person1_Image_v.setFitWidth(267);
        person1_Image_v.setFitHeight(356);
        person1_Image_v.setClip(person1);

        Text per1_name = new Text("Harshad Anbhule");
        per1_name.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 21px; -fx-font-weight: BOLD;-fx-text-fill: BLACK;");
        per1_name.setFill(Color.web("#161C2D"));
        Text per1_post = new Text("Chief Executive Officer");
        per1_post.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 17px; -fx-font-weight: REGULAR;-fx-text-fill: #161C2D;");
        per1_post.setFill(Color.web("#161C2D"));

        VBox person1_VBox = new VBox(10); // Vertical box for person1 image and name
        person1_VBox.setAlignment(Pos.CENTER);
        person1_VBox.getChildren().addAll(person1_Image_v, per1_name, per1_post);

        // Create the second person image and name
        Rectangle person2 = new Rectangle();
        person2.setWidth(267);
        person2.setHeight(356);
        person2.setArcWidth(35);
        person2.setArcHeight(35);

        Image person2_Image = new Image("/profile/shahuraj.jpg");
        ImageView person2_Image_v = new ImageView(person2_Image);
        person2_Image_v.setFitWidth(267);
        person2_Image_v.setFitHeight(356);
        person2_Image_v.setClip(person2);

        Text per2_name = new Text("Shahuraj Bhoite");
        per2_name.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 21px; -fx-font-weight: BOLD;-fx-text-fill: BLACK;");
        per2_name.setFill(Color.web("#161C2D"));
        Text per2_post = new Text("Chief Operating Officer");
        per2_post.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 17px; -fx-font-weight: REGULAR;-fx-text-fill: #161C2D;");
        per2_post.setFill(Color.web("#161C2D"));

        VBox person2_VBox = new VBox(10); // Vertical box for person2 image and name
        person2_VBox.setAlignment(Pos.CENTER);
        person2_VBox.getChildren().addAll(person2_Image_v, per2_name, per2_post);

        // Create the third person image and name
        Rectangle person3 = new Rectangle();
        person3.setWidth(267);
        person3.setHeight(356);
        person3.setArcWidth(35);
        person3.setArcHeight(35);

        Image person3_Image = new Image("/profile/anuj.jpg");
        ImageView person3_Image_v = new ImageView(person3_Image);
        person3_Image_v.setFitWidth(267);
        person3_Image_v.setFitHeight(356);
        person3_Image_v.setClip(person3);

        Text per3_name = new Text("Anuj Wawre");
        per3_name.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 21px; -fx-font-weight: BOLD;-fx-text-fill: BLACK;");
        Text per3_post = new Text("Chief Technology Officer");
        per3_name.setFill(Color.web("#161C2D"));
        per3_post.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 17px; -fx-font-weight: REGULAR;-fx-text-fill: #161C2D;");
        per3_post.setFill(Color.web("#161C2D"));

        VBox person3_VBox = new VBox(10); // Vertical box for person3 image and name
        person3_VBox.setAlignment(Pos.CENTER);
        person3_VBox.getChildren().addAll(person3_Image_v, per3_name, per3_post);

        // Create the fourth person image and name
        Rectangle person4 = new Rectangle();
        person4.setWidth(267);
        person4.setHeight(356);
        person4.setArcWidth(35);
        person4.setArcHeight(35);

        Image person4_Image = new Image("/profile/shri.jpg");
        ImageView person4_Image_v = new ImageView(person4_Image);
        person4_Image_v.setFitWidth(267);
        person4_Image_v.setFitHeight(356);
        person4_Image_v.setClip(person4);

        Text per4_name = new Text("Shrivesh Nagrale");
        per4_name.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 21px; -fx-font-weight: BOLD;-fx-text-fill: BLACK;");
        per4_name.setFill(Color.web("#161C2D"));
        Text per4_post = new Text("chief financial officer");
        per4_post.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 17px; -fx-font-weight: REGULAR;-fx-text-fill: #161C2D;");
        per4_post.setFill(Color.web("#161C2D"));

        VBox person4_VBox = new VBox(10); // Vertical box for person4 image and name
        person4_VBox.setAlignment(Pos.CENTER);
        person4_VBox.getChildren().addAll(person4_Image_v, per4_name, per4_post);

        // Add all person VBoxes to the HBox
        HBox us_box = new HBox(30);
        us_box.setPrefSize(1158, 10);
        us_box.setMinSize(600, 10);
        us_box.setMaxSize(1158, 452);
        us_box.setAlignment(Pos.TOP_LEFT);
        us_box.getChildren().addAll(person1_VBox, person2_VBox, person3_VBox, person4_VBox);

        Text apply_1 = new Text("Interested to join\nour team?");
        apply_1.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD;-fx-text-fill: #161C2D;");

        // Create the apply_now button with styled text
        Text applyText = new Text("Apply Now");
        applyText.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 21px; -fx-font-weight: BOLD; -fx-fill: #473BF0;");

        Button apply_now = new Button();
        apply_now.setGraphic(applyText);
        apply_now.setMaxWidth(130); 
        apply_now.setStyle(
            "-fx-background-color: transparent; " +
            "-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; " +
            "-fx-text-fill: #473BF0; " +
            "-fx-cursor: hand; " +
            "-fx-background-radius: 100; " +
            "-fx-pref-height: 72px; -fx-pref-width: 309px;"
        );

        apply_now.setOnMouseEntered(event -> {
            apply_now.setStyle(
                "-fx-background-color: transparent;"+"-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; " +
                "-fx-cursor: hand; " +
                "-fx-background-radius: 100; " +
                "-fx-pref-height: 72px; -fx-pref-width: 309px;"
            );
        });

        apply_now.setOnMouseExited(event -> {
            apply_now.setStyle(
                "-fx-background-color: transparent; " +
                "-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD;" +
                "-fx-cursor: hand; " +
                "-fx-background-radius: 100; " +
                "-fx-pref-height: 72px; -fx-pref-width: 309px;"
            );
        });
        apply_now.setTranslateX(0);
        apply_now.setTranslateY(50);
        VBox applyBox = new VBox(2, apply_1, apply_now);
        applyBox.setAlignment(Pos.CENTER_LEFT);
        applyBox.setTranslateX(790);
        applyBox.setTranslateY(45);

        StackPane.setAlignment(meet, Pos.TOP_LEFT);
        StackPane.setAlignment(txt2, Pos.TOP_LEFT);
        StackPane.setAlignment(us_box, Pos.TOP_LEFT);
        StackPane.setAlignment(applyBox, Pos.TOP_LEFT);

        StackPane.setMargin(us_box, new Insets(350, 0, 0, 381)); // Position us_box below txt2
        StackPane.setMargin(applyBox, new Insets(400, 0, 0, 800)); // Adjust position of applyBox as needed

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(meet, txt2, us_box, applyBox);



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

    private void openContact() {
        Contact cart = new Contact(stage);
        stage.setScene(cart.createScene());
        stage.setTitle("Contact");
    }

    private void openCart() {
        Cart cart = new Cart(stage);
        stage.setScene(cart.createScene());
        stage.setTitle("Cart");
    }

    private void openService() {
        Service cart = new Service(stage);
        stage.setScene(cart.createScene());
        stage.setTitle("Service");
    }

    private void openProfile() {
        Profile profile = new Profile(stage,LoginController.key);
        stage.setScene(profile.createScene());
        stage.setTitle("Profile");
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