package com.example.dashboards;

import com.example.controller.LoginController;
import com.example.firebaseConfig.DataService;
import com.google.cloud.firestore.DocumentSnapshot;
import java.awt.Desktop;
import java.net.URI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Profile {

    private Stage stage;
    private DataService dataService;
    private String username;
    private ImageView profileImageView;

    public Profile(Stage stage, String username) {
        this.stage = stage;
        this.username = username;
        this.dataService = new DataService();
        this.profileImageView = new ImageView();

        // Set default profile image
        Image defaultProfileImage = new Image(getClass().getResourceAsStream("/Home/blank-profile-picture-973460_1280 (2).png"));
        profileImageView.setImage(defaultProfileImage);
    }

    public Scene createScene() {
        Font.loadFont(getClass().getResourceAsStream("/fonts/POPPINS-SEMIBOLD.TTF"), 14);

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(50));

        // Circular profile image
        profileImageView.setFitWidth(184);
        profileImageView.setFitHeight(184);
        Circle clip = new Circle(92, 92, 92); // Adjust circle's position and radius to center the image
        profileImageView.setClip(clip);
        profileImageView.setTranslateX(0);
        profileImageView.setTranslateY(0);

        Label welcomeLabel = new Label(LoginController.key);
        welcomeLabel.setStyle("-fx-font-family: 'Poppins';-fx-font-weight: semibold;-fx-font-size: 24px; -fx-fill: #000000;");
        welcomeLabel.setTextFill(Color.web("#000000"));
        welcomeLabel.setTranslateX(10);
        welcomeLabel.setTranslateY(60);

        Image bg_Image = new Image("file:src/main/resources/Home/Frame 329 (2).png");
        ImageView bg_ImageView = new ImageView(bg_Image);
        bg_ImageView.setFitWidth(1920);  // Ensure the background image covers the entire width
        bg_ImageView.setFitHeight(1080); // Ensure the background image covers the entire height

        Image buttonImage = new Image("file:src/main/resources/Home/Group 14582630.png");
        ImageView buttonImageView = new ImageView(buttonImage);
        Button uploadButton = new Button();
        uploadButton.setOnAction(event -> selectProfileImage());
        uploadButton.setMaxSize(25, 25);
        uploadButton.setGraphic(buttonImageView);
        uploadButton.setStyle(
                "-fx-background-color: transparent;" +  // Set background to transparent
                "-fx-border-color: transparent;" +      // Remove border
                "-fx-padding: 5 10;"                     // Adjust padding as needed
        );

        Text emailText = new Text();
        emailText.setStyle("-fx-font-family: 'Poppins';-fx-font-weight: BOLD;-fx-font-size: 40px; -fx-fill: #0002AE;");
        Text phoneText = new Text();
        phoneText.setStyle("-fx-font-family: 'Poppins';-fx-font-weight: semibold;-fx-font-size: 24px; -fx-fill: #000000;");
        phoneText.setTranslateX(0);
        phoneText.setTranslateY(90);
        Text professionText = new Text();
        professionText.setStyle("-fx-font-family: 'Poppins';-fx-font-weight: LIGHT;-fx-font-size: 20px; -fx-fill: #000000;");
        Hyperlink socialMediaText = new Hyperlink();
        socialMediaText.setStyle("-fx-font-family: 'Poppins';-fx-font-weight: semibold;-fx-font-size: 24px; -fx-fill: #000000;");
        socialMediaText.setTranslateX(50);
        socialMediaText.setTranslateY(115);
        socialMediaText.setOnAction(event -> {
            String url = socialMediaText.getText();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error opening hyperlink: " + e.getMessage());
                }
            }
        });

        Button backButton = new Button();
        backButton.setMaxSize(42, 42);
        Image backImage = new Image("file:src/main/resources/Home/Arrow-Left.png");
        ImageView backImageView = new ImageView(backImage);
        backButton.setGraphic(backImageView);
        backButton.setStyle(
                "-fx-background-color: transparent;" +  // Set background to transparent
                "-fx-border-color: transparent;" +      // Remove border
                "-fx-padding: 5 10;"                     // Adjust padding as needed
        );

        backButton.setOnAction(event -> backToUserPage());
        backButton.setTranslateX(10);
        backButton.setTranslateY(10);

        // Fetch user data from Firestore
        try {
            DocumentSnapshot userData = dataService.getData("users", username);
            if (userData != null && userData.exists()) {
                String username2 = userData.getString("username2");
                String mobilenum = userData.getString("mobilenum");
                String profession = userData.getString("profession");
                String socialmedia = userData.getString("socialmedia");
                String profileImageUrl = userData.getString("profileImageUrl");

                // Log fetched data for debugging
                System.out.println("Username2: " + username2);
                System.out.println("Mobile Number: " + mobilenum);
                System.out.println("Profession: " + profession);
                System.out.println("Social Media: " + socialmedia);
                System.out.println("Profile Image URL: " + profileImageUrl);

                // Display fetched data
                emailText.setText(username2 != null ? username2 : "N/A");
                phoneText.setText(mobilenum != null ? mobilenum : "N/A");
                professionText.setText(profession != null ? profession : "N/A");
                socialMediaText.setText(socialmedia != null ? socialmedia : "N/A");

                // Load and display profile image
                if (profileImageUrl != null) {
                    Image profileImage = new Image(profileImageUrl);
                    profileImageView.setImage(profileImage);
                }
            } else {
                System.out.println("No user data found for username: " + username);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error fetching user data: " + ex.getMessage());
        }

        // Add components to layout
        layout.getChildren().addAll(
                profileImageView,
                uploadButton,
                emailText,
                professionText,
                welcomeLabel,
                phoneText,
                socialMediaText
        );

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(bg_ImageView, layout, backButton);
        StackPane.setMargin(layout, new Insets(0, 0, 45, 0));
        StackPane.setAlignment(backButton, Pos.TOP_LEFT);
        StackPane.setMargin(backButton, new Insets(0, 0, 0, 0)); // Adjust margins as needed

        VBox.setMargin(uploadButton, new Insets(0, 0, 0, 10));
        VBox.setMargin(profileImageView, new Insets(0, 0, 0, 0));

        return new Scene(stackPane, 1920, 1080);
    }

    private void backToUserPage() {
        UserPage userPage = new UserPage(stage);
        userPage.initUserScene(); // Re-initialize the UserPage scene
        stage.setScene(userPage.getUserScene()); // Set the UserPage scene
        stage.setTitle("User Dashboard");
    }

    private void selectProfileImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            try {
                FileInputStream inputStream = new FileInputStream(selectedFile);
                Image image = new Image(inputStream);
                profileImageView.setImage(image);
                // Save image to Firestore
                saveProfileImageToFirestore(selectedFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveProfileImageToFirestore(File file) {
        try {
            // Upload image to Firebase Storage and get the URL
            String imageUrl = dataService.uploadFileToStorage(file, "profile_images/" + username + ".jpg");

            // Save the image URL in Firestore
            dataService.updateField("users", username, "profileImageUrl", imageUrl);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error saving profile image to Firestore: " + e.getMessage());
        }
    }
}
