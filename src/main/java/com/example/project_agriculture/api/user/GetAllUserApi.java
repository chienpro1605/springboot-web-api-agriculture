package com.example.project_agriculture.api.user;

import com.example.project_agriculture.entity.Users;
import com.example.project_agriculture.repository.UserRepository;
import com.example.project_agriculture.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/users")
@RestController
@CrossOrigin(origins = "*")
public class GetAllUserApi {

    @Autowired
    UserService userService;

//    @GetMapping("")
//    public ResponseEntity<Iterable<Users>> getAllUsers() {
//        return new ResponseEntity<>(userService.getEntities(), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Users>> getUsersById(@PathVariable String id) {
        Optional<Users> usersOptional = userService.getUsersByUserId(id);
        if (usersOptional.isPresent()) {
            return new ResponseEntity<>(usersOptional, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/sortByName")
    public ResponseEntity<?> pageUserSortByName(@PageableDefault(sort = "username", direction = Sort.Direction.ASC)Pageable pageable) {
        Page<Users> usersPage = userService.findAll(pageable);
        if (usersPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(usersPage, HttpStatus.OK);
    }

    @GetMapping("/sortByGroupId")
    public ResponseEntity<?> pageUserSortByGroupId(@PageableDefault(sort = "groupId", direction = Sort.Direction.ASC)Pageable pageable) {
        Page<Users> usersPage = userService.findAll(pageable);
        if (usersPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(usersPage, HttpStatus.OK);
    }
}
