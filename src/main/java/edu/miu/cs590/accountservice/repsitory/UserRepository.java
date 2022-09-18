package edu.miu.cs590.accountservice.repsitory;

import edu.miu.cs590.accountservice.entity.Address;
import edu.miu.cs590.accountservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);

    @Query("select u.address from User u where u.id = ?1")
    Address findUserAddressById(Long id);

    @Query("select u.email from User u where u.id = ?1")
    String getEmailFromUserId(Long id);
}

