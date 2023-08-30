package com.example.externalAPI.controller;

import com.example.externalAPI.entity.Address;
import com.example.externalAPI.controller.response.AddressResponse;
import com.example.externalAPI.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public AddressResponse findAddress(@RequestParam("zipcode")String zipcode) {
        Address address = addressService.findZipCode(zipcode);
        return new AddressResponse(address);
    }
}
