package com.shubham.ecom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.security.AllPermission;
import java.sql.ResultSet;

public class OrderList {
    private TableView<Order> orderTable;

    private VBox createOrderTable(ObservableList<Order> data){
        TableColumn productName = new TableColumn("Product Name");
        productName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn id = new TableColumn("Order ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn quantity = new TableColumn("Quantity");
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn order_Date = new TableColumn("Order Date");
        order_Date.setCellValueFactory(new PropertyValueFactory<>("order_date"));

        TableColumn order_Status = new TableColumn("Delivery Status");
        order_Status.setCellValueFactory(new PropertyValueFactory<>("order_status"));

//        TableColumn quantity = new TableColumn("Quantity");
//        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        orderTable = new TableView<>();
        orderTable.setItems(data);
        orderTable.getColumns().addAll(productName, id, quantity, order_Date, order_Status);
        orderTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(orderTable);
        return vBox;
    }

    public VBox getAllOrders(int id){
        ObservableList<Order> data = Order.getAllOrders(id);
        return createOrderTable(data);
    }

//    public VBox getDummyTable(){
//        ObservableList<Product> data = FXCollections.observableArrayList();
//        data.add(new Product(2,"Iphone",44500));
//        data.add(new Product(4, "Laptop", 75000));
//        return createTable(data);
//    }
//    public static ObservableList<Order> getAllOrders (int customerId){
//        String selectOrderQuery = "SELECT product.name, orders.id, orders.quantity, order_date,delivery_status FROM orders join product on product_id = product.id WHERE customer_id="+customerId+")";
//        return fetchOrderData(selectOrderQuery);
//    }
//
//    private static ObservableList<Order> fetchOrderData(String query) {
//        ObservableList<Order> data = FXCollections.observableArrayList();
//        DbConnection dbConnection = new DbConnection();
//        try{
//            ResultSet rs = dbConnection.getQueryTable(query);
//            while(rs.next()){
//                Order order = new Order(rs.getString("name"),rs.getInt("id"), rs.getInt("quantity"), rs.getDate("order_date"),rs.getString("order_status"));
//                data.add(order);
//            }
//            return data;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }

}
