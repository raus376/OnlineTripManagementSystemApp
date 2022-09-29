package app.trip.repository.authentication;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.trip.exceptions.authentication.UserAlreadyExistsException;
import app.trip.models.authentication.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public Optional<User> findByEmail(String email);
}
