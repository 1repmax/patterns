package com.rlapins.patterns.service.decorator;

import com.rlapins.patterns.model.enumerations.Service;

import java.util.List;

public abstract class TicketDecorator implements Base {

    /**
     * Existing interface that will be decorated
     */
    protected Base baseTicket;

    /**
     * Only this constructor is allowed since we can decorate only existing interface
     */
    public TicketDecorator(Base ticket) {
        this.baseTicket = ticket;
    }

    @Override
    public List<Service> makeBaseTicket() {
        return baseTicket.makeBaseTicket();
    }
}
