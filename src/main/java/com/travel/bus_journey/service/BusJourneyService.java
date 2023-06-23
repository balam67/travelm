package com.travel.bus_journey.service;

import java.util.List;

import com.travel.bus_journey.entity.BusJourney;
import com.travel.bus_journey.entity.BusSearchForm;

public interface BusJourneyService {
    BusJourney saveBusJourney(BusJourney busJourney);

    BusJourney updateBusJourney(BusJourney busJourney);

    void deleteBusJourney(Long id);

    public List<BusJourney> searchBuses(BusSearchForm busSearchForm);
    List<BusJourney> getAllBusJourneys();

    BusJourney getBusJourneyByBusNumber(String busNumber);
    List<BusJourney> searchByCities(String departureCity, String arrivalCity);
     BusJourney getBusBusId(Long id);
     BusJourney updateBusJourneyActivationStatusToDeactivate(BusJourney busJourney);
     BusJourney updateBusJourneyActivationStatusToActivate(BusJourney busJourney);
     
     List<BusJourney> searchBusJourneys(BusJourney searchCriteria);
     BusJourney saveBusJourneyTicket(BusJourney busJourney);
}

