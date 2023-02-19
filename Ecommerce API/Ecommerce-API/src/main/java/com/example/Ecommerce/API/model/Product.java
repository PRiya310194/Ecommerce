package com.example.Ecommerce.API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="product_id")
    private Integer productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="price")
    private Integer price;
    @Column(name="description")
    private String description;
    @Column(name="category")
    private String category;
    @Column(name="brand")
    private String brand;


}
