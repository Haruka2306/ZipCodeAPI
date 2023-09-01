package com.example.externalapi.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class ZipCode {
    @NotEmpty
    @Pattern(regexp = "[0-9]{3}[-]{0,1}[0-9]{4}")
    private final String zipCode;

    public ZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }
}
