package com.example.adminapp;

import java.util.ArrayList;

public class Order {
    private String id;
    private String customerName;
    private String customerAddress;
    private String customerContact;
    private String productId;
    private ArrayList<Product> list;
    private int total;
    private String status;

    public Order(String id, String customerName, String customerAddress, String customerContact, String productId, ArrayList<Product> list) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerContact = customerContact;
        this.productId = productId;
        this.list = list;
    }

    public Order(String id, String customerName, String customerAddress, String customerContact, String productId, ArrayList<Product> list, int total, String status) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerContact = customerContact;
        this.productId = productId;
        this.list = list;
        this.total = total;
        this.status = status;
    }

    public Order() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public ArrayList<Product> getList() {
        return list;
    }

    public void setList(ArrayList<Product> list) {
        this.list = list;
    }


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
