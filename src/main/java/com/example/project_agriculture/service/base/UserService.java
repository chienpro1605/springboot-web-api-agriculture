package com.example.project_agriculture.service.base;

import com.example.project_agriculture.entity.Users;
import com.example.project_agriculture.service.CommonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends CommonService<Users>, UserDetailsService {
    UserDetails findUsersByUsernameAndPassword(String username, String password);
    Optional<Users> findByUsername(String name);
    Boolean existsByUsername(String username);
    Boolean existsByMobile(String mobile);
    Users save(Users users);
    List<Users> getAllUsers();
    Optional<Users> getUsersByUserId(String userid);
    Iterable<Users> searchUsers(String value);
    Page<Users> findAll(Pageable pageable);
}
