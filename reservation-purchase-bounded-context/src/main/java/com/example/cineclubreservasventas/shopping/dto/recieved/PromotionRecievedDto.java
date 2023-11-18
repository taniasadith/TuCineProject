package com.example.cineclubreservasventas.shopping.dto.recieved;

import lombok.Data;

import java.util.Date;
@Data
public class PromotionRecievedDto {
    private long cineclubId;
    private String title;
    private String description;
    private Date initDate;
    private Date endDate;
    float discountPercentage;
}
