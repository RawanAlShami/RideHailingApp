import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		
		//WE NEED TO START BY CREATING AN ADMIN FIRST
		
		
		Admin Administrator = null;
		ArrayList<Driver> Drivers= new ArrayList<Driver>();
		ArrayList<User> Users = new ArrayList<User>();
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
					boolean AdminRepeat=true;
					while(AdminRepeat)
					{	
						System.out.println("Admin Menu:");
						System.out.println("1 - Create Account");
						System.out.println("2 - Login");
						System.out.println("3 - Return To Main Menu");
						System.out.println("Choose An Operation: ");
						int AdminMenuChoice=input.nextInt();
						switch(AdminMenuChoice)
						{
							//Create account
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
							//Login
							case 2:
							{
								String Email, Password;
								boolean Logged=true;
								while(!Administrator.LoggedIn)
								{
								System.out.println("Please Provide Your Email And Password (NewLine Separated): ");
								Email=input.next();
								Password=input.next();
								Administrator.Login(Email, Password);
								}
								while(Logged)
								{
									System.out.println("1 - View Pending Drivers Requests");
									System.out.println("2 - View Drivers");
									System.out.println("3 - Verify Pending Driver Request");
									System.out.println("4 - LogOut");
									int AdminLoopChoice=input.nextInt();
									switch(AdminLoopChoice)
									{
										//1 - View Pending Drivers Requests
										case 1:
										{
											Administrator.ViewPendingRequests();
											break;
										}
										//2 - View Drivers
										case 2:
										{
											Administrator.ViewDrivers();
											break;
										}
										//3 - Verify Pending Driver Request
										case 3:
										{
											System.out.println("Please Enter Drivers National ID To Be Verified: ");
											String NationalID=input.next();
											Administrator.VerifyDriversRegistration(NationalID);
											break;
										}
										//4 - LogOut
										case 4:
										{
											Administrator.LoggedIn=false;
											Logged=false;
											break;
										}
									}
								}
								break;
							}
							//3 - Return To Main Menu
							case 3:
							{
								AdminRepeat=false;
								break;
							}
						}
					}
					break;
				}
				//CASE USER
				case 2:
				{
					boolean UserRepeat=true;
					while(UserRepeat) {
						System.out.println("User Menu:");
						System.out.println("1 - Create Account");
						System.out.println("2 - Login");
						System.out.println("3 - Return To Main Menu");
						System.out.println("Choose An Operation: ");
						int UserMenuChoice=input.nextInt();
						switch(UserMenuChoice) {
						//Create account
						case 1:{
							String Username, Password, MobileNumber, Email;
							System.out.println("Enter Username, Password, Mobile Number, Email (NewLine Separated): ");
							Username=input.next();
							Password=input.next();
							MobileNumber=input.next();
							Email=input.next();
							User U=new User(Username, Password, MobileNumber, Email);
							Users.add(U);
							break;
						}
						//Login
						case 2:{
							String Email, Password;
							boolean log=true;
							int UserIndex=-1;
							while(log) {
							
								System.out.println("Please Provide Your Email And Password (NewLine Separated): ");
								Email=input.next();
								Password=input.next();
								for(int i=0;i<Users.size();i++)
								{
									Users.get(i).Login(Email, Password);
									if(Users.get(i).LoggedIn)
									{
										UserIndex=i;
										break;
									}
								}
								
								System.out.println(UserIndex);
								log=false;
								
						}
							try {
							while(Users.get(UserIndex).LoggedIn)
							{
								System.out.println("1 - et2al");
								System.out.println("2 - yaba");
								System.out.println("3 - yazmeel");
								System.out.println("4 - logout");
								System.out.println("Choose An Operation: ");
								int LoggedChoice=input.nextInt();
								
								switch(LoggedChoice) {
									case 4:{
										Users.get(UserIndex).LoggedIn=false;
										break;
									}
								}
							}
							}
							catch(Exception e) {
								System.out.println("User not found");
							}
							
						}
					
					
					
					
						
					}
				}
					break;
				}
				//CASE DRIVER
				case 3:
				{
					boolean DriverRepeat=true;
					while(DriverRepeat) {
						System.out.println("Driver Menu:");
						System.out.println("1 - Create Account");
						System.out.println("2 - Login");
						System.out.println("3 - Return To Main Menu");
						System.out.println("Choose An Operation: ");
						int DriverMenuChoice=input.nextInt();
						switch(DriverMenuChoice) {
						
						//Create account
						case 1:{
							String Username, Password, MobileNumber, Email, NationalId, DriversLiscense;
							System.out.println("Enter Username, Password, Mobile Number, Email, NationalID, DriversLicense (NewLine Separated): ");
							Username=input.next();
							Password=input.next();
							MobileNumber=input.next();
							Email=input.next();
							NationalId=input.next();
							DriversLiscense=input.next();
							Driver d=new Driver(Username, Password, MobileNumber, Email, NationalId, DriversLiscense,Administrator);
							
							Drivers.add(d);
							System.out.println("Driver request is pending");
							break;
						}
						//Driver LOGIN
						case 2:{
							String Email, Password;
							boolean Logged=true;
							boolean log=true;
							int DriversIndex=-1;
							while(log) {
							
								System.out.println("Please Provide Your Email And Password (NewLine Separated): ");
								Email=input.next();
								Password=input.next();
								for(int i=0;i<Drivers.size();i++)
								{
									Drivers.get(i).Login(Email, Password);
									if(Drivers.get(i).Found)
									{
										DriversIndex=i;
										break;
									}
								}
								System.out.println(DriversIndex);
								log=false;
								
								
							}
							
							
							
							try {
							if(Drivers.get(DriversIndex).Accepted)
							{
							while(Logged)
							{
								System.out.println("1 - et2al");
								System.out.println("2 - yaba");
								System.out.println("3 - yazmeel");
								System.out.println("4 - logout");
								System.out.println("Choose An Operation: ");
								int LoggedChoice=input.nextInt();
								
								switch(LoggedChoice) {
									case 4:{
										Drivers.get(DriversIndex).LoggedIn=false;
										Drivers.get(DriversIndex).Found=false;
										Logged=false;
										break;
									}
								}
							}
							}
							else
							{
								Drivers.get(DriversIndex).Found=false;
							}
							}
							catch(Exception e) {
								System.out.println("Driver not found");
							}
							
							
						
							break;
						}
						//Return to main menu
						case 3:{
							DriverRepeat=false;
							break;
						}
						}
						
					}
					
					
					
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
	}
}
}
