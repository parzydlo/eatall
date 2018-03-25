package controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.BusinessList;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchNameController implements Initializable {


    @FXML
    private Pane contentArea;

    @FXML
    private JFXTextField input;

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }

    @FXML
    private void clicked_SearchPostcode(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);

    }

    @FXML
    private void clicked_Category(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/SearchCategory.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);

    }

    @FXML
    private void search(MouseEvent event) throws IOException {

        BusinessList.getInstance().searchByName(input.getText());
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/EatIn.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);

    }


}