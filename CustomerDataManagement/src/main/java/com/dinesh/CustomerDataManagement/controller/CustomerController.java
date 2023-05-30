package com.dinesh.CustomerDataManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.CustomerDataManagement.Entiry.Customer;
import com.dinesh.CustomerDataManagement.dto.CustomerDTO;
import com.dinesh.CustomerDataManagement.dto.ResponseStructure;
import com.dinesh.CustomerDataManagement.service.CustomerService;

@RestController
public class CustomerController 
{
	@Autowired
	private CustomerService service;
	
	@PostMapping("/customer")
	public @ResponseBody ResponseStructure<Object> saveCustomer(@RequestBody CustomerDTO dto)
	{
		return service.saveCustomer(dto);
	}
	
	@PutMapping("/customer")
	public @ResponseBody ResponseStructure<Customer> updateCustomer(@RequestBody Customer customer)
	{
		return service.updateCustomer(customer);
	}
	
	@GetMapping(value="/customer")
	public  @ResponseBody ResponseStructure<List<Customer>> getAllCustomerData()
	{
		return service.getAllCustomerData();
	}
	@GetMapping("/customer/{id}")
	public @ResponseBody ResponseStructure<Object> getCustomerDataById(@PathVariable("id") int id)
	{
		return service.getDataById(id);
	}
	@DeleteMapping("/customer/{id}")
	public @ResponseBody ResponseStructure<Object> deleteById(@PathVariable("id") int id)
	{
		return service.deleteByID(id);
	}
	@GetMapping("/customerbyname/{name}")
	public @ResponseBody List<Customer> getByName(@PathVariable("name") String name)
	{
		return service.getByCustomerName(name);
	}
	@PostMapping("/validateCustomer")
	public List<Customer> validateCustomer(@RequestParam("name") String name,
		@RequestParam("email")String email)
	{
		return service.validateCustomer(name, email);
	}
}
