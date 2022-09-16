package edu.miu.cs590.accountservice.serviceImpl;

import edu.miu.cs590.accountservice.dto.AuthenticationDto;
import edu.miu.cs590.accountservice.entity.User;
import edu.miu.cs590.accountservice.jwt.JWTUtility;
import edu.miu.cs590.accountservice.repsitory.UserRepository;
import edu.miu.cs590.accountservice.service.UserService;
import edu.miu.cs590.accountservice.util.ResponseUtility;
import edu.miu.cs590.accountservice.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserserviceImpl implements UserService {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MyUserService myUserService;

    @Override
    public ResponseEntity<ServerResponse> authenticateUser(AuthenticationDto authenticationDto) {
        try {
            UserDetails userDetails = myUserService.loadUserByUsername(authenticationDto.getUsername());
            if (passwordEncoder.matches(authenticationDto.getPassword(), userDetails.getPassword())) {
                final String token = jwtUtility.generateToken(userDetails);
                ServerResponse serverResponse = ResponseUtility
                        .getSuccessfulServerResponse(token, "User login successfully.");
                return new ResponseEntity<ServerResponse>(serverResponse, serverResponse.getHttpStatus());
            }
            ServerResponse serverResponse = ResponseUtility.getFailedServerResponse("Invalid username or password.");
            return new ResponseEntity<ServerResponse>(serverResponse, serverResponse.getHttpStatus());
        } catch (UsernameNotFoundException e) {
            ServerResponse serverResponse = ResponseUtility.getFailedServerResponse(e.getMessage());
            return new ResponseEntity<ServerResponse>(serverResponse, serverResponse.getHttpStatus());
        }
    }

    @Override
    public ResponseEntity<ServerResponse> registerUser(User user) {

        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            ServerResponse serverResponse = ResponseUtility
                    .getSuccessfulServerResponse("User with username " + user.getUsername() + " registered.", "User registered successfully.");
            return new ResponseEntity<ServerResponse>(serverResponse, serverResponse.getHttpStatus());
        } catch (Exception e) {
            ServerResponse serverResponse = ResponseUtility.getFailedServerResponse("Unable to register at this time. Please try again.");
            return new ResponseEntity<ServerResponse>(serverResponse, serverResponse.getHttpStatus());
        }
    }

    @Override
    public ResponseEntity<ServerResponse> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            ServerResponse serverResponse = ResponseUtility
                    .getSuccessfulServerResponse(user.get(), "User fetched.");
            return new ResponseEntity<ServerResponse>(serverResponse, serverResponse.getHttpStatus());
        } else {
            ServerResponse serverResponse = ResponseUtility.getFailedServerResponse("Unable to fetch user at this time.");
            return new ResponseEntity<ServerResponse>(serverResponse, serverResponse.getHttpStatus());
        }
    }
}
