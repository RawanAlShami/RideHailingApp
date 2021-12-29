public class TripEntity 
{
	//MEMBER VARIABLES
	protected int TripId;
	protected static int counter=0;
	protected String Source;
	protected String Destination;
	protected double Price=0;
	protected boolean Status;
	private UserEntity UserInfo;
	private DriverEntity DriverInfo;
	
	public TripEntity() {}
	
	//CONSTRUCTOR
	public TripEntity(String Src, String Dest)
	{
		Source=Src;
		Destination=Dest;
		TripId=counter++;
		Status=false;
	}
	
	//TRIPS' USER AND DRIVER SETTERS
	public void SetUser(UserEntity U) {UserInfo=U;}
	public void SetDriver(DriverEntity D) {DriverInfo=D;}
	
	//TRIPS' USER AND DRIVER GETTERS
	public UserEntity GetUser() {return UserInfo;}
	public DriverEntity GetDriver() {return DriverInfo;}
	
	public int GetTripID()
	{return TripId;}
	
	public String GetSource()
	{return Source;}
	
	public String GetDestination()
	{return Destination;}
	
	public double GetPrice()
	{return Price;}
	
	public void SetPrice(double price)
	{Price=price;}
}

