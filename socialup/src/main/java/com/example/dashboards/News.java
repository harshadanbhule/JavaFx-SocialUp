package com.example.dashboards;

import com.example.controller.LoginController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class News {

    private Stage stage;
    private VBox vb;
    private static JSONArray articles;
    private Application app;

    public News(Stage stage, Application app) {
        this.stage = stage;
        this.app = app;
    }

    public static void fetchArticles() throws IOException {
        StringBuffer response = new DataUrls().getResponseData();
        if (response != null) {
            JSONObject obj = new JSONObject(response.toString());
            articles = obj.getJSONArray("articles");
        } else {
            System.out.println("Response is empty");
        }
    }

    public Scene createScene() {
        vb = new VBox();
        vb.setStyle("-fx-background-color: #FFFFFF;");
        vb.setSpacing(20);
        vb.setPadding(new Insets(20));

        HBox hbox1 = createNavigationBar();
        vb.getChildren().add(hbox1);
        vb.setOnScroll(event -> handleScroll(event));

        try {
            fetchArticles();
            addArticlesToVBox();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Scene(vb, 1920, 1080);
    }

    private HBox createNavigationBar() {
        Font.loadFont(getClass().getResourceAsStream("/fonts/POPPINS-SEMIBOLD.TTF"), 14);
        Font.loadFont(getClass().getResourceAsStream("/fonts/manrope-extrabold.otf"), 14);

        Label text = new Label("SocialUP");
        text.setTextFill(Color.web("#2A4ECA"));
        text.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: bold; -fx-font-size: 32px; -fx-fill: #2A4ECA;");

        Label homeLabel = new Label("Home");
        homeLabel.setTextFill(Color.web("#092A93"));
        homeLabel.setFont(Font.font(16));
        Button homeButton = new Button();
        homeButton.setGraphic(homeLabel);
        homeButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        homeButton.setOnAction(event -> backToUserPage());

        Label aboutLabel = new Label("About Us");
        aboutLabel.setTextFill(Color.web("#092A93"));
        aboutLabel.setFont(Font.font(16));
        Button aboutButton = new Button();
        aboutButton.setGraphic(aboutLabel);
        aboutButton.setStyle("-fx-background-color: rgba(241, 244, 255, 0); -fx-background-radius: 10;");
        aboutButton.setOnAction(event -> openAbout());

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
        return hbox1;
    }

    private void addArticlesToVBox() {
        for (int i = 0; i < articles.length(); i++) {
        JSONObject article = articles.getJSONObject(i);

            String title = article.optString("title", "No Title");
            String description = article.optString("description", "No Description");
            String author = article.optString("author", "Unknown Author");
            String urlToImage = article.optString("urlToImage", "");
            String url = article.optString("url", "No URL");
            String publishedAt = article.optString("publishedAt", "No Date");
            String content = article.optString("content", "No Content");

            Font.loadFont(getClass().getResourceAsStream("/fonts/manrope-extrabold.otf"), 14);
            Text titleLabel = new Text(title);
            titleLabel.setStyle("-fx-font-family: 'Manrope ExtraBold'; -fx-font-size: 30px; -fx-fill: #092A93;");
            titleLabel.setWrappingWidth(950);

            Text descriptionText = new Text(description);
            descriptionText.setStyle("-fx-font-family: 'Manrope Bold'; -fx-font-size: 18px; -fx-fill: #000000;");
            descriptionText.setWrappingWidth(950);

            Label authorLabel = new Label("Author: " + author);
            authorLabel.setStyle("-fx-font-size: 14px; -fx-fill: #333333;");

            Hyperlink urlLink = new Hyperlink("Read more");
            urlLink.setOnAction(e -> app.getHostServices().showDocument(url));

            LocalDateTime dateTime = LocalDateTime.parse(publishedAt, DateTimeFormatter.ISO_DATE_TIME);
            Text publishedAtText = new Text("Published At: " + dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            publishedAtText.setStyle("-fx-font-size: 14px; -fx-fill: #666666;");

            Text contentText = new Text(content);
            contentText.setWrappingWidth(950);
            contentText.setStyle("-fx-font-family: 'Manrope'; -fx-font-size: 16px; -fx-fill: #444444;");

            vb.getChildren().addAll(titleLabel, descriptionText, authorLabel, publishedAtText, contentText, urlLink);
            VBox.setMargin(titleLabel, new Insets(20, 100, 0, 500));
            VBox.setMargin(descriptionText, new Insets(10, 100, 0, 500));
            VBox.setMargin(authorLabel, new Insets(10, 100, 0, 500));
            VBox.setMargin(publishedAtText, new Insets(5, 100, 0, 500));
            VBox.setMargin(contentText, new Insets(10, 100, 0, 500));
            VBox.setMargin(urlLink, new Insets(10, 100, 0, 500));

            if (!urlToImage.isEmpty()) {
                Image image = new Image(urlToImage, 950, 600, true, true);
                ImageView imageView = new ImageView(image);
                vb.getChildren().add(imageView);
                VBox.setMargin(imageView, new Insets(10, 100, 0, 500));
            }

            vb.getChildren().add(new Label(" "));
        }// Spacer between articles
    }

    private void backToUserPage() {
        UserPage userPage = new UserPage(stage);
        userPage.initUserScene();
        stage.setScene(userPage.getUserScene());
        stage.setTitle("User Dashboard");
    }

    private void openContact() {
        Contact contact = new Contact(stage);
        stage.setScene(contact.createScene());
        stage.setTitle("Contact");
    }

    private void openCart() {
        Cart cart = new Cart(stage);
        stage.setScene(cart.createScene());
        stage.setTitle("Cart");
    }

    private void openService() {
        Service service = new Service(stage);
        stage.setScene(service.createScene());
        stage.setTitle("Service");
    }

    private void openProfile() {
        Profile profile = new Profile(stage,LoginController.key);
        stage.setScene(profile.createScene());
        stage.setTitle("Profile");
    }

    private void openAbout() {
        About about = new About(stage);
        stage.setScene(about.createScene());
        stage.setTitle("About");
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
