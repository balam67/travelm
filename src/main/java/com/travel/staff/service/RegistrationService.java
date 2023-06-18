package com.travel.staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.staff.entity.Customer;
import com.travel.staff.entity.Staff;
import com.travel.staff.entity.User;
import com.travel.staff.repository.CustomerRepository;
import com.travel.staff.repository.StaffRepository;
import com.travel.staff.repository.UserRepository;

@Service
public class RegistrationService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private StaffRepository staffRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    public void registerStaff(Staff staff) {
        // Save staff to the staff table
        staffRepository.save(staff);
        
        // Create user for staff and save to the user table
      //  User user = new User(staff.getUsername(), staff.getPassword(), "ROLE_STAFF");
      //  userRepository.save(user);
    }
    
    public void registerCustomer(Customer customer) {
        // Save customer to the customer table
        customerRepository.save(customer);
        
        // Create user for customer and save to the user table
       // User user = new User(customer.getUsername(), customer.getPassword(), "ROLE_CUSTOMER");
       // userRepository.save(user);
    }
    
    // Add other methods as needed for user management, retrieval, etc.
}
