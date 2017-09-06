package com.parkinglot.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.parkinglot.domain.Car;
import com.parkinglot.domain.ParkingSlot;


public class ParkingImplementation implements IParking{
	
	HashMap<String, String> car_info = new HashMap<>();
	HashMap<Integer,Car> slot_info = new HashMap<>();
	
	ArrayList<ParkingSlot> slots = new ArrayList<>();
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
				slots.get(n-1).setStatus(false);
				System.out.println("Slot number"+" "+ n + " "+ "is free");
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
		ParkingSlot slot;
		for(int i =0;i<n;i++)
		{
			slot = new ParkingSlot();
			slot.setStatus(false);
			slots.add(slot);
			
		}
		System.out.println("Created a parking lot with" +" "+ n + " "+"slots");
		//parkinglot = new Parkinglot(n);
		
	}

	@Override
	public int getEmptySlotNumber() {
		// TODO Auto-generated method stub
		int n;
		for(n=0;n<slots.size();n++)
		{
			if(slots.get(n).getStatus()==false)
			{
				slots.get(n).setStatus(true);
				System.out.println("Allocated slot number:" + (n+1) );
				break;
			}
		}
		if(n==slots.size())
			{
			System.out.println("Sorry, parking lot is full");
			return -1;
			
			}
		return (n+1);
		
	}

	@Override
	public void getStatus() {
		// TODO Auto-generated method stub
		System.out.println("Slot Number" + " " + "Registration Number"+"  "+ "Color");
		{
		for(int i=0;i<=slot_info.size();i++)
			if(slots.get(i).getStatus()==true)
			{
				
				System.out.println((i+1)+" " + slot_info.get(i+1).getReg_number()+ " "+slot_info.get(i+1).getColor());
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
		
			System.out.println(keys);
		
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
		
			System.out.println(keys);
		
		
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