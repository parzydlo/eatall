package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.UserList;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainUiController implements Initializable {

    @FXML
    private BorderPane parent;
    @FXML
    private Pane contentArea;
    @FXML
    private Text loginButton, signupButton, accountButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Main init");
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
            if (UserList.getInstance().getLoggedInUser() == null) {
                loginButton.setVisible(true);
                signupButton.setVisible(true);
                accountButton.setVisible(false);
            } else {
                loginButton.setVisible(false);
                signupButton.setVisible(false);
                accountButton.setVisible(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(MainUiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void open_home(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
        refreshButtons();
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

    @FXML
    private void open_Account(MouseEvent ME) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/Account.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    private void refreshButtons() {
        if (UserList.getInstance().getLoggedInUser() == null) {
            loginButton.setVisible(true);
            signupButton.setVisible(true);
            accountButton.setVisible(false);
        } else {
            loginButton.setVisible(false);
            signupButton.setVisible(false);
            accountButton.setVisible(true);
        }
    }

}
