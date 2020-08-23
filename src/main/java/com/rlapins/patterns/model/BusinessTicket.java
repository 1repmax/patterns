package com.rlapins.patterns.model;

import com.rlapins.patterns.model.enumerations.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class BusinessTicket extends Ticket {

    private String businessField;

    public BusinessTicket(int seatNumber) {
        super(seatNumber);
    }


    public BusinessTicket(String departureStation, String arrivalStation, String price, String ticketOwner,
                          LocalDateTime departureTime, LocalDateTime arrivalTime, Integer seatNumber,
                          List<Service> serviceList, String businessField) {
        super(departureStation, arrivalStation, price, ticketOwner, departureTime, arrivalTime, seatNumber, serviceList);
        this.businessField = businessField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BusinessTicket that = (BusinessTicket) o;
        return Objects.equals(businessField, that.businessField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), businessField);
    }
}
