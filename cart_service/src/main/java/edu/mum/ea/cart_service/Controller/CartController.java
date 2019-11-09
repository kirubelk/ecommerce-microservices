package edu.mum.ea.cart_service.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.mum.ea.cart_service.Models.Product;
import edu.mum.ea.cart_service.Models.ProductWrapper;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/cart")
public class CartController {  

    @Autowired
    private RestTemplate template;
 
    List<Product> finalList;

    @GetMapping("/list")
    public List<Product> getAllCatredProducts(){
        ProductWrapper wrapper = template.getForObject("http://localhost:8081/products/carted", ProductWrapper.class);
        finalList = wrapper.getProductList();
        return wrapper.getProductList();
    }
 
    @GetMapping("/remove/{productId}")
    public List<Product> removeProduct(@PathVariable("productId")Integer productId){
        List<Product> removed = finalList;

        for(Product product : removed){
            if(product.getProductId() == productId){
                removed.remove(product);                
            }

        }
        return removed;
    }

    @GetMapping("/final")
    public ProductWrapper getFinalProduct(){
       ProductWrapper wrapper = new ProductWrapper();
       wrapper.setProductList(finalList);
        return wrapper;
    }

}