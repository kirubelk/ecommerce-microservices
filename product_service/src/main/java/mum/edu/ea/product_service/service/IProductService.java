package mum.edu.ea.product_service.service;

import java.util.List;

import mum.edu.ea.product_service.model.Product;

public interface IProductService {

    List<Product> getAllProducts();
    Product getProductById(Integer pID);
    List<Product> getCatredProducts();
    Product addProduct (Product product);
}