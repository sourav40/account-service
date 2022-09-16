package edu.miu.cs590.accountservice.service;

import edu.miu.cs590.accountservice.dto.AuthenticationDto;
import edu.miu.cs590.accountservice.entity.User;
import edu.miu.cs590.accountservice.util.ServerResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<ServerResponse> authenticateUser(AuthenticationDto authenticationDto);

    public ResponseEntity<ServerResponse> registerUser(User user);

    public ResponseEntity<ServerResponse> findById(Long id);

}

