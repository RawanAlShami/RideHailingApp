import java.util.ArrayList;
import java.util.Scanner;

public class AdminInterface 
{
	protected AdminEntity Administrator;
	protected AdminController AdminController=new AdminController();
	
	//SHOW MENU THROUGH INTERFACE
	public void ShowMenu()
	{
		Scanner input=new Scanner(System.in);
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
				//ADMIN - CREATE ACCOUNT
				case 1:
				{
					String Username, Password, MobileNumber, Email;
					System.out.println("Enter Username, Password, Mobile Number, Email (NewLine Separated): ");
					Username=input.next();
					Password=input.next();
					MobileNumber=input.next();
					Email=input.next();
					AdminController.CreateAdmin(Username, Password, MobileNumber, Email);
					Administrator=AdminController.AdminModel.GetAdmin();
					System.out.println("Account Created Successfully");
					break;
				}
				
				//ADMIN - LOGIN
				case 2:
				{
					String Email, Password;
					boolean Logged=true;
					boolean log=true;
					while(log)
					{
						System.out.println("Please Provide Your Email And Password (NewLine Separated): ");
						Email=input.next();
						Password=input.next();
						Administrator=AdminController.LogIn(Email, Password);
						if(Administrator==null)
						{
							System.out.println("Email And Password Not Found");
							Logged=false;
							log=false;
							
						}
						else
						{
							log=false;
							System.out.println("Logged In Successfully");
						}	
					}
					try 
					{
					while(Logged)
					{
						System.out.println("1 - View Pending Drivers Requests");
						System.out.println("2 - View Drivers");
						System.out.println("3 - Verify Pending Driver Request");
						System.out.println("4 - LogOut");
						int AdminLoopChoice=input.nextInt();
						switch(AdminLoopChoice)
						{
							//VIEW PENDING DRIVERS REQUESTS
							case 1:
							{
								ArrayList<DriverEntity> PendingDrivers=AdminController.DriverModel.GetPendingDrivers();
								System.out.println("Pending requests:");
								for (int i = 0;i<PendingDrivers.size(); i++)
						            System.out.println(PendingDrivers.get(i).GetDriversLicense() + "	" + PendingDrivers.get(i).GetNationalId());
								break;
							}
							//VIEW DRIVERS
							case 2:
							{
								ArrayList<DriverEntity> Drivers=AdminController.DriverModel.GetDrivers();
								System.out.println("Drivers:");
								for (int i = 0;i<Drivers.size(); i++)
						            System.out.println(Drivers.get(i).GetDriversLicense() + "	" + Drivers.get(i).GetNationalId());
								break;
							}
							//VERIFY PENDING DRIVER REQUESTS
							case 3:
							{
								boolean Verified;
								
								System.out.println("Please Enter Drivers National ID To Be Verified: ");
								String NationalID=input.next();
								
								Verified=AdminController.VerifyDriversRegistration(NationalID);
								if(Verified)
									System.out.println("Driver Accepted");
								else
									System.out.println("Driver Not Found");
								break;
							}
							//LOGOUT
							case 4:
							{
								Administrator.LoggedIn=false;
								Logged=false;
								break;
							}
						}
					}
					}
					catch(Exception e) 
					{
						System.out.println("");
					}
					break;
				}
				//RETURN TO MAIN MENU
				case 3:
				{
					AdminRepeat=false;
					break;
				}
			}
		}
	}
}
