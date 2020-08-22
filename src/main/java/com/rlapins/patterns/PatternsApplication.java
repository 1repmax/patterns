package com.rlapins.patterns;

import com.rlapins.patterns.builder.BusinessTicketBuilder;
import com.rlapins.patterns.builder.EcoTicketBuilder;
import com.rlapins.patterns.model.BusinessTicket;
import com.rlapins.patterns.model.EcoTicket;
import com.rlapins.patterns.model.Ticket;
import com.rlapins.patterns.model.enumerations.Service;
import com.rlapins.patterns.service.TicketService;
import com.rlapins.patterns.service.filter.AvailableTicketFilter;
import com.rlapins.patterns.service.filter.SoldTicketFilter;
import com.rlapins.patterns.service.filter.TicketFilterStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PatternsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PatternsApplication.class, args);

		TicketService service = (TicketService) context.getBean("ticketService");

		List<Ticket> samples = createSampleData();

		//Demonstrates Strategy pattern usage
		System.out.println("Printing Available tickets: ");
		TicketFilterStrategy<Ticket> strategy = new AvailableTicketFilter(samples);
		displayTickets(strategy.filter());

		System.out.println("Printing Sold tickets: ");
		strategy = new SoldTicketFilter(samples);
		displayTickets(strategy.filter());

		//Demonstrates Adapter usage
		samples.forEach(service::sell);
		System.out.println("Printing Sold tickets after selling each of them: ");
		displayTickets(strategy.filter());


	}

	private static List<Ticket> createSampleData() {
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(createEcoTicket("Riga", "Valmiera", "Sold", 1));
		tickets.add(createEcoTicket("Riga", "Ainazi", "Available", 2));
		tickets.add(createEcoTicket("Ainazi", "Valmiera", "Sold", 3));
		tickets.add(createEcoTicket("Suntazi", "Valmiera", "Available", 4));
		tickets.add(createEcoTicket("Riga", "Valmiera", "Sold", 5));
		tickets.add(createEcoTicket("Riga", "Ainazi", "Available", 6));

		tickets.add(createBusinessTicket("Riga", "Roja", "Available", 7));
		tickets.add(createBusinessTicket("Roja", "Valmiera", "Sold", 8));
		tickets.add(createBusinessTicket("Riga", "Valmiera", "Available", 9));
		tickets.add(createBusinessTicket("Sigulda", "Valmiera", "Available", 10));
		return tickets;
	}

	private static Ticket createEcoTicket(String depStat, String arrStat, String status, Integer seat) {
		return new EcoTicketBuilder()
				.withStatus(status)
				.withDepartureStation(depStat)
				.withArrivalStation(arrStat)
				.withDepartureTime(LocalDateTime.now())
				.withArrivalTime(LocalDateTime.now().plusHours(1L))
				.withPrice("5.00")
				.withSeatNumber(seat)
				.withServices(List.of(Service.COFFEE))
				.withSomeEcoField("economical")
				.build();
	}

	private static Ticket createBusinessTicket(String depStat, String arrStat, String status, Integer seat) {
		return new BusinessTicketBuilder()
				.withStatus(status)
				.withDepartureStation(depStat)
				.withArrivalStation(arrStat)
				.withDepartureTime(LocalDateTime.now())
				.withArrivalTime(LocalDateTime.now().plusHours(1L))
				.withPrice("5.00")
				.withSeatNumber(seat)
				.withServices(List.of(Service.COFFEE))
				.build();
	}

	private static void displayTickets(List<Ticket> ticketList) {
		for (Ticket ticket : ticketList) {
				System.out.println(ticket);
		}
	}

}
