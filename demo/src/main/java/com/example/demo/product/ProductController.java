package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path= "api/v1/user")
public class ProductController {
@Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin
    @GetMapping("/allproducts")
    public List<Product> getProducts(){ return productService.getProducts();}

    @CrossOrigin
    @GetMapping("/mobilephones")
    public List<Product> getMobile(){ return productService.getMobile();}

    @CrossOrigin
    @GetMapping("/wearables")
    public List<Product> getWearable(){ return productService.getWearable();}

    @CrossOrigin
    @GetMapping("/chargers")
    public List<Product> getCharger(){ return productService.getCharger();}
    @CrossOrigin
    @GetMapping("/other")
    public List<Product> getOther(){ return productService.getOther();}

    @CrossOrigin
    @GetMapping("/product/{prodId}")
    public Product getProductDetails(@PathVariable("prodId") Long prodId){
        return productService.getProductDetails(prodId);}


}
