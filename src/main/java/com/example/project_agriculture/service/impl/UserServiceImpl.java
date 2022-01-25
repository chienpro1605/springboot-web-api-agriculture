package com.example.project_agriculture.service.impl;

import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.entity.Users;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.repository.UserRepository;
import com.example.project_agriculture.security.UserDetailsImpl;
import com.example.project_agriculture.service.CommonServiceImpl;
import com.example.project_agriculture.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends CommonServiceImpl<Users, UserRepository> implements UserService {

    @Override
    @Transactional
    public UserDetails findUsersByUsernameAndPassword(String username, String password) {
        Users users = repository.findUsersByUsernameEqualsAndPasswordEquals(username, password)
                .orElseThrow(() -> new ApplicationException(ErrorCode.ACCOUNT_NOT_EXISTS.getValue()));
        return UserDetailsImpl.build(users);
    }

    @Override
    public Optional<Users> findByUsername(String name) {
        return repository.findByUsername(name);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public Boolean existsByMobile(String mobile) {
        return repository.existsByMobile(mobile);
    }

    @Override
    public Users save(Users users) {
        return repository.save(users);
    }

    @Override
    public List<Users> getAllUsers() {
        return repository.getAllUsers();
    }

    @Override
    public Optional<Users> getUsersByUserId(String userid) {
        return repository.getUsersByUserId(userid);
    }

    @Override
    public Iterable<Users> searchUsers(String value) {
        return repository.searchUsers(value);
    }

    @Override
    public Page<Users> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = repository.findUsersByUsernameEquals(username);
        return UserDetailsImpl.build(users.get());
    }
}
