package com.example.project_agriculture.api.user;

import com.example.project_agriculture.entity.Users;
import com.example.project_agriculture.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@RestController
@CrossOrigin(origins = "*")
public class SearchUsers {

    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<Iterable<Users>> searchUser(@RequestParam("value") String value) {
        return new ResponseEntity<>(userService.searchUsers(value), HttpStatus.OK);
    }
}
