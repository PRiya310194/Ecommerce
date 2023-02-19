package com.example.Ecommerce.API.controller;

import com.example.Ecommerce.API.dao.UserRepository;
import com.example.Ecommerce.API.model.Address;
import com.example.Ecommerce.API.model.User;
import com.example.Ecommerce.API.service.AddressService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/address")
    public String saveAddress(@RequestBody String addressRequest) {
        JSONObject json = new JSONObject(addressRequest);
        Address address = setAddress(json);
        addressService.saveAddress(address);
        return "saved address";

    }

    private Address setAddress(JSONObject json) {

        Address address = new Address();
        address.setAddressId(json.getInt("addressId"));
        address.setName(json.getString("name"));
        address.setLandmark(json.getString("landmark"));
        address.setPhoneNumber(json.getString("phoneNumber"));
        address.setZipcode(json.getString("Zipcode"));
        address.setState(json.getString("state"));


        Integer userId = json.getInt("userId");
        User user = userRepository.findById(userId).get();
        address.setUserId(user);
        return address;


    }


    @GetMapping(value = "/address")
    public ResponseEntity getAddress(@Nullable @RequestParam String userId,
                                      @Nullable @RequestParam String addressId) {

        JSONArray addressDetails = addressService.getAddress();

        return new ResponseEntity<>(addressDetails.toString(), HttpStatus.OK);
    }
}