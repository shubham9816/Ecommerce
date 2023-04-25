package com.shubham.ecom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.jar.Attributes;

public class UserInterface {
    GridPane loginPage;
    GridPane signupPage;
    HBox headerBar;
    HBox footerBar;

    Button signInButton;
    Button signUp;

    Button ordersButton;
    Label welcomeLabel;

    VBox body;
    Customer loggedInCustomer;

    ProductList  productList = new ProductList();
    OrderList orderList = new OrderList();
    VBox productPage;

    Button placeOrderButton  = new Button("Place Order");

    ObservableList<Product> itemsInCart = FXCollections.observableArrayList();
    public BorderPane createContent(){
        BorderPane root = new BorderPane();
        root.setPrefSize(800,600);
        //root.getChildren().add(loginPage);
        //root.setCenter(loginPage);
        //top header
        root.setTop(headerBar);
        //body
        body = new VBox();
        body.setPadding(new Insets(10));
        body.setAlignment(Pos.CENTER);
        root.setCenter(body);
        productPage = productList.getAllProducts();
        body.getChildren().add(productPage);
        // footer
        root.setBottom(footerBar);

        return root;
    }
    public UserInterface(){
        createSignupPage();
        createLoginPage();
        createHeaderBar();
        createFooterBar();
    }

    private void createLoginPage(){
        Text userNameText = new Text("User Name");
        Text passwordText = new Text("Password");

        TextField userName = new TextField();
        userName.setPromptText("Enter your user name here");
        PasswordField password = new PasswordField();
        password.setPromptText("Enter your password here");
        Label messageLable = new Label("Click On Login Button");
        Button loginButton = new Button("Login");


        loginPage = new GridPane();
       // loginPage.setStyle("-fx-background-color: grey;");
        loginPage.setHgap(10);
        loginPage.setVgap(10);
        loginPage.setAlignment(Pos.CENTER);
        loginPage.add(userNameText,0, 0);
        loginPage.add(userName,1,0);
        loginPage.add(passwordText,0,1);
        loginPage.add(password,1,1);
        loginPage.add(messageLable,1,2);
        loginPage.add(loginButton,1,3);

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = userName.getText();
                String pass = password.getText();
                Login login = new Login();
                loggedInCustomer = login.customerLogin(name,pass);
                if(loggedInCustomer!=null){
                    messageLable.setText("Welcome "+ loggedInCustomer.getName());
                    welcomeLabel.setText("Welcome "+ loggedInCustomer.getName());
//                    headerBar.getChildren().add(welcomeLabel);
                    headerBar.getChildren().remove(signUp);
                    body.getChildren().clear();
                    body.getChildren().add(productPage);
                    footerBar.setVisible(true);

                }else{
                    messageLable.setText("LogIn Failed !! please enter correct username and password.");
                }
            }
        });


    }
    private void createSignupPage(){
        Text NameText = new Text("Name");
        Text EmailText = new Text("Email");
        Text MobileText = new Text("Mobile");
        Text PasswordText = new Text("Password");
        Text AddressText = new Text("Address");

        TextField Name = new TextField();
        Name.setPromptText("Enter your name here");
        TextField Email = new TextField();
        Email.setPromptText("Enter your Email here");
        TextField Mobile = new TextField();
        Mobile.setPromptText("Enter your Mobile here");
        PasswordField Password = new PasswordField();
        Password.setPromptText("Enter your password here");
        TextField Address = new TextField();
        Address.setPromptText("Enter your Address here");

//        Label messageLable = new Label("Click On Login Button");
        Button signUpButton = new Button("Sign Up");

        signupPage = new GridPane();
        // loginPage.setStyle("-fx-background-color: grey;");
        signupPage.setHgap(10);
        signupPage.setVgap(10);
        signupPage.setAlignment(Pos.CENTER);
        signupPage.add(NameText,0, 0);
        signupPage.add(Name,1,0);
        signupPage.add(EmailText,0,1);
        signupPage.add(Email,1,1);
        signupPage.add(MobileText,0,2);
        signupPage.add(Mobile,1,2);
        signupPage.add(PasswordText,0,3);
        signupPage.add(Password,1,3);
        signupPage.add(AddressText,0,4);
        signupPage.add(Address,1,4);

        signupPage.add(signUpButton,1,5);

        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = Name.getText();
                String email = Email.getText();
                String mobile = Mobile.getText();
                String password = Password.getText();
                String address = Address.getText();

                boolean signUpStatus = Signup.signUpFn(name,email,mobile,password,address);

                if(signUpStatus==true){
                    showDialog("Sign Up Successful. Please Login!");

                }else{
                    showDialog("Sign Up Failed!!");
                    return;
                }
            }
        });

    }

    private void createHeaderBar(){
        Button homeButton = new Button();
        Image image = new Image("C:\\Users\\Shubham\\IdeaProjects\\Ecom\\src\\img_1.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(80);
        homeButton.setGraphic(imageView);

        TextField searchBar = new TextField();
        searchBar.setPromptText("Search here");
        searchBar.setPrefWidth(250);

        Button searchButton = new Button("Search");

        signInButton = new Button("Sign In");
        welcomeLabel = new Label();

        signUp = new Button("Sign Up");

        Button cart =  new Button("Cart");

        ordersButton = new Button("Orders");


        headerBar = new HBox();
        headerBar.setPadding(new Insets(10));
        headerBar.setSpacing(10);
        headerBar.setAlignment(Pos.CENTER);
        headerBar.getChildren().addAll(homeButton,searchBar,searchButton, signInButton,signUp, ordersButton, cart,welcomeLabel);

        signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                body.getChildren().clear();
                body.getChildren().add(loginPage);
                headerBar.getChildren().remove(signInButton);
                footerBar.setVisible(false);
            }
        });

        signUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                body.getChildren().clear();
                body.getChildren().add(signupPage);
                headerBar.getChildren().remove(signInButton);
                footerBar.setVisible(false);
            }
        });


        cart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                body.getChildren().clear();
                VBox productPage = productList.getProductInCart(itemsInCart);
                productPage.setSpacing(10);
                productPage.setAlignment(Pos.CENTER);
                productPage.getChildren().add(placeOrderButton);
                body.getChildren().add(productPage);
                footerBar.setVisible(false);
            }
        });

        ordersButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(loggedInCustomer == null){
                    showDialog("Please login first to view orders");
                    return;
                }
                body.getChildren().clear();
                VBox orderPage = orderList.getAllOrders(loggedInCustomer.getId());
