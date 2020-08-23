package com.rlapins.patterns.service.decorator;

import com.rlapins.patterns.model.enumerations.Service;

import java.util.List;

public class WifiDecorator extends TicketDecorator {

    public WifiDecorator(Base base) {
        super(base);
    }

    @Override
    public List<Service> makeBaseTicket() {
        List<Service> services = baseTicket.makeBaseTicket();
        addWifi(services);
        return services;
    }

    private void addWifi(List<Service> serviceList) {
        serviceList.add(Service.WIFI);
    }
}
