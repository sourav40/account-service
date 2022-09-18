package edu.miu.cs590.accountservice.service;

import edu.miu.cs590.accountservice.util.ServerResponse;
import org.springframework.http.ResponseEntity;

public interface AddressService {
    ResponseEntity<ServerResponse> getUserAddressByUserId(Long id);
}
