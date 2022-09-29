package app.trip.services.authentication;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.trip.exceptions.authentication.InvalidCredentialException;
import app.trip.exceptions.authentication.UserAlreadyExistsException;
import app.trip.models.authentication.CurrentUserLoginSession;
import app.trip.models.authentication.SessionDTO;
import app.trip.models.authentication.User;
import app.trip.models.authentication.UserDTO;
import app.trip.repository.authentication.SessionRepository;
import app.trip.repository.authentication.UserRepository;

@Service
public class UserAuthenticationServicesImpl implements UserAuthenticationServices{
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	SessionRepository sessionRepo;
	
	@Override
	public User userSingUp(User user) throws UserAlreadyExistsException {
		Optional<User> opt = userRepo.findByEmail(user.getEmail());
		if(opt.isPresent()) {
			throw new UserAlreadyExistsException("User already registered");
		}
		userRepo.save(user);
		return user;
	}

	@Override
	public SessionDTO userLogin(UserDTO user) throws InvalidCredentialException {
		Optional<User> opt = userRepo.findByEmail(user.getEmail());
		if(!opt.isPresent()) {
			throw new InvalidCredentialException("User doesn't exists...");
		}
		Optional<CurrentUserLoginSession> sessionExistence = sessionRepo.findByUserId(opt.get().getUserId());
		if(sessionExistence.isPresent()) {
			throw new InvalidCredentialException("User already logged in");
		}
		if(!(opt.get().getEmail().equals(user.getEmail()))){
			throw new InvalidCredentialException("Invalid Email Address...");
		}
		else if(!(opt.get().getPassword().equals(user.getPassword()))) {
			throw new InvalidCredentialException("Invalid Password...");
		}
		else if(!(opt.get().getPassword().equals(user.getPassword()) && opt.get().getEmail().equals(user.getEmail()))){
			throw new InvalidCredentialException("Invalid Credentials...");
		}
		SessionDTO sdt = new SessionDTO();
		CurrentUserLoginSession culs = new CurrentUserLoginSession();
		String authKey = UUID.randomUUID().toString();
		culs.setAuthKey(authKey);
		culs.setSessionStartTime(LocalDateTime.now());
		sdt.setAuthKey(culs.getAuthKey());
		sdt.setSessionStartTime(culs.getSessionStartTime());
		culs.setUserId(opt.get().getUserId());
		sessionRepo.save(culs);
		return sdt;
	}

	@Override
	public String userLogout(String authKey)throws InvalidCredentialException {
		Optional<CurrentUserLoginSession> culs = sessionRepo.findByAuthkey(authKey);
		if(!culs.isPresent()) {
			throw new InvalidCredentialException("User has not logged In with key : "+authKey);
		}
		sessionRepo.delete(culs.get());
		return "Logout successfully...";
	}
	
	
	
}
