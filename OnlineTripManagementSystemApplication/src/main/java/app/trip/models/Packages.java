package app.trip.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Packages")
public class Packages {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer packageId;

	@Column(length = 45)
	@NotNull
	@NotBlank
	@NotEmpty
	private String packageName;

	@Column(length = 45)
	@NotNull
	@NotBlank
	@NotEmpty
	private String packageDescription;

	@Enumerated(EnumType.ORDINAL)
	private PackageType packageType;

	@NotNull
	@Min(0)
	private Integer packageCost;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(length = 45)
	private String paymentDetails;

	@JsonIgnore
	@OneToMany(mappedBy = "packages", cascade = CascadeType.ALL)
	private List<Ticket> ticketDetails;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Hotel> hotelDetails;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Booking bookingDetails;
}
