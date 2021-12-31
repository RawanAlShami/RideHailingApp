package com.example.demo.Core;
import com.example.demo.Persistence.GoogleMapsAPI;
import com.example.demo.Persistence.TripETA;

public class TripEntity 
{
	//MEMBER VARIABLES
	protected int TripId;
	protected static int counter=0;
	protected String Source;
	protected String Destination;
	protected double Price=0;
	protected boolean CompletionStatus;
	protected boolean OfferAcceptance;
	private UserEntity UserInfo;
	private DriverEntity DriverInfo;
	private TripETA TripETAStrategy=new GoogleMapsAPI();
	private boolean Rated;
	private int Rating;
	
	
	//DEFAULT CONSTRUCTOR
	public TripEntity() {}
	
	//PARAMETERIZED CONSTRUCTOR
	public TripEntity(String Src, String Dest)
	{
		Source=Src;
		Destination=Dest;
		TripId=counter++;
		CompletionStatus=false;
		OfferAcceptance=false;
		Rated=false;
		Rating=0;
	}
	
	//SETTERS AND GETTERS
	public int getRating() 
	{ return Rating; }

	public void setRating(int rating) 
	{ Rating = rating; }

	public boolean isRated() 
	{ return Rated; }

	public void setRated(boolean rated) 
	{ Rated = rated; }
	
	public int getTripId() 
	{ return TripId; }

	public void setTripId(int tripId) 
	{ TripId = tripId; }

	public static int getCounter() 
	{ return counter; }

	public static void setCounter(int counter) 
	{ TripEntity.counter = counter; }

	public String getSource() 
	{ return Source; }

	public void setSource(String source) 
	{ Source = source; }

	public String getDestination() 
	{ return Destination; }

	public void setDestination(String destination) 
	{ Destination = destination; }

	public double getPrice() 
	{ return Price; }

	public void setPrice(double price) 
	{ Price = price; }

	public boolean isCompletionStatus() 
	{ return CompletionStatus; }

	public void setCompletionStatus(boolean status) 
	{ CompletionStatus = status; }

	public boolean isOfferAcceptance() 
	{ return OfferAcceptance; }

	public void setOfferAcceptance(boolean offerAcceptance) 
	{ OfferAcceptance = offerAcceptance; }

	public UserEntity getUserInfo() 
	{ return UserInfo; }

	public void setUserInfo(UserEntity userInfo) 
	{ UserInfo = userInfo; }

	public DriverEntity getDriverInfo() 
	{ return DriverInfo; }

	public void setDriverInfo(DriverEntity driverInfo) 
	{ DriverInfo = driverInfo; }

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
	
	//TRIPS' USER AND DRIVER SETTERS
	public void SetUser(UserEntity U) 
	{UserInfo=U;}
	
	public void SetDriver(DriverEntity D) 
	{DriverInfo=D;}
	
	//TRIPS' USER AND DRIVER GETTERS
	public UserEntity GetUser() 
	{return UserInfo;}
	
	public DriverEntity GetDriver() 
	{return DriverInfo;}
	
	public TripETA getTripETA() 
	{return TripETAStrategy;}

	public void setTripETA(TripETA tripETA) 
	{TripETAStrategy = tripETA;}
}

