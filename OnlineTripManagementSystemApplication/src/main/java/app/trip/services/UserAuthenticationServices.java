package app.trip.services;

import app.trip.exceptions.InvalidCredentialException;
import app.trip.exceptions.UserAlreadyExistsException;
import app.trip.models.SessionDTO;
import app.trip.models.User;
import app.trip.models.UserDTO;

public interface UserAuthenticationServices {
	
	public User userSignUp(User user)throws UserAlreadyExistsException;
	public SessionDTO userLogin(UserDTO user)throws InvalidCredentialException;
	public String userLogout(String authKey)throws InvalidCredentialException;
	public boolean updateUser(User user)throws InvalidCredentialException;
	
	// Admin access only
	public User deleteUser(Integer userId,String authKey)throws InvalidCredentialException;
	public User makeUserAdmin(String userEmail,String passcode)throws InvalidCredentialException;
}
