package edu.mum.ea.cart_service.Models;

public class Product {
    
   
    private Integer productId;
    private String productName;
    private String productDesc;
    private String productCatgory;
    private Double price;
    private String soldBy;
    private Boolean catred;


    public Product() {
    }


    public Product(Integer productId, String productName, String productDesc, String productCatgory) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productCatgory = productCatgory;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return this.productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductCatgory() {
        return this.productCatgory;
    }

    public void setProductCatgory(String productCatgory) {
        this.productCatgory = productCatgory;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSoldBy() {
        return this.soldBy;
    }

    public void setSoldBy(String soldBy) {
        this.soldBy = soldBy;
    }


    public Boolean isCatred() {
        return this.catred;
    }

    public Boolean getCatred() {
        return this.catred;
    }

    public void setCatred(Boolean catred) {
        this.catred = catred;
    }

}