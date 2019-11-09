package mum.edu.ea.product_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.edu.ea.product_service.model.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>{
    
}