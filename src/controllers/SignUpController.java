package controllers;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import main.Business;
import main.Individual;
import main.User;

/**
 * FXML Controller class
 */
public class SignUpController implements Initializable {

    boolean usr = false;
    boolean pwd = false;
    boolean fn = false;
    boolean ln = false;
    boolean bn = false;
    protected SignUpModel loginModel = new SignUpModel();
    Random rand = new Random();
    @FXML
    private Pane pane;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField businessname;
    @FXML
    private TextField bfirstname;
    @FXML
    private TextField blastname;
    @FXML
    private PasswordField bpassword;
    @FXML
    private Label errorlabel;
    @FXML
    private Label errorlabel2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void clicked_SignUpInd() throws SQLException{

        if(firstname.getText().isEmpty()||lastname.getText().isEmpty()) errorlabel.setText("First name or Surname cannot be empty");
        if(password.getText().isEmpty()) errorlabel.setText("Password cannot be empty");
        if(username.getText().isEmpty()){
            errorlabel.setText("Username cannot be empty");
            return;
        }
        boolean exists = loginModel.checkUsername(username.getText());

        if(exists) errorlabel.setText("Username is already registered to an account, please enter a different one.");
        else{
            loginModel.addToDB(firstname.getText(), lastname.getText(), username.getText(), password.getText(), "I");
            errorlabel.setTextFill(Color.GREEN);
            errorlabel.setText("You have registered successfully! Click back and you can log in.");
        }
    }

    public void clicked_SignUpBus(javafx.scene.input.MouseEvent me) throws SQLException {
        if(blastname.getText().isEmpty()||blastname.getText().isEmpty()) errorlabel2.setText("First name or Surname cannot be empty");
        if(bpassword.getText().isEmpty()) errorlabel2.setText("Password cannot be empty");
        if(businessname.getText().isEmpty()){
            errorlabel2.setText("Username cannot be empty");
            return;
        }
        boolean exists = loginModel.checkUsername(username.getText());

        if(exists) errorlabel2.setText("Username is already registered to an account, please enter a different one.");
        else{
            loginModel.addToDB(bfirstname.getText(), blastname.getText(), businessname.getText(), bpassword.getText(), "B");
            errorlabel2.setTextFill(Color.GREEN);
            errorlabel2.setText("You have registered successfully! Click back and you can log in.");
        }
    }


}
