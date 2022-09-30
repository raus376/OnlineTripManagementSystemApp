package app.trip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import app.trip.exceptions.BookingException;
import app.trip.models.Booking;
import app.trip.models.CurrentUserLoginSession;
import app.trip.models.User;
import app.trip.repository.BookingRepository;
import app.trip.repository.PackageRepository;
import app.trip.repository.SessionRepository;
import app.trip.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	PackageRepository pkgRepo;
	
	@Autowired
	SessionRepository sessionRepo;
	
	@Autowired
	BookingRepository bookRepo;
	
	@Autowired
	UserRepository userRepo;
	
	/*
	 * Need get/setBookings 
	 */
	@Override
	public Booking makeBooking(Booking bookings) throws BookingException {
		List<User> users = bookings.getUsers();
		for(User user:users) {
			// user.getBookings.setBookings(bookings);
		}
		return bookRepo.save(bookings);
	}

	@Override
	public boolean cancelBooking(Booking bookings) throws BookingException {
		Integer bookingId = bookings.getBookingId();
		if(bookingId != null) {
			bookRepo.deleteById(bookings.getBookingId());
			return true;
		}else {
			throw new BookingException("Booking not exists");
		}
	}
	
	/*
	 * @Query("select s.name from Student s where s.roll=:roll")
		public String getStudentNameByRoll(@Param("roll") int roll);
		
		select * from booking Inner join booking_users on 
		booking.booking_id = booking_users.booking_booking_id;
	 */
	@Override
	public List<Booking> viewBookings(User user) throws BookingException {
		
		return null;
	}

	@Override
	public List<Booking> viewAllBookings(String authKey) throws BookingException {
		Optional<CurrentUserLoginSession> currUser = sessionRepo.findByAuthkey(authKey);
		String userType = userRepo.findById(currUser.get().getUserId()).get().getUserType();
		if(userType.equalsIgnoreCase("user")) {
			throw new BookingException("Unauthorized Request...");
		}
		else{
			return bookRepo.findAll();
		}
	}
	

}
