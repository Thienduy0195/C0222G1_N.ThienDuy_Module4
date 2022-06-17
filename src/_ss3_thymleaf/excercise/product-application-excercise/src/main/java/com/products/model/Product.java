package com.products.model;

public class Product {
    private Integer productId;
    private String productName;
    private Integer productPrice;
    private String productDescription;
    private String productFirm;

    public Product() {
    }

    public Product(String productName) {
        this.productName = productName;
    }

    public Product(Integer productId, String productName, Integer productPrice, String productDescription, String productFirm) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productFirm = productFirm;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductFirm() {
        return productFirm;
    }

    public void setProductFirm(String productFirm) {
        this.productFirm = productFirm;
    }
}
