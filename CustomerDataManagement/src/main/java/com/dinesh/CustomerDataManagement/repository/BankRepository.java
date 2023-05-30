package com.dinesh.CustomerDataManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dinesh.CustomerDataManagement.Entiry.BankAccount;

public interface BankRepository extends JpaRepository<BankAccount, Integer>
{

}
