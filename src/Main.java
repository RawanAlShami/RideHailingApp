import java.util.Scanner;


public class main 
{
	public static void main(String [] args)
	{
		AdminInterface AdminInterface = new AdminInterface();
		UserInterface UserInterface = new UserInterface();
		DriverInterface DriverInterface = new DriverInterface();
		int Choice;
		
		Scanner input = new Scanner(System.in);
		boolean Repeat=true;
		while(Repeat)
		{
			//MAIN MENU TO CHOOSE ONE OF THE INTERFACES
			System.out.println("Choose One Of The Following Accounts: ");	
			System.out.println("1 - Admin");
			System.out.println("2 - User");
			System.out.println("3 - Driver");
			System.out.println("4 - Exit");
			System.out.print("Choice:");
					
			//CIN CHOICE
			
			Choice=input.nextInt();
			System.out.println();
				
			switch(Choice) 
			{ 
				//CASE ADMIN
				case 1:
				{
					AdminInterface.ShowMenu();
					break;
				}
				//CASE USER
				case 2:
				{
					UserInterface.ShowMenu();
					break;
				}
				//CASE DRIVER
				case 3:
				{
					DriverInterface.ShowMenu();
					break;
				}
				case 4:
				{
					Repeat=false;
					break;
				}
			}
			/*if(input.hasNextLine()) {
		        input.nextLine();
		    }*/
		}
		input.close();
		System.out.println("System Terminated");
		System.exit(0);
	}
}
