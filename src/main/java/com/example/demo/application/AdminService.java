package com.example.demo.application;

import java.util.ArrayList;

import com.example.demo.Core.AdminEntity;
import com.example.demo.Core.DriverEntity;
import com.example.demo.Persistence.AdminPersistence;
import com.example.demo.Persistence.DriverPersistence;


public class AdminService implements IAdminService 
{	
	
	private DriverPersistence DriverPersistence=new DriverPersistence();
	private AdminPersistence AdminPersistence=new AdminPersistence();
	
	@Override
	public boolean CreateAdmin(AdminEntity Admin) 
	{	return AdminPersistence.AddAdmin(Admin);	}
	
	@Override
    public  AdminEntity GetAdmin() 
    {	return AdminPersistence.GetAdmin();	}

	@Override
	public AdminEntity LogIn(String email, String password) 
	{
		AdminEntity Administrator=AdminPersistence.GetAdmin();
		
		Administrator.Login(email,password);
		if(Administrator.isLoggedIn())
			return Administrator;
		else
			return null;
	}
	
	@Override
	public String LogOut(AdminEntity Admin) 
	{
		Admin.setLoggedIn(false);
		return "Admin is now logged out";
	}

	@Override
	public ArrayList<DriverEntity> ViewPendingDriversRequests() 
	{
		AdminEntity Administrator=AdminPersistence.GetAdmin();
		if(Administrator.isLoggedIn())
			return DriverPersistence.GetPendingDrivers();
		else
			return null;
	}

	@Override
	public boolean VerifyDriversRegistration(String NationalID) 
	{
		ArrayList<DriverEntity> Pending=DriverPersistence.GetPendingDrivers();
		
		for(int i=0;i<Pending.size();i++)
		{
			if(Pending.get(i).getNationalId().equals(NationalID))
			{
				Pending.get(i).setAccepted(true);
				DriverPersistence.AddToDrivers(Pending.get(i));
				DriverPersistence.RemoveFromPending(Pending.get(i));
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<DriverEntity> ViewAcceptedDrivers() 
	{
		AdminEntity Administrator=AdminPersistence.GetAdmin();
		if(Administrator.isLoggedIn())
			return DriverPersistence.GetDrivers();
		else
			return null;	
	}
	
}
