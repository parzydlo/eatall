package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Business;
import model.BusinessList;
import model.Item;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RestaurantPageController implements Initializable {

    Business b;
    @FXML
    Label businessName;

    @FXML
    VBox content;

    @FXML
    private Pane contentArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        b = BusinessList.getInstance().getSelectedBuisness();
        businessName.setText(b.getBusinessname());
        //Stage.getScene().getRoot().getUserData();


        createItemPane();
    }

    public void createItemPane() {
        for (Item i : b.getItems()) {
            HBox restaurantPane = new HBox();
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

            Label name = new Label();
            name.setText(i.getName());
            name.setFont(Font.font("SYSTEM", 20));
            name.setPrefSize(226, 35);
            name.setAlignment(Pos.CENTER);
            restaurantPane.getChildren().add(name);

            Label price = new Label();
            price.setText(Double.toString(i.getCost()));
            price.setFont(Font.font("SYSTEM", 20));
            price.setPrefSize(226, 35);
            price.setAlignment(Pos.CENTER);
            restaurantPane.getChildren().add(price);

            Label des = new Label();
            des.setText(i.getDescription());
            des.setFont(Font.font("SYSTEM", 20));
            des.setPrefSize(226, 35);
            des.setAlignment(Pos.CENTER);
            restaurantPane.getChildren().add(des);

            Label cat = new Label();
            cat.setText(i.getCategories().toString());
            cat.setFont(Font.font("SYSTEM", 20));
            cat.setPrefSize(226, 35);
            cat.setAlignment(Pos.CENTER);
            restaurantPane.getChildren().add(cat);

            JFXButton button = new JFXButton();
            button.setButtonType(JFXButton.ButtonType.RAISED);
            button.setPrefWidth(226);
            button.setPrefHeight(35);
            button.setStyle("-fx-background-color:#DACE00");
            button.setText("Add");
            button.setDisable(false);

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    try {
                        System.out.println("hi");
                    }
                    catch (Exception t)
                    {
                        System.out.println(t.getStackTrace());
                    }
                }
            });

            restaurantPane.getChildren().add(button);


            content.getChildren().add(restaurantPane);
        }
    }

    public void viewReviews() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/Reviews.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

}
