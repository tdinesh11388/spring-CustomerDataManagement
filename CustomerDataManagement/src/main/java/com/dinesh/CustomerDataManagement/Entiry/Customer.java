package com.dinesh.CustomerDataManagement.Entiry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.dinesh.CustomerDataManagement.dto.CustomerDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="customer_data")
public class Customer
{
	@Id
	@GenericGenerator(name = "auto",strategy = "increment")
	@GeneratedValue(generator="auto")
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	public Customer(CustomerDTO dto)
	{
		this.id=dto.getId();
		this.name=dto.getName();
		this.email=dto.getEmail();
	}
}
