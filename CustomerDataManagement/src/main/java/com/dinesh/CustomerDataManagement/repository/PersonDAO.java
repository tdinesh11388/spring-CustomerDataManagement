package com.dinesh.CustomerDataManagement.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dinesh.CustomerDataManagement.Entiry.Person;

@Repository
public class PersonDAO
{
	@Autowired
	private PersonRepository repsoitory;
	
	public Person save(Person person)
	{
		return repsoitory.save(person);
	}
	public List<Person> getAllCustomers(Person person)
	{
		return repsoitory.findAll();
	}
}
