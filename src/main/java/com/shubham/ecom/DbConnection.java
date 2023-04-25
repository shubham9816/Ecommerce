package com.shubham.ecom;

import javax.xml.transform.Result;
import java.sql.*;

public class DbConnection {
    private final String dbUrl = "jdbc:mysql://localhost:3306/ecommerce";
    private final String userName ="root";
    private final String password = "0852";

    private Statement getStatement(){
        try{
            Connection connection = DriverManager.getConnection(dbUrl,userName,password);
            return connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getQueryTable(String query){

        try{
            Statement statement = getStatement();
            assert statement != null;
            return statement.executeQuery(query);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int updateDatabase(String query){
        try{
            Statement statement = getStatement();
            return statement.executeUpdate(query);

        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        DbConnection conn = new DbConnection();
        ResultSet rs = conn.getQueryTable("SELECT * FROM customer");

        if(rs != null){
            System.out.println("Connection Successful");
        }else{
            System.out.println("Connection Failed");
        }
    }
}
