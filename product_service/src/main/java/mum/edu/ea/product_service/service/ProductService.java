package mum.edu.ea.product_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.ea.product_service.Repository.ProductRepository;
import mum.edu.ea.product_service.model.Product;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository repo;

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public Product getProductById(Integer pID) {
        return repo.findById(pID).orElse(null);
    }

    @Override
    public List<Product> getCatredProducts() {
        List<Product> catred = new ArrayList<>();
        List<Product> finded = repo.findAll();
        for(Product pro : finded){
            if(pro.getCatredFlag() != null){
                catred.add(pro);
            }
        }
        return catred;
    }

    @Override
    public Product addProduct(Product product) {
        return repo.save(product);
    }
    
}