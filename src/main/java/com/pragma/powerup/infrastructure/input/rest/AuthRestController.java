package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.UserRequestDTO;
import com.pragma.powerup.application.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final IUserHandler userHandler;

    @PostMapping("/register")
    public ResponseEntity<Void> saveUser(@RequestBody UserRequestDTO userRequestDTO){
        userHandler.saveUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
