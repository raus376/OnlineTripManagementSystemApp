package app.trip.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.trip.exceptions.AccessDeniedException;
import app.trip.exceptions.InvalidRouteException;
import app.trip.exceptions.InvalidTicketException;
import app.trip.exceptions.PackageException;

import app.trip.models.Ticket;
import app.trip.services.TicketService;


@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = "*")
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	// gets all tickets
	@GetMapping("/allTickets")
	public ResponseEntity<List<Ticket>> getAllTickets(@RequestParam(required = false) Integer packageId, @RequestParam(required = false) String authKey) throws InvalidTicketException, AccessDeniedException {
		List<Ticket> tickets = null;
		
		tickets = ticketService.getAllTickets(packageId,authKey);
				
		return new ResponseEntity<List<Ticket>>(tickets,HttpStatus.FOUND);
	}
	
	// gets specific ticket
	@GetMapping("/showTicket")
	public ResponseEntity<Ticket> getTicket(@RequestParam Integer ticketId, @RequestParam String authKey) throws InvalidTicketException, AccessDeniedException {
		Ticket ticket = null;
		
		ticket = ticketService.getTicket(ticketId, authKey);
		
		return new ResponseEntity<Ticket>(ticket,HttpStatus.FOUND);
	}
	
	// creates a ticket
	@PostMapping("/createTicket")
	public ResponseEntity<Ticket> createTicket(@Valid @RequestBody Ticket ticket, @RequestParam Integer packageId, @RequestParam Integer routeId, @RequestParam String authKey) throws InvalidTicketException, InvalidRouteException, PackageException, AccessDeniedException {
		Ticket createdTicket = null;
		
		createdTicket = ticketService.createTicket(ticket, packageId, routeId, authKey);
		
		return new ResponseEntity<Ticket>(createdTicket,HttpStatus.CREATED);
	}
	
	// deletes a ticket
	@DeleteMapping("/removeTicket")
	public ResponseEntity<Ticket> deleteTicket(@RequestParam Integer ticketId, @RequestParam String authKey) throws InvalidTicketException, AccessDeniedException {
		Ticket ticket = null;
		
		ticket = ticketService.deleteTicket(ticketId, authKey);
		
		return new ResponseEntity<Ticket>(ticket,HttpStatus.OK);
	}
	
}
