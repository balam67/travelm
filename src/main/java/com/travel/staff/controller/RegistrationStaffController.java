package com.travel.staff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.travel.staff.entity.Customer;
import com.travel.staff.entity.Staff;
import com.travel.staff.entity.Status;
import com.travel.staff.entity.User;
import com.travel.staff.repository.CustomerRepository;
import com.travel.staff.repository.StaffRepository;
import com.travel.staff.repository.UserRepository;
import com.travel.staff.service.RegistrationService;

@Controller

public class RegistrationStaffController {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private StaffRepository staffRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private RegistrationService registrationService;
    
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
    	staff.setStatus(Status.Activated);
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
    
   
  
    @GetMapping("/success")
    public String showRegistrationSuccessPage() {
        // Add logic to display the registration success page
        return "registration-success";
    }
    
    @GetMapping("/show-all-stsff")
    public String showAllStaff(Model model) {
       
    	
    	List<Staff> allStaff = registrationService.getAllStaff();
    	model.addAttribute("allStaff", allStaff);
    	System.out.println(allStaff.toString());
        return "show-all-stsff";
    }
    
   
}
