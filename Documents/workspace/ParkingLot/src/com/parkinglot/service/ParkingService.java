package com.parkinglot.service;

import com.parkinglot.dao.IParking;
import com.parkinglot.dao.ParkingImplementation;
import com.parkinglot.domain.Car;
//import com.parkinglot.domain.Parkinglot;

public class ParkingService {
	IParking parking = new ParkingImplementation();
	
	//Parkinglot parkinglot;
	public void createParkingLot(int n)
	{
		parking.createParkingLot(n);

	}
	
	public void park(Car car)
	{
		
		int slot_number = parking.getEmptySlotNumber();
		if(slot_number!=-1)
		{
			parking.addCar(car);
			parking.parkCar(slot_number,car);
			
		}
		
	}
	

	public void leave(int n)
	{
		parking.removeCar(n);
	
	}
	
	public void status()
	{
		parking.getStatus();

	}
	
	public void getRegNumWithColor(String color)
	{
		parking.getRegNumWithColor(color);
		
		
		
	}
	
	public void getSlotNumsWithColor(String color)
	{
		parking.getSlotNumsWithColor(color);
		
	}
	
	public void getSlotNumWithRegNum(String reg_num)
	{
		parking.getSlotNumWithRegNum(reg_num);
		
		
	}
}
