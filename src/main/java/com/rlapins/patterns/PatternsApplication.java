package com.rlapins.patterns;

import com.rlapins.patterns.builder.EcoTicketBuilder;
import com.rlapins.patterns.model.EcoTicket;
import com.rlapins.patterns.model.Ticket;
import com.rlapins.patterns.model.enumerations.Service;
import com.rlapins.patterns.service.TicketService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class PatternsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PatternsApplication.class, args);

		TicketService service = (TicketService) context.getBean("ticketService");

		EcoTicket ticket = new EcoTicketBuilder().withTicketOwner("Available")
				.withDepartureStation("Riga")
				.withArrivalStation("Valmiera")
				.withDepartureTime(LocalDateTime.of(2015, Month.FEBRUARY, 20, 6, 30))
				.withArrivalTime(LocalDateTime.of(2015, Month.FEBRUARY, 20, 8, 30))
				.withPrice("5.00")
				.withSeatNumber(5)
				.withServices(List.of(Service.COFFEE))
				.withSomeEcoField("economical")
				.build();
		service.sell(ticket);

	}

}
