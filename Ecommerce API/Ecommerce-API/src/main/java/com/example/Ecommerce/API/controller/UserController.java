package com.example.Ecommerce.API.controller;

import com.example.Ecommerce.API.model.User;
import com.example.Ecommerce.API.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(value="/user")
    public String saveUser(@RequestBody String userRequest){
        JSONObject json=new JSONObject(userRequest);
        User user=setUser(json);
        userService.saveUser(user);
        return "user saved";

    }
private User setUser(JSONObject json){
        User user=new User();
        user.setUserId(json.getInt("userId"));
        user.setName(json.getString("name"));
        user.setEmail(json.getString("email"));
        user.setPassword(json.getString("password"));
        user.setPhoneNumber(json.getString("phoneNumber"));
        return user;
}
@GetMapping(value="/user")
   public List<User>getUser(@Nullable @RequestParam Integer userId){
        return userService.getUser(userId);
}
@DeleteMapping("/delete")
    public void deleteUser(@PathVariable int userId){
        userService.deteteUser(userId);
}
}



