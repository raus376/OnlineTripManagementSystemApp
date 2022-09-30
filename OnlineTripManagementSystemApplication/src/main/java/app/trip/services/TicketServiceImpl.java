package app.trip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.trip.exceptions.InvalidCredentialException;
import app.trip.exceptions.InvalidTicketException;
import app.trip.models.CurrentUserLoginSession;
import app.trip.models.Packages;
import app.trip.models.Ticket;
import app.trip.repository.PackageRepository;
import app.trip.repository.SessionRepository;
import app.trip.repository.TicketRepository;
import app.trip.repository.UserRepository;


@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepo;

	@Autowired
	PackageRepository pkgRepo;

	@Autowired
	SessionRepository sessionRepo;
	
	@Autowired
	UserRepository userRepo;
	

	@Override
	public List<Ticket> getAllTickets(Integer packageId,String authKey) throws InvalidTicketException {
		List<Ticket> tickets = null;
		
		Optional<CurrentUserLoginSession> culs = sessionRepo.findByAuthkey(authKey);
		
		String userType = userRepo.findById(culs.get().getUserId()).get().getUserType();
				
		if(userType.equalsIgnoreCase("user") && packageId != null) {
			Optional<Packages> pkg = pkgRepo.findById(packageId);
			Packages packages = pkg.get();
			tickets = ticketRepo.findByPackages(packages);
		} else if(userType.equalsIgnoreCase("admin") && packageId == null) {
			tickets = ticketRepo.findAll();			
		} else if(userType.equalsIgnoreCase("admin") && packageId != null) {
			Optional<Packages> pkg = pkgRepo.findById(packageId);
			Packages packages = pkg.get();
			tickets = ticketRepo.findByPackages(packages);
		} else {
			throw new InvalidTicketException("Please enter package Id.");
		}
		
		if(tickets.isEmpty() || tickets == null) {
			throw new InvalidTicketException("Tickets Not Available.");
		}
		
		return tickets;
	}
	
	@Override
	public Ticket getTicket(Integer ticketId) throws InvalidTicketException {
		Ticket ticket = null;
		
		Optional<Ticket> tkt = ticketRepo.findById(ticketId);
		
		if(tkt.isPresent() == false) {
			throw new InvalidTicketException("No such Ticket exists.");
		} else {
			ticket = tkt.get();
		}
		
		return ticket;
	}
	
	@Override
	public Ticket createTicket(Ticket ticket) throws InvalidTicketException {
		Optional<Ticket> user = ticketRepo.findById(ticket.getTicketId());
		
		if(user.isPresent()) {
			throw new InvalidTicketException("Ticket Already Exists with Id "+ticket.getTicketId());
		}
		
		Ticket ticketCreated  = ticketRepo.save(ticket);
		
		return ticketCreated;
	}

	
	@Override
	public Ticket deleteTicket(Integer ticketId) throws InvalidTicketException {
		Ticket ticket = null;
		
		Optional<Ticket> user = ticketRepo.findById(ticketId);		
		
		if(user.isPresent()) {
			ticket = user.get();
			
			ticketRepo.delete(ticket);
		} else {
			throw new InvalidTicketException("Ticket does not exist....");			
		}
		
		return ticket;
	}
}
