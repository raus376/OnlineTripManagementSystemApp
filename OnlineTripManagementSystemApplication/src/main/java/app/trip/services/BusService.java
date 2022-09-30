package app.trip.services;

import app.trip.exceptions.BusException;
import app.trip.models.Bus;

public interface BusService {
	
	public Bus registerBus(Bus bus,String authKey) throws BusException;

}
