package controllers;

import java.io.*;
import java.net.URL;
import java.util.Random;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import main.Individual;
import main.User;

/**
 * FXML Controller class
 *
 * @author Benny Coder
 */
public class SignUpController implements Initializable {

    boolean usr=false;
    boolean pwd=false;
    boolean fn=false;
    boolean ln=false;
    Random rand;
    @FXML
    private Pane pane;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
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

    public void clicked_SignUpInd(javafx.scene.input.MouseEvent me) throws IOException {

        if (username.getText() != null && !username.getText().isEmpty()){
            usr=true;
        }else {
            errorlabel.setTextFill(Color.RED);
            errorlabel.setText("Must choose a username");
        }
        if (password.getText() != null && !password.getText().isEmpty()){
            pwd=true;
        }else {
            errorlabel.setTextFill(Color.RED);
            errorlabel.setText("Must choose password");
        }
        if (firstname.getText() != null && !firstname.getText().isEmpty()){
            fn=true;
        }else {
            errorlabel.setTextFill(Color.RED);
            errorlabel.setText("Must enter First name");
        }
        if (lastname.getText() != null && !firstname.getText().isEmpty()){
            ln=true;
        }else {
            errorlabel.setTextFill(Color.RED);
            errorlabel.setText("Must enter Last name");
        }
        if (usr && pwd && fn && ln){
            errorlabel.setTextFill(Color.GREEN);
            errorlabel.setText("Sign Up Successful");
//            User individual = new Individual(firstname.getText(),lastname.getText(), rand.nextInt(1000));
//            System.out.println(individual.getFirstname());
//            System.out.println(individual.getLastname());
            //PrintWriter outputStream = new PrintWriter(new FileWriter("users.txt"));
        }
    }

    public void clicked_SignUpBus(javafx.scene.input.MouseEvent me) throws IOException {

    }

}
