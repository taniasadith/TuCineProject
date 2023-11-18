package com.example.cineclubreservasventas.shopping.controller;

import com.example.cineclubreservasventas.shopping.dto.common.TicketDto;
import com.example.cineclubreservasventas.shopping.dto.recieved.TicketRecievedDto;
import com.example.cineclubreservasventas.shopping.entity.Ticket;
import com.example.cineclubreservasventas.shopping.service.inter.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/TuCine/v1/reservation_purchase")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public ResponseEntity<List<TicketDto>> getTicket(){
        return new ResponseEntity<>(ticketService.getTicket(), org.springframework.http.HttpStatus.OK);
    }

    @PostMapping("/tickets")
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketRecievedDto ticket){
        return new ResponseEntity<>(ticketService.createTicket(ticket), org.springframework.http.HttpStatus.OK);
    }

    @PutMapping("/tickets/{ticketId}")
    public ResponseEntity<TicketDto> modifyTicket(@PathVariable Long ticketId, @RequestBody TicketRecievedDto updatedTicket){
        return new ResponseEntity<>(ticketService.modifyTicket(ticketId, updatedTicket), org.springframework.http.HttpStatus.OK);
    }

    @DeleteMapping("/tickets/{ticketId}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long ticketId){
        ticketService.deleteTicket(ticketId);
        return new ResponseEntity<>(org.springframework.http.HttpStatus.NO_CONTENT);
    }
}
