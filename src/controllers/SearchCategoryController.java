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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class SearchCategoryController implements Initializable {


    @FXML
    private Pane contentArea;

    @FXML
    private JFXTextField searchField;

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
    private void clicked_Name(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/views/SearchName.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);

    }

    @FXML
    private void search() throws IOException {
        String[] searchTerms = searchField.getText().split(",");
        ArrayList<String> searchCategories = new ArrayList<String>(Arrays.asList(searchTerms));
        BusinessList.getInstance().searchByCategory(searchCategories);

        Parent fxml = FXMLLoader.load(getClass().getResource("/views/EatIn.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
}