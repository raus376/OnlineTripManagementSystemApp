package app.trip.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;

	/*
	 * Description about the ticket - Package and Route
	 */
	@NotNull
	@NotBlank
	@NotEmpty
	private String ticketDescription;

	/*
	 * TRUE - BOOKED
	 * FALSE - NOT_BOOKED
	 */
	private Boolean ticketStatus;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "packageId")
	private Packages packages;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "routeId")
	private Route route;
}
