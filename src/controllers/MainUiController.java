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

public class MainUiController implements Initializable {

    @FXML
    private BorderPane parent;
    @FXML
    private Pane contentArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(MainUiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void open_home(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    private void open_Restaurants(ActionEvent event) throws IOException {
        System.out.println("Show logIn screen");

        Parent fxml = FXMLLoader.load(getClass().getResource("/views/EatIn.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    private void open_LogIn(MouseEvent ME) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    private void open_SignUp(MouseEvent ME) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/SignUp.fxml"));
         contentArea.getChildren().removeAll();
         contentArea.getChildren().setAll(fxml);

    }

}
