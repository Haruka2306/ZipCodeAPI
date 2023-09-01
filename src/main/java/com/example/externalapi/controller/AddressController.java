package com.example.externalapi.controller;

import com.example.externalapi.controller.response.AddressResponse;
import com.example.externalapi.entity.Address;
import com.example.externalapi.entity.ZipCode;
import com.example.externalapi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public AddressResponse findAddress(@RequestParam("zipcode") @Validated ZipCode zipCode) {
        Address address = addressService.findZipCode(zipCode.getZipCode());
        return new AddressResponse(address);
    }
}
