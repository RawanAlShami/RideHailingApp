import java.util.ArrayList;

public class User extends Accounts 
{
	protected Trip UserTrip;
	protected ArrayList<Trip> TripHistory= new ArrayList<Trip>();
	
	public User(String UName, String Pass, String MobNo, String Mail) 
	{super(UName, Pass, MobNo, Mail);}
	
	public Trip CreateTrip(String Src,String Dest)
	{
		UserTrip=new Trip(Src,Dest);
		UserTrip.SetUser(this);
		TripHistory.add(UserTrip);
		return UserTrip;
	}
	
	public Driver RegisterAsDriver(String NId, String DLicense, Admin A) 
	{
		Driver D =new Driver(Username, Password,MobileNo,Email,NId,DLicense, A);
		return D;
	}
	public void driverOfferUpdate(double p) {
		UserTrip.Price=p;
		System.out.println("User Notified");
	}
	public Trip geTrip() {
		return UserTrip;
	}
}
