package com.example.cineclubreservasventas.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "promotions")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "cineclubId", nullable = false)
    private long cineclubId;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "initDate", nullable = false)
    private Date initDate;
    @Column(name = "endDate", nullable = false)
    private Date endDate;
    @Getter
    float discountPercentage;

}
