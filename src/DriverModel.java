import java.util.ArrayList;

public class DriverModel 
{
	//REPOSITORY
	protected static ArrayList<DriverEntity> PendingDrivers= new ArrayList<DriverEntity>();
	protected static ArrayList<DriverEntity> Drivers = new ArrayList<DriverEntity>();
	
	//CRUD
	public void AddToPending(DriverEntity DriverEntity)
	{PendingDrivers.add(DriverEntity);}
	
	public void RemoveFromPending(DriverEntity DriverEntity)
	{
		PendingDrivers.remove(DriverEntity);
		PendingDrivers.trimToSize();
	}
	
	public ArrayList<DriverEntity> GetPendingDrivers()
	{return PendingDrivers;}
	
	public void AddToDrivers(DriverEntity DriverEntity)
	{Drivers.add(DriverEntity);}
	
	public ArrayList<DriverEntity> GetDrivers()
	{return Drivers;}
	
	

}
