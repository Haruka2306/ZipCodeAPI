package com.example.externalAPI.entity;

import java.util.ArrayList;
import java.util.List;

public class Address {
    int status;
    String message;
    List<AddressData> results = new ArrayList<>();

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
