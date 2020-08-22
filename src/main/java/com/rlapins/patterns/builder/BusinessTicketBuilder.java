package com.rlapins.patterns.builder;

import com.rlapins.patterns.model.BusinessTicket;

/**
 * Specific builder for EcoTicket objects. Can define implementations that are different from base builder.
 */
public class BusinessTicketBuilder extends AbstractTicketBuilder<BusinessTicketBuilder, BusinessTicket> {

    private String businessField;

    public BusinessTicketBuilder withSomeEcoField(String field) {
        this.businessField = field;
        return this;
    }

    @Override
    protected BusinessTicket internalBuild() {
        return new BusinessTicket(this.departureStation, this.arrivalStation, this.price, this.ticketOwner, this.departureTime,
                this.arrivalTime, this.seatNumber, this.serviceList, this.businessField);
    }
}
