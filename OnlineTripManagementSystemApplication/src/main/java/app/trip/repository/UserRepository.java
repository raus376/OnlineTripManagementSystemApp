package app.trip.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.trip.exceptions.UserAlreadyExistsException;
import app.trip.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public Optional<User> findByEmail(String email);
	
	public Optional<User>  findByUserId(Integer userId);
	
}
