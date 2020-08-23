package com.rlapins.patterns.service.decorator;

import com.rlapins.patterns.builder.EcoTicketBuilder;
import com.rlapins.patterns.model.EcoTicket;
import com.rlapins.patterns.model.enumerations.Service;

import java.util.List;

public class BaseTicket implements Base {

    @Override
    public List<Service> makeBaseTicket() {
        EcoTicket ticket = new EcoTicketBuilder()
                .withStatus("Available")
                .withSomeEcoField("Economical")
                .build();
        return ticket.getServiceList();
    }
}
