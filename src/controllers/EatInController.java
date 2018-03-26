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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Builder;
import model.Business;
import model.BusinessList;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * FXML Controller class
 *
 *
 */
public class EatInController implements Initializable {

    @FXML
    private Pane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        createRestaurantBox();
    }

    private void createRestaurantBox() {
        for (Business b : BusinessList.getInstance().getLastQuery()) {
            System.out.println(b.getBusinessname());

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

            ImageView IV = new ImageView();
            IV.setImage(new Image("icons/Burger_small.png"));
            IV.setFitWidth(226);
            IV.setFitHeight(184);
            restaurantPane.getChildren().add(IV);

            Label label = new Label(b.getDescription());
            label.setPrefWidth(226);
            label.setFont(Font.font("SYSTEM", 20));
            label.setMaxWidth(226);
            label.setWrapText(true);
            restaurantPane.getChildren().add(label);

            JFXButton button = new JFXButton();
            button.setButtonType(JFXButton.ButtonType.RAISED);
            button.setPrefWidth(226);
            button.setPrefHeight(35);
            button.setStyle("-fx-background-color:#DACE00");
            button.setText("Select");

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {

                    try {
                        BusinessList.getInstance().setSelectedBuisness(b);
                        Parent root = FXMLLoader.load(getClass().getResource("/views/RestaurantPage.fxml"));
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        // stage.initStyle(StageStyle.UNDECORATED);
                        stage.show();
                    }
                    catch (Exception t)
                    {
                        System.out.println(t.getStackTrace());
                    }


                }
            });

            restaurantPane.getChildren().add(button);
            pane.getChildren().add(restaurantPane);
        }
    }

    @FXML
    private void testMe(MouseEvent ME) throws IOException {
        //Parent fxml = FXMLLoader.load(getClass().getResource("/views/EatIn.fxml"));
        // contentArea.getChildren().removeAll();
        // contentArea.getChildren().setAll(fxml);

        System.out.println("Show logIn screen");
    }

}
