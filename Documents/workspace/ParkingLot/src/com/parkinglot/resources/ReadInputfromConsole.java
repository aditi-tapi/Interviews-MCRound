package resources;

import java.util.Scanner;

import com.parkinglot.domain.Car;
import com.parkinglot.service.ParkingService;

public class ReadInputfromConsole implements IInputtype{
	ParkingService service = new ParkingService();
	Car car;
	//String inputs[];
	//private Scanner sc;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		for (;;)
		{	
			//String input = null;
			int i=0;
			//inputs = null;
			System.out.println("Input:");
			String input = s.nextLine();
			
			
			String [] inputs = input.split(" ");
			
			if(inputs[0].contains("exit"))
			{
				s.close();
				break;
			}
			else if(inputs[0].contains("create_parking_lot"))
			{
				//String [] inputs = input.split(" ");
				if(inputs.length<2)
					{
					System.out.println("Invalid number of arguments");
					s.close();
					break;
					}
				service.createParkingLot(Integer.parseInt(inputs[1]));
			}
			else if(inputs[0].contains("park"))
			{
				//String [] inputs = input.split(" ");
				if(inputs.length<3)
					{
					System.out.println("Invalid number of arguments");
					s.close();
					break;
					}
				car = new Car(inputs[1],inputs[2]);
				service.park(car);
			}
			else if(inputs[0].contains("leave"))
			{
//				String [] inputs = input.split(" ");
				if(inputs.length<2)
					{
					System.out.println("Invalid number of arguments");
					s.close();
					break;
					}
				service.leave(Integer.parseInt(inputs[1]));
			}
			else if(inputs[0].contains("status"))
			{
				service.status();
			}
			else if(inputs[0].contains("registration_numbers_for_cars_with_colour"))
			{
				//String [] inputs = input.split(" ");
				if(inputs.length<2)
					{
					System.out.println("Invalid number of arguments");
					s.close();
					break;
					}
				service.getRegNumWithColor(inputs[1]);
			}
			else if(inputs[0].contains("slot_numbers_for_cars_with_colour"))
			{
				//String [] inputs = input.split(" ");
				if(inputs.length<2)
					{
					System.out.println("Invalid number of arguments");
					s.close();
					break;
					}
				service.getSlotNumsWithColor(inputs[1]);
			}
			else if(inputs[0].contains("slot_number_for_registration_number"))
			{
				//String [] inputs = input.split(" ");
				if(inputs.length<2)
					{
					System.out.println("Invalid number of arguments");
					s.close();
					break;
					}
				service.getSlotNumWithRegNum(inputs[1]);
			}
		}
		
	}
	
}
