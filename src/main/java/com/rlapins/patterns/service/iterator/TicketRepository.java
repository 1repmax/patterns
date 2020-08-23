package com.rlapins.patterns.service.iterator;

import com.rlapins.patterns.model.BusinessTicket;
import com.rlapins.patterns.model.EcoTicket;
import com.rlapins.patterns.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketRepository implements Aggregate<Ticket> {

    private Ticket tickets[] = {
            new EcoTicket(1),
            new EcoTicket(2),
            new EcoTicket(3),
            new BusinessTicket(4),
            new BusinessTicket(5),
            new BusinessTicket(6)
    };

    @Override
    public Iterator<Ticket> getIterator() {
        return new TicketIterator();
    }

    private class TicketIterator implements Iterator<Ticket> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < tickets.length;
        }

        @Override
        public Ticket next() {
            return tickets[index++];
        }
    }
}
