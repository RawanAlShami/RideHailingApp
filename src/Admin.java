import java.util.ArrayList;

public class Admin extends Accounts
{
	private ArrayList<Driver> PendingDrivers= new ArrayList<Driver>();
	private ArrayList<Driver> Drivers = new ArrayList<Driver>();
	private int PendingDriversCounter;
	private int DriversCounter;
	
	public Admin(String UName, String Pass, String MobNo, String Mail) 
	{
		super(UName, Pass, MobNo, Mail);
		System.out.println("Account Created Successfully");
	}
	
	public void ViewPendingRequests() 
	{
		System.out.println("Pending requests:");
		for (int i = 0;i< PendingDrivers.size(); i++)
            System.out.println(PendingDrivers.get(i).GetDriversLicense() + "	" + PendingDrivers.get(i).GetNationalId());
	}
	
	public void ViewDrivers() 
	{
		System.out.println("Drivers:");
		for (int i = 0;i< Drivers.size(); i++)
            System.out.println(Drivers.get(i).GetDriversLicense() + "	" + Drivers.get(i).GetNationalId());
	}
	
	public void AddPendingDrivers(Driver D) 
	{PendingDrivers.add(D);}
	
	public void VerifyDriversRegistration(String NationalID)
	{
		for(int i=0;i<PendingDrivers.size();i++)
		{
			if(NationalID.equals(PendingDrivers.get(i).GetNationalId()))
			{
				PendingDrivers.get(i).Accepted=true;
				Drivers.add(PendingDrivers.get(i));
				PendingDrivers.remove(i);
				PendingDrivers.trimToSize();
				System.out.println("Driver Accepted");
				return;
			}
			
		}
		System.out.println("Driver Not Found");
	}
}
