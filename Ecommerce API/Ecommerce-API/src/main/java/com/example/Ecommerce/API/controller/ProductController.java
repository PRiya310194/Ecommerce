package com.example.Ecommerce.API.controller;

import com.example.Ecommerce.API.model.Product;
import com.example.Ecommerce.API.model.User;
import com.example.Ecommerce.API.service.ProductService;
import com.example.Ecommerce.API.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping(value="/product")
    public String saveProduct(@RequestBody String productRequest){
        JSONObject json=new JSONObject(productRequest);
        Product product=setProduct(json);
        productService.saveProduct(product);
        return "product saved";

    }
    private Product setProduct(JSONObject json){
        Product product =new Product();
        product.setProductId(json.getInt("productId"));
        product.setProductName(json.getString("productName"));
        product.setPrice(json.getInt("price"));
        product.setDescription(json.getString("description"));
        product.setCategory(json.getString("category"));
        product.setBrand(json.getString("brand"));

        return product;
    }
    @GetMapping(value="/product")
    public List<Product> getProduct(@Nullable @RequestParam Integer productId){
        return productService.getProduct(productId);
    }
    @DeleteMapping("/delete-product/id//{id}")
    public void deteteProduct(@PathVariable int productId){
        productService.deteteProduct(productId);
    }
}



