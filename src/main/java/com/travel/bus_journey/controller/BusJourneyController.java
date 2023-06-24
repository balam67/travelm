package com.travel.bus_journey.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.stream.Collectors;

import com.travel.bus_journey.entity.BusJourney;
import com.travel.bus_journey.entity.BusSearchForm;
import com.travel.bus_journey.service.BusJourneyService;

@Controller
@RequestMapping("/bus-journey")
public class BusJourneyController {

    private final BusJourneyService busJourneyService;

    @Autowired
    public BusJourneyController(BusJourneyService busJourneyService) {
        this.busJourneyService = busJourneyService;
    }

    @GetMapping("/show_bus_journeys")
    public String getAllBusJourneys(Model model) {
        model.addAttribute("busJourneys", busJourneyService.getAllBusJourneys());
        return "show_all_bus_journeys";
    }

    
    @GetMapping("/show_bus_journeys_homepage")
    public String getBusJourneysHomePage(Model model) {
    	 model.addAttribute("busJourney", new BusJourney());
    	
        return "show_bus_journeys_home_page";
    }

    
    //customer related bus
    @GetMapping("/search_by_busno")
    public String searchByBusNumber(@RequestParam("busNumber") String busNumber, Model model) {
        BusJourney busJourney = busJourneyService.getBusJourneyByBusNumber(busNumber);
        model.addAttribute("busJourney", busJourney);
        return "bus_journey_details_by_busno";
    }

    @GetMapping("/create-bus_journey")
    public String showCreateForm(Model model) {
        model.addAttribute("busJourney", new BusJourney());
        return "create_bus_journey";
    }

    @PostMapping("/create-bus_journey")
    public String createBusJourney(@ModelAttribute("busJourney") BusJourney busJourney) {
        busJourneyService.saveBusJourney(busJourney);
        return "redirect:/bus-journey/show_bus_journeys";
    }

    @GetMapping("/updateBus")
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        BusJourney busJourney = busJourneyService.getBusBusId(id);
        model.addAttribute("busJourney", busJourney);
        return "edit_bus_journey";
    }
    

    @GetMapping("/bookTicket")
    public String getUnassignedBusJourneys(@RequestParam("id") Long id) {
    	System.out.println("Customer Id "+id);
    	
         List<BusJourney> findUnassignedBusJourneys = busJourneyService.findUnassignedBusJourneys();
         System.out.println("List of AVAILABLE "+findUnassignedBusJourneys); 
         
         for (BusJourney busJourney : findUnassignedBusJourneys) {
             System.out.println("Customer id " + busJourney.getBookingStatus());
             
             // Perform operations on each unassigned bus journey
             if (busJourney.getBookingStatus().equals("AVAILABLE")) {
                 busJourney.setCustomerId(1l);
                 updateBusJourneyForTicket(busJourney);
                 break; // Exit the loop after the condition is met
             }
         }

         return "redirect:/bus-journey/search";
         
    }
   
    
	/*
	 * @GetMapping("/bookTicket") public String bookBusTicket(@RequestParam("id")
	 * Long id, Model model) {
	 * 
	 * 
	 * 
	 * List<BusJourney> allBusJourneys = busJourneyService.getAllBusJourneys();
	 * 
	 * 
	 * 
	 * model.addAttribute("allBusJourneys", allBusJourneys); return "busResults"; }
	 */
    
    @GetMapping("/deactivateBus")
    public String showEditFormForBusActivationStatusToDeactivate(@RequestParam("id") Long id, Model model) {
        BusJourney busJourney = busJourneyService.getBusBusId(id);
        
        busJourney= busJourneyService.updateBusJourneyActivationStatusToDeactivate(busJourney);
        
        model.addAttribute("busJourney", busJourney);
        return "redirect:/bus-journey/show_bus_journeys";
    }
    
    @GetMapping("/activateBus")
    public String showEditFormForBusActivationStatusToActivate(@RequestParam("id") Long id, Model model) {
        BusJourney busJourney = busJourneyService.getBusBusId(id);
        
        busJourney= busJourneyService.updateBusJourneyActivationStatusToActivate(busJourney);
        
        model.addAttribute("busJourney", busJourney);
        return "redirect:/bus-journey/show_bus_journeys";
    }
    
    public void updateBusJourneyForTicket( BusJourney busJourney) {
        busJourneyService.updateBusJourney(busJourney);
        
    }

    @PostMapping("/updateBus")
    public String updateBusJourney(@ModelAttribute("busJourney") BusJourney busJourney) {
        busJourneyService.updateBusJourney(busJourney);
        return "redirect:/bus-journey/show_bus_journeys";
    }

    @GetMapping("/deleteBus")
    public String deleteBusJourney(@RequestParam("id") Long id) {
        busJourneyService.deleteBusJourney(id);
        return "redirect:/bus-journey/show_bus_journeys";
    }
    
    @GetMapping("/search_bus_journey")
    public String searchBusJourneysByInput(Model model) {
    	
    	
        model.addAttribute("busJourneyByInput", new BusJourney());
    																																
        return "search_bus_journey";
    }
    
    
    @PostMapping("/search_bus_journey_details")
    public String searchBusJourneys(@ModelAttribute("busJourney") BusJourney busJourney,Model model) {
    	List<BusJourney> searchBusJourneys = busJourneyService.getAllBusJourneys();
    	
    	model.addAttribute("searchBusJourneys", searchBusJourneys);
    	System.out.println("busJourney object from jsp"+busJourney.toString());	
        System.out.println("searchBusJourneys object from database"+searchBusJourneys.toString());																															
        return "search_bus_journey_post";
    }
    
                          
    @GetMapping("/save_booking")
    public String BookBusJourneys(@RequestParam("busJourneyId") Long busJourneyId,Model model) {
    	System.out.println(busJourneyId);
    	BusJourney busBusIdDetails = busJourneyService.getBusBusId(busJourneyId);
        model.addAttribute("busBusIdDetails", busJourneyService.saveBusJourneyTicket(busBusIdDetails));
        return "search_bus_journey_status";
    }
    
    
    @GetMapping("/search")
    public String searchJourneys(Model model) {
    	
    	
    	
    	 model.addAttribute("busSearchForm", new BusSearchForm());
    	
        return "searchBus";
    }
    
   
    // ...
    
    
    

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchBuses(@ModelAttribute("busSearchForm") BusSearchForm busSearchForm, Model model) {
    	LocalDate fromDate2 = busSearchForm.getFromDate(); 
    	System.out.println(fromDate2);
    	//String dateString = busSearchForm.getFromDate(); // Get the input date string
		/*
		 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //
		 * Specify the expected format LocalDate fromDate = LocalDate.parse(dateString,
		 * formatter); // Convert the string to LocalDate form.setFromDate(fromDate); //
		 * Set the converted LocalDate object back to the form attribute
		 * 
		 * String dateString = form.getFromDate(); // Get the input date string
		 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //
		 * Specify the expected format LocalDate toDate = LocalDate.parse(dateString,
		 * formatter); // Convert the string to LocalDate form.setFromDate(fromDate); //
		 * Set the converted LocalDate object back to the form attribute
		 */
        
        
    	
    	List<BusJourney> searchBuses = busJourneyService.searchBuses(busSearchForm);
    	System.out.println("Final Data "+ searchBuses.toString());
        model.addAttribute("searchBuses", searchBuses);

        return "busResults";
    }

    
    
}
