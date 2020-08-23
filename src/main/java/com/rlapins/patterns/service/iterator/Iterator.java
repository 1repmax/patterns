package com.rlapins.patterns.service.iterator;

import com.rlapins.patterns.model.Ticket;

public interface Iterator<T extends Ticket> {

    /**
     * Checks if collection has next element.
     */
    boolean hasNext();

    /**
     * Returns next element from collection
     * @return next Ticket
     */
    T next();
}