//                System.out.print(loggedInCustomer.getId());
                body.getChildren().add(orderPage);
                footerBar.setVisible(false);
            }
        });

        placeOrderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                    if(itemsInCart==null){
                        //show message;
                        showDialog("Please Add some product first in the cart to place order!");
                        return;
                    }
                    if(loggedInCustomer==null){
                        showDialog("Please login first to place your order!");
                        return;
                    }
                    int count = Order.placeMultipleOrder(loggedInCustomer, itemsInCart);
                    if(count!=0){
                        showDialog("Your Order is Placed Successfully!!");
                        itemsInCart.clear();
                    }else{
                        showDialog("Order Failed!!");
                    }
            }
        });

        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                body.getChildren().clear();
                body.getChildren().add(productPage);
                footerBar.setVisible(true);
                if(loggedInCustomer==null) {
                    if(headerBar.getChildren().indexOf(signInButton)==-1){
                        headerBar.getChildren().add(signInButton);
                    }
                }
                if(loggedInCustomer!=null){
                    if(headerBar.getChildren().indexOf(signUp)==-1){
                        headerBar.getChildren().add(signUp);
                    }
                    headerBar.getChildren().remove(signUp);
                }

            }
        });

    }
    private void createFooterBar(){
        Button buyNow = new Button("Buy Now");
        Button addToCart = new Button("Add to Cart");

        footerBar = new HBox();
        footerBar.setPadding(new Insets(10));
        footerBar.setSpacing(10);
        footerBar.setAlignment(Pos.CENTER);
        footerBar.getChildren().addAll(buyNow, addToCart);

        buyNow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Product product = productList.getSelectedProduct();
                if(product==null){
                    //show message;
                    showDialog("Please select a product first to place your order!");
                    return;
                }
                if(loggedInCustomer==null){
                    showDialog("Please login first to place your order!");
                    return;
                }
                boolean status = Order.placeOrder(loggedInCustomer, product);
                if(status==true){
                    showDialog("Your Order is Placed Successfully!!");
                }else{
                    showDialog("Order Failed!!");
                }
            }
        });

        addToCart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Product product = productList.getSelectedProduct();
                if(product==null){
                    //show message;
                    showDialog("Please select a product to Add to Cart!");
                    return;
                }
                itemsInCart.add(product);
                showDialog("Product Successfully Added to Cart!!");
            }
        });


    }
    private void showDialog(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.setTitle("Message");
        alert.showAndWait();
    }
}
