package com.travel.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.travel.staff.entity.Customer;
import com.travel.staff.entity.Staff;
import com.travel.staff.entity.Status;
import com.travel.staff.entity.User;
import com.travel.staff.repository.CustomerRepository;
import com.travel.staff.repository.StaffRepository;
import com.travel.staff.repository.UserRepository;

@Controller

public class RegistrationStaffController {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private StaffRepository staffRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @GetMapping("/staff")
    public String showStaffRegistrationForm(Model model) {
        // Add logic to display the staff registration form
    	Staff staff = new Staff();    	
    	model.addAttribute("staff", staff);
        return "staff-registration";
    }
    
    @GetMapping("/")
    public String showIndexPage() {
        // Add logic to display the staff registration form
        return "home";
    }
    
    @PostMapping("/add-staff")
    public String registerStaff(@ModelAttribute("staff") Staff staff) {
        // Add logic to display the staff registration form
    	System.out.println(staff.toString());
    	staff.setStatus(Status.ACTIVATED);
    	 staffRepository.save(staff);
    	 
    	 User user = new User();
    	 user.setUsername(staff.getUsername());
    	 user.setPassword(staff.getPassword());
    	 user.setEnabled(true);
    	 
         //User user = new User(staff.getUsername(), staff.getPassword(), "STAFF");
               userRepository.save(user);
               System.out.println(user.toString());  
         return "redirect:/success";
    }
    
   
    
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
    	 customer.setStatus(Status.ACTIVATED);
        customerRepository.save(customer);
        userRepository.save(user);
       
        return "redirect:/success";
    }
    
    @GetMapping("/success")
    public String showRegistrationSuccessPage() {
        // Add logic to display the registration success page
        return "registration-success";
    }
}
