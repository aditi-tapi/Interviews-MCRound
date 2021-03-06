package resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.parkinglot.domain.Car;
import com.parkinglot.service.ParkingService;

public class ReadInputfromfile implements IInputtype{
	@Override
	public void run()
	{
		ParkingService service = new ParkingService();
		Car car;
		BufferedReader br = null;
		FileReader fr = null;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter file path:");
		
		String filePath = sc.nextLine();
		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				String [] inputs = sCurrentLine.split(" ");
				if(inputs[0].contains("exit"))
				{
					//s.close();
					break;
				}
				else if(inputs[0].contains("create_parking_lot"))
				{
					//String [] inputs = input.split(" ");
					if(inputs.length<2)
						{
						System.out.println("Invalid number of arguments");
						//s.close();
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
						break;
						}
					car = new Car(inputs[1],inputs[2]);
					service.park(car);
				}
				else if(inputs[0].contains("leave"))
				{
//					String [] inputs = input.split(" ");
					if(inputs.length<2)
						{
						System.out.println("Invalid number of arguments");
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
						//s.close();
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
						break;
						}
					service.getSlotNumWithRegNum(inputs[1]);
				}

			}

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		
	}

}
