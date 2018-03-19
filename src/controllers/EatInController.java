package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Benny Coder
 */
public class EatInController implements Initializable {

    @FXML
    private Pane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
