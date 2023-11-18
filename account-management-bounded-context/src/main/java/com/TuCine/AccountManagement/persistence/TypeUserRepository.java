package com.TuCine.AccountManagement.persistence;

import com.TuCine.AccountManagement.domain.enumeration.TypeUsers;
import com.TuCine.AccountManagement.domain.model.TypeUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeUserRepository extends JpaRepository<TypeUser, Long> {
    Optional<TypeUser> findByName(TypeUsers name);
    boolean existsByName(TypeUsers name);
}
