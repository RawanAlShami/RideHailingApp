package com.example.demo.application;

import java.util.ArrayList;

import com.example.demo.Core.AdminEntity;
import com.example.demo.Core.DriverEntity;
import com.example.demo.Core.UserEntity;

public interface IAdminService {
		
	boolean CreateAdmin(AdminEntity Admin);
	
	AdminEntity LogIn(String Email, String Password);
	
	String LogOut(AdminEntity Admin);
	
	//void AddPendingDrivers(DriverEntity D);
	 
	boolean VerifyDriversRegistration(String NationalID);

	AdminEntity GetAdmin();

	ArrayList<DriverEntity> ViewPendingDriversRequests();
	
	ArrayList<DriverEntity> ViewAcceptedDrivers();
}
