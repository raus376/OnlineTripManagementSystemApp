package app.trip.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class PackageExceptionHandler {
	
	@ExceptionHandler(PackageException.class)
	public ResponseEntity<ErrorDetails> packageExceptionHandler(PackageException pe, WebRequest req){
		ErrorDetails ped = new ErrorDetails();
		ped.setTimestamp(LocalDateTime.now());
		ped.setMessage(pe.getMessage());
		ped.setDescription(req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ped,HttpStatus.BAD_REQUEST);
	}
}
