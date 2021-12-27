public class AdminController 
{
	//DRIVER MODEL OBJECT
	protected DriverModel DriverModel=new DriverModel();
	protected AdminModel AdminModel=new AdminModel();
	
	//FUNCTION TO VIEW PENDING REQUESTS
	public void ViewPendingRequests() 
	{
		System.out.println("Pending requests:");
		for (int i = 0;i<DriverModel.PendingDrivers.size(); i++)
            System.out.println(DriverModel.PendingDrivers.get(i).GetDriversLicense() + "	" + DriverModel.PendingDrivers.get(i).GetNationalId());
	}
	
	//FUNCTION TO VIEW ALL VERIFIED DRIVERS
	public void ViewDrivers() 
	{
		System.out.println("Drivers:");
		for (int i = 0;i<DriverModel.Drivers.size(); i++)
            System.out.println(DriverModel.Drivers.get(i).GetDriversLicense() + "	" + DriverModel.Drivers.get(i).GetNationalId());
	}
	
	//FUNCTION TO ADD PENDING DRIVER TO LLIST OF PENDING DRIVERS
	public void AddPendingDrivers(DriverEntity D) 
	{DriverModel.PendingDrivers.add(D);}
	
	//FUNCTION TO VERIFY A PENDING DRIVER
	public void VerifyDriversRegistration(String NationalID)
	{
		for(int i=0;i<DriverModel.PendingDrivers.size();i++)
		{
			if(NationalID.equals(DriverModel.PendingDrivers.get(i).GetNationalId()))
			{
				DriverModel.PendingDrivers.get(i).Accepted=true;
				DriverModel.Drivers.add(DriverModel.PendingDrivers.get(i));
				DriverModel.PendingDrivers.remove(i);
				DriverModel.PendingDrivers.trimToSize();
				System.out.println("Driver Accepted");
				return;
			}
		}
		System.out.println("Driver Not Found");
	}
}
