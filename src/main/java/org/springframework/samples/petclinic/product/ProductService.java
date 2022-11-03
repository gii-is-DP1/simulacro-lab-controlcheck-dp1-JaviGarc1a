package org.springframework.samples.petclinic.product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return this.productRepository.findByPriceLessThan(price);
    }

    @Transactional(readOnly = true)
    public ProductType getProductType(String typeName) {
        return this.productRepository.getProductType(typeName);
    }

    @Transactional
    public Product save(Product p){
        return productRepository.save(p);       
    }

    
}
