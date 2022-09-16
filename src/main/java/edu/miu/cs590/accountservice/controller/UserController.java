package edu.miu.cs590.accountservice.controller;

import edu.miu.cs590.accountservice.dto.AuthenticationDto;
import edu.miu.cs590.accountservice.entity.User;
import edu.miu.cs590.accountservice.service.UserService;
import edu.miu.cs590.accountservice.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<ServerResponse> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/user/authenticate")
    public ResponseEntity<ServerResponse> authenticateUser(@Valid @RequestBody AuthenticationDto authenticationDto) {
        return userService.authenticateUser(authenticationDto);
    }

    @PostMapping("/user/register")
    public ResponseEntity<ServerResponse> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

}
