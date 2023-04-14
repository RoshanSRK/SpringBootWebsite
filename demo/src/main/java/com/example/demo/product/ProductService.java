package com.example.demo.product;

import com.example.demo.user.User;
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


    public List<Product> getMobile() {
        List<Product> productFound =
                productRepository.findProductByProductCategory("P");

        if(!productFound.isEmpty()) {
            return productFound;
        }
        else{
            throw new IllegalStateException("No mobile phones found.");
        }
    }

    public List<Product> getWearable() {
//        return productRepository.findWearable();
        List<Product> productFound =
                productRepository.findProductByProductCategory("E");
        productFound.addAll(productRepository.findProductByProductCategory("H"));
        if(!productFound.isEmpty()) {
            return productFound;
        }
        else{
            throw new IllegalStateException("No wearables found.");
        }
    }
    public List<Product> getCharger() {
//        return productRepository
        List<Product> productFound =
                productRepository.findProductByProductCategory("C");

        if(!productFound.isEmpty()) {
            return productFound;
        }
        else{
            throw new IllegalStateException("No chargers found.");
        }
    }

    public List<Product> getOther() {
        List<Product> productFound =
                productRepository.findProductByProductCategory("O");

        if(!productFound.isEmpty()) {
            return productFound;
        }
        else{
            throw new IllegalStateException("No chargers found.");
        }
    }

}
