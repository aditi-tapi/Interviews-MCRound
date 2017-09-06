package test;

import com.parkinglot.domain.Car;
import com.parkinglot.service.ParkingService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParkingService service = new ParkingService();
		service.createParkingLot(6);
		Car a = new Car("abc","white");
		Car b = new Car("def","brown");
		Car c = new Car("ghi","white");
		Car c1 = new Car("ghi1","blue");
		Car c2 = new Car("ghi2","black");
		Car c3 = new Car("ghi3","white");
		service.park(a);
		service.park(b);
		service.park(c);
		service.park(c1);
		service.park(c2);
		service.park(c3);
		
		service.leave(4);
		
		service.status();
		
		Car c22 = new Car("ghi2","black");
		Car c32 = new Car("ghi3","white");
		
		service.park(c22);
		service.park(c32);
		
		service.getRegNumWithColor("white");

	}

}
