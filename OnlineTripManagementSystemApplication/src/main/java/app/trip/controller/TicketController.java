package app.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.trip.exceptions.InvalidTicketException;
import app.trip.models.Ticket;
import app.trip.services.TicketService;


@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	// gets all tickets
	@GetMapping("/allTickets")
	public ResponseEntity<List<Ticket>> getAllTickets(@RequestParam(required = false) Integer packageId,@RequestParam(required = false) String authKey) throws InvalidTicketException {
		List<Ticket> tickets = null;
		
		tickets = ticketService.getAllTickets(packageId,authKey);
				
		return new ResponseEntity<List<Ticket>>(tickets,HttpStatus.FOUND);
	}
	
	// gets specific ticket
	@GetMapping("/showTicket")
	public ResponseEntity<Ticket> getTicket(@RequestParam Integer ticketId, @RequestParam String authKey) throws InvalidTicketException {
		Ticket ticket = null;
		
		ticket = ticketService.getTicket(ticketId);
		
		return new ResponseEntity<Ticket>(ticket,HttpStatus.FOUND);
	}
	
	// creates a ticket
	@PostMapping("/createTicket")
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket,  @RequestParam String authKey) throws InvalidTicketException {
		Ticket createdTicket = null;
		
		createdTicket = ticketService.createTicket(ticket);
		
		return new ResponseEntity<Ticket>(createdTicket,HttpStatus.CREATED);
	}
	
	// deletes a ticket
	@DeleteMapping("/removeTicket")
	public ResponseEntity<Ticket> deleteTicket(@RequestParam Integer ticketId,  @RequestParam String authKey) throws InvalidTicketException {
		Ticket ticket = null;
		
		ticket = ticketService.deleteTicket(ticketId);
		
		return new ResponseEntity<Ticket>(ticket,HttpStatus.OK);
	}
	
}
