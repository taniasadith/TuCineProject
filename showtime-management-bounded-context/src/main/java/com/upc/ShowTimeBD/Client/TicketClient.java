package com.upc.ShowTimeBD.Client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "reservation-purchase-service",path = "/api/TuCine/v1/reservation_purchase")
public interface TicketClient {
}
