package app.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.trip.exceptions.BusException;
import app.trip.exceptions.TravelException;
import app.trip.models.Bus;
import app.trip.models.Travel;
import app.trip.services.BusService;

@RestController
public class BusController {
	
	@Autowired
	private BusService bService;
	
	@GetMapping("/busesAll")
	public ResponseEntity<List<Bus>> serchTravle() throws TravelException, BusException{
		
		List<Bus> busList=bService.getAllBusFromAllAgency();
	
		return new ResponseEntity<>(busList,HttpStatus.CREATED);
	
	}

}
