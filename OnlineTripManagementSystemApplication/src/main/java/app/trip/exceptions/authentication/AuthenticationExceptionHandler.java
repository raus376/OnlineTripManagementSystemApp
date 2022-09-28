package app.trip.exceptions.authentication;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AuthenticationExceptionHandler {
	
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<AuthErrDetails> InvalidcredentialExceptionHandler(InvalidCredentialException ice, WebRequest req){
		AuthErrDetails authEx = new AuthErrDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(ice.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<AuthErrDetails>(authEx,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<AuthErrDetails> DuplicateSignUpExceptionHandler(UserAlreadyExistsException uae, WebRequest req){
		AuthErrDetails authEx = new AuthErrDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(uae.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<AuthErrDetails>(authEx,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<AuthErrDetails> OtherExceptionHandler(Exception uae, WebRequest req){
		AuthErrDetails authEx = new AuthErrDetails();
		authEx.setTimestamp(LocalDateTime.now());
		authEx.setMessage(uae.getMessage());
		authEx.setDescription(req.getDescription(false));
		
		return new ResponseEntity<AuthErrDetails>(authEx,HttpStatus.BAD_REQUEST);
	}
}
