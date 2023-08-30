package com.example.externalAPI.controller.response;

import com.example.externalAPI.entity.Address;
import com.example.externalAPI.entity.AddressData;

import java.util.ArrayList;
import java.util.List;

public class AddressResponse {
    private int status;
    private String message;
    private List<AddressData> results = new ArrayList<>();

    public AddressResponse(Address address) {
        this.status = address.getStatus();
        this.message = address.getMessage();
        this.results = address.getResults();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<AddressData> getResults() {
        return results;
    }
}
