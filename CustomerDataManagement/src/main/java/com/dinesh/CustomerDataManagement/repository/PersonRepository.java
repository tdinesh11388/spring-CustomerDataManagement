package com.dinesh.CustomerDataManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dinesh.CustomerDataManagement.Entiry.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>
{

}
