package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 */
public class SignUpController implements Initializable {

    Random rand = new Random();
    @FXML
    private Pane pane;
    @FXML
    private TextField username, firstname, lastname;
    @FXML
    private PasswordField password, bpassword, dpassword;
    @FXML
    private TextField businessname, busername, bstreet, bpostcode;
    @FXML
    private TextField dusername, dfirstname, dlastname;
    @FXML
    private Label errorlabel, errorlabel2, errorlabel3;
    @FXML
    private TextArea bdescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UserList.getInstance();
    }

    public void clicked_SignUpInd() throws SQLException{

        if(firstname.getText().isEmpty()||lastname.getText().isEmpty()) errorlabel.setText("First name or Surname cannot be empty");
        if(password.getText().isEmpty()) errorlabel.setText("Password cannot be empty");
        if(username.getText().isEmpty()){
            errorlabel.setText("Username cannot be empty");
            return;
        }
        System.out.println(UserList.getInstance());
        boolean exists = UserList.getInstance().isUsernameTaken(username.getText());

        if(exists) errorlabel.setText("Username is already registered to an account, please enter a different one.");
        else{
            //loginModel.addToDB(firstname.getText(), lastname.getText(), username.getText(), password.getText(), "I");
            errorlabel.setTextFill(Color.GREEN);
            errorlabel.setText("You have registered successfully! Click back and you can log in.");
            UserList.getInstance().addUser(new Individual(firstname.getText(), lastname.getText(), username.getText(), password.getText()));
        }
    }

    public void clicked_SignUpBus() throws SQLException {
        if (busername.getText().isEmpty()) errorlabel2.setText("First name or Surname cannot be empty");
        if(bpassword.getText().isEmpty()) errorlabel2.setText("Password cannot be empty");
        if(businessname.getText().isEmpty()){
            errorlabel2.setText("Username cannot be empty");
            return;
        }
        boolean exists = UserList.getInstance().isUsernameTaken(busername.getText());

        if(exists) errorlabel2.setText("Username is already registered to an account, please enter a different one.");
        else{
            //loginModel.addToDB(bfirstname.getText(), blastname.getText(), businessname.getText(), bpassword.getText(), "B");
            errorlabel2.setTextFill(Color.GREEN);
            errorlabel2.setText("You have registered successfully! Click back and you can log in.");
            UserList.getInstance().addUser(new Business(businessname.getText(), busername.getText(), bpassword.getText(), bdescription.getText(), bstreet.getText(), bpostcode.getText()));
        }
    }

    public void clicked_SignUpDri() throws SQLException {
        if(dfirstname.getText().isEmpty()||dlastname.getText().isEmpty()) errorlabel3.setText("First name or Surname cannot be empty");
        if(dpassword.getText().isEmpty()) errorlabel3.setText("Password cannot be empty");
        if(dusername.getText().isEmpty()){
            errorlabel3.setText("Username cannot be empty");
            return;
        }
        // boolean exists = loginModel.checkUsername(dusername.getText());
        boolean exists = UserList.getInstance().isUsernameTaken(dusername.getText());


        if(exists) errorlabel3.setText("Username is already registered to an account, please enter a different one.");
        else{
            //loginModel.addToDB(dfirstname.getText(), dlastname.getText(), dusername.getText(), dpassword.getText(), "D");
            errorlabel3.setTextFill(Color.GREEN);
            errorlabel3.setText("You have registered successfully! Click back and you can log in.");
            UserList.getInstance().addUser(new Driver(dfirstname.getText(), dlastname.getText(), dusername.getText(), dpassword.getText()));
        }
    }


}
