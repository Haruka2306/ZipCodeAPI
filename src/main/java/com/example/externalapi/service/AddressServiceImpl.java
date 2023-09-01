package com.example.externalapi.service;

import com.example.externalapi.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressServiceImpl implements AddressService {
    private final String URL = "https://zipcloud.ibsnet.co.jp/api/search?zipcode={zipcode}";
    private final RestTemplate restTemplate;

    @Autowired
    public AddressServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Address findZipCode(String zipCode) {
        ResponseEntity<Address> response = restTemplate.getForEntity(URL, Address.class, zipCode);
        return response.getBody();
    }
}
