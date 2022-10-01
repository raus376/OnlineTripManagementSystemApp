package app.trip.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class HotelExceptionHandler {
	
	@ExceptionHandler(HotelException.class)
	public ResponseEntity<ErrorDetails> OtherExceptionHandler(HotelException uae, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(uae.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.BAD_REQUEST);
	}

}
