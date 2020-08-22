package com.rlapins.patterns.service;

import com.rlapins.patterns.model.Ticket;
import com.rlapins.patterns.service.adapter.SellingServiceAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TicketService {

    private SellingServiceAdapter sellingService;

    @Autowired
    private TicketService(SellingServiceAdapter sellingService) {
        this.sellingService = sellingService;
    }

    public void sell(Ticket ticket) {
        log.info("Ticket status before selling: " + ticket.getStatus());
        sellingService.sellTicket(ticket);
        log.info("Ticket status after sell() call: " + ticket.getStatus());
    }

}
