/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private Pane contentArea;

    @FXML
    private void clicked_SearchName(javafx.scene.input.MouseEvent ME) throws IOException {

        Parent fxml = FXMLLoader.load(getClass().getResource("/views/SearchName.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    private void clicked_SearchCategory(javafx.scene.input.MouseEvent ME) throws IOException {

        Parent fxml = FXMLLoader.load(getClass().getResource("/views/SearchCategory.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    private void feedMe() {
        //Search postcode rahat.
    }



}
