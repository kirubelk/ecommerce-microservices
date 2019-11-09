package mum.edu.ea.product_service.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mum.edu.ea.product_service.model.Product;
import mum.edu.ea.product_service.model.ProductWrapper;
import mum.edu.ea.product_service.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductController {

        private ProductService service;


     List<Product> products = Arrays.asList(
       new Product(1, "MacBook Air", "Best Computer for the development", "Computer", 1456.89, "Apple", null),
       new Product(2, "S 10", "Best mobile company ", "mobile", 1000.9, "Samsung", null),
       new Product(3, "Nike 200", "new nike shoe ", "Shoe", 389.00, "Nike .plc", null),
       new Product(4, "pc bag", "laptop bag ", "laptops", 56.00, "Ethio Farm", null) 
     );



        @Autowired
        public ProductController (ProductService service){
             this.service = service;
        }

        @GetMapping("/list")
        public List<Product> getProducts(){
           return service.getAllProducts();
        }

        @GetMapping("/{proudtId}")
        public Product getProductInf(@PathVariable("proudtId") Integer pID){
             return service.getProductById(pID);
        }

        @GetMapping("/carted")
        public ProductWrapper getCartedProduct(){
             ProductWrapper wrapper = new ProductWrapper();
             wrapper.setProductList(service.getCatredProducts());
             return wrapper;
        }

        @PostMapping("/add")
        public String addProductsToDatabase(){

          for(Product p : products){
               service.addProduct(p);
          }
             return "you have succesfully added the products";
        }

        @PostMapping("/addtocart/{productId}")
        public String addToCart(@PathVariable("productId")Integer productId){
          Product pp = service.getProductById(productId);
          pp.setCatredFlag(1);
          service.addProduct(pp);
          return "you have succesfully added the product to the cart";
        }


     //    @GetMapping("/test")
     //    public List<Product> getcarted(){
     //         return service.getCatredProducts();
     //    }

}