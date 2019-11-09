package edu.mum.ea.order_service.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer oID;

    private Integer quantity;
    private String userNameInfo;
    private String productName;
    private String productDesc;
    private String soldBy;
    private Double price;


    public Order() {
    }



    public Order(Integer quantity, String userNameInfo, String productName, String productDesc, String soldBy, Double price) {
        this.quantity = quantity;
        this.userNameInfo = userNameInfo;
        this.productName = productName;
        this.productDesc = productDesc;
        this.soldBy = soldBy;
        this.price = price;
    }
    

    public Integer getOID() {
        return this.oID;
    }

    public void setOID(Integer oID) {
        this.oID = oID;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUserNameInfo() {
        return this.userNameInfo;
    }

    public void setUserNameInfo(String userNameInfo) {
        this.userNameInfo = userNameInfo;
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

    public String getSoldBy() {
        return this.soldBy;
    }

    public void setSoldBy(String soldBy) {
        this.soldBy = soldBy;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }





}