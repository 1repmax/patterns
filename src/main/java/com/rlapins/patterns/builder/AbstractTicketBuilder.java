package com.rlapins.patterns.builder;

import com.rlapins.patterns.model.enumerations.Service;
import com.rlapins.patterns.model.Ticket;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Abstract builder class for common fields in base Ticket class.
 * @param <BUILDER> Type of a subclassed ticket builder
 * @param <TARGET> Type of a object that will be built
 */
public abstract class AbstractTicketBuilder<BUILDER extends TicketBuilder<BUILDER, TARGET>, TARGET extends Ticket> implements TicketBuilder<BUILDER, TARGET> {

    protected String departureStation;
    protected String arrivalStation;
    protected String price;
    protected String ticketOwner;
    protected LocalDateTime departureTime;
    protected LocalDateTime arrivalTime;
    protected Integer seatNumber;
    protected List<Service> serviceList;

    @Override
    public BUILDER withDepartureStation(String departureStation) {
        this.departureStation = departureStation;
        return self();
    }

    @Override
    public BUILDER withArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
        return self();
    }

    @Override
    public BUILDER withPrice(String price) {
        this.price = price;
        return self();
    }

    @Override
    public BUILDER withStatus(String status) {
        this.ticketOwner = status;
        return self();
    }

    @Override
    public BUILDER withDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
        return self();
    }

    @Override
    public BUILDER withArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        return self();
    }

    @Override
    public BUILDER withSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
        return self();
    }

    @Override
    public BUILDER withServices(List<Service> services) {
        this.serviceList = services;
        return self();
    }

    @Override
    public TARGET build() {
        return internalBuild();
    }

    protected abstract TARGET internalBuild();

    private BUILDER self() {
        return (BUILDER) this;
    }
}
