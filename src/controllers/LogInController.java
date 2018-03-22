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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;

import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author Benny Coder
 */
public class LogInController implements Initializable {

    protected SignUpModel loginModel = new SignUpModel();
    @FXML
    private Pane pane;
    @FXML
    private TextField usrname;
    @FXML
    private TextField pword;
    @FXML
    private Label errorlabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void clicked_Login() throws SQLException {
        try {

            String username = usrname.getText();
            String password = pword.getText();
            String[] data = loginModel.getData(username, password);
            if (data != null) {
//                if (data[4].equals("Student")) {
//
//                } else if (data[4].equals("Teacher")) {
//
//                }
                errorlabel.setTextFill(Color.GREEN);
                errorlabel.setText("Login Successful");
            } else if (username.equals("") || password.equals("")) {
                errorlabel.setText("Username or password cannot be blank.");
            } else errorlabel.setText("Incorrect username or password. Please try again.");
        } catch (SQLException ex) {
            Logger.getLogger(SignUpModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
