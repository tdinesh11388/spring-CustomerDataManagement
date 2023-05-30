package com.dinesh.CustomerDataManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.CustomerDataManagement.Entiry.Person;
import com.dinesh.CustomerDataManagement.repository.PersonRepository;
import com.dinesh.CustomerDataManagement.service.PersonService;

@RestController
public class PersonController 
{
	@Autowired
	private PersonService service;
	
	@PostMapping("/person")
	public Person saveData(@RequestBody Person person)
	{
		return service.savePerson(person);
	}
	@GetMapping("/person")
	public  @ResponseBody  List<Person>getAllUsers(Person person)
	{
		return service.getAllCustomers(person);
	}
	
}
