package com.example.demo.application;
import java.util.ArrayList;

import com.example.demo.Core.TripEntity;
import com.example.demo.Persistence.RequestPersistence;
import com.example.demo.Persistence.TripETA;

public class TripService implements ITripService
{
	protected TripETA TripETACalculation;
	private RequestPersistence RequestPersistence=new RequestPersistence();
	
	@Override
	public String CalculateDistance(int id) 
	{
		TripEntity CurrentTrip;
		ArrayList<TripEntity> ActiveTrips=RequestPersistence.GetActiveTrips();
		for(int i=0;i<ActiveTrips.size();i++)
		{
			if(ActiveTrips.get(i).getTripId()==id)
			{
				CurrentTrip=ActiveTrips.get(i);
				CurrentTrip.setTripETA(CurrentTrip.getTripETA().TrackTrafficCalls());
				return CurrentTrip.getTripETA().CalculateDistanceETA();
			}
		}
		return "Trip Has Not Been Started Yet";
	}
}