package app.trip.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


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
	@NotNull @NotBlank @NotEmpty
	private String ticketDescription;
	
	/*
	 * TRUE - BOOKED
	 * FALSE - NOT_BOOKED
	 */
	private Boolean ticketStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "packageId")
	private Packages packages;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "routeId")
	private Route route;
}
