package app.trip.services;

import java.util.List;

import app.trip.exceptions.BusException;
import app.trip.models.Bus;

public interface BusService {
	
	public List<Bus> getAllBusFromAllAgency() throws BusException;

}
