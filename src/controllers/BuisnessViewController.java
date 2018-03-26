


package controllers;

import com.sun.org.apache.xml.internal.security.Init;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Business;
import model.UserList;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuisnessViewController implements Initializable{
    @FXML
    private BorderPane parent;
    @FXML
    private Pane contentArea;


    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("/views/BusinessItemList.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        }
        catch (Exception t)
        {

        }
    }

    @FXML
    private void menu(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/BusinessItemList.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    private void orders(ActionEvent event) throws IOException {
        System.out.println("Show logIn screen");

        Parent fxml = FXMLLoader.load(getClass().getResource("/views/EatIn.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }


}

