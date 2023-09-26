package com.TuCine.AccountManagement.service.Impl;

import com.TuCine.AccountManagement.domain.enumeration.TypeUsers;
import com.TuCine.AccountManagement.domain.model.TypeUser;
import com.TuCine.AccountManagement.mapping.TypeUserMapper;
import com.TuCine.AccountManagement.persistence.TypeUserRepository;
import com.TuCine.AccountManagement.resource.TypeUserDto;
import com.TuCine.AccountManagement.service.TypeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TypeUserServiceImpl implements TypeUserService {

    @Autowired
    private TypeUserRepository typeUserRepository;
    private TypeUserMapper mapper;

    private static String[] DEFAULT_TYPE_USERS = { "CINEPHILE", "BUSINESS", "ADMIN" };

    public TypeUserServiceImpl(TypeUserMapper typeUserMapper) {
        this.mapper = typeUserMapper;
    }

    @Override
    public List<TypeUserDto> getAllTypeUsers() {
        return mapper.toResourceList(typeUserRepository.findAll());
    }

    @Override
    public void seed() {
        Arrays.stream(DEFAULT_TYPE_USERS).forEach(name -> {
            TypeUsers typeUserName = TypeUsers.valueOf(name);
            if (!typeUserRepository.existsByName(typeUserName)) {
                typeUserRepository.save((new TypeUser()).withName(typeUserName));
            }
        });
    }
}
