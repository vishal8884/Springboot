package com.BankApp.Logic;

import java.util.Random;

public class PinLogic {

	
	  public static int getPin()
	  {
		  Random rand = new Random();
	         int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
	         
	         return resRandom;
	  }
}
