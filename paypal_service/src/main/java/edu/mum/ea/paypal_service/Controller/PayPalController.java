package edu.mum.ea.paypal_service.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.mum.ea.paypal_service.Models.PayPal;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/paypal")
public class PayPalController {
    
    RestTemplate template = new RestTemplate();

    @GetMapping()
    public PayPal getPayPal(){
        PayPal pp = new PayPal("PayPal", "Hello !!!!!!! I am payPal. You have succesfully used paypal");
        return pp;
    }


}