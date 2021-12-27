import java.util.Scanner;

public class UserInterface 
{
	//CONTROLLERS
	protected UserController UserController=new UserController();
	
	//FUNCTION TO ACCESS USER MENU
	public void ShowMenu()
	{
		Scanner input=new Scanner(System.in);
		UserEntity CurrentUser=null;
		boolean UserRepeat=true;
		while(UserRepeat) 
		{
			System.out.println("User Menu:");
			System.out.println("1 - Create Account");
			System.out.println("2 - Login");
			System.out.println("3 - Return To Main Menu");
			System.out.println("Choose An Operation: ");
			int UserMenuChoice=input.nextInt();
			switch(UserMenuChoice) 
			{
				//CREATE ACCOUNT
				case 1:
				{
					String Username, Password, MobileNumber, Email;
					System.out.println("Enter Username, Password, Mobile Number, Email (NewLine Separated): ");
					Username=input.next();
					Password=input.next();
					MobileNumber=input.next();
					Email=input.next();
					UserController.CreateUser(Username, Password, MobileNumber, Email);
					break;
				}
				//LOGIN
				case 2:
				{
					String Email, Password;
					boolean log=true;
					while(log) 
					{
						System.out.println("Please Provide Your Email And Password (NewLine Separated): ");
						Email=input.next();
						Password=input.next();
						CurrentUser=UserController.LogIn(Email, Password);
						if(CurrentUser.equals(null))
							{System.out.println("Email And Password Not Found");}
						else
						{
							log=false;
							System.out.println("Logged In Successfully");
						}	
					}
					try 
					{
						boolean UserLoggedMenu=true;
						while(UserLoggedMenu)
						{
							System.out.println("1 - View trip offer");
							System.out.println("2 - Request ride");
							System.out.println("3 - Register as a driver");
							System.out.println("4 - logout");
							System.out.println("Choose An Operation: ");
							int LoggedChoice=input.nextInt();
							
							switch(LoggedChoice) 
							{
								//VIEW TRIP OFFER
								case 1:
								{
									/*
									try 
									{
										Trip P=Users.get(UserIndex).geTrip();
										if(P.Price==0) 
											System.out.println("No offers yet");
										else
											System.out.println("Price Offer:" +P.Price);
									}
									catch(Exception e) 
									{
										System.out.println("No request yet");
									}	
									*/
									break;
								}
								//REQUEST A RIDE
								case 2:
								{
									/*
									String Src,Dest;
									System.out.println("Please enter Source, Destination(NewLine Seperated): ");
									Src=input.next();
									Dest=input.next();
									r.addToPending(Users.get(UserIndex).CreateTrip(Src, Dest));
									*/
									break;								
								}
								//Become a driver
								case 3:
								{
									/*
									String nationalId, DriversLicense; 
									System.out.println("Please enter your nationalID, DriversLicense (NewLine Seperated): ");
									nationalId=input.next();
									DriversLicense=input.next();
									Drivers.add(Users.get(UserIndex).RegisterAsDriver(nationalId, DriversLicense, Administrator));	
									*/					
									break;
										
								}
								//LOGOUT
								case 4:
								{
									UserController.LogOut(CurrentUser);
									UserLoggedMenu=false;
									break;
								}
							}
						}
					}
					catch(Exception e) 
					{
						System.out.println("User not found");
					}
				
					break;
				}
				//RETURN TO MAIN MENU
				case 3:
				{
					UserRepeat=false;
					break;
				}
			}
		}
		//input.close();
	}
}
