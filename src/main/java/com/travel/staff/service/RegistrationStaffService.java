package com.travel.staff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.staff.entity.Customer;
import com.travel.staff.entity.Staff;
import com.travel.staff.entity.User;
import com.travel.staff.repository.CustomerRepository;
import com.travel.staff.repository.StaffRepository;
import com.travel.staff.repository.UserRepository;

@Service
public class RegistrationStaffService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private StaffRepository staffRepository;
    
   
    public void registerStaff(Staff staff) {
        // Save staff to the staff table
        staffRepository.save(staff);
        
        // Create user for staff and save to the user table
      //  User user = new User(staff.getUsername(), staff.getPassword(), "ROLE_STAFF");
      //  userRepository.save(user);
    }
    
   
        // Create user for customer and save to the user table
       // User user = new User(customer.getUsername(), customer.getPassword(), "ROLE_CUSTOMER");
       // userRepository.save(user);
    
    // Add other methods as needed for user management, retrieval, etc.
    
   public List<Staff> getAllStaff(){
	   
	   
	   
	   return staffRepository.findAll();
   }  

  
   public void updateStaff(Staff staff) {
       staffRepository.save(staff);
   }

   public Optional<Staff> findById(Long id) {
       
	return staffRepository.findById(id);
   }



}
