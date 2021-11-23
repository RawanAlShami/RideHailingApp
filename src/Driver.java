import java.util.ArrayList;

public class Driver extends Accounts implements DriverObservers
{
	protected ArrayList<Trip> PendingTrips= new ArrayList<Trip>();
	private String DriversLicense;
	private String NationalId;
	protected boolean Accepted;
	protected boolean Found;
	protected FavAreas favAreas=new FavAreas();
	ArrayList<String> Notifications= new ArrayList<String>();
	protected Offer offer=new Offer();
	
	
	public Driver(String UName, String Pass, String MobNo, String Mail,  String NatId, String DLicense, Admin A) 
	{
		super(UName, Pass, MobNo, Mail);
		DriversLicense=DLicense;
		NationalId=NatId;
		Accepted=false;
		A.AddPendingDrivers(this);
		favAreas = new FavAreas();
	}
	
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
	
	public String GetDriversLicense()
	{return DriversLicense;}
	
	public String GetNationalId()
	{return NationalId;}
	
	//public ArrayList<String> ViewFavAreaRequests(Request r) {
	public ArrayList<String> ViewFavAreaRequests(Request r) {
		try {
			this.favAreas.notifyDriver(r,this);
		}catch(Exception e) {
			System.out.println("Driver Class");
		}
		
	return Notifications;
	}
	
	//public Trip SuggestPrice(int TripId, double NewPrice)
	//{
		
		//return NewTrip;
	//}
}
