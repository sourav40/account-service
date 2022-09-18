package edu.miu.cs590.accountservice.serviceImpl;

import edu.miu.cs590.accountservice.entity.User;
import edu.miu.cs590.accountservice.repsitory.UserRepository;
import edu.miu.cs590.accountservice.util.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found."));
        return user.map(MyUserDetails::new).get();
    }
}
