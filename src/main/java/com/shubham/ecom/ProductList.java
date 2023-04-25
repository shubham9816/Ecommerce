package com.shubham.ecom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ProductList {
    private TableView<Product> productTable;

    private VBox createTable(ObservableList<Product> data){
        TableColumn id = new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn name = new TableColumn("NAME");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn price = new TableColumn("PRICE");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

//        TableColumn quantity = new TableColumn("Quantity");
//        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        productTable = new TableView<>();
        productTable.setItems(data);
        productTable.getColumns().addAll(id, name, price);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(productTable);
        return vBox;
    }

//    public VBox getDummyTable(){
//        ObservableList<Product> data = FXCollections.observableArrayList();
//        data.add(new Product(2,"Iphone",44500));
//        data.add(new Product(4, "Laptop", 75000));
//        return createTable(data);
//    }

    public VBox getAllProducts(){
        ObservableList<Product> data = Product.getAllProducts();
        return createTable(data);
    }

    public Product getSelectedProduct(){
       return productTable.getSelectionModel().getSelectedItem();
    }

    public VBox getProductInCart(ObservableList<Product> data){
        return createTable(data);
    }


}
