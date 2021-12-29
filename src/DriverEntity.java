public class DriverEntity extends Accounts
{
	//MEMBER VARIABLES
	private String DriversLicense;
	private String NationalId;
	protected boolean Accepted;
	protected boolean Found;
	protected FavAreasModel FavAreas=new FavAreasModel();
	
	//CONSTRUCTOR
	public DriverEntity(String UName, String Pass, String MobNo, String Mail,  String NatId, String DLicense) 
	{
		super(UName,Pass, MobNo, Mail);
		DriversLicense=DLicense;
		NationalId=NatId;
		Accepted=false;
	}
		
	//PRIVATE MEMBER VARIABLES GETTERS
	public String GetDriversLicense()
	{return DriversLicense;}
	
	public String GetNationalId()
	{return NationalId;}
	
	
	
}
