package com.rlapins.patterns.service.legacy;

import com.rlapins.patterns.model.Ticket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LegacySellingService {

    /**
     * Seller ID use case is trivial in this case to keep code short and simple but it could be used in some other business logic
     * in the old legacy version.
     */
    public boolean sellTicket(Ticket ticket, String sellerId) {
        if(ticket.getStatus().equalsIgnoreCase("sold")) {
            return false;
        }
        ticket.setStatus("Sold");
        log.info("Ticket has been sold by " + sellerId);
        return true;
    }

}
