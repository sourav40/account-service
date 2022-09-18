package edu.miu.cs590.accountservice.serviceImpl;

import edu.miu.cs590.accountservice.repsitory.AddressRepository;
import edu.miu.cs590.accountservice.service.AddressService;
import edu.miu.cs590.accountservice.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public ResponseEntity<ServerResponse> getUserAddressByUserId(Long id) {
        return null;
    }
}
