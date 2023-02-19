package com.example.Ecommerce.API.service;

import com.example.Ecommerce.API.dao.AddressRepository;
import com.example.Ecommerce.API.model.Address;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    public JSONArray getAddress() {
        List<Address> addressList = addressRepository.findAll();

        JSONArray addressArr = new JSONArray();

        for (Address address: addressList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("addressId", address.getAddressId());
            jsonObject.put("name", address.getAddressId());
            jsonObject.put("landmark", address.getAddressId());
            jsonObject.put("phoneNumber", address.getAddressId());
            jsonObject.put("zipcode", address.getAddressId());
            jsonObject.put("state", address.getAddressId());
            jsonObject.put("userId", address.getUser().getUserId());


            addressArr.put(jsonObject);
        }

        return addressArr;

    }
}

