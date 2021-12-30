package com.example.demo.application;

import java.util.ArrayList;

import com.example.demo.Core.Accounts;
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
	public ArrayList<UserEntity> GetUsersModel() 
	{	return UserPersistence.GetUsers();	}
	
	@Override
    public  UserEntity GetUser(int id) 
    {
		return UserPersistence.GetUser(id);
    }
	
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
	public void RegisterAsDriver(String NId, String DLicense, UserEntity UserEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String LogOut() {
		CurrentUser.setLoggedIn(false);
		return "User is now logged out";
	}

	@Override
	public TripEntity CreateTrip(String Src, String Dest) {
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
	public ArrayList<TripEntity> GetOffer(UserEntity UserEntity) {
		// TODO Auto-generated method stub
		return null;
	}
}