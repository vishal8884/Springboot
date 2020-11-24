package com.BankApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankCustomerPin {

	@Id
	private int custId;
	private int pin;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "BankCustomerPin [custId=" + custId + ", pin=" + pin + "]";
	}
	
	
	
}
