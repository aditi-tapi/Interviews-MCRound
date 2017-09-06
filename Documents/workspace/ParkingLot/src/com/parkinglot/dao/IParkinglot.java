package com.parkinglot.dao;

import com.parkinglot.domain.Car;

public interface IParkinglot {
	void createParkingLot(int n);
	void parkCar(int slot_num, Car car);
	
	int getEmptySlotNumber();
	void getStatus();
	void addCar(Car car);
	void removeCar(int n);
	
	void getRegNumWithColor(String color);
	void getSlotNumsWithColor(String color);
	void getSlotNumWithRegNum(String reg_num);
}
