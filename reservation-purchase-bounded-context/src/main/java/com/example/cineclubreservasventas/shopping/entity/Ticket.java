package com.example.cineclubreservasventas.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "dateEmition", nullable = false)
    private Date dateEmition;
    @Column(name = "dateModify", nullable = false)
    private int dateModify;
    @Column(name = "numberSeats", nullable = false)
    private int numberSeats;
    @Column(name = "userId", nullable = false)
    private long userId;
    @Column(name = "totalPrice", nullable = false)
    private float totalPrice;
    private long movieId;
    private int status;
}
