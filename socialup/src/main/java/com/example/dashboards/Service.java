package com.example.dashboards;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.example.SecondStage;
import com.example.controller.LoginController;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
public class Service {

    private Stage stage;
    VBox vb;

    public Service(Stage stage) {
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

        Label singleLabel = new Label("Single Services");
        singleLabel.setTextFill(Color.web("#FFFFFF"));
        singleLabel.setStyle("-fx-font-weight: 500; -fx-font-size: 24px;");

        // Create a HBox and add the label
        HBox service = new HBox(singleLabel);
        service.setAlignment(Pos.CENTER);
        service.setLayoutX(200); // Adjust the position to be next to the rectangle
        service.setLayoutY(0);


        Image g_d_image = new Image("file:src/main/resources/images/Designer-rafiki.png");
        ImageView g_d_image_v = new ImageView(g_d_image);
        g_d_image_v.setLayoutX(113.14);
        g_d_image_v.setLayoutY(60.33);

        Image v_e_image = new Image("file:src//main//resources//images//Programming-rafiki.png");
        ImageView v_e_image_v = new ImageView(v_e_image);
        v_e_image_v.setLayoutX(590);
        v_e_image_v.setLayoutY(60.33);

        Image c_w_image = new Image("file:src//main//resources//images//Notes-rafiki.png");
        ImageView c_w_image_v = new ImageView(c_w_image);
        c_w_image_v.setLayoutX(1105);
        c_w_image_v.setLayoutY(60.33);
        
        Image v_g_image = new Image("file:src//main//resources//images//Group.png");
        ImageView v_g_image_v = new ImageView(v_g_image);
        v_g_image_v.setLayoutX(1600);
        v_g_image_v.setLayoutY(60.33);

        // Create a Rectangle
        Rectangle rect1 = new Rectangle(350, 483, Color.web("#4CB568"));
        rect1.setLayoutX(0); // Position the rectangle
        rect1.setLayoutY(0);
        rect1.setArcWidth(35); // Set the arc width for rounded corners
        rect1.setArcHeight(35);
        rect1.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 20, 0, 0, 10);");

        Text gdesign = new Text("Graphic Design");
        gdesign.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: bold; -fx-font-size: 32px; -fx-fill: #FFFFFF;");
        gdesign.setLayoutX(55);
        gdesign.setLayoutY(236);

        Text gdesign_2 = new Text("We provide\n6 posters/week\nwith your requirements.");
        gdesign_2.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: 100; -fx-font-size: 17px; -fx-fill: #FFFFFF;");
        gdesign_2.setLayoutX(75);
        gdesign_2.setLayoutY(297);
        gdesign_2.setTextAlignment(TextAlignment.CENTER);

        Button graphic_b = new Button("3000 Rs/Week");
        graphic_b.setLayoutX(78);
        graphic_b.setLayoutY(411);
        graphic_b.setPrefSize(186, 42);
        graphic_b.setStyle(
            "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #68D585; " +
            "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
            "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
        );

        graphic_b.setOnMouseEntered(event -> graphic_b.setStyle(
            "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #FFFFFF; " +
            "-fx-background-color: #68D585; -fx-cursor: hand; " +
            "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
        ));

        graphic_b.setOnMouseExited(event -> graphic_b.setStyle(
            "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #68D585; " +
            "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
            "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
        ));
        graphic_b.setOnAction(event -> openLink("https://rzp.io/l/AjvOSSyUfH"));

