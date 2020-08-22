package com.rlapins.patterns.builder;

import com.rlapins.patterns.model.EcoTicket;
import com.rlapins.patterns.model.enumerations.Service;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EcoTicketBuilderTest {

    @Test
    public void testEcoTicketBuilder() {
        EcoTicket expectedTicket = new EcoTicket("Riga", "Valmiera", "5.00",
                "Raivo Lapins",
                LocalDateTime.of(2015, Month.FEBRUARY, 20, 6, 30),
                LocalDateTime.of(2015, Month.FEBRUARY, 20, 8, 30),
                5, List.of(Service.COFFEE), "economical");

        EcoTicket actualTicket = new EcoTicketBuilder().withStatus("Raivo Lapins")
                .withDepartureStation("Riga")
                .withArrivalStation("Valmiera")
                .withDepartureTime(LocalDateTime.of(2015, Month.FEBRUARY, 20, 6, 30))
                .withArrivalTime(LocalDateTime.of(2015, Month.FEBRUARY, 20, 8, 30))
                .withPrice("5.00")
                .withSeatNumber(5)
                .withServices(List.of(Service.COFFEE))
                .withSomeEcoField("economical")
                .build();

        assertThat(actualTicket).isEqualTo(expectedTicket);
    }

}
