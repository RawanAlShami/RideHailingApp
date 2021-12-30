package com.example.demo.application;

import java.util.ArrayList;

import com.example.demo.Core.Accounts;
import com.example.demo.Core.TripEntity;
import com.example.demo.Core.UserEntity;

public interface IUserService 
{
	boolean CreateUser(UserEntity User);
	
	UserEntity GetUser(int id);
	
	ArrayList<UserEntity> GetUsersModel();	
	
	UserEntity LogIn(String Email, String Password);
	
	 void RegisterAsDriver(String NId, String DLicense,UserEntity UserEntity);
	 
	 String LogOut();
	 
	 TripEntity CreateTrip(String Src,String Dest);
	 
	 ArrayList<TripEntity> GetOffer(UserEntity UserEntity);
	 
	 
	
	
	
	
}