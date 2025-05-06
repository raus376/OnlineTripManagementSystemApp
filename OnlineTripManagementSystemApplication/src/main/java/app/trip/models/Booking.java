package app.trip.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	private String bookingType;
	private String description;
	private String bookingTitle;
	private LocalDateTime date;


	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<User> users = new ArrayList<>();

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "package_f_id", referencedColumnName = "packageId")
	private Packages packages;

}
