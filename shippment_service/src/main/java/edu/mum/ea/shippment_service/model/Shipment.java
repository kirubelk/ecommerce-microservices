package edu.mum.ea.shippment_service.model;

public class Shipment {

    private String message;


    public Shipment() {
    }

    public Shipment(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Shipment message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            "}";
    }

}