package com.travel.staff.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travel.staff.entity.Customer;
import com.travel.staff.entity.Staff;
import com.travel.staff.entity.Status;
import com.travel.staff.entity.User;
import com.travel.staff.repository.CustomerRepository;
import com.travel.staff.repository.StaffRepository;
import com.travel.staff.repository.UserRepository;
import com.travel.staff.service.RegistrationCustomerService;


@Controller
@RequestMapping("/customer")
public class RegistrationCustomerController {

	    @Autowired
	    private UserRepository userRepository;
	    
	   
	    @Autowired
	    private CustomerRepository customerRepository;
	    
	    @Autowired
	    private RegistrationCustomerService registrationService;
	
	  
    @GetMapping("/customer")
    public String showCustomerRegistrationForm(Model model) {
        // Add logic to display the customer registration form
    	Customer customer = new Customer();
    	model.addAttribute("customer", customer);
        return "customer-registration";
    }
    
    @PostMapping("/add-customer")
    public String registerCustomer(@ModelAttribute("customer") Customer customer) {
        // Add logic to save the customer registration details to the database
    	 User user = new User();
    	 user.setUsername(customer.getUsername());
    	 user.setPassword(customer.getPassword());
    	 user.setEnabled(true);
    	 customer.setStatus(Status.Activated);
        customerRepository.save(customer);
        userRepository.save(user);
       
        return "redirect:/success";
    }
    
    
    @GetMapping("/show-all-customers")
    public String showAllCustomers(Model model) {
       
    	
    List<Customer> allCustomers = registrationService.getAllCustomers();
    	model.addAttribute("allCustomers", allCustomers);
    	
        return "show-all-customers";
    }
    
    @GetMapping("/show-all-registered-customers")
    public String showAllRegisteredCustomers(Model model) {
       
    	
    List<Customer> allCustomers = registrationService.getAllCustomers();
    	model.addAttribute("allCustomers", allCustomers);
    	
        return "show-all-registered-customers";
    }
    
    @GetMapping("/updateCustomer")
    public String showUpdateCustomerForm(@RequestParam("id") Long id, Model model) {
      
    	Optional<Customer> customerOptional = registrationService.findById(id);
    	
    	
    	if (customerOptional.isPresent()) {
    	    // Object is present
    		Customer customer = customerOptional.get();
    	    // Do something with the staff object
    	    model.addAttribute("customer", customer);
            return "update-customer-form";
    	} else {
    	    // Object is not present
    	    // Handle the case when the staff object is not found
    		return "customer-not-found";
    	}
        
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute("staff") Customer customer) {
    	System.out.println(customer.toString());
    	customer.setStatus(Status.Activated);
    	registrationService.updateCustomer(customer);
        return "redirect:/show-all-customers";
    }
}
