package com.dinesh.CustomerDataManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.dinesh.CustomerDataManagement.Entiry.Customer;

@Repository
public class CustomerDAO {
	
	@Autowired
	private CustomerRepository repsository;
	
	public Customer saveCustomer(Customer customer)
	{
		return repsository.save(customer);
	}
	public List<Customer> getAllCustomerData()
	{
		return repsository.findAll();
	}
	public Customer getCustomerById(int id)
	{
		return repsository.findById(id).orElse(
				new Customer(HttpStatus.NOT_FOUND.value()
						,HttpStatus.NOT_FOUND.name()
						,HttpStatus.NOT_FOUND.name()));
	}
	public Customer deleteCustomerDataById(int id)
	{
		Customer customerById = getCustomerById(id);
		
		if(customerById.getId()!=404)
		{
			repsository.deleteById(id);
		}
		return customerById;
	}
	public List<Customer> getCustomerByName(String name)
	{
		return repsository.findByName(name);
	}
	
	public List<Customer> validateCustomer(String name,String email)
	{
		return repsository.validateCustomer(name, email);
	}
}
