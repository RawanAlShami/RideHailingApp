public class Trip 
{
	protected int TripId;
	protected String Source;
	protected String Destination;
	protected double Price;
	protected boolean Status;
	private User UserInfo;
	private Driver DriverInfo;
	
	public Trip(String Src, String Dest, double Cost)
	{
		Source=Src;
		Destination=Dest;
		Price=Cost;
	}
	
	public void SetUser(User U) {UserInfo=U;}
	public void SetDriver(Driver D) {DriverInfo=D;}
	
	public User GetUser() {return UserInfo;}
	public Driver GetDriver() {return DriverInfo;}
}
