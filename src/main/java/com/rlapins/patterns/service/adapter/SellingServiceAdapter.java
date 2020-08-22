package com.rlapins.patterns.service.adapter;

import com.rlapins.patterns.model.Ticket;
import com.rlapins.patterns.service.legacy.LegacySellingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Adapter pattern example.
 * SellingServiceAdapter adapts a LegacySeller because the legacy seller has incompatible interface.
 * This class also demonstrates Composite pattern since it HAS-A multiple subclasses instead of using inheritance and
 * IS-A relationship.
 */
@Service
@Slf4j
public class SellingServiceAdapter implements Sell<Ticket> {

    private LegacySellingService legacySellingService;
    private SellerService seller;

    @Autowired
    public SellingServiceAdapter(LegacySellingService legacySellingService, SellerService seller) {
        this.legacySellingService = legacySellingService;
        this.seller = seller;
    }

    /**
     * Our new Selling Service should work only with Ticket objects but the Legacy selling service also needs
     * a seller ID provided. Thus the interfaces are incompatible and we need an adapter to make them compatible.
     */
    @Override
    public boolean sellTicket(Ticket ticket) {
        return legacySellingService.sellTicket(ticket, seller.getSellerId());
    }
}
