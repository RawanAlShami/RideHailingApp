package com.example.demo.application;

import java.util.ArrayList;

import com.example.demo.Core.DriverEntity;
import com.example.demo.Core.TripEntity;
import com.example.demo.Persistence.RequestPersistence;
import com.example.demo.Persistence.OfferPersistence;

public class OfferService implements IOfferService
{
	
	protected RequestPersistence RequestPersistence=new RequestPersistence();
	protected OfferPersistence OfferPersistence=new OfferPersistence();	
	
	@Override
	public boolean OfferNewPrice(double Price, int TripId, DriverEntity DriverEntity) 
	{
		TripEntity NewOffer=new TripEntity(); 
		ArrayList<TripEntity> PendingTrips=RequestPersistence.GetPendingTrips();
		for(int i=0;i<PendingTrips.size();i++){
			if(PendingTrips.get(i).getTripId()==TripId)
			{
				NewOffer.setSource(PendingTrips.get(i).GetSource());
				NewOffer.setDestination(PendingTrips.get(i).GetDestination());
				NewOffer.setCompletionStatus(PendingTrips.get(i).isCompletionStatus());
				NewOffer.SetDriver(DriverEntity);
				NewOffer.SetUser(PendingTrips.get(i).GetUser());
				NewOffer.setTripId(PendingTrips.get(i).GetTripID());
				NewOffer.SetPrice(Price);
				OfferPersistence.AddToAllOffers(NewOffer);
				return true;
			}
		}
		return false;
	}	
}
