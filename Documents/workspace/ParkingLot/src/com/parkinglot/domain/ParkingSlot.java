package com.parkinglot.domain;

public class ParkingSlot {
		public ParkingSlot() {
		super();
		this.status = false;
	}
		private Car car;
		private boolean status;
		
		public Car getCar() {
			return car;
		}
		public void setCar(Car car) {
			this.car = car;
		}
		public boolean getStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
}
