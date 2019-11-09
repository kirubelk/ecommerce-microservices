package edu.mum.ea.creditcard_service.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.mum.ea.creditcard_service.Models.CreditCard;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/creditcard")
public class CreditCardController {
    
    RestTemplate template = new RestTemplate();

    @GetMapping()
    public CreditCard getCreitCard(){
        CreditCard cc = new CreditCard("Credit Card", "Heloo !!!!! I am Credit Card, You have Succesfully used Credit card");
        return cc;
    }


}