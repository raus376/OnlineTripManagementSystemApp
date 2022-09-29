package app.trip.exceptions.package_exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PackageErrorDetails {
	
	private LocalDateTime timestamp;
	private String message;
	private String description;
}
