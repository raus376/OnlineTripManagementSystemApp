package app.trip.models.authentication;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
	
	private String email;
	private String password;
}
