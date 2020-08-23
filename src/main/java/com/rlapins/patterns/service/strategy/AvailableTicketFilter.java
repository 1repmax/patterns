package com.rlapins.patterns.service.strategy;

import com.rlapins.patterns.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Strategy pattern.
 */
public class AvailableTicketFilter implements TicketFilterStrategy<Ticket> {

    private List<Ticket> ticketList;

    @Autowired
    public AvailableTicketFilter(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public List<Ticket> filter() {
        return ticketList.stream()
                .filter(ticket -> ticket.getStatus().equalsIgnoreCase("available"))
                .collect(Collectors.toList());
    }
}
