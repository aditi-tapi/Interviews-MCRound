package resources;

import java.util.Scanner;

import com.parkinglot.domain.Car;
import com.parkinglot.service.ParkingService;

public class ReadInputfromConsole implements IInputtype{
	ParkingService service = new ParkingService();
	Car car;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		for (;;)
		{
			System.out.println("Input:");
			String input = sc.next();
			if(input == "exit")
			{
				sc.close();
				break;
			}
			else if(input.contains("create_parking_lot"))
			{
				String [] inputs = input.split(" ");
				service.createParkingLot(Integer.parseInt(inputs[1]));
			}
			else if(input.contains("park"))
			{
				String [] inputs = input.split(" ");
				car = new Car(inputs[1],inputs[2]);
				service.park(car);
			}
			else if(input.contains("leave"))
			{
				String [] inputs = input.split(" ");
				service.leave(Integer.parseInt(inputs[1]));
			}
			else if(input.contains("status"))
			{
				service.status();
			}
			else if(input.contains("registration_numbers_for_cars_with_colour"))
			{
				String [] inputs = input.split(" ");
				service.getRegNumWithColor(inputs[1]);
			}
			else if(input.contains("slot_numbers_for_cars_with_colour"))
			{
				String [] inputs = input.split(" ");
				service.getSlotNumsWithColor(inputs[1]);
			}
			else if(input.contains("slot_number_for_registration_number"))
			{
				String [] inputs = input.split(" ");
				service.getSlotNumWithRegNum(inputs[1]);
			}
		}
		
	}
	//ReadInputfromConsole console = new ReadInputfromConsole();
}
