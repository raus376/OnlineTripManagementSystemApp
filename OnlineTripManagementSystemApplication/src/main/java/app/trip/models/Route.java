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
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@NotNull @NotBlank @NotEmpty
	private String Routefrom;
	
	@NotNull @NotBlank @NotEmpty
	private String RouteTo;
	
	private LocalDateTime departureTime;
	
	private LocalDateTime arrivalTime;
	
	private LocalDate dateOfJourney;
	
	@NotNull @NotBlank @NotEmpty
	private String pickUpPoint;
	
	@NotNull @Min(0)
	private Integer fare;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ticketId")
	private Ticket ticket;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "travelId")
	private Travel travelId;
}
