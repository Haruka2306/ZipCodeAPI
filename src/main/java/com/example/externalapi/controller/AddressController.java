package com.example.externalapi.controller;

import com.example.externalapi.controller.response.AddressResponse;
import com.example.externalapi.entity.Address;
import com.example.externalapi.service.AddressService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Validated
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public AddressResponse findAddress(@RequestParam("zipcode") @NotBlank @Pattern(regexp = "[0-9]{3}[-]{0,1}[0-9]{4}") String zipCode) {
        Address address = addressService.findZipCode(zipCode);
        return new AddressResponse(address);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> badRequestException(ConstraintViolationException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "status", String.valueOf(HttpStatus.BAD_REQUEST.value()),
                "error", HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "message", "ZipCode entered is incorrect",
                "path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.BAD_REQUEST);
    }
}
