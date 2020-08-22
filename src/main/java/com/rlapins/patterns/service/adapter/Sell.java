package com.rlapins.patterns.service.adapter;

import com.rlapins.patterns.model.Ticket;

public interface Sell<T extends Ticket> {

    boolean sellTicket(T ticket);

}
