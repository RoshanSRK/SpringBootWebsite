package com.example.demo.product;


import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @SequenceGenerator(
            name= "product-sequence",
            sequenceName = "product-sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product-sequence"
    )
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_desc")
    private String productDesc;
    @Column(name = "product_image1")
    private String productImage1;
    @Column(name = "product_image2")
    private String productImage2;
    @Column(name = "product_image3")
    private String productImage3;
    @Column(name = "product_price")
    private int productPrice;
    @Column(name = "product_category")
    private String productCategory;
    @Column(name = "qty_in_stock")
    private int qtyInStock;

    public Product() {
    }

    public Product(Long productId, String productName, String productDesc, String productImage1, String productImage2, String productImage3, int productPrice, String productCategory, int qtyInStock) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productImage1 = productImage1;
        this.productImage2 = productImage2;
        this.productImage3 = productImage3;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.qtyInStock = qtyInStock;
    }

    public Product(String productName, String productDesc, String productImage1, int productPrice) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.productImage1 = productImage1;
        this.productPrice = productPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductImage1() {
        return productImage1;
    }

    public void setProductImage1(String productImage1) {
        this.productImage1 = productImage1;
    }

    public String getProductImage2() {
        return productImage2;
    }

    public void setProductImage2(String productImage2) {
        this.productImage2 = productImage2;
    }

    public String getProductImage3() {
        return productImage3;
    }

    public void setProductImage3(String productImage3) {
        this.productImage3 = productImage3;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productImage1='" + productImage1 + '\'' +
                ", productImage2='" + productImage2 + '\'' +
                ", productImage3='" + productImage3 + '\'' +
                ", productPrice=" + productPrice +
                ", productCategory='" + productCategory + '\'' +
                ", qtyInStock=" + qtyInStock +
                '}';
    }
}
