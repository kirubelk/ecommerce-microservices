package edu.mum.ea.checkout_service.Models;

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