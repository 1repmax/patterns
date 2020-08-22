package com.rlapins.patterns.builder;

import com.rlapins.patterns.model.EcoTicket;

/**
 * Specific builder for BusinessTicket objects. Can define implementations that are different from base builder.
 */
public class EcoTicketBuilder extends AbstractTicketBuilder<EcoTicketBuilder, EcoTicket> {

    private String ecoField;

    public EcoTicketBuilder withSomeEcoField(String field) {
        this.ecoField = field;
        return this;
    }

    @Override
    protected EcoTicket internalBuild() {
        return new EcoTicket(this.departureStation, this.arrivalStation, this.price, this.ticketOwner, this.departureTime,
                this.arrivalTime, this.seatNumber, this.serviceList, this.ecoField);
    }

}
