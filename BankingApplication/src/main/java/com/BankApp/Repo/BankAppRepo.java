package com.BankApp.Repo;

import org.springframework.data.repository.CrudRepository;

import com.BankApp.model.BankCustomer;

public interface BankAppRepo extends CrudRepository<BankCustomer, Integer>{

}
