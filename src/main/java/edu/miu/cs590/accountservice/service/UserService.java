package edu.miu.cs590.accountservice.service;

import edu.miu.cs590.accountservice.dto.AuthenticationDto;
import edu.miu.cs590.accountservice.entity.User;
import edu.miu.cs590.accountservice.util.ServerResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<ServerResponse> authenticateUser(AuthenticationDto authenticationDto);

    ResponseEntity<ServerResponse> registerUser(User user);

    ResponseEntity<ServerResponse> findById(Long id);

    ResponseEntity<ServerResponse> findUserAddressById(Long id);

    ResponseEntity<ServerResponse> getUserDetailsFromUserName(String username);

    ResponseEntity<ServerResponse> getEmailFromUserId(Long id);
}

