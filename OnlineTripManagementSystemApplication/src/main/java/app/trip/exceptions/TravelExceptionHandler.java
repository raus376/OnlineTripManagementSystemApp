package app.trip.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class TravelExceptionHandler {
	
	//TravelExceptionHandler
	
		@ExceptionHandler(TravelException.class)
		public ResponseEntity<ErrorDetails> travelExceptionHandler(TravelException te, WebRequest req){
			
			ErrorDetails err=new ErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(te.getMessage());
			err.setDescription(req.getDescription(false));
			
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		}
		
	
}
