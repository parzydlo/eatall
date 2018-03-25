package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.SignUpModel;
import model.UserList;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
            String username = usrname.getText();
            String password = pword.getText();
        boolean data = UserList.getInstance().verifyCredentials(username, password);
        if (data) {
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

    }


}
