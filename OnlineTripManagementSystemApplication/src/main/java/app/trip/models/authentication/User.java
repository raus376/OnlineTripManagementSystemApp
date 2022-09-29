package app.trip.models.authentication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;import lombok.Setter;

@Data
@Entity
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@NotBlank @NotBlank @NotEmpty @Size(min = 3, max = 20)
	private String name;
	@JsonIgnore
	private String userType = "User";
	@Email
	private String email;
//	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[*@!&%^])(?=.*[0-9]).{6,8}$")
	@NotNull @NotBlank @NotEmpty
	private String password;
}
