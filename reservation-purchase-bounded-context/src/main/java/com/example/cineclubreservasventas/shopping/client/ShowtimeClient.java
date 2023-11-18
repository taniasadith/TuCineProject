package com.example.cineclubreservasventas.shopping.client;

import com.example.cineclubreservasventas.shopping.shared.ShowtimeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "showtime-service", path = "/api/TuCine/v1/showtime/")
public interface ShowtimeClient {
    @RequestMapping("/showtime/verify/{cineclubId}")
    boolean checkIfShowtimeExist(@PathVariable("cineclubId") Long cineclubId) throws RuntimeException;
    @GetMapping("/showtime/{cineclubId}")
    public ResponseEntity<ShowtimeResponse> getShowtimeByCinemaId(@PathVariable("cineclubId") Long id);
    @PutMapping("/showtime/{movieId}")
    ResponseEntity<Void> updateShowtimeByMovieId(@PathVariable("movieId") Long movieId, @RequestBody ShowtimeResponse showtimeResponse);

}