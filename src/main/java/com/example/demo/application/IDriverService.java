package com.example.demo.application;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Core.DriverEntity;
import com.example.demo.Core.TripEntity;
import com.example.demo.Core.UserEntity;

public interface IDriverService {
	
	ArrayList<TripEntity>  GetPendingFavAreaTrips(DriverEntity DriverEntity);
	
	boolean CreateDriver(DriverEntity DriverEntity );
	
	DriverEntity LogIn(String Email, String Password);
	
	DriverEntity GetDriver(int id);

	String LogOut();
	
	
   
}
