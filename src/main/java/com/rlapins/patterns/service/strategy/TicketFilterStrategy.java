package com.rlapins.patterns.service.strategy;

import com.rlapins.patterns.model.Ticket;

import java.util.List;

/**
 * Interface used for Strategy pattern.
 */
public interface TicketFilterStrategy<T extends Ticket> {

    List<T> filter();
}
