import java.util.Scanner;

public class AdminInterface 
{
	//ONE GENERAL SYSTEM ADMIN
	protected AdminEntity Administrator=null;
	
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
					AdminEntity Admin=new AdminEntity(Username, Password, MobileNumber, Email);
					Administrator=Admin;
					Admin.AdminController.AdminModel.Admins.add(Admin);
					break;
				}
				
				//ADMIN - LOGIN
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
							//VIEW PENDING DRIVERS REQUESTS
							case 1:
							{
								Administrator.AdminController.ViewPendingRequests();
								break;
							}
							//VIEW DRIVERS
							case 2:
							{
								Administrator.AdminController.ViewDrivers();
								break;
							}
							//VERIFY PENDING DRIVER REQUESTS
							case 3:
							{
								System.out.println("Please Enter Drivers National ID To Be Verified: ");
								String NationalID=input.next();
								Administrator.AdminController.VerifyDriversRegistration(NationalID);
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
		//input.close();
	}
}
