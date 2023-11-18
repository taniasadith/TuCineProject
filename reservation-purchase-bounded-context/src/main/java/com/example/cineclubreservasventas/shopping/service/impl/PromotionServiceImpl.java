package com.example.cineclubreservasventas.shopping.service.impl;

import com.example.cineclubreservasventas.shopping.client.ShowtimeClient;
import com.example.cineclubreservasventas.shopping.dto.common.PromotionDto;
import com.example.cineclubreservasventas.shopping.dto.recieved.PromotionRecievedDto;
import com.example.cineclubreservasventas.shopping.entity.Promotion;
import com.example.cineclubreservasventas.shopping.repository.PromotionRepository;
import com.example.cineclubreservasventas.shopping.service.inter.PromotionService;
import feign.FeignException;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.modelmapper.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    private ShowtimeClient showtimeClient;
    @Autowired
    PromotionRepository promotionRepository;
    @Autowired
    private ModelMapper modelMapper;
    PromotionServiceImpl(){
        modelMapper=new ModelMapper();
    }
    public PromotionDto EntityToDto(Promotion promotion){
        return modelMapper.map(promotion, PromotionDto.class);
    }
    public Promotion DtoToEntity(PromotionDto promotion){
        return modelMapper.map(promotion, Promotion.class);
    }
    @SneakyThrows
    @Override
    public PromotionDto createPromotion(PromotionRecievedDto promotion) {
        validatePromotion(promotion);
        ValidateIfShowtimeExists(String.valueOf(promotion.getCineclubId()));
        PromotionDto promotionDto = modelMapper.map(promotion, PromotionDto.class);
        Promotion prom = DtoToEntity(promotionDto);

        return EntityToDto(promotionRepository.save(prom));
    }

    @Override
    public PromotionDto modifyPromotion(Long id, PromotionRecievedDto promotion) {
        Promotion existingPromotion = promotionRepository.findById(id)
                .orElseThrow(() ->  new IllegalArgumentException("Can't find a promotion with that Id"));
        existingPromotion.setTitle(promotion.getTitle());
        existingPromotion.setDescription(promotion.getDescription());
        existingPromotion.setEndDate(promotion.getEndDate());
        existingPromotion.setInitDate(promotion.getInitDate());
        existingPromotion.setDiscountPercentage(promotion.getDiscountPercentage());

        Promotion updatedPromotion = promotionRepository.save(existingPromotion);

        return EntityToDto(updatedPromotion);
    }

    @Override
    public void deletePromotion(Long id) {
        Promotion existingPromotion = promotionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Can't find a promotion with that Id"));
        promotionRepository.delete(existingPromotion);
    }

    @Override
    public List<PromotionDto> getPromotion() {
        List<Promotion> promotions = promotionRepository.findAll();
        return promotions.stream()
                .map(this::EntityToDto)
                .collect(Collectors.toList());
    }

    private void validatePromotion(PromotionRecievedDto promotion){
        if(promotion.getTitle() == null || promotion.getTitle().isEmpty()){
            throw new IllegalArgumentException("Title is obligatory");
        }
        if(promotion.getEndDate() == null){
            throw new IllegalArgumentException("EndDate is obligatory");
        }
        if(promotion.getInitDate() == null){
            throw new IllegalArgumentException("InitDate is obligatory");
        }
    }

    private void ValidateIfShowtimeExists(String id) throws Exception {
        try{
            boolean ShowtimeResponse = showtimeClient.checkIfShowtimeExist(Long.valueOf(id));
            if(!ShowtimeResponse){
                throw new IllegalArgumentException("Showtime does not exists");
            }

        } catch (FeignException feignException) {
            throw new IllegalArgumentException(feignException.getMessage());
        }
    }

}
