package app.trip.services.authentication;

import app.trip.exceptions.authentication.InvalidCredentialException;
import app.trip.exceptions.authentication.UserAlreadyExistsException;
import app.trip.models.authentication.SessionDTO;
import app.trip.models.authentication.User;
import app.trip.models.authentication.UserDTO;

public interface UserAuthenticationServices {
	
	public User userSingUp(User user)throws UserAlreadyExistsException;
	public SessionDTO userLogin(UserDTO user)throws InvalidCredentialException;
	public String userLogout(String authKey)throws InvalidCredentialException;
	public User makeUserAdmin(String userEmail,String passcode)throws InvalidCredentialException;
}
