package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Business;
import model.BusinessList;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;


/**
 * FXML Controller class
 *
 * @author Benny Coder
 */
public class EatInController implements Initializable {

    @FXML
    private TilePane grid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Creating restaurant list view");

        createRestaurantBox();
    }

    private void createRestaurantBox() {
        System.out.println("Creating restaurant list view");
        for (Business b : BusinessList.getInstance().getBusinessArrayList()) {
            System.out.println(b.getBusinessname());
            grid.setHgap(25);
            grid.setVgap(25);
            grid.setPrefColumns(3);
            VBox restaurantPane = new VBox();
            restaurantPane.setStyle("-fx-background-color: #F0F0F0");
            DropShadow ds = new DropShadow();
            ds.setWidth(21.0);
            ds.setHeight(21.0);
            ds.setRadius(10.0);
            ds.setBlurType(BlurType.THREE_PASS_BOX);
            ds.setColor(Color.rgb(211, 205, 205, 1.0));
            //ds.setColor();
            restaurantPane.setEffect(ds);
            //restaurantPane.setPrefSize(226,318);
            //restaurantPane.s

            Label l = new Label();
            l.setText(b.getBusinessname());
            l.setFont(Font.font("SYSTEM", 20));
            l.setPrefSize(226, 35);
            l.setAlignment(Pos.CENTER);
            restaurantPane.getChildren().add(l);
//
            ImageView IV = new ImageView();

            // TODO: assign a random icon

            IV.setImage(new Image("icons/Burger_small.png"));
            IV.setFitWidth(226);
            IV.setFitHeight(184);
            restaurantPane.getChildren().add(IV);
//
            Label label = new Label(b.getDescription());
            label.setPrefWidth(226);
            label.setFont(Font.font("SYSTEM", 14));
            label.setMaxWidth(226);
            label.setWrapText(true);
            restaurantPane.getChildren().add(label);
//
            JFXButton button = new JFXButton();
            button.setButtonType(JFXButton.ButtonType.RAISED);
            button.setPrefWidth(226);
            button.setPrefHeight(10);
            button.setStyle("-fx-background-color:#DACE00");
            button.setText("Select");
            button.setAlignment(Pos.BOTTOM_CENTER);
//
            restaurantPane.getChildren().add(button);
            grid.getChildren().add(restaurantPane);
        }
    }

    @FXML
    private void testMe(MouseEvent ME) throws IOException {
        //Parent fxml = FXMLLoader.load(getClass().getResource("/views/EatIn.fxml"));
        // contentArea.getChildren().removeAll();
        // contentArea.getChildren().setAll(fxml);

        System.out.println("Show logIn screen");
    }
    @FXML
    private void openRestaurant(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/RestaurantPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        // stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    
}
