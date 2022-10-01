package app.trip.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.trip.exceptions.InvalidCredentialException;
import app.trip.models.CurrentUserLoginSession;
import app.trip.models.User;

@Repository
public interface SessionRepository extends JpaRepository<CurrentUserLoginSession, Integer>{
	
	public Optional<CurrentUserLoginSession> findByUserId(Integer userId)throws InvalidCredentialException;
	@Query("select c from CurrentUserLoginSession c where c.authKey=?1")
	public Optional<CurrentUserLoginSession> findByAuthkey(String key);
}	
