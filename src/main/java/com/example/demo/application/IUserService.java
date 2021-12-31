package com.example.demo.application;

import java.util.ArrayList;

import com.example.demo.Core.TripEntity;
import com.example.demo.Core.UserEntity;

public interface IUserService 
{
	boolean CreateUser(UserEntity User);
	
	UserEntity GetUser(int id);
	
	ArrayList<UserEntity> GetUsersModel();	
	
	UserEntity LogIn(String Email, String Password);
	
	String LogOut();
	 
	TripEntity CreateTrip(String Src,String Dest);
	 
	ArrayList<TripEntity> GetOffers();
	 
	boolean AcceptOffer(int TripId,double price,String drivername);
	 
	ArrayList<TripEntity>  ViewTripHistory();
	 
	boolean RateTrip(int TripId,int rating);
	
	boolean RegisterAsDriver(String NId, String DLicense);
}