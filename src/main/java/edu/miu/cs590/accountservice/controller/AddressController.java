package edu.miu.cs590.accountservice.controller;

import edu.miu.cs590.accountservice.service.AddressService;
import edu.miu.cs590.accountservice.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<ServerResponse> getUserAddressByUserId(Long id){
        return addressService.getUserAddressByUserId(id);
    }
}
