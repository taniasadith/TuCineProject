package com.TuCine.AccountManagement.controller;

import com.TuCine.AccountManagement.resource.GenderDto;
import com.TuCine.AccountManagement.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/TuCine/v1/account_management")
public class GenderController {
    @Autowired
    private GenderService genderService;

    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    //URL: http://localhost:8080/api/TuCine/v1/genders
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/genders")
    public ResponseEntity<List<GenderDto>> getAllGenders() {
        return new ResponseEntity<>(genderService.getAllGenders(), HttpStatus.OK);
    }
}