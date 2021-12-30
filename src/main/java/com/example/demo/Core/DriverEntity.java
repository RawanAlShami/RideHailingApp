package com.example.demo.Core;
public class DriverEntity extends Accounts
{
	//MEMBER VARIABLES
	private String DriversLicense;
	private String NationalId;
	protected boolean Accepted;
	protected boolean Found;
	
	//***********protected FavAreasModel FavAreas=new FavAreasModel();
	
	//CONSTRUCTOR
	public DriverEntity()
	{
		UserID=UserIdCounter++;
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



	public boolean isFound() {
		return Found;
	}



	public void setFound(boolean found) {
		Found = found;
	}



	//PRIVATE MEMBER VARIABLES GETTERS
	public String GetDriversLicense()
	{return DriversLicense;}
	
	public String GetNationalId()
	{return NationalId;}
	
	
	
}
