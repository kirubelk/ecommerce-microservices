package edu.mum.ea.bankaccoubt_service.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.mum.ea.bankaccoubt_service.Model.BanckAccount;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/bankAccount")
public class BankAccountController {
    
    RestTemplate template = new RestTemplate();

    @GetMapping()
    public BanckAccount getBankAccount(){
        BanckAccount bc = new BanckAccount("Bank Account", "Hello!!!!!! I am Bank Account Payment System, You Have Succesfully used Bank Account");
        return bc;
    }


}