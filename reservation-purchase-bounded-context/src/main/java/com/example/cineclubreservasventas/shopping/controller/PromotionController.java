package com.example.cineclubreservasventas.shopping.controller;

import com.example.cineclubreservasventas.shopping.dto.common.PromotionDto;
import com.example.cineclubreservasventas.shopping.dto.recieved.PromotionRecievedDto;
import com.example.cineclubreservasventas.shopping.entity.Promotion;
import com.example.cineclubreservasventas.shopping.service.inter.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/TuCine/v1/reservation_purchase")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    @GetMapping("/promotions")
    public ResponseEntity<List<PromotionDto>> getPromotion(){
        return new ResponseEntity<>(promotionService.getPromotion(), HttpStatus.OK);
    }

    @PostMapping("/promotions")
    public ResponseEntity<PromotionDto> createPromotion(@RequestBody PromotionRecievedDto promotion){
        return new ResponseEntity<>(promotionService.createPromotion(promotion), HttpStatus.OK);
    }

    @PutMapping("/promotions/{promotionId}")
    public ResponseEntity<PromotionDto> modifyPromotion(@PathVariable Long promotionId, @RequestBody PromotionRecievedDto updatedPromotion){
        return new ResponseEntity<>(promotionService.modifyPromotion(promotionId, updatedPromotion), HttpStatus.OK);
    }

    @DeleteMapping("/promotions/{promotionId}")
    public ResponseEntity<Void> deletePromotion(@PathVariable Long promotionId){
        promotionService.deletePromotion(promotionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}