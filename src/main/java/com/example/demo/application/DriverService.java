package com.example.demo.application;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Core.DriverEntity;
import com.example.demo.Core.TripEntity;
import com.example.demo.Core.UserEntity;
import com.example.demo.Persistence.UserPersistence;
import com.example.demo.Persistence.DriverPersistence;
import com.example.demo.Persistence.RequestPersistence;

public class DriverService implements IDriverService {

	private RequestPersistence RequestPersistence=new RequestPersistence();
	private DriverPersistence DriverPersistence=new DriverPersistence();
	private DriverEntity CurrentDriver;
	private OfferService OfferService=new OfferService();
	
	

	@Override
	public boolean CreateDriver(DriverEntity DriverEntity) {
		return DriverPersistence.AddToPending(DriverEntity);
	}

	@Override
	public DriverEntity LogIn(String Email, String Password) {
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
	public String LogOut() {
		CurrentDriver.setLoggedIn(false);
		return "Driver is now logged out";
	}

	@Override
	public DriverEntity GetDriver(int id) {
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
	public ArrayList<String> ViewFavAreas()
	{
		return CurrentDriver.getFavAreas().GetFavAreasModel();
	}
	
	@Override
	public boolean AddFavAreaSrc(String src)
	{
		return CurrentDriver.getFavAreas().addFavArea(src);
	}

	@Override
	public ArrayList<TripEntity> GetPendingFavAreaTrips() {
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
	public ArrayList<TripEntity> ViewAllPendingTrips() {
		return RequestPersistence.GetPendingTrips();
	}

	@Override
	public boolean OfferPrice(int TripId, double Price) {
		return OfferService.OfferNewPrice(Price, TripId, CurrentDriver);
	}

	@Override
	public ArrayList<TripEntity> GetActiveTrips() {
		return RequestPersistence.GetActiveTrips();
	}



	

	
	
  

}
