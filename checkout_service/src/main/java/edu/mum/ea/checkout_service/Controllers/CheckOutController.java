package edu.mum.ea.checkout_service.Controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.mum.ea.checkout_service.Models.BanckAccount;
import edu.mum.ea.checkout_service.Models.CheckOut;
import edu.mum.ea.checkout_service.Models.CheckOutWrapper;
import edu.mum.ea.checkout_service.Models.CreditCard;
import edu.mum.ea.checkout_service.Models.PayPal;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/checkOut")
public class CheckOutController {
    
    @Autowired
    private RestTemplate template;
    
    List<CheckOut> list = Arrays.asList(
                new CheckOut("PAYPAL METHOD", "paypal", "This paypal method for the payment type, if you wish to use, Remove paymentOptions and Append paypal url"),
                new CheckOut("CREDITCARD METHOD", "creditcard", "This creditcard method for thr payment, if you wish to use, Remove paymentOptions and Append creditcard url"),
                new CheckOut("BANK ACCOUNT METHOD", "bankaccount", "This bank Acount method for thr payment, if you wish to use, Remove paymentOptions and Append bankacount url")
            );

    @GetMapping("/paymentOptions")
    public List<CheckOut> getcheckOutOptions(){
        return list;
    }


    @GetMapping("/paypal")
    public PayPal makePaypalPayment(){
        PayPal pp = template.getForObject("http://localhost:8085/paypal", PayPal.class);
        return pp;
    }

    @GetMapping("/creditcard")
    public CreditCard makeCreditCardPayment(){
        CreditCard cc = template.getForObject("http://localhost:8086/creditcard", CreditCard.class);
        return cc;
    }

    @GetMapping("/bankaccount")
    public BanckAccount makeBankAccountPayment(){
        BanckAccount ba = template.getForObject("http://localhost:8087/bankAccount", BanckAccount.class);
        return ba;
    }


    @GetMapping("/payments")
    public CheckOutWrapper getpaymentMethods(){
        CheckOutWrapper wrapper = new CheckOutWrapper();
        wrapper.setCheckOutWrappers(list);
        return wrapper;
    }

}