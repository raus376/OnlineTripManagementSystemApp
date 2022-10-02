package app.trip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.trip.models.Packages;
import app.trip.models.Ticket;



@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	public List<Ticket> findByPackages(Packages packages);
	
	//public List<Ticket> findByRouteId(Integer routeId);
	
}
