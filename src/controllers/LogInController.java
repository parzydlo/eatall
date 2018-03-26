package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.*;

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
            errorlabel.setTextFill(Color.GREEN);
            errorlabel.setText("Login Successful");
            UserList.getInstance().setLoggedInUser(UserList.getInstance().getUserWithCredentials(username, password));

            if(UserList.getInstance().getLoggedInUser() instanceof Business)
            {
                //Load buisness view
                try {
                    System.out.println("loadme");
                    Parent root = FXMLLoader.load(getClass().getResource("/views/BuisnessView.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                }
                catch (Exception t)
                {
                    System.out.println(t.getStackTrace());
                }
            }

        } else if (username.equals("") || password.equals("")) {
            errorlabel.setText("Username or password cannot be blank.");
        } else errorlabel.setText("Incorrect username or password. Please try again.");

    }


}
