package com.rlapins.patterns.service.decorator;

import com.rlapins.patterns.model.Ticket;
import com.rlapins.patterns.model.enumerations.Service;

import java.util.List;

/**
 * Interface that will be wrapped for decorator pattern.
 */
public interface Base {

    List<Service> makeBaseTicket();
}
