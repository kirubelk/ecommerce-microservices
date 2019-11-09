package edu.mum.ea.order_service.controller;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.mum.ea.order_service.Service.OrderService;
import edu.mum.ea.order_service.configuration.JwtRequestFilter;
import edu.mum.ea.order_service.model.BanckAccount;
import edu.mum.ea.order_service.model.CheckOut;
import edu.mum.ea.order_service.model.CheckOutWrapper;
import edu.mum.ea.order_service.model.CreditCard;
import edu.mum.ea.order_service.model.JwtResponse;
import edu.mum.ea.order_service.model.Order;
import edu.mum.ea.order_service.model.PayPal;
import edu.mum.ea.order_service.model.Product;
import edu.mum.ea.order_service.model.ProductWrapper;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/orders") 
public class OrderController {
    
    @Autowired
    private OrderService service;

    @Autowired
    private RestTemplate template;

    @Autowired
    private JwtRequestFilter requstgetter;

    private String tokenMap = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJraXJ1YmVsIiwiaWF0IjoxNTczMjU3NjcwLCJleHAiOjE1NzMyNTc3NTd9.P-tsfMhp4G-LYkPHdIXBvSrwYeOKO38fA_Xd4fW_2ab857WLHddjGu4PpRpjhO7oyxQVvfm3YZi30N9EfRrztA" ;


    List<Product> productList = new ArrayList<>();

    HttpHeaders headers = new HttpHeaders();

    @GetMapping("/generate/token")
    public ResponseEntity<?> generateToken(){
        return ResponseEntity.ok(new JwtResponse(tokenMap));
    }

    @GetMapping("/list")
    public List<Product> getAllOrders(){
        System.out.println("I am bing called");
        ProductWrapper wrapper = template.getForObject("http://localhost:8083/cart/final", ProductWrapper.class);
        System.out.println(wrapper.getProductList());
        productList = wrapper.getProductList();
        return wrapper.getProductList();
    }


     @GetMapping("/checkOut")
     public List<CheckOut> getPyments(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", tokenMap);
        HttpEntity<String> entity = new HttpEntity<String>(headers); 
        CheckOutWrapper wrapper = template.exchange("http://localhost:8084/checkOut/payments", HttpMethod.GET, entity,  CheckOutWrapper.class).getBody();
        return wrapper.getCheckOutWrappers();

     }

     @GetMapping("checkOut/paypal")
     public PayPal usePaypal(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", tokenMap);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

         PayPal pp = template.exchange("http://localhost:8084/checkOut/paypal", HttpMethod.GET, entity,  PayPal.class).getBody();
         return pp;
     }


     @GetMapping("checkOut/creditcard")
     public CreditCard useCreditCard(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", tokenMap);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        CreditCard cc = template.exchange("http://localhost:8084/checkOut/creditcard", HttpMethod.GET, entity, CreditCard.class).getBody();
         return cc;
     }


     @GetMapping("checkOut/bankaccount")
     public BanckAccount useBanckAccount(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", tokenMap);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
         BanckAccount ba = template.exchange("http://localhost:8084/checkOut/bankaccount",  HttpMethod.GET, entity, BanckAccount.class).getBody();
         return ba;
     }

     @GetMapping("/getordered")
     public List<Order> addedToOrder(){
         for(Product pp : productList){
             service.createOrder(new Order(1, requstgetter.username, pp.getProductName(), pp.getProductDesc(), pp.getSoldBy(), pp.getPrice()));
         }
        return service.getAllOrders();
     }


     @GetMapping("/shippment")
     public String getShippment(){
         return template.getForObject("http://localhost:8090/shipment", String.class);
     }

}