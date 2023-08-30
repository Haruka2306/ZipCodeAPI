package com.example.externalAPI.service;

import com.example.externalAPI.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "https://zipcloud.ibsnet.co.jp/api/search?zipcode={zipcode}";

    @Override
    public Address findZipCode (String zipCode) {
       ResponseEntity<Address> response = restTemplate.getForEntity(URL, Address.class, zipCode);
        return response.getBody();
    }

}
