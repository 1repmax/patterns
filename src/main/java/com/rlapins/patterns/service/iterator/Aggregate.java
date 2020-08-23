package com.rlapins.patterns.service.iterator;

import com.rlapins.patterns.model.Ticket;

/**
 * Must be implemented by all classes that want to use Iterator pattern.
 * @param <T>
 */
public interface Aggregate<T extends Ticket> {

    Iterator<Ticket> getIterator();
}
