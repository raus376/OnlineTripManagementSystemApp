package app.trip.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> OtherExceptionHandler(Exception exp, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(exp.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exp) {
		
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage("Validation Error");
		authEx.setDescription(exp.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorDetails> AccessDeniedExceptionHandler(AccessDeniedException exp, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(exp.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(InvalidTicketException.class)
	public ResponseEntity<ErrorDetails> InvalidTicketExceptionHandler(InvalidTicketException exp, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(exp.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(InvalidRouteException.class)
	public ResponseEntity<ErrorDetails> InvalidRouteExceptionHandler(InvalidRouteException exp, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(exp.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PackageException.class)
	public ResponseEntity<ErrorDetails> packageExceptionHandler(PackageException pe, WebRequest req){
		ErrorDetails ped = new ErrorDetails();
		ped.setTimestamp(LocalDateTime.now());
		ped.setMessage(pe.getMessage());
		ped.setDescription(req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ped,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<ErrorDetails> InvalidcredentialExceptionHandler(InvalidCredentialException ice, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(ice.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ErrorDetails> DuplicateSignUpExceptionHandler(UserAlreadyExistsException uae, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(uae.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BookingException.class)
	public ResponseEntity<ErrorDetails> bookingExceptionHandler(BookingException be, WebRequest req){
		ErrorDetails bookexe = new ErrorDetails();
		bookexe.setTimestamp(LocalDateTime.now());
		bookexe.setMessage(be.getMessage());
		bookexe.setDescription(req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(bookexe,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BusException.class)
	public ResponseEntity<ErrorDetails> busExceptionHandler(BusException be, WebRequest req){
		
		ErrorDetails err=new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(be.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FeedbackException.class)
	public ResponseEntity<ErrorDetails> OtherExceptionHandler(FeedbackException uae, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(uae.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HotelException.class)
	public ResponseEntity<ErrorDetails> OtherExceptionHandler(HotelException uae, WebRequest req){
		ErrorDetails authEx = new ErrorDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(uae.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(authEx,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ReportException.class)
	public ResponseEntity<ErrorDetails> packageExceptionHandler(ReportException re, WebRequest req){
		ErrorDetails red = new ErrorDetails();
		red.setTimestamp(LocalDateTime.now());
		red.setMessage(re.getMessage());
		red.setDescription(req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(red,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TravelException.class)
	public ResponseEntity<ErrorDetails> travelExceptionHandler(TravelException te, WebRequest req){
		
		ErrorDetails err=new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(te.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	

}
