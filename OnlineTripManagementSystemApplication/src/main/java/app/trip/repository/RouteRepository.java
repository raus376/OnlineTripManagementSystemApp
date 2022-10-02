package app.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.trip.models.Route;


public interface RouteRepository extends JpaRepository<Route, Integer> {
	
}
