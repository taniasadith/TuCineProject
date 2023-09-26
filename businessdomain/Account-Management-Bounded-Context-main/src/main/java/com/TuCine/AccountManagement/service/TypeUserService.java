package com.TuCine.AccountManagement.service;

import com.TuCine.AccountManagement.resource.TypeUserDto;

import java.util.List;

public interface TypeUserService {
    void seed();
    List<TypeUserDto> getAllTypeUsers();
}
