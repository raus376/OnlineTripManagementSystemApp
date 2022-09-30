package app.trip.services;

import java.util.List;

import app.trip.exceptions.TravelException;
import app.trip.models.Travel;

public interface TravelService {
	
	
	
	public Travel addTravels(Travel travel , String authKey) throws TravelException;
	
	public Travel updateTravels(Travel travel,String authKey) throws TravelException;

	public Travel removeTravels(Integer travelId,String authKey) throws TravelException;
	
	public Travel serchTravels(Integer travelId) throws TravelException;
	
	public List<Travel> viewTravels() throws TravelException;
}
