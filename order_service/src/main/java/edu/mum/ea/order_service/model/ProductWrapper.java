package edu.mum.ea.order_service.model;

import java.util.List;

public class ProductWrapper {

    private List<Product> productList;


    public ProductWrapper(List<Product> productList) {
        this.productList = productList;
    }

    public ProductWrapper() {
    }
    

    public List<Product> getProductList() {
        return this.productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}