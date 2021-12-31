package com.example.demo.Persistence;

import java.util.ArrayList;

import com.example.demo.Core.DriverEntity;

public class DriverPersistence 
{
	//ARRAYLISTS
	protected static ArrayList<DriverEntity> PendingDrivers= new ArrayList<DriverEntity>();
	protected static ArrayList<DriverEntity> Drivers = new ArrayList<DriverEntity>();
	
	//CRUD
	public boolean AddToPending(DriverEntity DriverEntity)
	{return PendingDrivers.add(DriverEntity);}
	
	public void RemoveFromPending(DriverEntity DriverEntity)
	{
		PendingDrivers.remove(DriverEntity);
		PendingDrivers.trimToSize();
	}
	
	public void AddToDrivers(DriverEntity DriverEntity)
	{Drivers.add(DriverEntity);}
	
	public ArrayList<DriverEntity> GetPendingDrivers()
	{return PendingDrivers;}
	
	public ArrayList<DriverEntity> GetDrivers()
	{return Drivers;}
	
}
