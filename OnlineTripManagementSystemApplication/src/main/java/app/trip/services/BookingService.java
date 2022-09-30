package app.trip.services;

import java.util.List;

import app.trip.exceptions.BookingException;
import app.trip.models.Booking;
import app.trip.models.User;

public interface BookingService {
	
	public Booking makeBooking(Booking bookings) throws BookingException;;
	public boolean cancelBooking(Booking bookings) throws BookingException;; 
	public List<Booking> viewBookings(User user) throws BookingException;;
	/*
	 * Administrator Access
	 */
	public List<Booking> viewAllBookings(String authKey) throws BookingException;;
}
