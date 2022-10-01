package app.trip.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import app.trip.exceptions.InvalidTicketException;
import app.trip.models.Ticket;



public interface TicketService {
	
	// user or admin can create ticket
	public Ticket createTicket(Ticket ticket) throws InvalidTicketException;
	
	// user or admin can see ticket
	public Ticket getTicket(Integer ticketId) throws InvalidTicketException;
	
	// user or admin can delete ticket
	public Ticket deleteTicket(Integer ticketId) throws InvalidTicketException;
	
	/* ADMIN can see all tickets in database 
	 * USER can see their tickets
	*/
	public List<Ticket> getAllTickets(Integer packageId,String authKey) throws InvalidTicketException;
}
