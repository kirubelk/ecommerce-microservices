package edu.mum.ea.shippment_service.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/shipment")
public class ShipmentController {
    

    @GetMapping()
    public String successShipment(){
        return "Your orders hase beeen succesfully shipped to your address";
    }

}