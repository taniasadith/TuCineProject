package com.example.cineclubreservasventas.shopping.repository;

import com.example.cineclubreservasventas.shopping.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    public List<Promotion> findPromotionById(long Id);
}
