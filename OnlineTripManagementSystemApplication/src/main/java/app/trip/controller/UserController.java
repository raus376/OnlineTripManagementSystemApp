package app.trip.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.trip.exceptions.InvalidCredentialException;
import app.trip.exceptions.UserAlreadyExistsException;
import app.trip.models.SessionDTO;
import app.trip.models.User;
import app.trip.models.UserDTO;
import app.trip.services.UserAuthenticationServices;
import lombok.Delegate;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserAuthenticationServices service;
	
	@PostMapping("/signup")
	public ResponseEntity<String> userSignUp(@Valid @RequestBody User user)throws UserAlreadyExistsException{
		service.userSingUp(user);
		return new ResponseEntity<String>("Registered Successfully",HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<SessionDTO> userSignIn(@Valid @RequestBody UserDTO user)throws UserAlreadyExistsException, InvalidCredentialException{
		SessionDTO sdt = service.userLogin(user);
		return new ResponseEntity<SessionDTO>(sdt,HttpStatus.OK);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> userLogout(@RequestParam(value = "key") String authKey)throws InvalidCredentialException{
		service.userLogout(authKey);
		return new ResponseEntity<String>("Logged out successfully...",HttpStatus.OK);
	}
	
	@PutMapping("/profile")
	public ResponseEntity<String> updateUser(@Valid @RequestBody User user)throws InvalidCredentialException{
		 service.updateUser(user);
		return new ResponseEntity<String>("User updated successfully...",HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<User> deleteUser(@RequestParam Integer userid,@RequestParam String authKey)throws InvalidCredentialException{
		User u = service.deleteUser(userid, authKey);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	@PostMapping("/appoint")
	public ResponseEntity<User> appointNewAdmin(@RequestParam("email") String email,@RequestParam("code") String passcode)throws InvalidCredentialException{
		User user = service.makeUserAdmin(email, passcode);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
}
