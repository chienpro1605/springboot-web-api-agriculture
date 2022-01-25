package com.example.project_agriculture.api.user;

import com.example.project_agriculture.constant.RoleName;
import com.example.project_agriculture.entity.Role;
import com.example.project_agriculture.entity.Users;
import com.example.project_agriculture.jwt.JwtTokenProvider;
import com.example.project_agriculture.request.user.SignUpForm;
import com.example.project_agriculture.response.user.ResponMessage;
import com.example.project_agriculture.service.base.RoleService;
import com.example.project_agriculture.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "*")
public class RegisterApi {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm){
        if(userService.existsByUsername(signUpForm.getUsername())){
            return new ResponseEntity<>(new ResponMessage("user existed"), HttpStatus.OK);
        }
        if(userService.existsByMobile(signUpForm.getMobile())){
            return new ResponseEntity<>(new ResponMessage("mobile existed"), HttpStatus.OK);
        }

        Users user = new Users(signUpForm.getName(),
                signUpForm.getUsername(),
                signUpForm.getAddress(),
                signUpForm.getBirthday(),
                signUpForm.getCooperative(),
                signUpForm.getMobile(),
                signUpForm.getAvatar(),
                signUpForm.getGroupId(),
                passwordEncoder.encode(signUpForm.getPassword()));
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role ->{
            switch (role){
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow(
                            ()-> new RuntimeException("Role not found")
                    );
                    roles.add(adminRole);
                    break;
                case "manager":
                    Role managerRole = roleService.findByName(RoleName.MANAGER).orElseThrow( ()-> new RuntimeException("Role not found"));
                    roles.add(managerRole);
                    break;
                default:
                    Role farmerRole = roleService.findByName(RoleName.FARMER).orElseThrow( ()-> new RuntimeException("Role not found"));
                    roles.add(farmerRole);
            }
        });
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new ResponMessage("register success!!"), HttpStatus.OK);
    }
}
