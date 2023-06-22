package com.travel.staff.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travel.staff.entity.Staff;
import com.travel.staff.entity.Status;
import com.travel.staff.entity.User;
import com.travel.staff.repository.StaffRepository;
import com.travel.staff.repository.UserRepository;
import com.travel.staff.service.RegistrationStaffService;

@Controller

public class RegistrationStaffController {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private StaffRepository staffRepository;
    
    
    
    @Autowired
    private RegistrationStaffService registrationService;
    
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
    
    @GetMapping("/show-all-staff")
    public String showAllStaff(Model model) {
       
    	
    	List<Staff> allStaff = registrationService.getAllStaff();
    	model.addAttribute("allStaff", allStaff);
    	System.out.println(allStaff.toString());
        return "show-all-staff";
    }
    
    @GetMapping("/updateStaff")
    public String showUpdateStaffForm(@RequestParam("id") Long id, Model model) {
      
    	Optional<Staff> staffOptional = registrationService.findById(id);
    	
    	
    	if (staffOptional.isPresent()) {
    	    // Object is present
    	    Staff staff = staffOptional.get();
    	    // Do something with the staff object
    	    model.addAttribute("staff", staff);
            return "update-staff-form";
    	} else {
    	    // Object is not present
    	    // Handle the case when the staff object is not found
    		return "staff-not-found";
    	}
        
    }

    @PostMapping("/updateStaff")
    public String updateStaff(@ModelAttribute("staff") Staff staff) {
    	System.out.println(staff.toString());
    	staff.setStatus(Status.Activated);
    	registrationService.updateStaff(staff);
        return "redirect:/show-all-staff";
    }
    
    
    
    @GetMapping(value = "/deleteStaff")
    public String showIndexPage(@RequestParam("id") Long staffId) {
        // Add logic to display the staff registration form
    	return deleteStaff(staffId);
    }
    
 // DELETE /staff/deleteStaff?id={id}
    @RequestMapping(value = "/deleteStaff")
    @ResponseBody
    public String  deleteStaff(@RequestParam("id") Long staffId) {
       
        	registrationService.deleteStaffById(staffId);
        	return "redirect:/show-all-staff";
           
    }
    
    // GET /staff/deactivate?id={id}
    @GetMapping("/deactivateStaff")
    public String deactivateStaff(@RequestParam("id") Long staffId) throws NotFoundException {
    	registrationService.deactivateStaff(staffId);
        return "redirect:/show-all-staff"; // Redirect to a staff list page or any other appropriate page
    }
    
    
    
    // GET /staff/activate?id={id}
    @GetMapping("/activateStaff")
    public String activateStaff(@RequestParam("id") Long staffId) throws NotFoundException {
    	registrationService.activateStaff(staffId);
        return "redirect:/show-all-staff";  // Redirect to a staff list page or any other appropriate page
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}




