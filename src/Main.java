import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		//BOOL VARIABLE TO ALLOW FOR CONTINOUS LOOPING AND EXITING UPON CHOICE
		boolean Repeat=true;
		while(Repeat)
		{
			//MAIN MENU TO CHOOSE SHAPE OR CHOOSE TO DRAW
			System.out.println("Choose One Of The Following Accounts: ");	
			System.out.println("1 - Admin");
			System.out.println("2 - User");
			System.out.println("3 - Driver");
			System.out.println("4 - Exit");
			System.out.print("Choice:");
					
			//CIN CHOICE
			Scanner input = new Scanner(System.in);
			int Choice=input.nextInt();
			System.out.println();
				
			switch(Choice) 
			{ 
				//CASE ADMIN
				case 1:
				{
					Admin Administrator = null;
					boolean AdminRepeat=true;
					while(AdminRepeat)
					{	
						System.out.println("1 - Create Account");
						System.out.println("2 - Login");
						System.out.println("3 - Return To Main Menu");
						System.out.println("Choose An Operation: ");
						int AdminMenuChoice=input.nextInt();
						switch(AdminMenuChoice)
						{
							case 1:
							{
								String Username, Password, MobileNumber, Email;
								System.out.println("Enter Username, Password, Mobile Number, Email (NewLine Separated): ");
								Username=input.next();
								Password=input.next();
								MobileNumber=input.next();
								Email=input.next();
								Admin A=new Admin(Username, Password, MobileNumber, Email);
								Administrator=A;
								break;
							}
							case 2:
							{
								boolean Logged=true;
								System.out.println("Please Provide Your Email And Password (NewLine Separated): ");
								String Username, Password;
								Username=input.next();
								Password=input.next();
								while(!Administrator.LoggedIn)
								{Administrator.Login(Username, Password);}
								while(Logged)
								{
									System.out.println("1 - View Pending Drivers Requests");
									System.out.println("2 - View Drivers");
									System.out.println("3 - Verify Pending Driver Request");
									System.out.println("4 - LogOut");
									int AdminLoopChoice=input.nextInt();
									switch(AdminLoopChoice)
									{
										case 1:
										{
											Administrator.ViewPendingRequests();
											break;
										}
										case 2:
										{
											Administrator.ViewDrivers();
											break;
										}
										case 3:
										{
											System.out.println("Please Enter Drivers National ID To Be Verified: ");
											String NationalID=input.next();
											Administrator.VerifyDriversRegistration(NationalID);
											break;
										}
										case 4:
										{
											Administrator.LoggedIn=false;
											return;
										}
									}
								}
								break;
							}
						}
					}
					break;
				}
				//CASE USER
				case 2:
				{
					break;
				}
				//CASE DRIVER
				case 3:
				{
					break;
				}
				//CASE EXIT
				case 4:
				{
					System.out.println("Exiting Program");
					Repeat=false;
					break;
				}
				default:
				{System.out.println("Invalid Choice");}
				
			}
		/*
		
		Admin A=new Admin("Admin", "1111", "012","admin@",333);
		
		User U= new User("Sayed","pass","011","sayed@yahoo.com",123);	
		U.Login("sayed@yahoo.com", "pass");
		
		Driver D=U.RegisterAsDriver("NationalID","Dlic",A);
		System.out.println("Accepted Status: "+ D.Accepted);
		D.Login("Sayed","pass");
		
		Driver D1=new Driver("7amo","password","013","7amoo@ooo",1111,"NatID7amo","DLic7amo",A);
		
		A.ViewPendingRequests();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Drivers National ID To Verify: ");
		String NId=input.nextLine();
		
		A.VerifyDriversRegistration(NId);
		
		System.out.println("Pending Requests: ");
		A.ViewPendingRequests();
		
		System.out.println("Drivers: ");
		A.ViewDrivers();
		
		System.out.println("Accepted Status: "+ D.Accepted);
		
		D.Login("sayed@yahoo.com", "pass");
		*/
	}
}
}
