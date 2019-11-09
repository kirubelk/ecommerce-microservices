package edu.mum.ea.order_service.model;

import java.util.List;

public class CheckOutWrapper {

    List<CheckOut> checkOutWrappers;


    public CheckOutWrapper() {
    }

    public CheckOutWrapper(List<CheckOut> checkOutWrappers) {
        this.checkOutWrappers = checkOutWrappers;
    }

    public List<CheckOut> getCheckOutWrappers() {
        return this.checkOutWrappers;
    }

    public void setCheckOutWrappers(List<CheckOut> checkOutWrappers) {
        this.checkOutWrappers = checkOutWrappers;
    }
    
}