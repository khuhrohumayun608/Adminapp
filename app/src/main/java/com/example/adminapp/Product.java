package com.example.adminapp;

public class Product {
    private String id;
    private String productTitle;
    private String productDesc;
    private int productPrice;
    private int productAvlQty;
    private String productImg;
    private String productSize;

    public Product(String productTitle, int productPrice, String productImg) {
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.productImg = productImg;
    }

    public Product(String id, String productTitle, String productDesc, int productPrice, int productAvlQty, String productImg, String productSize) {
        this.id = id;
        this.productTitle = productTitle;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.productAvlQty = productAvlQty;
        this.productImg = productImg;
        this.productSize = productSize;
    }
    public Product(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductAvlQty() {
        return productAvlQty;
    }

    public void setProductAvlQty(int productAvlQty) {
        this.productAvlQty = productAvlQty;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }
}
