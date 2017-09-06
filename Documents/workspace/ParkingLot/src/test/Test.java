package test;

import java.util.Scanner;

import com.parkinglot.domain.Car;
import com.parkinglot.service.ParkingService;

import resources.IInputtype;
import resources.ReadInputfromConsole;
import resources.ReadInputfromfile;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IInputtype input;
		System.out.println("Select mode of input from below-");
		System.out.println("1.Interactive/Command Line");
		System.out.println("2.Read instructions from a file");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		sc.close();
		
		if(option == 1)
		{
			input = new ReadInputfromConsole();
			input.runConsole();
		}
		else if(option == 2)
			input = new ReadInputfromfile();
		else
			System.out.println("Invalid input");
		 
		
//		ParkingService service = new ParkingService();
//		service.createParkingLot(6);
//		Car a = new Car("abc","white");
//		Car b = new Car("def","brown");
//		Car c = new Car("ghi","white");
//		Car c1 = new Car("ghi1","blue");
//		Car c2 = new Car("ghi2","black");
//		Car c3 = new Car("ghi3","white");
//		service.park(a);
//		service.park(b);
//		service.park(c);
//		service.park(c1);
//		service.park(c2);
//		service.park(c3);
//		
//		service.leave(4);
//		
//		service.status();
//		
//		Car c22 = new Car("ghi2","black");
//		Car c32 = new Car("ghi3","white");
//		
//		service.park(c22);
//		service.park(c32);
//		
//		service.status();
//		service.getRegNumWithColor("white");
//		service.getSlotNumsWithColor("pink");
//		service.getSlotNumWithRegNum("ghi3");

	}

}
