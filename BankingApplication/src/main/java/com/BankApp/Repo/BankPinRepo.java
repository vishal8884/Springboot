package com.BankApp.Repo;

import org.springframework.data.repository.CrudRepository;

import com.BankApp.model.BankCustomerPin;

public interface BankPinRepo extends CrudRepository<BankCustomerPin, Integer>{

}
