package app.trip.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Route")
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer routeId;

	@NotNull
	@NotBlank
	@NotEmpty
	private String Routefrom;

	@NotNull
	@NotBlank
	@NotEmpty
	private String RouteTo;

	private LocalDateTime departureTime;

	private LocalDateTime arrivalTime;

	private LocalDate dateOfJourney;

	@NotNull
	@NotBlank
	@NotEmpty
	private String pickUpPoint;

	@NotNull
	@Min(0)
	private Integer fare;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ticketId")
	private Ticket ticket;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "travelId")
	private Travel travelId;
}
