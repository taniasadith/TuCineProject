package com.example.cineclubreservasventas.shopping.client;

import com.example.cineclubreservasventas.shopping.shared.ShowtimeResponse;
import com.example.cineclubreservasventas.shopping.shared.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "account-managment-service",path = "/api/TuCine/v1/account_management")
public interface UserClient {
    @RequestMapping("/users/verify/{userId}")
    boolean checkIfUserExist(@PathVariable("userId") Long userId) throws RuntimeException;

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Long id);
}

// account-management-service