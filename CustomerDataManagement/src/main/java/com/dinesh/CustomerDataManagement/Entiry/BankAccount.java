package com.dinesh.CustomerDataManagement.Entiry;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.ws.soap.MTOM;

import lombok.Data;

@Entity
@Data
public class BankAccount implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="p_id")
	private Integer bid;
	
	private String name;
	@Column(name="account_number")
	private long acccountNumber;
	
	@ManyToOne
	@JoinColumn
	private Person person;
}
