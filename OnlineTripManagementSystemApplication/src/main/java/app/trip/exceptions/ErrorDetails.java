package app.trip.exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {
	
	private LocalDateTime timestamp;
	private String message;
	private String description;
}
