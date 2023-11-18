package com.TuCine.AccountManagement.service;

import com.TuCine.AccountManagement.resource.GenderDto;

import java.util.List;

public interface GenderService {
    void seed();
    List<GenderDto> getAllGenders();
}
