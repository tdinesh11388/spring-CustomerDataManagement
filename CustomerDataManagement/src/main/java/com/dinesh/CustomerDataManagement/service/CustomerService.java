package com.dinesh.CustomerDataManagement.service;

import java.time.LocalDateTime;
import java.util.List;import org.aspectj.weaver.patterns.HasMemberTypePatternForPerThisMatching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dinesh.CustomerDataManagement.Entiry.Customer;
import com.dinesh.CustomerDataManagement.dto.CustomerDTO;
import com.dinesh.CustomerDataManagement.dto.ResponseStructure;
import com.dinesh.CustomerDataManagement.repository.CustomerDAO;
import com.dinesh.CustomerDataManagement.repository.CustomerRepository;

@Service
public class CustomerService
{
	@Autowired
	private CustomerDAO dao;
	
	public ResponseStructure<Object> saveCustomer(CustomerDTO dto)
	{
		Customer cus = new Customer(dto);
		Customer customer = dao.saveCustomer(cus);
		ResponseStructure<Object> rs = new ResponseStructure<>();
		rs.setData(customer);
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Customer data saved Sucessfully");
		rs.setTimeStamp(LocalDateTime.now());
		return rs;
	}
	
	public ResponseStructure<Customer> updateCustomer(Customer customer)
	{
		 Customer cus = dao.saveCustomer(customer);
		 ResponseStructure<Customer> rs = new ResponseStructure<>();
		 rs.setData(cus);
		 rs.setStatusCode(HttpStatus.ACCEPTED.value());
		 rs.setTimeStamp(LocalDateTime.now());
		 rs.setMessage(HttpStatus.ACCEPTED.name());
		 return rs;
	}
	public ResponseStructure<List<Customer>> getAllCustomerData()
	{
		 List<Customer> list = dao.getAllCustomerData();
		 ResponseStructure< List<Customer>> rs = new ResponseStructure<>();
		 if(list.size()!=0)
		 {
			 rs.setStatusCode(HttpStatus.FOUND.value());
			 rs.setData(list);
			 rs.setTimeStamp(LocalDateTime.now());
			 rs.setMessage("Customers entery found in database");
		 }else {
			 rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			 rs.setData(null);
			 rs.setTimeStamp(LocalDateTime.now());
			 rs.setMessage("No Customer Entery found in database");
		 }
		 return rs;
	}
	
	public ResponseStructure<Object> getDataById(int id)
	{
		 Customer id1 = dao.getCustomerById(id);
		 ResponseStructure<Object> rs = new ResponseStructure<>();
		 if(id1!=null)
		 {
				rs.setData(id1);
				rs.setStatusCode(HttpStatus.FOUND.value());
				rs.setMessage("Customers entery found in database");
				rs.setTimeStamp(LocalDateTime.now());
		 }else {
				rs.setData(null);
				rs.setStatusCode(HttpStatus.NOT_FOUND.value());
				rs.setMessage("No Customer Entery found in database");
				rs.setTimeStamp(LocalDateTime.now());
		 }
		 return rs;
	}
	
	public ResponseStructure<Object> deleteByID(int id)
	{
		Customer dId = dao.deleteCustomerDataById(id);
		ResponseStructure<Object> rs = new ResponseStructure<>();
		if(dId!=null)
		{
			rs.setData(dId);
			rs.setStatusCode(HttpStatus.OK.value());
			rs.setTimeStamp(LocalDateTime.now());
			rs.setMessage("deleted sucessfully");
		}else {
			rs.setData(null);
			rs.setStatusCode(HttpStatus.NO_CONTENT.value());
			rs.setTimeStamp(LocalDateTime.now());
			rs.setMessage("data not found");
		}
		return rs;
	}
	public List<Customer> getByCustomerName(String name)
	{
		return dao.getCustomerByName(name);
	}
	
	public List<Customer> validateCustomer(String name,String email)
	{
		return dao.validateCustomer(name, email);
	}
}
