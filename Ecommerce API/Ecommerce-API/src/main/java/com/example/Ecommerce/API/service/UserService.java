package com.example.Ecommerce.API.service;

import com.example.Ecommerce.API.dao.UserRepository;
import com.example.Ecommerce.API.model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void saveUser(User user){
        userRepository.save(user);
    }
    public List<User> getUser(Integer userId) {
        List<User> userList;
        if (null != userId) {
            userList = new ArrayList<>();
            userList.add(userRepository.findById(Integer.valueOf(userId)).get());
        } else {
            userList = userRepository.findAll();
        }
        return userList;
    }
    public void deteteUser(int userId) {
        User user=userRepository.findById(userId).get();
        userRepository.delete(user);
    }
}

