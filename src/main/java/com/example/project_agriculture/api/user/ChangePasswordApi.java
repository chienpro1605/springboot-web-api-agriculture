package com.example.project_agriculture.api.user;

import com.example.project_agriculture.entity.Users;
import com.example.project_agriculture.request.user.ChangePasswordRequest;
import com.example.project_agriculture.response.user.ResponMessage;
import com.example.project_agriculture.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/users")
@RestController
@CrossOrigin(origins = "*")
public class ChangePasswordApi {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PutMapping("/change-password/{id}")
    public ResponseEntity<?> changePassword(@PathVariable String id, @Valid @RequestBody ChangePasswordRequest changePasswordRequest) {
        Users users = userService.findEntityById(id);
        boolean matches = passwordEncoder.matches(changePasswordRequest.getCurrentPassword(), users.getPassword());
        if (matches == true) {
            users.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
            userService.save(users);
        } else {
            return new ResponseEntity<>(new ResponMessage("old password is incorrect"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponMessage("change password success!!"), HttpStatus.OK);
    }
}
