package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;

import java.util.Arrays;

public class ViewItemController {


    public TableView tblView;
    public TableColumn colViewID;
    public TableColumn colViewName;
    public TableColumn colViewQnty;
    public TableColumn colViewPrice;
    public TableColumn colViewDesc;





    public void btnReloadOnAction(ActionEvent actionEvent) {

        loadTable();


    }

    private void loadTable() {
        colViewID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colViewName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colViewQnty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colViewPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colViewDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));


        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();

        DBConnection.getInstance().getDBList().forEach(item -> {
            itemObservableList.add(item);
        });

        tblView.setItems(itemObservableList);
    }
@FXML
    public void btnRemoveOnAction(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<Item> selectionModel = tblView.getSelectionModel();
        if(selectionModel.isEmpty()){
            System.out.println("An Item is not Selected...");
        }

        ObservableList<Integer> list = selectionModel.getSelectedIndices();
        Integer[] selectedIndices = new Integer[list.size()];
        selectedIndices = list.toArray(selectedIndices);

        Arrays.sort(selectedIndices);

        for(int i = selectedIndices.length - 1;i>=0;i--) {
            selectionModel.clearSelection(selectedIndices[i].intValue());
            tblView.getItems().remove(selectedIndices[i].intValue());
        }
        }
    }

