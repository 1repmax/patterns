package com.rlapins.patterns.builder;

import com.rlapins.patterns.model.BusinessTicket;
import com.rlapins.patterns.model.enumerations.Service;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketBuilderTest {

    @Test
    public void testBusinessTicketBuilder() {
        BusinessTicket expectedTicket = new BusinessTicket("Riga", "Valmiera", "5.00",
                "Raivo Lapins",
                LocalDateTime.of(2015, Month.FEBRUARY, 20, 6, 30),
                LocalDateTime.of(2015, Month.FEBRUARY, 20, 8, 30),
                5, List.of(Service.COFFEE), "business");

        BusinessTicket actualTicket = new BusinessTicketBuilder().withTicketOwner("Raivo Lapins")
                .withDepartureStation("Riga")
                .withArrivalStation("Valmiera")
                .withDepartureTime(LocalDateTime.of(2015, Month.FEBRUARY, 20, 6, 30))
                .withArrivalTime(LocalDateTime.of(2015, Month.FEBRUARY, 20, 8, 30))
                .withPrice("5.00")
                .withSeatNumber(5)
                .withServices(List.of(Service.COFFEE))
                .withSomeEcoField("business")
                .build();

        assertThat(actualTicket).isEqualTo(expectedTicket);
    }

}
