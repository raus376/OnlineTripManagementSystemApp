package app.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.trip.models.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel,Integer>{

}
