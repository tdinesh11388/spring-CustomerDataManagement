package com.dinesh.CustomerDataManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinesh.CustomerDataManagement.Entiry.Person;
import com.dinesh.CustomerDataManagement.repository.PersonDAO;

@Service
public class PersonService
{
	@Autowired
	private PersonDAO dao;
	
	public Person savePerson(Person person)
	{
		return dao.save(person);
	}
	public List<Person> getAllCustomers(Person person)
	{
		return dao.getAllCustomers(person);
	}
}
