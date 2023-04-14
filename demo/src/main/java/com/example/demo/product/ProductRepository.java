package com.example.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE p.productName=?1")
    Optional<Product> findProductByProductName(String productName);

//   @Query("SELECT p FROM product p WHERE p.product_category LIKE 'P%' ")// ORDER BY FUNCTION('RAND')
//    Optional<Product> findMobile();
    @Query("SELECT p FROM Product p WHERE p.productCategory LIKE :productCategory% ")
    List<Product> findProductByProductCategory(@Param("productCategory") String productCategory);

//    @Query("SELECT p FROM Product p WHERE p.product_category LIKE 'E%' OR productCategory LIKE 'H%' ")
//    Optional<Product> findWearable();// ORDER BY FUNCTION('RAND')
//
//    @Query("SELECT p FROM Product p WHERE p.product_category LIKE 'C%' ")
//    Optional<Product> findCharger();// ORDER BY FUNCTION('RAND')
//
//    @Query("SELECT p FROM Product p WHERE p.product_category LIKE 'O%' ")
//    Optional<Product> findOther();// ORDER BY FUNCTION('RAND')
}
