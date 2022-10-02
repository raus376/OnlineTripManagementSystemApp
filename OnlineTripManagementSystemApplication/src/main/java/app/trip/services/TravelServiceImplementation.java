package app.trip.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.trip.exceptions.TravelException;
import app.trip.models.Bus;
import app.trip.models.CurrentUserLoginSession;
import app.trip.models.Travel;
import app.trip.models.User;
import app.trip.repository.SessionRepository;
import app.trip.repository.TravelRepository;
import app.trip.repository.UserRepository;

@Service
public class TravelServiceImplementation implements TravelService{

	@Autowired
	private TravelRepository tDao;
	
	@Autowired
	private SessionRepository sRepo;
	
	@Autowired
	private UserRepository uRepo;

//	@Override
//	public Travel addTravels(Travel travel) {
////		Integer id=travel.getTravelId();
//		
////		Set<Bus> buses=travel.getBuses();
////		
//////		for(Bus b:buses) {
////           
////			travel.setBuses(buses);
//			
////		}
//		
//	}

	@Override
	public Travel addTravels(Travel travel, String authKey) throws TravelException {
      Travel t=null;
       Optional<CurrentUserLoginSession> opt=sRepo.findByAuthkey(authKey);
	
       if(!opt.isPresent()) {
    	   throw new TravelException("Please Login first");
       }
       else {
    	   CurrentUserLoginSession loginSession=opt.get();
	    	 Optional<User> optUser=uRepo.findById(loginSession.getUserId());
	    	  User user=optUser.get();
	    	  
	    	  if(user.getUserType().equals("admin")) {
	    		 	
	    		Set<Bus> buses= travel.getBuses();
	    		for(Bus b:buses) {
	    			b.setTDetails(travel);
	    		}
	    		t= tDao.save(travel);	
	    	  }
	    	  else {
	    		  throw new TravelException("Only Admin have to Access this.");
	    	  }
	    	  
       }
	return t;
	
	}

@Override
public Travel updateTravels(Travel travel, String authKey) throws TravelException {
	
    Travel t=null;
    Optional<CurrentUserLoginSession> opt=sRepo.findByAuthkey(authKey);
	
    if(!opt.isPresent()) {
 	   throw new TravelException("Please Login first");
    }
    else {
 	   CurrentUserLoginSession loginSession=opt.get();
	    	 Optional<User> optUser=uRepo.findById(loginSession.getUserId());
	    	  User user=optUser.get();
	    	  
	    	  if(user.getUserType().equals("admin")) {
	    		 Optional<Travel> updateTravel= tDao.findById(travel.getTravelId());
	    		 
	    		 if(!updateTravel.isPresent()) {
	    			 throw new TravelException("Travel Id does not match");
	    		 }
	    		 else {
	    			Set<Bus> busSet= travel.getBuses();
	    			
	    			for(Bus b:busSet) {
	    				b.setTDetails(travel);
	    			}
	    			 t=tDao.save(travel);
	    		 }
	    		 
	    	  }
	    	  else {
	    		  throw new TravelException("Only Admin have to Access this.");
	    	  }
	    	  
    }
	return t;
	 
}

@Override
public Travel removeTravels(Integer travelId, String authKey) throws TravelException {
	
	 Travel t=null;
	    Optional<CurrentUserLoginSession> opt=sRepo.findByAuthkey(authKey);
		
	    if(!opt.isPresent()) {
	 	   throw new TravelException("Please Login first");
	    }
	    else {
	 	   CurrentUserLoginSession loginSession=opt.get();
		    	 Optional<User> optUser=uRepo.findById(loginSession.getUserId());
		    	  User user=optUser.get();
		    	  
		    	  if(user.getUserType().equals("admin")) {
		    		 Optional<Travel> findTravel= tDao.findById(travelId);
		    		 
		    		 if(!findTravel.isPresent()) {
		    			 throw new TravelException("Travel Agency is not present with: "+travelId);
		    		 }
		    		 else {
                         t= findTravel.get();
                         tDao.delete(t);
                         
                        
		    		 }
		    		 
		    	  }
		    	  else {
		    		  throw new TravelException("Only Admin have to Access this.");
		    	  }
		    	  
	    }
		return t;
		
}

@Override
public Travel serchTravels(Integer travelId) throws TravelException {

     Optional<Travel> opt=tDao.findById(travelId);
     
     if(opt.isPresent()) {
    	return opt.get();
     }
     else
    	 throw new TravelException("Travel Agency not found with : "+travelId);
}

@Override
public List<Travel> viewTravels() throws TravelException {

      List<Travel> travelList= tDao.findAll();
      if(travelList.size()>0) {
    	  return travelList;
      }
      else
    	  throw new TravelException("No any Travel Agency is present");
}


	
	
	
	
}
