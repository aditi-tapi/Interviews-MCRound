package resources;

import java.util.Scanner;

public class ReadInputfromfile implements IInputtype{
	@Override
	public void run()
	{
		System.out.println("Enter file path:");
		Scanner sc= new Scanner(System.in);
		String filePath = sc.next();
		
	}

}
