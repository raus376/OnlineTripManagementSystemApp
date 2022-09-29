package app.trip.exceptions.authentication;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AuthErrDetails {
	
	private LocalDateTime timestamp;
	private String message;
	private String description;
}
