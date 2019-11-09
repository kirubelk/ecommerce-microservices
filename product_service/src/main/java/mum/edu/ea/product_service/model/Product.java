package mum.edu.ea.product_service.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    
    @Id
    private Integer productId;


    private String productName;
    private String productDesc;
    private String productCatgory;
    private Double price;
    private String soldBy;
    private Integer catredFlag;


    public Product() {
    }


    public Product(Integer productId, String productName, String productDesc, String productCatgory, Double price, String soldBy, Integer catredFlag) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productCatgory = productCatgory;
        this.price = price;
        this.soldBy = soldBy;
        this.catredFlag = catredFlag;
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

    public Integer getCatredFlag() {
        return this.catredFlag;
    }

    public void setCatredFlag(Integer catredFlag) {
        this.catredFlag = catredFlag;
    }
    

}