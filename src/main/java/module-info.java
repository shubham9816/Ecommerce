module com.shubham.ecom {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.shubham.ecom to javafx.fxml;
    exports com.shubham.ecom;
}