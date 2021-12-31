package com.example.demo.application;

import java.util.ArrayList;

import com.example.demo.Core.DriverEntity;
import com.example.demo.Core.TripEntity;
import com.example.demo.Core.UserEntity;
import com.example.demo.Persistence.UserPersistence;
import com.example.demo.Persistence.OfferPersistence;
import com.example.demo.Persistence.DriverPersistence;
import com.example.demo.Persistence.RequestPersistence;


public class UserService implements IUserService 
{
	private UserPersistence UserPersistence = new UserPersistence();
	private OfferPersistence OfferPersistence=new OfferPersistence();
	private DriverPersistence DriverPersistence=new DriverPersistence();
	private RequestPersistence RequestPersistence=new RequestPersistence();
	
	private UserEntity CurrentUser; 

    
	@Override
	public boolean CreateUser(UserEntity User)
	{	return UserPersistence.AddUser(User);	}
	
	@Override
    public  UserEntity GetUser(int id) 
    {	return UserPersistence.GetUser(id);	}

	@Override
	public ArrayList<UserEntity> GetUsersModel() 
	{	return UserPersistence.GetUsers();	}
	
	@Override
	public UserEntity LogIn(String email, String password)
	{
		ArrayList<UserEntity> AllUsers=UserPersistence.GetUsers();
		
		for(int i=0; i<AllUsers.size(); i++)
		{
			AllUsers.get(i).Login(email,password);
			if(AllUsers.get(i).isLoggedIn()) {
				CurrentUser=AllUsers.get(i);
				return AllUsers.get(i);
			}
				
		}
		//CHECKS IN INTERFACE IF NULL-> USER NOT FOUND. REENTER EMAIL AND PASSWORD
		return null;
	}
	
	@Override
	public String LogOut() 
	{
		CurrentUser.setLoggedIn(false);
		return "User is now logged out";
	}

	@Override
	public TripEntity CreateTrip(String Src, String Dest) 
	{
		if(CurrentUser.isLoggedIn())
		{
			TripEntity Trip=new TripEntity(Src,Dest);
			Trip.SetUser(CurrentUser);
			RequestPersistence.addToPending(Trip);
			return Trip;
		}
		else 
			return null; 	
	}

	@Override
	public ArrayList<TripEntity> GetOffers() 
	{
		 ArrayList<TripEntity> Offer=new ArrayList<TripEntity>();
		 ArrayList<TripEntity> DriverOffers=OfferPersistence.GetAllOffers();
		 for(int i=0;i<DriverOffers.size();i++)
		 {
			 if(DriverOffers.get(i).GetUser().GetID()==CurrentUser.getUserID())
			 {
				 Offer.add(DriverOffers.get(i));
			 }
		 }
		 if(Offer.isEmpty())
				Offer.add(null);	 
		 
		 return Offer;
	 }

	@Override
	public boolean AcceptOffer(int TripId, double price, String drivername) 
	{
		ArrayList<TripEntity> DriverOffers=OfferPersistence.GetAllOffers();
		boolean TripRemover=false;
		for(int i=0;i<DriverOffers.size();i++)
		 {
			if(DriverOffers.get(i).getTripId()==TripId && DriverOffers.get(i).getPrice()==price)
			{
				if(DriverOffers.get(i).GetDriver().getUsername().equals(drivername))
				{
					DriverOffers.get(i).setOfferAcceptance(true);
					RequestPersistence.AddToActive(DriverOffers.get(i));
					TripRemover=true;
				}
			}
		 }
		
		RequestPersistence.RemoveFromPending(TripId);
		OfferPersistence.RemoveFromAllOffers(TripId);
		
		return TripRemover;	
	}

	@Override
	public ArrayList<TripEntity> ViewTripHistory() 
	{
		 ArrayList<TripEntity> UserHistory=new ArrayList<TripEntity>();
		 ArrayList<TripEntity> AllHistory=RequestPersistence.GetTripHistory();
		 for(int i=0;i<AllHistory.size();i++)
		 {
			 if(AllHistory.get(i).GetUser().GetID()==CurrentUser.getUserID())
			 {
				 UserHistory.add(AllHistory.get(i));
			 }
		 }
		 if(UserHistory.isEmpty())
			 UserHistory.add(null);
		 
		 return UserHistory;
	 }

	@Override
	public boolean RateTrip(int TripId,int rating) 
	{
		ArrayList<TripEntity> History=ViewTripHistory();
		boolean rated=false;
		for(int i=0;i<History.size();i++)
		{
			if(History.get(i).getTripId()==TripId)
			{
				History.get(i).setRating(rating);
				History.get(i).setRated(true);
				rated=true;
			}
		}
		
		return rated;	
	}
	
	@Override
	public boolean RegisterAsDriver(String NId, String DLicense) 
	{
		DriverEntity DriverEntity =new DriverEntity(CurrentUser.getUsername(), CurrentUser.getPassword()
		,CurrentUser.getMobileNo(),CurrentUser.getEmail(),NId,DLicense);
		
		return DriverPersistence.AddToPending(DriverEntity);
	}

}

