package app.trip.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.trip.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
	
}
