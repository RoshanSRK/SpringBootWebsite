package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){this.productRepository = productRepository;}

    public List<Product> getProducts(){ return productRepository.findAll();}

    public void addNewProduct(Product product){
        Optional<Product> productOptional = productRepository.findProductByProductName(product.getProductName());

        if(productOptional.isPresent()){
            throw new IllegalStateException("Product already exists");
        }

        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            throw new IllegalStateException("Product with product id " + productId  + " does not exist");

        }
        productRepository.deleteById(productId);
    }


}
