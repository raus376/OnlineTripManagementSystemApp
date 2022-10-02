package app.trip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.trip.exceptions.HotelException;
import app.trip.models.CurrentUserLoginSession;
import app.trip.models.Hotel;
import app.trip.models.Packages;
import app.trip.models.User;
import app.trip.repository.HotelDao;
import app.trip.repository.PackageRepository;
import app.trip.repository.SessionRepository;
import app.trip.repository.UserRepository;



@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelDao hotelDao;
	
	@Autowired
	 private SessionRepository sessionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PackageRepository packageRepository;

	@Override
	public Hotel addHotel(Integer packageId,Hotel hotel, String authKey) throws HotelException {
		
	     Optional<CurrentUserLoginSession> opt=sessionRepository.findByAuthkey(authKey);
	     
	     if(!opt.isPresent())
	     {
	    	 throw new HotelException("The admin is not logged in. Please Log in first");
	     }
	     else 
	     {
	    	 CurrentUserLoginSession currentUser=opt.get();
	    	 Optional<User> opt2=userRepository.findById(currentUser.getUserId());
	    	  User user=opt2.get();
	    	  if(user.getUserType().equals("admin"))
	    	  {
	    		  
	    		 Optional<Packages> optPackage=packageRepository.findById(packageId);
	    		  if(!optPackage.isPresent())
	    		     {
	    		    	 throw new HotelException("Package with given pakcage Id does not exist");
	    		     }
                Packages packages = optPackage.get();
                
                hotel.setPackages(packages);
                Hotel returnedHotel=hotelDao.save(hotel);
            
                 return returnedHotel;
	    		  
	    	  }
	    	  else 
	    	  {
	    		  throw new HotelException("Kindly log in as Admin");	
			}
		 	
		 }
	}

	@Override
public Hotel deleteHotel(Integer hotelId, String authKey) throws HotelException {
		
		Optional<CurrentUserLoginSession> opt=sessionRepository.findByAuthkey(authKey);
	     
	     if(!opt.isPresent())
	     {
	    	 throw new HotelException("The admin is not logged in. Please Log in first");
	     }
	     else 
	     {
	    	 CurrentUserLoginSession currentUser=opt.get();
	    	 Optional<User> opt2=userRepository.findById(currentUser.getUserId());
	    	  User user=opt2.get();
	    	  if(user.getUserType().equals("admin"))
	    	  {
	    		  Optional<Hotel> hotelOpt=hotelDao.findById(hotelId);
	    		  if(!hotelOpt.isPresent())
	    		     {
	    		    	 throw new HotelException("No hotel present with the given hotel Id;");
	    		     }
	    		  else 
	    		  {
	    			  Hotel hotel=hotelOpt.get();
	    			  Packages packages=hotel.getPackages();
	    			  
	    			  hotel.setPackages(null);
	    			  hotelDao.delete(hotel);
	    			  packageRepository.save(packages);
	    			 
	    			  return hotel;
				 }
	    		  
	    	  }
	    	  else 
	    	  {
	    		  throw new HotelException("Kindly log in as Admin");	
			}
		 	
		 }
	}

	@Override
public Hotel updateHotel(Hotel hotel, String authKey) throws HotelException {
		
		Optional<CurrentUserLoginSession> opt=sessionRepository.findByAuthkey(authKey);
	     
	     if(!opt.isPresent())
	     {
	    	 throw new HotelException("The admin is not logged in. Please Log in first");
	     }
	     else 
	     {
	    	 CurrentUserLoginSession currentUser=opt.get();
	    	 Optional<User> opt2=userRepository.findById(currentUser.getUserId());
	    	  User user=opt2.get();
	    	  if(user.getUserType().equals("admin"))
	    	  {
	    		  Optional<Hotel> hotelOpt=hotelDao.findById(hotel.getHotelId());
	    		  if(!hotelOpt.isPresent())
	    		     {
	    		    	 throw new HotelException("No hotel present with the given details;");
	    		     }
	    		  else 
	    		  {
	    			  Hotel returnedHotel=hotelOpt.get();
	    			  if(hotel.getAddress()!=null) {
	    				  returnedHotel.setAddress(hotel.getAddress());
	    			  }
	    			  if(hotel.getHotelDescription()!=null) {
	    				  returnedHotel.setHotelDescription(hotel.getHotelDescription());
	    			  }
	    			  if(hotel.getHotelName()!=null) {
	    				  returnedHotel.setHotelName(hotel.getHotelName());
	    			  }
	    			  if(hotel.getHotelType()!=null) {
	    				  returnedHotel.setHotelType(hotel.getHotelType());
	    			  }
	    			  if(hotel.getRent()!=0) {
	    				  returnedHotel.setRent(hotel.getRent());
	    			  }
	    			  if(hotel.getStatus()!=null) {
	    				  returnedHotel.setStatus(hotel.getStatus());
	    			  }
	    			 return hotelDao.save(returnedHotel);
	    			 
				 }
	    		  
	    	  }
	    	  else 
	    	  {
	    		  throw new HotelException("Kindly log in as Admin");	
			}
		 	
		 }
	}
}
