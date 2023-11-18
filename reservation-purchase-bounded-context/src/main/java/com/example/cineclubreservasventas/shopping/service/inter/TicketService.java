package com.example.cineclubreservasventas.shopping.service.inter;

import com.example.cineclubreservasventas.shopping.dto.common.TicketDto;
import com.example.cineclubreservasventas.shopping.dto.recieved.TicketRecievedDto;
import com.example.cineclubreservasventas.shopping.entity.Promotion;
import com.example.cineclubreservasventas.shopping.entity.Ticket;

import java.util.List;

public interface TicketService {
    public TicketDto createTicket(TicketRecievedDto ticket);
    public TicketDto modifyTicket(Long id, TicketRecievedDto ticket);
    public void deleteTicket(Long id);
    public Ticket applyPromotion(Promotion promotion, Ticket ticket);
    public List<TicketDto> getTicket();
}
