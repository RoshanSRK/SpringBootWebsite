package com.example.demo.product;

//import com.example.demo.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner commandLineRunnerP(ProductRepository pRepository){
        pRepository.flush();
        return null;
    }
}
