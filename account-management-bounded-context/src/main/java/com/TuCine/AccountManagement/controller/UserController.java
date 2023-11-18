package com.TuCine.AccountManagement.controller;

import com.TuCine.AccountManagement.domain.communication.LoginRequest;
import com.TuCine.AccountManagement.domain.communication.RegisterRequest;
import com.TuCine.AccountManagement.domain.communication.UpdateRequest;
import com.TuCine.AccountManagement.resource.TypeUserDto;
import com.TuCine.AccountManagement.resource.UserDto;
import com.TuCine.AccountManagement.shared.exception.ValidationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.TuCine.AccountManagement.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/TuCine/v1/account_management")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    //URL: http://localhost:8080/api/TuCine/v1/users
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/TuCine/v1/users/{userId}
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId){
        return new ResponseEntity<>(userService.getById(userId), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/TuCine/v1/users/auth/sign-up
    //Method: POST
    @PostMapping("/users/auth/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    //URL: http://localhost:8080/api/TuCine/v1/users/auth/sign-in
    //Method: POST
    @PostMapping("/users/auth/sign-in")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest request) {
        return userService.login(request);
    }

    //Update user
    //URL: http://localhost:8080/api/TuCine/v1/users/{userId}
    //Method: PUT
    @PutMapping("/users/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable("userId") Long userId, @RequestBody UpdateRequest request ){
        return new ResponseEntity<>(userService.updateUser(userId,request), HttpStatus.OK);
    }

    //Delete user
    //URL: http://localhost:8080/api/TuCine/v1/users/{userId}
    //Method: DELETE
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId){
        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
    }

    //
    //URL: http://localhost:8080/api/TuCine/v1/users/{userId}
    @RequestMapping("/users/verify/{userId}")
    boolean checkIfUserExist(@PathVariable Long userId){
        return userService.checkIfUserExist(userId);
    }
}
