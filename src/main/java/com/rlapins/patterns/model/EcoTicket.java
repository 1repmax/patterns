package com.rlapins.patterns.model;

import com.rlapins.patterns.model.enumerations.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class EcoTicket extends Ticket {

    private String economicalField;

    public EcoTicket(int seatNumber) {
        super(seatNumber);
    }

    public EcoTicket(String departureStation, String arrivalStation, String price, String ticketOwner,
                     LocalDateTime departureTime, LocalDateTime arrivalTime, Integer seatNumber,
                     List<Service> serviceList, String economicalField) {
        super(departureStation, arrivalStation, price, ticketOwner, departureTime, arrivalTime, seatNumber, serviceList);
        this.economicalField = economicalField;
    }

    public String getEconomicalField() {
        return economicalField;
    }

    public void setEconomicalField(String economicalField) {
        this.economicalField = economicalField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EcoTicket ecoTicket = (EcoTicket) o;
        return Objects.equals(economicalField, ecoTicket.economicalField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), economicalField);
    }
}
