package com.example.externalapi.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ZipCode {
    @NotBlank
    @Pattern(regexp = "[0-9]{3}[-]{0,1}[0-9]{4}")
    private final String zipCode;

    public ZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }
}
