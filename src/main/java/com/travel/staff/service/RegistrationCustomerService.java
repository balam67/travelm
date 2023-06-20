package com.travel.staff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.staff.entity.Customer;
import com.travel.staff.entity.Staff;
import com.travel.staff.repository.CustomerRepository;

@Service
public class RegistrationCustomerService {
	
	    @Autowired
	    private CustomerRepository customerRepository;
	    


	 public void registerCustomer(Customer customer) {
	        // Save customer to the customer table
	        customerRepository.save(customer);
	        
	 }
	 
	 
	 public List<Customer> getAllCustomers(){
		   
		   
		  return customerRepository.findAll();
	}


	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
		
	}


	public Optional<Customer> findById(Long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id);
	}  
}
