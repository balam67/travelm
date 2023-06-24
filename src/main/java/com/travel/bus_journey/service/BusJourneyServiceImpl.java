package com.travel.bus_journey.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.travel.bus_journey.entity.ActivationStatus;
import com.travel.bus_journey.entity.BookingStatus;
import com.travel.bus_journey.entity.BusJourney;
import com.travel.bus_journey.entity.BusSearchForm;
import com.travel.bus_journey.repository.BusJourneyRepository;

@Service
public class BusJourneyServiceImpl implements BusJourneyService {

	//@Autowired
    //private final BusJourneyRepository busJourneyRepository;

	/*
	 * @Autowired public BusJourneyServiceImpl(BusJourneyRepository
	 * busJourneyRepository) { this.busJourneyRepository = busJourneyRepository; }
	 * 
	 * 
	 */
	
	@Autowired
	private BusJourneyRepository busJourneyRepository;
    @Autowired
	 private  EntityManager entityManager;

	
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
		
		
		
		
		
		  @Override 
		  public List<BusJourney> searchBuses(BusSearchForm busSearchForm) {
		  
		  System.out.println("Input Data in service class   "+busSearchForm.toString()) ; 
		  BusJourney bus = new BusJourney();
		  
		  if (null != busSearchForm.getArrivalCity() && !"".equals(busSearchForm.getArrivalCity())) {
		       bus.setArrivalCity(busSearchForm.getArrivalCity());
		       
		  }
		  
		  if (null != busSearchForm.getBusNumber() && !"".equals(busSearchForm.getBusNumber())) {
		       bus.setBusNumber(busSearchForm.getBusNumber());
		  
		  }
		  
		  if (null != busSearchForm.getDepartureCity() &&  !"".equals(busSearchForm.getDepartureCity())) {
		       bus.setDepartureCity(busSearchForm.getDepartureCity()); 
		  
		  }
		  
		  
		  if (null != busSearchForm.getFromDate() && !"".equals(busSearchForm.getFromDate())) {
				  bus.setFromDate(busSearchForm.getFromDate()); 
				  
		  
		  }
		  if (null != busSearchForm.getToDate() && !"".equals(busSearchForm.getToDate())) {
			  bus.setToDate(busSearchForm.getToDate()); 
			  
	  
	  }
		  if (null != busSearchForm.getBookingStatus() && !"".equals(busSearchForm.getBookingStatus())) {
			  bus.setBookingStatus(busSearchForm.getBookingStatus()); 
			  
	  
	  }
		  if (null != busSearchForm.getCustomerId() && !"".equals(busSearchForm.getCustomerId())) {
			  bus.setCustomerId(busSearchForm.getCustomerId()); 
			  
	  
	  }
		  
		  Example<BusJourney> example = Example.of(bus);

			List<BusJourney> findAll = busJourneyRepository.findAll(example);
  
			 System.out.println("Output Data in service class   "+findAll.toString()) ; 
			//findAll.forEach(System.out::println);

			return findAll;
		  }
		  
		 
		    
		

		//@Override
		public List<BusJourney> searchBuses1(BusSearchForm busSearchForm) {
			
			
			
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		    CriteriaQuery<BusJourney> criteriaQuery = criteriaBuilder.createQuery(BusJourney.class);
		    Root<BusJourney> root = criteriaQuery.from(BusJourney.class);

		    List<Predicate> predicates = new ArrayList<>();

		    if (null != busSearchForm.getArrivalCity() && !"".equals(busSearchForm.getArrivalCity())) {
		        predicates.add(criteriaBuilder.equal(root.get("arrivalCity"), busSearchForm.getArrivalCity()));
		    }

		    if (null != busSearchForm.getBusNumber() && !"".equals(busSearchForm.getBusNumber())) {
		        predicates.add(criteriaBuilder.equal(root.get("busNumber"), busSearchForm.getBusNumber()));
		    }

		    if (null != busSearchForm.getDepartureCity() && !"".equals(busSearchForm.getDepartureCity())) {
		        predicates.add(criteriaBuilder.equal(root.get("departureCity"), busSearchForm.getDepartureCity()));
		    }

		    criteriaQuery.select(root)
		            .where(predicates.toArray(new Predicate[0]));

		    return entityManager.createQuery(criteriaQuery).getResultList();
			
	
			
			
		}

		@Override
		public List<BusJourney> findUnassignedBusJourneys() {
			// TODO Auto-generated method stub
			return busJourneyRepository.findUnassignedBusJourneys();
		}
 
		    
	
			
			
}
		







