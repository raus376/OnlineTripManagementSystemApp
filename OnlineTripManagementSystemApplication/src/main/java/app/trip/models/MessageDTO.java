package app.trip.models;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MessageDTO {
	
	private String message;
	private LocalDateTime timestamp;
}
