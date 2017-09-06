package com.parkinglot.service;

import java.util.*;
import java.util.HashSet;

import com.parkinglot.domain.Car;
import com.parkinglot.domain.Parkinglot;

public class ParkingServiceImplementation {
	Parkinglot parkinglot;
	public Parkinglot createParkingLot(int n)
	{
		parkinglot = new Parkinglot(n);
		System.out.println("Created a parking lot with" + n +"slots");
		return parkinglot;
	}
	HashMap<String, String> car_info = new HashMap<>();
	HashMap<Integer,Car> slot_info = new HashMap<>();
	public void park(Car car)
	{
		
		int slot_number = getEmptySlotNumber();
		if(slot_number!=-1)
		{
			slot_info.put(slot_number,car);
			car_info.put(car.getReg_number(), car.getColor());
		}
		
	}
	
	public int getEmptySlotNumber()
	{
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
	public void leave(int n)
	{
		if(car_info.containsKey((slot_info.get(n).getReg_number())))
		{
			car_info.remove((slot_info.get(n).getReg_number()));
			slot_info.remove(n);
			parkinglot.getSlots()[n-1].setStatus(false);
			System.out.println("Slot number"+ n + "is free");
		}
		}
	
	public void status()
	{
		System.out.println("Slot Number" + "Registration Number"+ "Color" + "\n");
		for(int i=0;i<slot_info.size();i++)
		{
			if(parkinglot.getSlots()[i].getStatus()==true)
			{
				
				System.out.println((i+1) + slot_info.get(i+1).getReg_number()+slot_info.get(i+1).getColor());
			}
		}
	}
	
	public void getRegNumWithColor(String color)
	{
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
	
	public void getSlotNumsWithColor(String color)
	{
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
	
	public void getSlotNumWithRegNum(String reg_num)
	{
		//List<Integer> keys = new LinkedList<>();
		for (Map.Entry<Integer, Car> entry : slot_info.entrySet()) {
			  if (entry.getValue().getReg_number().equals(reg_num)) {
			    System.out.println(entry.getKey());
			    break;
			  }
			}
		System.out.println("Not found");
	}
}
