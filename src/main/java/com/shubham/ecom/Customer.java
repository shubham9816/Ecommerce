package com.shubham.ecom;

public class Customer {
    private int id;
    private String  name, email, mobile, password, address;

    public Customer(int id, String name, String email, String mobile, String password, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setAddress(String address){
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }
    public String getPassword(){
        return password;
    }
    public String getAddress(){
        return address;
    }
}
