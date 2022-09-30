package app.trip.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.trip.exceptions.BusException;
import app.trip.models.Bus;
import app.trip.models.Travel;
import app.trip.repository.BusRepository;
import app.trip.repository.SessionRepository;
import app.trip.repository.TravelRepository;
import app.trip.repository.UserRepository;

@Service
public class BusServiceImplimentation implements BusService{

	@Autowired
	private TravelRepository tDao;
	
	@Autowired
	private SessionRepository sRepo;
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private BusRepository bRepo;
	
	
	
	@Override
	public List<Bus> getAllBusFromAllAgency() throws BusException {
		List<Bus> busList=new ArrayList<>();
		List<Travel> travelList=tDao.findAll();
		
		if(travelList.size()>0) {
			
			
			for(Travel t:travelList) {
				List<Bus> busList2=t.getBuses();
				if(busList2.size()>0) {
					for(Bus b:busList2) {
						busList.add(b);
					}
				}
			}
			return busList;
		}
		else
			throw new BusException("Buses are not present");
	}



	

}
