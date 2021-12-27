public class DriverEntity extends Accounts
{
	//MEMBER VARIABLES
	private String DriversLicense;
	private String NationalId;
	protected boolean Accepted;
	protected boolean Found;
	
	//CONSTRUCTOR
	public DriverEntity(String UName, String Pass, String MobNo, String Mail,  String NatId, String DLicense, AdminEntity A) 
	{
		super(UName,Pass, MobNo, Mail);
		DriversLicense=DLicense;
		NationalId=NatId;
		Accepted=false;
	}
	
	//LOGIN FUNCTION OVERRIDDEN TO CHECK IF DRIVER HAS BEEN VERIFIED FIRST
	@Override
	public void Login(String Mail, String Pass) 
	{
		if(Mail.equals(Email)&& Pass.equals(Password )&& Accepted)
		{
			LoggedIn=true;
			Found=true;
			System.out.println("Logged In Successfully");
		}
		else if(Mail.equals(Email)&& Pass.equals(Password )&& !Accepted)
		{
			Found=true;
			System.out.println("Driver Not Verified Yet");
		}
	}
	
	//PRIVATE MEMBER VARIABLES GETTERS
	public String GetDriversLicense()
	{return DriversLicense;}
	
	public String GetNationalId()
	{return NationalId;}
}
