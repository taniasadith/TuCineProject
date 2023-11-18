package com.TuCine.AccountManagement.persistence;

import com.TuCine.AccountManagement.domain.enumeration.Genders;
import com.TuCine.AccountManagement.domain.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenderRepository extends JpaRepository<Gender,Long> {

    Optional<Gender> findByName(Genders name);
    boolean existsByName(Genders name);
}
