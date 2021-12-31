package com.example.demo.application;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Core.DriverBalance;
import com.example.demo.Core.DriverEntity;
import com.example.demo.Core.TripEntity;
import com.example.demo.Core.UserEntity;

public interface IDriverService {
	
	boolean CreateDriver(DriverEntity DriverEntity );
	
	DriverEntity LogIn(String Email, String Password);
	
	DriverEntity GetDriver(int id);

	String LogOut();

	ArrayList<String> ViewFavAreas();
	
	ArrayList<TripEntity> ViewAllPendingTrips();
	
	ArrayList<TripEntity> GetPendingFavAreaTrips();

	boolean AddFavAreaSrc(String src);
	
	boolean OfferPrice(int TripId,double Price);
	
	ArrayList<TripEntity> GetActiveTrips();
	
	boolean EndRide(int TripId);
	
	DriverBalance ViewBalance();
}
