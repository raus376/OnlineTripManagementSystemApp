package app.trip.services;

import app.trip.exceptions.HotelException;
import app.trip.models.Hotel;



public interface HotelService {
	
	public Hotel addHotel(Integer packageId,Hotel hotel, String authKey) throws HotelException;
	
	public Hotel deleteHotel(Integer hotelId, String authKey) throws HotelException;
	
	public Hotel updateHotel(Hotel hotel, String authKey) throws HotelException;
	
	

}
