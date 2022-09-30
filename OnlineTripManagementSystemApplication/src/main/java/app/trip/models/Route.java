package app.trip.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Route")
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer routeId;
	
	private String Routefrom;
	private String RouteTo;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private LocalDate dateOfJourney;
	private String pickUpPoint;
	private Integer fare;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ticketId")
	private Ticket ticket;

	//@OneToOne(cascade = CascadeType.ALL)
	//private Integer busId;

}
