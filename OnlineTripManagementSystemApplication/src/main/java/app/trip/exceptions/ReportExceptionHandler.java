package app.trip.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


public class ReportExceptionHandler {
	
	@ExceptionHandler(ReportException.class)
	public ResponseEntity<ErrorDetails> packageExceptionHandler(ReportException re, WebRequest req){
		ErrorDetails red = new ErrorDetails();
		red.setTimestamp(LocalDateTime.now());
		red.setMessage(re.getMessage());
		red.setDescription(req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(red,HttpStatus.BAD_REQUEST);
	}
}
