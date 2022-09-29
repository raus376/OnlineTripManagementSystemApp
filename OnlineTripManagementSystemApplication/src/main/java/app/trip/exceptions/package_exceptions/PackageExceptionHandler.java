package app.trip.exceptions.package_exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class PackageExceptionHandler {
	
	@ExceptionHandler(PackageException.class)
	public ResponseEntity<PackageErrorDetails> packageExceptionHandler(PackageException pe, WebRequest req){
		PackageErrorDetails ped = new PackageErrorDetails();
		ped.setTimestamp(LocalDateTime.now());
		ped.setMessage(pe.getMessage());
		ped.setDescription(req.getDescription(false));
		return new ResponseEntity<PackageErrorDetails>(ped,HttpStatus.BAD_REQUEST);
	}
}
