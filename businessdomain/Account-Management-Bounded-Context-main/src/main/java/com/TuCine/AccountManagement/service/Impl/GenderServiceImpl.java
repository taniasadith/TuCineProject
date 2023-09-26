package com.TuCine.AccountManagement.service.Impl;

import com.TuCine.AccountManagement.domain.enumeration.Genders;
import com.TuCine.AccountManagement.domain.model.Gender;
import com.TuCine.AccountManagement.mapping.GenderMapper;
import com.TuCine.AccountManagement.persistence.GenderRepository;
import com.TuCine.AccountManagement.resource.GenderDto;
import com.TuCine.AccountManagement.service.GenderService;
import com.TuCine.AccountManagement.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private EnhancedModelMapper enhancedMapper;
    private GenderMapper mapper;

    private static String[] DEFAULT_GENDERS = { "MALE", "FEMALE", "OTHER" };

    GenderServiceImpl(GenderMapper genderMapper) {
        this.mapper = genderMapper;
    }

    @Override
    public List<GenderDto> getAllGenders() {
        return mapper.toResourceList(genderRepository.findAll());
    }

    @Override
    public void seed() {
        Arrays.stream(DEFAULT_GENDERS).forEach(name -> {
            Genders genderName = Genders.valueOf(name);
            if (!genderRepository.existsByName(genderName)) {
                genderRepository.save(new Gender().withName(genderName));

            }
        });
    }
}
