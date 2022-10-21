package app.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.trip.exceptions.TravelException;
import app.trip.models.Travel;
import app.trip.services.TravelService;

@RestController
@CrossOrigin(origins = "*")
public class TravelController {
	
	@Autowired
	private TravelService tService;
	
	@PostMapping("/travels/{key}")
	public ResponseEntity<Travel> addTravel(@PathVariable("key") String key,@RequestBody Travel travel) throws TravelException{
		
		Travel travels=tService.addTravels(travel, key);
	
		return new ResponseEntity<>(travels,HttpStatus.CREATED);
	
	}
	
	@PutMapping("/travelsUpdate/{key}")
	public ResponseEntity<Travel> updateTravel(@PathVariable("key") String key,@RequestBody Travel travel) throws TravelException{
		
		Travel travels=tService.updateTravels(travel,key);
	
		return new ResponseEntity<>(travels,HttpStatus.CREATED);
	
	}
	
	@DeleteMapping("/travelsDelete/{travelId}/{key}")
	public ResponseEntity<Travel> deleteTravel(@PathVariable("key") String key,@PathVariable("travelId") Integer travelId) throws TravelException{
		
		Travel travels=tService.removeTravels(travelId, key);
	
		return new ResponseEntity<>(travels,HttpStatus.CREATED);
	
	}
	
	@GetMapping("/travelsSearch/{travelId}")
	public ResponseEntity<Travel> serchTravel(@PathVariable("travelId") Integer travelId) throws TravelException{
		
		Travel travels=tService.serchTravels(travelId);
	
		return new ResponseEntity<>(travels,HttpStatus.CREATED);
	
	}
	
	@GetMapping("/travelsList")
	public ResponseEntity<List<Travel>> getListOfTravel() throws TravelException{
		
		List<Travel> travels=tService.viewTravels();
	
		return new ResponseEntity<>(travels,HttpStatus.CREATED);
	
	}

}
