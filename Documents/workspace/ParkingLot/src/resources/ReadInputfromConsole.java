package resources;

import java.util.Scanner;

import com.parkinglot.service.ParkingService;

public class ReadInputfromConsole implements IInputtype {
	ParkingService service = new ParkingService();
	@Override
	public void runConsole() {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		String input = sc.next();
		if(input == "exit")
			sc.close();
		else if(input.contains("create_parking_lot"))
		
	}
	//ReadInputfromConsole console = new ReadInputfromConsole();
}
