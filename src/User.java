public class User extends Accounts 
{
	public User(String UName, String Pass, String MobNo, String Mail) 
	{super(UName, Pass, MobNo, Mail);}
	
	public Trip CreateTrip(String Src,String Dest, double Price)
	{
		Trip UserTrip=new Trip(Src,Dest,Price);
		return UserTrip;
	}
	
	public Driver RegisterAsDriver(String NId, String DLicense, Admin A) 
	{
		Driver D =new Driver(Username, Password,MobileNo,Email,NId,DLicense, A);
		return D;
	}
}
