import java.util.ArrayList;

public class AdminController 
{
	//DRIVER MODEL OBJECT
	protected DriverModel DriverModel=new DriverModel();
	protected AdminModel AdminModel=new AdminModel();
	
	
	public void CreateAdmin(String Username,String  Password,String  MobileNumber,String  Email)
	{
		AdminEntity AdminEntity=new AdminEntity(Username, Password, MobileNumber, Email);
		AdminModel.SetAdmin(AdminEntity);
	}
	
	//FINDS USER AND LOGS THEM IN
	public AdminEntity LogIn(String Email, String Password)
	{
				
		AdminEntity Admin=AdminModel.GetAdmin();
				
		if(Admin!=null && Admin.Email.equals(Email) && Admin.Password.equals(Password))
		{
			return Admin;
		}
		//CHECKS IN INTERFACE IF NULL-> USER NOT FOUND. REENTER EMAIL AND PASSWORD
		return null;
	}
	
	//FUNCTION TO ADD PENDING DRIVER TO LLIST OF PENDING DRIVERS
	public void AddPendingDrivers(DriverEntity D) 
	{DriverModel.PendingDrivers.add(D);}
	
	//FUNCTION TO VERIFY A PENDING DRIVER
	public boolean VerifyDriversRegistration(String NationalID)
	{
		ArrayList<DriverEntity> PendingDrivers=DriverModel.GetPendingDrivers();
		for(int i=0;i<PendingDrivers.size();i++)
		{
			if(NationalID.equals(PendingDrivers.get(i).GetNationalId()))
			{
				PendingDrivers.get(i).Accepted=true;
				DriverModel.AddToDrivers(PendingDrivers.get(i));
				DriverModel.RemoveFromPending(PendingDrivers.get(i));
				return true;
			}
		}
		return false;
	}
}
