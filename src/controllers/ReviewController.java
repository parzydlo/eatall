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
public class ReviewController implements Initializable {
    
    Business b;
    @FXML
    private Pane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        b = BusinessList.getInstance().getSelectedBuisness();
        createReviewBox();
    }

    private void createReviewBox() {
        b.setRevs("Very Good");
        for (String review : b.getRevs()) {
            System.out.println(review);
            VBox reviewBox = new VBox();
            reviewBox.setStyle("-fx-background-color: #F0F0F0");
            DropShadow ds = new DropShadow();
            ds.setWidth(21.0);
            ds.setHeight(15.0);
            ds.setRadius(10.0);
            ds.setBlurType(BlurType.THREE_PASS_BOX);
            ds.setColor(Color.rgb(211, 205, 205, 1.0));
            reviewBox.setEffect(ds);

            Label l = new Label();
            l.setText(review);
            l.setFont(Font.font("SYSTEM", 20));
            l.setPrefSize(226, 35);
            l.setAlignment(Pos.CENTER);
            reviewBox.getChildren().add(l);



            pane.getChildren().add(reviewBox);
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
