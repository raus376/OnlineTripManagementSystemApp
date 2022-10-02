package app.trip.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.trip.exceptions.BookingException;
import app.trip.models.Booking;
import app.trip.services.BookingService;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "*")
public class BookingController {
	
	@Autowired
	BookingService bookingService;

	@DeleteMapping("/cancel")
	public ResponseEntity<Booking> cancelBooking(@RequestParam Integer bookingId) throws BookingException {
		Booking booking = null;
		booking = bookingService.cancelBooking(bookingId);
		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
	}
	

	@PostMapping("/book")
	public ResponseEntity<Booking> makeBookings (@Valid @RequestBody Booking booking, @RequestParam Integer pkgId) throws BookingException{
		Booking createBooking = null;
		createBooking = bookingService.makeBooking(booking, pkgId);
		return new ResponseEntity<Booking>(createBooking, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/showBooking")
	public ResponseEntity<List<Booking>> viewBookings(@RequestParam(required = false) Integer userId) throws BookingException{
		List<Booking> bookings = null;
		bookings = bookingService.viewBookings(userId);
		return new ResponseEntity<List<Booking>>(bookings, HttpStatus.FOUND);
	}
	
	@GetMapping("/showAllBooking")
	public ResponseEntity<List<Booking>> viewBookings(@RequestParam(required = false) String authKey) throws BookingException{
		List<Booking> bookings = null;
		bookings = bookingService.viewAllBookings(authKey);
		return new ResponseEntity<List<Booking>>(bookings, HttpStatus.FOUND);
	}
	
}
