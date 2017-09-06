package com.parkinglot.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.parkinglot.domain.Car;
import com.parkinglot.domain.Parkinglot;

public class ParkingImplementation implements IParkinglot{
	
	HashMap<String, String> car_info = new HashMap<>();
	HashMap<Integer,Car> slot_info = new HashMap<>();
	Parkinglot parkinglot;
	@Override
	public void addCar(Car car) {
		// TODO Auto-generated method stub
		car_info.put(car.getReg_number(), car.getColor());
	}

	@Override
	public void removeCar(int n) {
		// TODO Auto-generated method stub
		if(car_info.containsKey((slot_info.get(n).getReg_number())))
			{
				car_info.remove((slot_info.get(n).getReg_number()));
				slot_info.remove(n);
				parkinglot.getSlots()[n-1].setStatus(false);
				System.out.println("Slot number"+ n + "is free");
			}
		
	}

	@Override
	public void parkCar(int slot_num, Car car) {
		// TODO Auto-generated method stub
		slot_info.put(slot_num,car);
	}

	@Override
	public void createParkingLot(int n) {
		// TODO Auto-generated method stub
		parkinglot = new Parkinglot(n);
		System.out.println("Created a parking lot with" + n +"slots");
	}

	@Override
	public int getEmptySlotNumber() {
		// TODO Auto-generated method stub
		int n;
		for(n=0;n<parkinglot.getSlots().length;n++)
		{
			if(parkinglot.getSlots()[n].getStatus()==false)
			{
				parkinglot.getSlots()[n].setStatus(true);
				System.out.println("Allocated slot number:" + n+1 );
				break;
			}
		}
		if(n==parkinglot.getSlots().length)
			{
			System.out.println("Sorry, parking lot is full");
			return -1;
			
			}
		return n+1;
		
	}

	@Override
	public void getStatus() {
		// TODO Auto-generated method stub
		System.out.println("Slot Number" + "Registration Number"+ "Color" + "\n");
		{
		for(int i=0;i<slot_info.size();i++)
			if(parkinglot.getSlots()[i].getStatus()==true)
			{
				
				System.out.println((i+1) + slot_info.get(i+1).getReg_number()+slot_info.get(i+1).getColor());
			}
		}
	}

	@Override
	public void getRegNumWithColor(String color) {
		// TODO Auto-generated method stub
		List<String> keys = new LinkedList<>();
		for (Map.Entry<String, String> entry : car_info.entrySet()) {
			  if (entry.getValue().equals(color)) {
			    keys.add(entry.getKey());
			   
			  }
			}
		int i=0;
		while(i<keys.size())
		{
			System.out.println(keys.get(i) + ",");
		}
	}

	@Override
	public void getSlotNumsWithColor(String color) {
		// TODO Auto-generated method stub
		List<Integer> keys = new LinkedList<>();
		for (Map.Entry<Integer, Car> entry : slot_info.entrySet()) {
			  if (entry.getValue().getColor().equals(color)) {
			    keys.add(entry.getKey());
			   
			    
			  }
			}
		int i=0;
		while(i<keys.size())
		{
			System.out.println(keys.get(i) + ",");
		}
		
	}

	@Override
	public void getSlotNumWithRegNum(String reg_num) {
		// TODO Auto-generated method stub
		for (Map.Entry<Integer, Car> entry : slot_info.entrySet()) {
			  if (entry.getValue().getReg_number().equals(reg_num)) {
			    System.out.println(entry.getKey());
			    break;
			  }
			}
		System.out.println("Not found");
	}

	

}
