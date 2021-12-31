package com.example.demo.Persistence;

public abstract class TripETA 
{
	int NumberOfCalls;

	public int getNumberOfCalls() 
	{	return NumberOfCalls;	}

	public void setNumberOfCalls(int numberOfCalls) 
	{	NumberOfCalls = numberOfCalls;	}
	
	public TripETA TrackTrafficCalls()
	{
		TripETA DistanceStrategy;
		NumberOfCalls=(int)(Math.random()*(1000-200))+200;
		if(NumberOfCalls>700)
			DistanceStrategy=new Harvesine();
		else
			DistanceStrategy=new GoogleMapsAPI();
		return DistanceStrategy; 
	}
	
	public abstract String CalculateDistanceETA();
}