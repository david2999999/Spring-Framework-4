package com.bean.service;

public class RandomizerRequestScope {
	
	private int randomNumber = 5;

	public int getRandomNumber() {
		return randomNumber;
	}
	
	public void generateRandomNumber() {
		this.randomNumber = (int) (Math.random() * 9999);
	}
	
}
