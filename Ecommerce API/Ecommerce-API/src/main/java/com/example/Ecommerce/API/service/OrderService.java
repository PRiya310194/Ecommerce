package com.example.Ecommerce.API.service;

import com.example.Ecommerce.API.dao.OrderRepository;
import com.example.Ecommerce.API.model.Order;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public JSONArray getOrder(Integer orderId) {

        List<Order> orderList = OrderRepository.findAll();

        JSONArray orderArr = new JSONArray();

        for (Order order: orderList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("orderId", order.getOrderId());

            jsonObject.put("userId", order.getUserId().getUserId());
            jsonObject.put("productId", order.getUserId().getUserId());
            jsonObject.put("addressId", order.getUserId().getUserId());
            orderArr.put(order);
        }


        return orderArr;

    }

}

