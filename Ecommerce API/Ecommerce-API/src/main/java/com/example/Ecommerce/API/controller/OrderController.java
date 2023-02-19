package com.example.Ecommerce.API.controller;

import com.example.Ecommerce.API.dao.AddressRepository;
import com.example.Ecommerce.API.dao.ProductRepository;
import com.example.Ecommerce.API.dao.UserRepository;
import com.example.Ecommerce.API.model.Address;
import com.example.Ecommerce.API.model.Order;
import com.example.Ecommerce.API.model.Product;
import com.example.Ecommerce.API.model.User;
import com.example.Ecommerce.API.service.AddressService;
import com.example.Ecommerce.API.service.OrderService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AddressRepository addressRepository;
    @PostMapping(value = "/order")
    public String saveOrder(@RequestBody String orderRequest) {
        JSONObject json = new JSONObject(orderRequest);
        Order order = setOrder(json);
        orderService.saveOrder(order);
        return "saved address";
    }
    private Order setOrder(JSONObject json) {
        Order order = new Order();
        order.setOrderId(json.getInt("orderId"));

        Integer userId = json.getInt("userId");

        User user = userRepository.findById(userId).get();
        Order.setUserId(user);

        Integer productId = json.getInt("productId");
        Product product = productRepository.findById(productId).get();
        Order.setProductId(product);

        Integer addressId = json.getInt("addressId");
        Address address = addressRepository.findById(addressId).get();
        Order.setAddressId(address);

return order;

    }
    @GetMapping("/getorder")
    public ResponseEntity getOrder (@RequestParam Integer orderId){


            JSONArray orderDetails = orderService.getOrder(orderId);

            return new ResponseEntity<>(orderDetails.toString(), HttpStatus.OK);
        }
    }


