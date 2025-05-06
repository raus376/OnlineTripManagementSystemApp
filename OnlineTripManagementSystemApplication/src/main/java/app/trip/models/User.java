package app.trip.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@NotBlank
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 20, message = "Name must contain at least 3 characters")
	private String name;

	@NotNull
	@Pattern(regexp = "[0-9]{10}", message = "Mobile number should be of 10 digits")
	private String mobile;

	@NotBlank
	@NotBlank
	@NotEmpty
	private String address;

	@JsonIgnore
	private String userType = "User";

	@Email(message = "Invalid Email Address.")
	private String email;

	@Pattern(regexp = "[A-Za-z0-9@]{6,15}", message = "Password must be 6 to 15 characters and must have at least 1 alphabate and 1 number")
	@NotNull
	@NotBlank
	@NotEmpty
	private String password;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Feedback> feedbacks = new ArrayList<>();
}
