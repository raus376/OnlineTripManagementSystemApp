package app.trip.controller.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.trip.exceptions.authentication.InvalidCredentialException;
import app.trip.exceptions.authentication.UserAlreadyExistsException;
import app.trip.models.authentication.SessionDTO;
import app.trip.models.authentication.User;
import app.trip.models.authentication.UserDTO;
import app.trip.services.authentication.UserAuthenticationServices;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserAuthenticationServices service;
	
	@PostMapping("/signup")
	public ResponseEntity<String> userSignUp(@RequestBody User user)throws UserAlreadyExistsException{
		service.userSingUp(user);
		return new ResponseEntity<String>("Registered Successfully",HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<SessionDTO> userSignIn(@RequestBody UserDTO user)throws UserAlreadyExistsException, InvalidCredentialException{
		SessionDTO sdt = service.userLogin(user);
		return new ResponseEntity<SessionDTO>(sdt,HttpStatus.OK);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> userLogout(@RequestParam(value = "key") String authKey)throws InvalidCredentialException{
		service.userLogout(authKey);
		return new ResponseEntity<String>("Logged out successfully...",HttpStatus.OK);
	}
	
	@PostMapping("/a/{email}/{code}")
	public ResponseEntity<User> appointNewAdmin(@RequestParam("email") String email,@RequestParam("code") String passcode)throws InvalidCredentialException{
		User user = service.makeUserAdmin(email, passcode);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
}
