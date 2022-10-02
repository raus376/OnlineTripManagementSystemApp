package app.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.trip.models.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus,Integer>{

}
