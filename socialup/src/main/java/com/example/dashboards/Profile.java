package com.example.dashboards;

import com.example.controller.LoginController;
import com.example.firebaseConfig.DataService;
import com.google.cloud.firestore.DocumentSnapshot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
    }

    public Scene createScene() {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(50));

        Label welcomeLabel = new Label("Welcome, " + LoginController.key + "!");
        welcomeLabel.setFont(Font.font("Poppins", FontWeight.BOLD, 24));
        welcomeLabel.setTextFill(Color.web("#092A93"));

        // Circular profile image
        profileImageView.setFitWidth(100);
        profileImageView.setFitHeight(100);
        Circle clip = new Circle(50, 50, 50);
        profileImageView.setClip(clip);
        
        Button uploadButton = new Button("Upload Profile Image");
        uploadButton.setOnAction(event -> selectProfileImage());

        Text emailText = new Text();
        Label emailLabel = new Label("Username:");
        Text phoneText = new Text();
        Label phoneLabel = new Label("Mobile Number:");
        Text professionText = new Text();
        Label professionLabel = new Label("Profession:");
        Text socialMediaText = new Text();
        Label socialMediaLabel = new Label("Social Media:");

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> backToUserPage());

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
                welcomeLabel,
                profileImageView,
                uploadButton,
                emailLabel, emailText,
                phoneLabel, phoneText,
                professionLabel, professionText,
                socialMediaLabel, socialMediaText,
                backButton
        );

        return new Scene(layout, 1920, 1080);
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

   // In Profile class
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
