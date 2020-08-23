package com.rlapins.patterns.service.decorator;

import com.rlapins.patterns.model.enumerations.Service;

import java.util.List;

public class CoffeeDecorator extends TicketDecorator {

    public CoffeeDecorator(Base base) {
        super(base);
    }

    @Override
    public List<Service> makeBaseTicket() {
        List<Service> services = baseTicket.makeBaseTicket();
        addCoffee(services);
        return services;
    }

    private void addCoffee(List<Service> serviceList) {
        serviceList.add(Service.COFFEE);
    }
}
