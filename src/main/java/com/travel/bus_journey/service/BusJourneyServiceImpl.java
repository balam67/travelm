package com.travel.bus_journey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.travel.bus_journey.entity.ActivationStatus;
import com.travel.bus_journey.entity.BookingStatus;
import com.travel.bus_journey.entity.BusJourney;
import com.travel.bus_journey.repository.BusJourneyRepository;

@Service
public class BusJourneyServiceImpl implements BusJourneyService {

	@Autowired
    private final BusJourneyRepository busJourneyRepository;

    @Autowired
    public BusJourneyServiceImpl(BusJourneyRepository busJourneyRepository) {
        this.busJourneyRepository = busJourneyRepository;
    }

    @Override
    public BusJourney saveBusJourney(BusJourney busJourney) {
    	
    	busJourney.setActivationStatus(ActivationStatus.ACTIVE);
    	busJourney.setBookingStatus(BookingStatus.AVAILABLE);
        return busJourneyRepository.save(busJourney);
    }

    @Override
    public BusJourney updateBusJourney(BusJourney busJourney) {
        if (busJourney.getId() == null) {
            throw new IllegalArgumentException("Bus journey ID cannot be null");
        }
        
        busJourney.setActivationStatus(ActivationStatus.ACTIVE);
    	busJourney.setBookingStatus(BookingStatus.AVAILABLE);
        return busJourneyRepository.save(busJourney);
    }

    @Override
    public void deleteBusJourney(Long id) {
        busJourneyRepository.deleteById(id);
    }

    @Override
    public List<BusJourney> getAllBusJourneys() {
    	System.out.println("getAllBusJourneys() IN SERVICE CLASS");
        return busJourneyRepository.findAll();
    }

    @Override
    public BusJourney getBusJourneyByBusNumber(String busNumber) {
        return busJourneyRepository.findByBusNumber(busNumber);
    }

	@Override
	public BusJourney getBusBusId(Long id) {
		// TODO Auto-generated method stub
		 return busJourneyRepository.getById(id);
	}

	@Override
	public BusJourney updateBusJourneyActivationStatusToDeactivate(BusJourney busJourney) {
		
		 if (busJourney.getId() == null) {
	            throw new IllegalArgumentException("Bus journey ID cannot be null");
	        }
	        
	        busJourney.setActivationStatus(ActivationStatus.INACTIVE);
	    	busJourney.setBookingStatus(BookingStatus.AVAILABLE);
	        return busJourneyRepository.save(busJourney);
	}

	@Override
	public BusJourney updateBusJourneyActivationStatusToActivate(BusJourney busJourney) {
		if (busJourney.getId() == null) {
            throw new IllegalArgumentException("Bus journey ID cannot be null");
        }
        
        busJourney.setActivationStatus(ActivationStatus.ACTIVE);
    	busJourney.setBookingStatus(BookingStatus.AVAILABLE);
        return busJourneyRepository.save(busJourney);
	}

	
		

		@Override
		public List<BusJourney> searchBusJourneys(BusJourney searchCriteria) {
			
			String arrivalCity = searchCriteria.getArrivalCity();
			String departureCity = searchCriteria.getDepartureCity();
			
			List<BusJourney> searchByCities = searchByCities( departureCity,  arrivalCity); 
			 
			 return searchByCities;
			
			
	     
	      
		}

		@Override
		public BusJourney saveBusJourneyTicket(BusJourney busJourney) {
			busJourney.setActivationStatus(ActivationStatus.ACTIVE);
	    	busJourney.setBookingStatus(BookingStatus.BOOKED);
	        return busJourneyRepository.save(busJourney);
		}

		@Override
		public List<BusJourney> searchByCities(String departureCity, String arrivalCity) {
			// TODO Auto-generated method stub
			return busJourneyRepository.searchByCities(departureCity, arrivalCity);
		}
}
		







