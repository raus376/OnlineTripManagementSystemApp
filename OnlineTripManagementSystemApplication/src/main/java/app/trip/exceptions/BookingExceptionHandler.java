package app.trip.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class BookingExceptionHandler {
	@ExceptionHandler(BookingException.class)
	public ResponseEntity<ErrorDetails> bookingExceptionHandler(BookingException be, WebRequest req){
		ErrorDetails bookexe = new ErrorDetails();
		bookexe.setTimestamp(LocalDateTime.now());
		bookexe.setMessage(be.getMessage());
		bookexe.setDescription(req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(bookexe,HttpStatus.BAD_REQUEST);
	}
}
