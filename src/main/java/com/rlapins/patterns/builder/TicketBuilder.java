package com.rlapins.patterns.builder;

import com.rlapins.patterns.model.enumerations.Service;
import com.rlapins.patterns.model.Ticket;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Interface that should be implemented by every ticket builder.
 * @param <SELF> Type of a subclassed Ticket builder
 * @param <TARGET> Type of a object that will be built
 */
public interface TicketBuilder<SELF extends TicketBuilder<SELF, TARGET>, TARGET extends Ticket> {

    SELF withDepartureStation(String departureStation);

    SELF withArrivalStation(String arrivalStation);

    SELF withPrice(String price);

    SELF withTicketOwner(String ticketOwner);

    SELF withDepartureTime(LocalDateTime departureTime);

    SELF withArrivalTime(LocalDateTime arrivalTime);

    SELF withSeatNumber(Integer seatNumber);

    SELF withServices(List<Service> services);

    TARGET build();
}
