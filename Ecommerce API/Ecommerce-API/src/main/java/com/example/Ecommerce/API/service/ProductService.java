package com.example.Ecommerce.API.service;

import com.example.Ecommerce.API.dao.ProductRepository;

import com.example.Ecommerce.API.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public void saveProduct(Product product){
        productRepository.save(product);
    }
    public List<Product> getProduct(Integer productId) {
        List<Product> productList;
        if (null != productId) {
            productList = new ArrayList<>();
            productList.add(productRepository.findById(Integer.valueOf(productId)).get());
        } else {
            productList = productRepository.findAll();
        }
        return productList;
    }
    public void deteteProduct(int productId) {
        Product product=productRepository.findById(productId).get();
        productRepository.delete(product);
    }

}
