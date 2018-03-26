package controllers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import model.Business;
import model.Item;
import model.UserList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class BusinessItemListController implements Initializable {


    @FXML
    private TableColumn<Item, Integer> QuantityCol;

    @FXML
    private TableColumn<Item, Double> PriceCol;

    @FXML
    private TextField itemName, itemPrice, itemQuantity;

    @FXML
    private TableView<Item> tableView;

    @FXML
    private TextArea itemDescription;

    @FXML
    private TableColumn<Item, String> ItemNameCol;

    @FXML
    private TableColumn<Item, String> descriptionCol;

    @FXML
    private TableColumn<Item, Boolean> availableCol;

    @FXML
    void changeItemPrice(TableColumn.CellEditEvent edittedCell) {
        Item itemSelected =  tableView.getSelectionModel().getSelectedItem();
        itemSelected.setCost(Double.parseDouble(edittedCell.getNewValue().toString()));
        UserList.getInstance().updateUserListFile();
    }

    @FXML
    void changeItemQuantity(TableColumn.CellEditEvent edittedCell) {
        Item itemSelected =  tableView.getSelectionModel().getSelectedItem();
        itemSelected.setQuantity(Integer.parseInt(edittedCell.getNewValue().toString()));
        UserList.getInstance().updateUserListFile();

    }

    @FXML
    void changeItemDes(TableColumn.CellEditEvent edittedCell) {
        Item itemSelected =  tableView.getSelectionModel().getSelectedItem();
        itemSelected.setDescription(edittedCell.getNewValue().toString());
        UserList.getInstance().updateUserListFile();
    }

    @FXML
    void changeItemAvail(TableColumn.CellEditEvent edittedCell) {
        System.out.println("tick");
    }

    @FXML
    void changeItemName(TableColumn.CellEditEvent edittedCell) {
        Item itemSelected =  tableView.getSelectionModel().getSelectedItem();
        itemSelected.setName(edittedCell.getNewValue().toString());
        UserList.getInstance().updateUserListFile();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        availableCol.setCellValueFactory(new PropertyValueFactory<Item, Boolean>("Available"));
        ItemNameCol.setCellValueFactory(new PropertyValueFactory<Item, String>("Name"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<Item, Double>("Cost"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("Quantity"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<Item, String>("Description"));

        //load dummy data

        ObservableList<Item> items = FXCollections.observableArrayList();
        for( Item i: ((Business)UserList.getInstance().getLoggedInUser()).getItems()){
            items.add(i);
            System.out.println("ITEM" + i.getName());

        }

        //Update the table to allow for the first and last name fields
        //to be editable
        tableView.setEditable(true);
        ItemNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        PriceCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        QuantityCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        availableCol.setCellFactory(column -> new CheckBoxTableCell<>());

        //This will allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        tableView.setItems(items);

        //Update the table to allow for the first and last name fields
        //to be editable
        tableView.setEditable(true);
        //firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
       // lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
       // birthdayColumn.setCellFactory(column -> new CheckBoxTableCell<>());

        //This will allow the table to select multiple rows at once
       // tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Disable the detailed person view button until a row is selected
      //  this.detailedPersonViewButton.setDisable(true);
    }

    @FXML
    public void newItemPressed(MouseEvent ME) throws IOException {

        Item newItem = new Item(itemName.getText(),Double.parseDouble(itemPrice.getText()),Integer.parseInt(itemQuantity.getText()),itemDescription.getText());
        ((Business)UserList.getInstance().getLoggedInUser()).addItem(newItem);

        //Get all the items from the table as a list, then add the new person to
        //the list
        tableView.getItems().add(newItem);

        for( Item i: ((Business)UserList.getInstance().getLoggedInUser()).getItems()){
            System.out.println("ITEM" + i.getName());

        }
    }


}
