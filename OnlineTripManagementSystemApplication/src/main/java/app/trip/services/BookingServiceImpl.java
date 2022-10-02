package app.trip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.trip.exceptions.BookingException;
import app.trip.models.Booking;
import app.trip.models.CurrentUserLoginSession;
import app.trip.models.Packages;
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
	public Booking makeBooking(Booking bookings, Integer pkgId) throws BookingException {
		Optional<Packages> packagesOpt = pkgRepo.findById(pkgId);
		
		if(packagesOpt.isPresent()) {
			List<User> users = bookings.getUsers();
			for(User user:users) {
				 user.getBookings().add(bookings);
			}
			bookings.setPackages(packagesOpt.get());
			return bookRepo.save(bookings);
		}else {
			throw new BookingException("Provide valid package... ");
		}	
	}
	
	
	@Override
	public Booking cancelBooking(Integer bookingsId) throws BookingException {
		Booking booking = null;
		Optional<Booking> book = bookRepo.findById(bookingsId);
		if(book.isPresent()) {
			booking = book.get();
			List<User> users = booking.getUsers();
			for(User user:users) {
				 user.getBookings().remove(booking);
			}
			bookRepo.delete(booking);
			return booking;
		}else {
			throw new BookingException("Booking not exists");
		}
				
	}
	
	/*
	 * entityManager.remove(group)
		for (User user : group.users) {
		     user.groups.remove(group);
		}
	 */

	@Override
	public List<Booking> viewBookings(Integer userId) throws BookingException {
		User user = null;
		Optional<User> userOpt = userRepo.findById(userId);
		if(userOpt.isPresent()) {
			user = userOpt.get();
			List<Booking> bookings = user.getBookings();
			if(bookings.isEmpty()) {
				throw new BookingException("No booking exists..");
			}
			return bookings;
		}else {
			throw new BookingException("No user exists..");
		}
		
	}


	@Override
	public List<Booking> viewAllBookings(String authKey) throws BookingException {
		Optional<CurrentUserLoginSession> currUser = sessionRepo.findByAuthkey(authKey);
		String userType = userRepo.findById(currUser.get().getUserId()).get().getUserType();
		List<Booking> bookings = null;
		if(userType.equalsIgnoreCase("user")) {
			throw new BookingException("Unauthorized Request...");
		}
		else{
			bookings = bookRepo.findAll();
			if(bookings.isEmpty()) {
				throw new BookingException("No bookings available...");
			}else {
				return bookings;
			}
		}
	}
	

}
