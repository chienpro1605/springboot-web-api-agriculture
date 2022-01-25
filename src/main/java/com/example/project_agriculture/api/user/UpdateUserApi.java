package com.example.project_agriculture.api.user;

import com.example.project_agriculture.entity.Users;
import com.example.project_agriculture.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@RequestMapping("/api/users")
@RestController
@CrossOrigin(origins = "*")
public class UpdateUserApi {

    @Autowired
    UserService userService;

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUsersId(@RequestBody Users users, @PathVariable String id) {
        Optional<Users> usersOptional =userService.getUsersByUserId(id);
        if (!usersOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        users.setUserId(usersOptional.get().getUserId());
        users.setPassword(usersOptional.get().getPassword());
        users.setCooperative(usersOptional.get().getCooperative());
        users.setCreated_time(Timestamp.valueOf(LocalDateTime.now()));
        userService.save(users);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
