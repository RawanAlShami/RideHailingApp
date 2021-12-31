package com.example.demo.application;

import java.util.ArrayList;

import com.example.demo.Core.AdminEntity;
import com.example.demo.Core.DriverEntity;

public interface IAdminService {
		
	boolean CreateAdmin(AdminEntity Admin);
	
	AdminEntity GetAdmin();
	
	AdminEntity LogIn(String Email, String Password);
	
	String LogOut(AdminEntity Admin);
	
	ArrayList<DriverEntity> ViewPendingDriversRequests();
	 
	boolean VerifyDriversRegistration(String NationalID);
	
	ArrayList<DriverEntity> ViewAcceptedDrivers();
}
