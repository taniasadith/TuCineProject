package com.example.cineclubreservasventas.shopping.dto.common;

import lombok.Data;

import java.util.Date;

@Data
public class PromotionDto {
    private long id;
    private long cineclubId;
    private String title;
    private String description;
    private Date initDate;
    private Date endDate;
    float discountPercentage;

}
