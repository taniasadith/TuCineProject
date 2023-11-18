package com.example.cineclubreservasventas.shopping.service.inter;

import com.example.cineclubreservasventas.shopping.dto.common.PromotionDto;
import com.example.cineclubreservasventas.shopping.dto.recieved.PromotionRecievedDto;
import com.example.cineclubreservasventas.shopping.entity.Promotion;

import java.util.List;

public interface PromotionService {
    PromotionDto createPromotion(PromotionRecievedDto promotion);
    PromotionDto modifyPromotion(Long id, PromotionRecievedDto promotion);
    public void deletePromotion(Long id);
    public List<PromotionDto> getPromotion();
}
