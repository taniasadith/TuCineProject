package com.example.cineclubreservasventas.shopping.dto.recieved;

import lombok.Data;

import java.util.Date;

@Data
public class TicketRecievedDto {
    private Date dateEmition;
    private int dateModify;
    private int numberSeats;
    private long userId;
    private float totalPrice;
    private long movieId;
    private int status;
}
