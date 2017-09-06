package com.parkinglot.domain;

public class Car {
	
	public Car(String reg_number, String color) {
		super();
		this.reg_number = reg_number;
		this.color = color;
	}
	private String reg_number;
	private String color;
	public String getReg_number() {
		return reg_number;
	}
	public void setReg_number(String reg_number) {
		this.reg_number = reg_number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	

}
