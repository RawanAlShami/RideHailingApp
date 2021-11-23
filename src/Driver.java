public class Driver extends Accounts
{
	private String DriversLicense;
	private String NationalId;
	protected boolean Accepted;

	public Driver(String UName, String Pass, String MobNo, String Mail,  String NatId, String DLicense, Admin A) 
	{
		super(UName, Pass, MobNo, Mail);
		DriversLicense=DLicense;
		NationalId=NatId;
		Accepted=false;
		A.AddPendingDrivers(this);
	}
	
	@Override
	public void Login(String Mail, String Pass) 
	{
		if(Mail==Email && Pass==Password && Accepted==true)
		{System.out.println("Logged In Successfully");}
		else
		{System.out.println("Driver Not Verified Yet");}
	}
	
	public String GetDriversLicense()
	{return DriversLicense;}
	
	public String GetNationalId()
	{return NationalId;}
}
