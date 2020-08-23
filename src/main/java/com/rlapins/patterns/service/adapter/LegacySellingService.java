package com.rlapins.patterns.service.adapter;

import com.rlapins.patterns.model.Ticket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LegacySellingService implements LegacySell<Ticket> {

    /**
     * Seller ID use case is trivial in this case to keep code short and simple but it could be used in some other business logic
     * in the old legacy version.
     */
    public boolean sellTicket(Ticket ticket, String sellerId) {
        if(ticket.getStatus().equalsIgnoreCase("sold")) {
            log.info("Can't sell ticket that is already sold. Skipping.");
            return false;
        }
        ticket.setStatus("Sold");
        log.info("Ticket has been sold by " + sellerId);
        return true;
    }

}
