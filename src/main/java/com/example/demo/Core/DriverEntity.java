package com.example.demo.Core;

import com.example.demo.Persistence.FavAreasPersistence;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class DriverEntity extends Accounts
{
	//MEMBER VARIABLES
	private String DriversLicense;
	private String NationalId;
	protected boolean Accepted;
	
	@JsonIgnore
	protected FavAreasPersistence FavAreas=new FavAreasPersistence();
	
	//CONSTRUCTOR
	public DriverEntity()
	{
		UserID=UserIdCounter++;
	}
	
	@JsonIgnore
	public FavAreasPersistence getFavAreas() {
		return FavAreas;
	}
	
	
	public DriverEntity(String UName, String Pass, String MobNo, String Mail,  String NatId, String DLicense) 
	{
		super(UName,Pass, MobNo, Mail);
		DriversLicense=DLicense;
		NationalId=NatId;
		Accepted=false;
	}
		
	
	
	public String getDriversLicense() {
		return DriversLicense;
	}



	public void setDriversLicense(String driversLicense) {
		DriversLicense = driversLicense;
	}



	public String getNationalId() {
		return NationalId;
	}



	public void setNationalId(String nationalId) {
		NationalId = nationalId;
	}



	public boolean isAccepted() {
		return Accepted;
	}



	public void setAccepted(boolean accepted) {
		Accepted = accepted;
	}

	//PRIVATE MEMBER VARIABLES GETTERS
	public String GetDriversLicense()
	{return DriversLicense;}
	
	public String GetNationalId()
	{return NationalId;}

	
	
}
