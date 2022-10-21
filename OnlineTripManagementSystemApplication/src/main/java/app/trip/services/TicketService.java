package app.trip.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import app.trip.exceptions.AccessDeniedException;
import app.trip.exceptions.InvalidRouteException;
import app.trip.exceptions.InvalidTicketException;
import app.trip.exceptions.PackageException;

import app.trip.models.Ticket;



public interface TicketService {
	
	// user or admin can create ticket
	public Ticket createTicket(Ticket ticket, Integer packageId, Integer routeId, String authKey) throws InvalidTicketException, InvalidRouteException, PackageException, AccessDeniedException;
	
	// user or admin can see ticket
	public Ticket getTicket(Integer ticketId, String authKey) throws InvalidTicketException, AccessDeniedException;
	
	// user or admin can delete ticket
	public Ticket deleteTicket(Integer ticketId, String authKey) throws InvalidTicketException, AccessDeniedException;
		
	/* ADMIN can see all tickets in database
	 * USER can see their tickets
	 */
	public List<Ticket> getAllTickets(Integer packageId, String authKey) throws InvalidTicketException, AccessDeniedException;
}
