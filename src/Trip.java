public class Trip 
{
	protected int TripId;
	protected static int counter=0;
	protected String Source;
	protected String Destination;
	protected double Price=0;
	protected boolean Status;
	private User UserInfo;
	private Driver DriverInfo;
	
	
	public Trip(String Src, String Dest)
	{
		Source=Src;
		Destination=Dest;
		TripId=counter++;
		Status=false;
	}
	
	public void SetUser(User U) {UserInfo=U;}
	public void SetDriver(Driver D) {DriverInfo=D;}
	
	public User GetUser() {return UserInfo;}
	public Driver GetDriver() {return DriverInfo;}
	

}

