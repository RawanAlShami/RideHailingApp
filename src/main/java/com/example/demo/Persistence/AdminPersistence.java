package com.example.demo.Persistence;

import java.util.ArrayList;

import com.example.demo.Core.AdminEntity;

public class AdminPersistence 
{
	//ARRAYLIST
	protected ArrayList<AdminEntity> Admins = new ArrayList<AdminEntity>();

	//CRUD
	public boolean AddAdmin(AdminEntity Admin)
	{ return Admins.add(Admin); }
	
	public AdminEntity GetAdmin()
	{
		if(Admins.isEmpty())
			Admins.add(null);
			
		return Admins.get(0);
	}
	
}

