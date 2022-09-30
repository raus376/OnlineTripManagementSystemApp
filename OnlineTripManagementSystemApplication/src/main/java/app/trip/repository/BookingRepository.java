package app.trip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.trip.exceptions.BookingException;
import app.trip.models.Booking;
import app.trip.models.User;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
	@Query("DELETE FROM booking WHERE booking_id= ?1")
	List<Booking> viewBookings(User user) throws BookingException;
	
}
