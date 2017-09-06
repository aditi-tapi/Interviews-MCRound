package com.parkinglot.domain;

public class Parkinglot {
	public Parkinglot() {
		super();
	}

	public Parkinglot(int n) {
		super();
		for(int i =0;i<n;i++)
		{
			slots[i]= new ParkingSlot();
			//System.out.println("Allocated slot number:" + i+1 );
		}
		this.slots = new ParkingSlot[n];
		
	}

	private ParkingSlot [] slots;

	public ParkingSlot[] getSlots() {
		return slots;
	}

	public void setSlots(ParkingSlot[] slots) {
		this.slots = slots;
	}
	

}
