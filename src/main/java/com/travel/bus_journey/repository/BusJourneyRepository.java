package com.travel.bus_journey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.bus_journey.entity.BusJourney;

@Repository
public interface BusJourneyRepository extends JpaRepository<BusJourney, Long> {

	BusJourney findByBusNumber(String busNumber);

    // Add any additional custom query methods if needed
	
	  @Query("SELECT b FROM BusJourney b WHERE b.departureCity = :departureCity AND b.arrivalCity = :arrivalCity")
	    List<BusJourney> searchByCities(@Param("departureCity") String departureCity, @Param("arrivalCity") String arrivalCity);

}
