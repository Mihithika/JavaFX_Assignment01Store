package controller;


import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Item;

import java.io.IOException;




public class ItemFormController {

    public TextField txtid;
    public TextField txtname;
    public TextField txtquantity;
    public TextField txtprice;
    public TextArea txtdesc;
    public TableView tblItems;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colQnty;
    public TableColumn colPrice;
    public TableColumn colDesc;


    public void AddItemOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String name = txtname.getText();
        Integer quantity = Integer.parseInt( txtquantity.getText());
        Double price = Double.parseDouble(txtprice.getText());
        String desc = txtdesc.getText();


        Item item = new Item(id, name, quantity, price, desc);
        DBConnection.getInstance().getDBList().add(item);
        loadTable();

    }

    private void loadTable() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQnty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));


        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();

        DBConnection.getInstance().getDBList().forEach(item -> {
            itemObservableList.add(item);
        });

        tblItems.setItems(itemObservableList);
    }

    public void btnViewListOnAction(ActionEvent actionEvent)throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/ViewAllItems.fxml"))));
        stage.show();
        }
    }



