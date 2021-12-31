package com.example.demo.application;

import java.util.ArrayList;
import com.example.demo.Core.DriverBalance;
import com.example.demo.Core.DriverEntity;
import com.example.demo.Core.TripEntity;

public interface IDriverService {
	
	boolean CreateDriver(DriverEntity DriverEntity );
	
	DriverEntity GetDriver(int id);
	
	DriverEntity LogIn(String Email, String Password);

	String LogOut();
	
	boolean AddFavAreaSrc(String src);

	ArrayList<String> ViewFavAreas();
	
	ArrayList<TripEntity> ViewAllPendingTrips();
	
	ArrayList<TripEntity> GetActiveTrips();
	
	ArrayList<TripEntity> GetPendingFavAreaTrips();
	
	boolean OfferPrice(int TripId,double Price);
	
	boolean EndRide(int TripId);
	
	DriverBalance ViewBalance();
}
