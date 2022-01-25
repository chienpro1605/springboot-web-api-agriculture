package com.example.project_agriculture.repository;

import com.example.project_agriculture.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
        Optional<Users> findUsersByUsernameEqualsAndPasswordEquals(String username, String password);
        Optional<Users> findUsersByUsernameEquals(String username);
        Optional<Users> findByUsername(String name);
        Boolean existsByUsername(String username);
        Boolean existsByMobile(String mobile);

        @Query(value = "SELECT * FROM getallusers();", nativeQuery = true)
        List<Users> getAllUsers();

        @Query(value = "SELECT * FROM getusersid(:userid);", nativeQuery = true)
        Optional<Users> getUsersByUserId(String userid);

        @Query(value = "select * from Users u WHERE (u.name like :value or u.groupId like :value or u.mobile like :value)", nativeQuery = true)
        Iterable<Users> searchUsers(String value);

        Page<Users> findAll(Pageable pageable);
}
