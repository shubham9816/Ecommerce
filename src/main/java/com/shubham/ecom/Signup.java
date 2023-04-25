package com.shubham.ecom;

import java.sql.ResultSet;

public class Signup {
    public static boolean signUpFn(String Name, String Email, String Mobile, String Password, String Address) {
        String customerId = "SELECT max(id) +1 id FROM customer";

        DbConnection dbConnection = new DbConnection();
        try {
            ResultSet rs = dbConnection.getQueryTable(customerId);
            if (rs.next()) {
                String SignupQuery = "INSERT INTO customer(name,email, mobile, password, address) value('"+Name+"','"+Email+"','"+Mobile+"','"+Password+"','"+Address+"')";
                System.out.print(SignupQuery);
                return dbConnection.updateDatabase(SignupQuery) !=0;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

