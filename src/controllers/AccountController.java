package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
public class AccountController implements Initializable {
    
    Random rand = new Random();
    @FXML
    private Pane pane;
    @FXML
    private TextField firstname, lastname, username, udoor, ustreet, upostcode;
    @FXML
    private PasswordField password;
    @FXML
    private TextField businessname, busername, bstreet, bpostcode;
    @FXML
    private PasswordField bpassword;
    @FXML
    private TextArea bdescription;
    @FXML
    private Label errorlabel1, errorlabel2;
    @FXML
    private AnchorPane individualForm, businessForm, driverForm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User user = UserList.getInstance().getLoggedInUser();
        if (user == null) System.out.println("Cannot find account!");
        if (user instanceof Individual) {
            individualForm.setVisible(true);
            businessForm.setVisible(false);
//            driverForm.setVisible(false);
            System.out.println("Individual user.");
        } else if(user instanceof Business) {
            individualForm.setVisible(false);
            businessForm.setVisible(true);
//            driverForm.setVisible(false);
            System.out.println("Business user.");
        } else {
            individualForm.setVisible(false);
            businessForm.setVisible(false);
//            driverForm.setVisible(true);
            System.out.println("Driver user.");
        }
        prepareTextFields(user);
        System.out.println("Account Controller initialised.");
    }

    private void prepareTextFields(User user) {
        if (user instanceof Individual) {
            firstname.setPromptText(user.getName().split(" ")[0]);
            lastname.setPromptText(user.getName().split(" ")[1]);
            username.setPromptText(user.getUsername());
            udoor.setPromptText(((Individual) user).getDoor());
            ustreet.setPromptText(((Individual) user).getStreet());
            upostcode.setPromptText(((Individual) user).getPostcode());
        } else if (user instanceof Business) {
            businessname.setPromptText(((Business) user).getBusinessname());
            busername.setPromptText(user.getUsername());
            bpostcode.setPromptText(((Business) user).getPostcode());
            bstreet.setPromptText(((Business) user).getStreet());
            bdescription.setPromptText(((Business) user).getDescription());
        }
    }

    public void clicked_UpdateAccount() {
        System.out.println("Updating account...");
        User user = UserList.getInstance().getLoggedInUser();
        if (user == null) System.out.println("Cannot update non-existing account!");

        if (user instanceof Individual) {
            updateIndividual(user);
        } else if (user instanceof Business) {
            updateBusiness((Business) user);
        } else {
            updateDriver(user);
        }
    }

    public void clicked_RemoveAccount() {
        System.out.println("Removing account");
        User user = UserList.getInstance().getLoggedInUser();
        if (user == null) System.out.println("Cannot remove non-existing user!");

        UserList.getInstance().removeUser(user);
        errorlabel1.setTextFill(Color.GREEN);
        errorlabel1.setText("Account removed successfully!");
    }

    public void updateIndividual(User user) {
        System.out.println("Updating individual");
        if(firstname.getText().isEmpty()||lastname.getText().isEmpty()) errorlabel1.setText("First name or Surname cannot be empty");
        if(password.getText().isEmpty()) errorlabel1.setText("Password cannot be empty");
        if(username.getText().isEmpty()){
            errorlabel1.setText("Username cannot be empty");
            return;
        }
        user.setName(firstname.getText() + " " + lastname.getText());
        user.setUsername(username.getText());
        user.setPassword(password.getText());
        UserList.getInstance().updateUserListFile();
        errorlabel1.setTextFill(Color.GREEN);
        errorlabel1.setText("Account updated successfully!");
    }

    public void updateBusiness(Business user) {
        System.out.println("Updating business");
        if(businessname.getText().isEmpty()||busername.getText().isEmpty()) errorlabel2.setText("Business name cannot be empty");
        if(bpassword.getText().isEmpty()) errorlabel2.setText("Password cannot be empty");
        if(busername.getText().isEmpty()){
            errorlabel2.setText("Username cannot be empty");
            return;
        }
        user.setBusinessname(businessname.getText());
        user.setUsername(busername.getText());
        user.setPassword(bpassword.getText());
        user.setStreet(bstreet.getText());
        user.setPostcode(bpostcode.getText());
        user.setDescription(bdescription.getText());
        UserList.getInstance().updateUserListFile();
        errorlabel1.setTextFill(Color.GREEN);
        errorlabel1.setText("Account updated successfully!");
    }

    public void updateDriver(User user) {
        System.out.println("Updating driver");
    }


}
