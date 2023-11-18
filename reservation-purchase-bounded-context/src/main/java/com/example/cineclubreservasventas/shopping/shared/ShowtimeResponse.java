package com.example.cineclubreservasventas.shopping.shared;

import lombok.Data;

@Data
public class ShowtimeResponse {
    Long id;
    Long movieId;
    Long cinemaId;
    int numberOfSeats;
}