        Rectangle rect2 = new Rectangle(350, 483, Color.web("#4363D0"));
        rect2.setLayoutX(497); // Position the rectangle
        rect2.setLayoutY(0);
        rect2.setArcWidth(35); // Set the arc width for rounded corners
        rect2.setArcHeight(35);
        rect2.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 20, 0, 0, 10);");

        Text v_editor = new Text("Video Editor");
        v_editor.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: bold; -fx-font-size: 32px; -fx-fill: #FFFFFF;");
        v_editor.setLayoutX(575);
        v_editor.setLayoutY(236);

        Text v_editor_2 = new Text("We provide\n4 reels/week\n1 max 15 min video\nwith your requirements.");
        v_editor_2.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: 100; -fx-font-size: 17px; -fx-fill: #FFFFFF;");
        v_editor_2.setLayoutX(575);
        v_editor_2.setLayoutY(297);
        v_editor_2.setTextAlignment(TextAlignment.CENTER);

        Button v_editor_b = new Button("4000 Rs/Week");
        v_editor_b.setLayoutX(575);
        v_editor_b.setLayoutY(411);
        v_editor_b.setPrefSize(186, 42);
        v_editor_b.setStyle(
            "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #4363D0; " +
            "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
            "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
        );


        v_editor_b.setOnMouseEntered(event -> {
            v_editor_b.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #FFFFFF; " +
                "-fx-background-color: #4363D0; -fx-cursor: hand; " +
                "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
            );
        });
        
        v_editor_b.setOnMouseExited(event -> {
            v_editor_b.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #4363D0; " +
                "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
                "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
            );
        });
        v_editor_b.setOnAction(event -> openLink("https://rzp.io/l/1QTQ5Rr"));

        Rectangle rect3 = new Rectangle(350, 483, Color.web("#CE5757"));
        rect3.setLayoutX(994); // Position the rectangle
        rect3.setLayoutY(0);
        rect3.setArcWidth(35); // Set the arc width for rounded corners
        rect3.setArcHeight(35);
        rect3.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 20, 0, 0, 10);");

        Text c_writer = new Text("Content Writer");
        c_writer.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: bold; -fx-font-size: 32px; -fx-fill: #FFFFFF;");
        c_writer.setLayoutX(1060);
        c_writer.setLayoutY(236);

        Text c_writer_2 = new Text("We provide\n6 contents/week\nwith your requirements.");
        c_writer_2.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: 100; -fx-font-size: 17px; -fx-fill: #FFFFFF;");
        c_writer_2.setLayoutX(1070);
        c_writer_2.setLayoutY(297);
        c_writer_2.setTextAlignment(TextAlignment.CENTER);

        Button c_writer_b = new Button("2000 Rs/Week");
        c_writer_b.setLayoutX(1070);
        c_writer_b.setLayoutY(411);
        c_writer_b.setPrefSize(186, 42);
        c_writer_b.setStyle(
            "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #d56868; " +
            "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
            "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
        );

        c_writer_b.setOnMouseEntered(event -> {
            c_writer_b.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #FFFFFF; " +
                "-fx-background-color: #d56868; -fx-cursor: hand; " +
                "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
            );
        });
        
        c_writer_b.setOnMouseExited(event -> {
            c_writer_b.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #d56868; " +
                "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
                "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
            );
        });



        Rectangle rect4 = new Rectangle(350, 483, Color.web("#C76935"));
        rect4.setLayoutX(1491); // Position the rectangle
        rect4.setLayoutY(0);
        rect4.setArcWidth(35); // Set the arc width for rounded corners
        rect4.setArcHeight(35);
        rect4.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 20, 0, 0, 10);");

        Text v_grapher = new Text("Videographer");
        v_grapher.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: bold; -fx-font-size: 32px; -fx-fill: #FFFFFF;");
        v_grapher.setLayoutX(1555);
        v_grapher.setLayoutY(236);

        Text v_grapher_2 = new Text("We provide\n20 hrs/week\nwith your requirements.");
        v_grapher_2.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: 100; -fx-font-size: 17px; -fx-fill: #FFFFFF;");
        v_grapher_2.setLayoutX(1570);
        v_grapher_2.setLayoutY(297);
        v_grapher_2.setTextAlignment(TextAlignment.CENTER);

        Button v_grapher_b = new Button("6000 Rs/Week");
        v_grapher_b.setLayoutX(1560);
        v_grapher_b.setLayoutY(411);
        v_grapher_b.setPrefSize(186, 42);
        v_grapher_b.setStyle(
            "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #d5b668; " +
            "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
            "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
        );

        v_grapher_b.setOnMouseEntered(event -> {
            v_grapher_b.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #FFFFFF; " +
                "-fx-background-color: #d5b668; -fx-cursor: hand; " +
                "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
            );
        });
        
        v_grapher_b.setOnMouseExited(event -> {
            v_grapher_b.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #d5b668; " +
                "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
                "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
            );
        });




        // Create a Pane to set the background color
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #FFFFFF;");
        pane.setLayoutX(39);
        pane.setLayoutY(318);
        pane.setPrefSize(1841, 483);

        
        // Add the rectangle and HBox to the pane
        pane.getChildren().addAll(rect1, gdesign, gdesign_2, graphic_b,rect2,v_editor,v_editor_2,v_editor_b,rect3,c_writer,c_writer_2,c_writer_b,rect4,v_grapher,v_grapher_2,v_grapher_b,g_d_image_v,v_e_image_v,c_w_image_v,v_g_image_v);

        Image ph_image = new Image("file:src//main//resources//images//Group (1).png");
        ImageView ph_image_v = new ImageView(ph_image);
        ph_image_v.setLayoutX(113.14);
        ph_image_v.setLayoutY(55);

        Image s_w_image = new Image("file:src//main//resources//images//Group (2).png");
        ImageView s_w_image_v = new ImageView(s_w_image);
        s_w_image_v.setLayoutX(610);
        s_w_image_v.setLayoutY(55);

        Image s_s_image = new Image("file:src//main//resources//images/Group (3).png");
        ImageView s_s_image_v = new ImageView(s_s_image);
        s_s_image_v.setLayoutX(1105);
        s_s_image_v.setLayoutY(30);
        
        Image c_m_image = new Image("file:src//main//resources//images//Group (4).png");
        ImageView c_m_image_v = new ImageView(c_m_image);
        c_m_image_v.setLayoutX(1600);
        c_m_image_v.setLayoutY(60.33);


        Rectangle rect5 = new Rectangle(350, 483, Color.web("#E0C74E"));
        rect5.setLayoutX(0); // Position the rectangle
        rect5.setLayoutY(0);
        rect5.setArcWidth(35); // Set the arc width for rounded corners
        rect5.setArcHeight(35);
        rect5.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 20, 0, 0, 10);");

        Text pgrapher = new Text("Photographer");
        pgrapher.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: bold; -fx-font-size: 32px; -fx-fill: #FFFFFF;");
        pgrapher.setLayoutX(55);
        pgrapher.setLayoutY(236);

        Text pgrapher_2 = new Text("We provide\n20 hrs/week\nwith your requirements.");
        pgrapher_2.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: 100; -fx-font-size: 17px; -fx-fill: #FFFFFF;");
        pgrapher_2.setLayoutX(75);
        pgrapher_2.setLayoutY(297);
        pgrapher_2.setTextAlignment(TextAlignment.CENTER);

        Button pgrapher_b = new Button("4000 Rs/Week");
        pgrapher_b.setLayoutX(78);
        pgrapher_b.setLayoutY(411);
        pgrapher_b.setPrefSize(186, 42);
        pgrapher_b.setStyle(
            "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #d5d168; " +
            "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
            "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
        );

        pgrapher_b.setOnMouseEntered(event -> pgrapher_b.setStyle(
            "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #FFFFFF; " +
            "-fx-background-color: #d5d168; -fx-cursor: hand; " +
            "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
        ));

        pgrapher_b.setOnMouseExited(event -> pgrapher_b.setStyle(
            "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #d5d168; " +
            "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
            "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
        ));


        Rectangle rect6 = new Rectangle(350, 483, Color.web("#D0436D"));
        rect6.setLayoutX(497); // Position the rectangle
        rect6.setLayoutY(0);
        rect6.setArcWidth(35); // Set the arc width for rounded corners
        rect6.setArcHeight(35);
        rect6.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 20, 0, 0, 10);");

        Text s_writer = new Text("Subtitle Writer");
        s_writer.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: bold; -fx-font-size: 32px; -fx-fill: #FFFFFF;");
        s_writer.setLayoutX(565);
        s_writer.setLayoutY(236);

        Text s_writer_2 = new Text("We provide\n160 min video subtitle\nwith your requirements.");
        s_writer_2.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: 100; -fx-font-size: 17px; -fx-fill: #FFFFFF;");
        s_writer_2.setLayoutX(575);
        s_writer_2.setLayoutY(297);
        s_writer_2.setTextAlignment(TextAlignment.CENTER);

        Button s_writer_b = new Button("3000 Rs/Week");
        s_writer_b.setLayoutX(575);
        s_writer_b.setLayoutY(411);
        s_writer_b.setPrefSize(186, 42);
        s_writer_b.setStyle(
            "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #d1738f; " +
            "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
            "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
        );

        s_writer_b.setOnMouseEntered(event -> {
            s_writer_b.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #FFFFFF; " +
                "-fx-background-color: #d1738f; -fx-cursor: hand; " +
                "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
            );
        });
        
        s_writer_b.setOnMouseExited(event -> {
            s_writer_b.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #d1738f; " +
                "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
                "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
            );
        });


        Rectangle rect7 = new Rectangle(350, 483, Color.web("#CE57C9"));
        rect7.setLayoutX(994); // Position the rectangle
        rect7.setLayoutY(0);
        rect7.setArcWidth(35); // Set the arc width for rounded corners
        rect7.setArcHeight(35);
        rect7.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 20, 0, 0, 10);");

        Text s_special = new Text("SEO Specialist");
        s_special.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: bold; -fx-font-size: 32px; -fx-fill: #FFFFFF;");
        s_special.setLayoutX(1060);
        s_special.setLayoutY(236);

        Text s_special_2 = new Text("We provide\n6 contents/week\nwith your requirements.");
        s_special_2.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: 100; -fx-font-size: 17px; -fx-fill: #FFFFFF;");
        s_special_2.setLayoutX(1070);
        s_special_2.setLayoutY(297);
        s_special_2.setTextAlignment(TextAlignment.CENTER);

        Button s_special_b = new Button("5000 Rs/Week");
        s_special_b.setLayoutX(1070);
        s_special_b.setLayoutY(411);
        s_special_b.setPrefSize(186, 42);
        s_special_b.setStyle(
            "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #d67ad2; " +
            "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
            "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
        );

        s_special_b.setOnMouseEntered(event -> {
            s_special_b.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #FFFFFF; " +
                "-fx-background-color: #d67ad2; -fx-cursor: hand; " +
                "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
            );
        });
        
        s_special_b.setOnMouseExited(event -> {
            s_special_b.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #d67ad2; " +
                "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
                "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
            );
        });

        Rectangle rect8 = new Rectangle(350, 483, Color.web("#35A4C7"));
        rect8.setLayoutX(1491); // Position the rectangle
        rect8.setLayoutY(0);
        rect8.setArcWidth(35); // Set the arc width for rounded corners
        rect8.setArcHeight(35);
        rect8.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 20, 0, 0, 10);");

        Text c_manager = new Text("Community Manager");
        c_manager.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: bold; -fx-font-size: 32px; -fx-fill: #FFFFFF;");
        c_manager.setLayoutX(1510);
        c_manager.setLayoutY(236);

        Text c_manager_2 = new Text("We provide\n20 hrs/week\nwith your requirements.");
        c_manager_2.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: 100; -fx-font-size: 17px; -fx-fill: #FFFFFF;");
        c_manager_2.setLayoutX(1570);
        c_manager_2.setLayoutY(297);
        c_manager_2.setTextAlignment(TextAlignment.CENTER);

        Button c_manager_b = new Button("7000 Rs/Week");
        c_manager_b.setLayoutX(1560);
        c_manager_b.setLayoutY(411);
        c_manager_b.setPrefSize(186, 42);
        c_manager_b.setStyle(
            "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #67b6cf; " +
            "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
            "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
        );

        c_manager_b.setOnMouseEntered(event -> {
            c_manager_b.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill: #FFFFFF; " +
                "-fx-background-color: #67b6cf; -fx-cursor: hand; " +
                "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
            );
        });
        
        c_manager_b.setOnMouseExited(event -> {
            c_manager_b.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 20px; -fx-font-weight: 100; -fx-text-fill:#67b6cf; " +
                "-fx-background-color: #FFFFFF; -fx-cursor: hand; " +
                "-fx-background-insets: 0, 1, 2, 3; -fx-background-radius: 5, 4, 3, 2;"
            );
        });





        Pane pane2 = new Pane();
        pane2.setStyle("-fx-background-color: #FFFFFF;");
        pane2.setLayoutX(39);
        //pane2.setLayoutY(100);
        pane2.setPrefSize(1841, 483);

        
        // Add the rectangle and HBox to the pane
        pane2.getChildren().addAll(rect5,pgrapher, pgrapher_2, pgrapher_b,rect6,s_writer, s_writer_2,s_writer_b,rect7,s_special, s_special_2, s_special_b,rect8,c_manager, c_manager_2, c_manager_b,ph_image_v,s_w_image_v,s_s_image_v,c_m_image_v);

        Text pack_ser = new Text("Single Services");
        pack_ser.setLayoutX(45);
        pack_ser.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; -fx-text-fill:BLUE;");
        pack_ser.setFill(Color.web("#2A4ECA"));

        Text pack_ser2 = new Text("Package Service");
        pack_ser2.setLayoutX(45);
        pack_ser2.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; -fx-text-fill:BLUE;");
        pack_ser2.setFill(Color.web("#2A4ECA"));
        
        Rectangle rectangle = new Rectangle(200, 200, Color.web("#4CB568"));
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);


        Image packImage = new Image("file:src//main//resources//images//Group 14582626.png");
        ImageView packImageV = new ImageView(packImage);
        packImageV.setLayoutX(150);

        Button purc1 = new Button("Purchase");
        purc1.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; -fx-text-fill: WHITE; " +
            "-fx-background-color: #092A93; -fx-cursor: hand; " +
             "-fx-background-radius:100;-fx-pref-height: 72px;-fx-pref-width: 309px;");
        purc1.setOnMouseEntered(event -> {
            purc1.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; -fx-text-fill: WHITE; " +
            "-fx-background-color: #5c75c4; -fx-cursor: hand; " +
             "-fx-background-radius:100;-fx-pref-height: 72px;-fx-pref-width: 309px;"
            );
        });
        
        purc1.setOnMouseExited(event -> {
            purc1.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; -fx-text-fill: WHITE; " +
            "-fx-background-color: #092A93; -fx-cursor: hand; " +
             "-fx-background-radius:100;-fx-pref-height: 72px;-fx-pref-width: 309px;"
            );
        });
        purc1.setOnAction(event -> openLink("https://rzp.io/l/q8zxjB5waE"));

        Button purc2 = new Button("Purchase");
        purc2.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; -fx-text-fill: #092A93; " +
            "-fx-background-color: WHITE; -fx-cursor: hand; " +
             "-fx-background-radius:100;-fx-pref-height: 72px;-fx-pref-width: 309px;");
        purc2.setOnMouseEntered(event -> {
            purc2.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; -fx-text-fill: WHITE; " +
            "-fx-background-color: #496bd6; -fx-cursor: hand; " +
             "-fx-background-radius:100;-fx-pref-height: 72px;-fx-pref-width: 309px;"
            );
        });
        
        purc2.setOnMouseExited(event -> {
            purc2.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; -fx-text-fill: #496bd6; " +
            "-fx-background-color: WHITE; -fx-cursor: hand; " +
             "-fx-background-radius:100;-fx-pref-height: 72px;-fx-pref-width: 309px;"
            );
        });

        Button purc3 = new Button("Purchase");
        purc3.setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; -fx-text-fill: WHITE; " +
            "-fx-background-color: #092A93; -fx-cursor: hand; " +
             "-fx-background-radius:100;-fx-pref-height: 72px;-fx-pref-width: 309px;");
        purc3.setOnMouseEntered(event -> {
            purc3.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; -fx-text-fill: WHITE; " +
            "-fx-background-color: #5c75c4; -fx-cursor: hand; " +
             "-fx-background-radius:100;-fx-pref-height: 72px;-fx-pref-width: 309px;"
            );
        });
        
        purc3.setOnMouseExited(event -> {
            purc3.setStyle(
                "-fx-font-family: 'Poppins'; -fx-font-size: 24px; -fx-font-weight: BOLD; -fx-text-fill: WHITE; " +
            "-fx-background-color: #092A93; -fx-cursor: hand; " +
             "-fx-background-radius:100;-fx-pref-height: 72px;-fx-pref-width: 309px;"
            );
        });
        purc3.setOnAction(event -> openLink("https://rzp.io/l/tQBkO3kD"));




        StackPane stackPane = new StackPane(packImageV,purc1,purc2,purc3);
        StackPane.setMargin(purc1, new Insets(767,853,0,0));
        StackPane.setMargin(purc2, new Insets(880,2,0,0));
        StackPane.setMargin(purc3, new Insets(993,2,0,854));
        
        Rectangle rectangle2=new Rectangle();
        rectangle2.setHeight(100);
        rectangle2.setFill(Color.WHITE);



        vb = new VBox(hbox1,pack_ser,pane,pane2,pack_ser2,stackPane,rectangle2);
        vb.setOnScroll(event -> handleScroll(event));
        VBox.setMargin(pane, new Insets(150,0,0,50));
        VBox.setMargin(pane2, new Insets(650,0,0,50));
        VBox.setMargin(pack_ser, new Insets(100,0,0,50));
        VBox.setMargin(pack_ser2, new Insets(700,0,0,50));
        VBox.setMargin(stackPane, new Insets(200,0,100,50));
        //VBox.setMargin(purc1,new Insets(100,0,0,250));

        vb.setStyle("-fx-background-color: #FFFFFF;");

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

    private void openNews() {
        News cart = new News(stage, null);
        stage.setScene(cart.createScene());
        stage.setTitle("News");
    }
    private void handleLogout() {
        LoginController loginController = new LoginController(stage);
        loginController.showLoginScene();
    }

    private void openLink(String url) {
    if (Desktop.isDesktopSupported()) {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    } else {
        System.err.println("Desktop is not supported. Cannot open link.");
    }
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