package com.senai.intellivision.controller.User;

import com.senai.intellivision.domain.orgUser.InputLoginDTO;
import com.senai.intellivision.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login/validate")
    public ResponseEntity<?> validateLogin(InputLoginDTO inputLoginDTO) {
        try {
            userService.validateLogin(inputLoginDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
