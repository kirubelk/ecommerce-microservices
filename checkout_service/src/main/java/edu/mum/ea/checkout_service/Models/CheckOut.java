package edu.mum.ea.checkout_service.Models;


public class CheckOut {

    private String paymentMethod;
    private String url;
    private String message;


    public CheckOut() {
    }


    public CheckOut(String paymentMethod, String url, String message) {
        this.paymentMethod = paymentMethod;
        this.url = url;
        this.message = message;
    }


    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}