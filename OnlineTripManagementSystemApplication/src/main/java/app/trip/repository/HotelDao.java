package app.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.trip.models.Hotel;



@Repository
public interface HotelDao extends JpaRepository<Hotel, Integer>{

}
