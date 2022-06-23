package com.products.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotEmpty
    @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid name of product!")
    private String productName;

    @NotEmpty
    @Pattern(regexp = "^[0-9]+$", message = "Invalid product price!")
    private String productPrice;

    private String productDescription;

    @NotEmpty
    @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid firm of product!")
    private String productFirm;

    public Product() {
    }

    public Product(Long productId, @NotEmpty @Pattern(regexp = "^[A-Za-z ]{1,4}$", message = "Invalid name of product!") String productName, @NotEmpty @Pattern(regexp = "^[0-9]$", message = "Invalid product price!") String productPrice, String productDescription, @NotEmpty @Pattern(regexp = "^[A-Za-z ]{1,4}$", message = "Invalid firm of product!") String productFirm) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productFirm = productFirm;
    }

    public Product(@NotEmpty @Pattern(regexp = "^[A-Za-z ]{1,4}$", message = "Invalid name of product!") String productName, @NotEmpty @Pattern(regexp = "^[0-9]$", message = "Invalid product price!") String productPrice, String productDescription, @NotEmpty @Pattern(regexp = "^[A-Za-z ]{1,4}$", message = "Invalid firm of product!") String productFirm) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productFirm = productFirm;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
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
