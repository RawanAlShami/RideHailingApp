package com.example.demo.application;

import java.util.ArrayList;
import com.example.demo.Core.DriverBalance;
import com.example.demo.Core.DriverEntity;
import com.example.demo.Core.TripEntity;
import com.example.demo.Persistence.DriverPersistence;
import com.example.demo.Persistence.RequestPersistence;

public class DriverService implements IDriverService 
{
	private RequestPersistence RequestPersistence=new RequestPersistence();
	private DriverPersistence DriverPersistence=new DriverPersistence();
	private DriverEntity CurrentDriver;
	private OfferService OfferService=new OfferService();
	
	
	@Override
	public boolean CreateDriver(DriverEntity DriverEntity) 
	{	return DriverPersistence.AddToPending(DriverEntity);	}

	@Override
	public DriverEntity GetDriver(int id) 
	{
		ArrayList<DriverEntity> AllDrivers=DriverPersistence.GetDrivers();
		DriverEntity Driver;
		for(int i=0;i<AllDrivers.size();i++)
		{
			if(AllDrivers.get(i).GetID()==id)
			{
				return Driver=AllDrivers.get(i);
				
			}
		} 
		return null;
	}
	
	@Override
	public DriverEntity LogIn(String Email, String Password) 
	{
		ArrayList<DriverEntity> AllDrivers=DriverPersistence.GetDrivers();
		
		for(int i=0; i<AllDrivers.size(); i++)
		{
			if(AllDrivers.get(i).isAccepted())
			{
				AllDrivers.get(i).Login(Email, Password);
				if(AllDrivers.get(i).isLoggedIn())
				{
					CurrentDriver=AllDrivers.get(i);
					return AllDrivers.get(i);
				}				
			}
		}
		//CHECKS IN INTERFACE IF NULL-> USER NOT FOUND. REENTER EMAIL AND PASSWORD
		return null;
	}
	
	@Override
	public String LogOut() 
	{
		CurrentDriver.setLoggedIn(false);
		return "Driver is now logged out";
	}
	
	@Override
	public boolean AddFavAreaSrc(String src)
	{	return CurrentDriver.getFavAreas().addFavArea(src);		}
	
	@Override
	public ArrayList<String> ViewFavAreas()
	{	return CurrentDriver.getFavAreas().GetFavAreasModel();	}
	
	@Override
	public ArrayList<TripEntity> ViewAllPendingTrips() 
	{	return RequestPersistence.GetPendingTrips();	}
	
	@Override
	public ArrayList<TripEntity> GetActiveTrips() 
	{	return RequestPersistence.GetActiveTrips();	}

	@Override
	public ArrayList<TripEntity> GetPendingFavAreaTrips() 
	{
		ArrayList<TripEntity> Notifications = new ArrayList<TripEntity>();
		ArrayList<TripEntity> PendingTrips=RequestPersistence.GetPendingTrips();
		for(int i=0;i<PendingTrips.size();i++)
		{
				
			for(int j=0;j<CurrentDriver.getFavAreas().GetFavAreasModel().size();j++)
			{
				if(PendingTrips.get(i).getSource().contains(CurrentDriver.getFavAreas().GetFavAreasModel().get(j)))
				{
					Notifications.add(PendingTrips.get(i));
				}
			}
		}
		return Notifications;
	}

	@Override
	public boolean OfferPrice(int TripId, double Price) 
	{	return OfferService.OfferNewPrice(Price, TripId, CurrentDriver);	}

	@Override
	public boolean EndRide(int TripId) 
	{
		ArrayList<TripEntity> ActiveTrips=RequestPersistence.GetActiveTrips();
		boolean End=false;
		for(int i=0;i<ActiveTrips.size();i++)
		{
			if(ActiveTrips.get(i).getTripId()==TripId)
			{
				CurrentDriver.GetBalance().setBalance(ActiveTrips.get(i).getPrice());
				ActiveTrips.get(i).setCompletionStatus(true);
				RequestPersistence.ActiveToHistory(ActiveTrips.get(i));
				End=true;
			}
		}
		ActiveTrips.trimToSize();
		
		return End;
	}

	@Override
	public DriverBalance ViewBalance() 
	{	return CurrentDriver.GetBalance();	} 
	
}
