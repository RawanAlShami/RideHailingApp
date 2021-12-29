import java.util.ArrayList;

public class RequestModel  implements RequestSubject
{
	protected static ArrayList<TripEntity> PendingTrips = new ArrayList<TripEntity>();
	
	protected static ArrayList<TripEntity> ActiveTrips = new ArrayList<TripEntity>();
	
	protected static ArrayList<TripEntity> TripHistory = new ArrayList<TripEntity>();
	
	//CRUD
	public ArrayList<TripEntity> GetTripHistory()
	{return TripHistory;}
	
	//CRUD
	public ArrayList<TripEntity> GetPendingTrips()
	{return PendingTrips;}
	
	public void addToPending(TripEntity T)
	{
		PendingTrips.add(T);
		notifyObserver();
	}
	
	
	public void PendingToActive(TripEntity T) 
	{
		try {
		ActiveTrips.add(T);
		PendingTrips.remove(T);
		}catch(Exception e) {
			System.out.println("Trip Not Found!");
		}
	}
	
	
	public void ActiveToHistory(TripEntity T) {
		try {
			ActiveTrips.remove(T);
			TripHistory.add(T);
			}catch(Exception e) {
				System.out.println("Trip Not Found!");
			}
	}


	public void addObserver(DriverEntity d) {
		// TODO Auto-generated method stub
		//Driver.add(d);
		//System.out.println("Driver D:" + d.GetDriversLicense()+" Accepted:"+ d.Accepted);
		
	}
	
	public void removeObserver(DriverEntity d) {
		// TODO Auto-generated method stub
		//Driver.remove(d);
	}


	@Override
	public void  notifyObserver() 
	{
		/*
		ArrayList<String> FavAreasUpdate= new ArrayList<String>();
		for(int i=0;i<Driver.size();i++)
		{
			FavAreasUpdate=Driver.get(i).favAreas.notifyDriver(this,Driver.get(i));
			Driver.get(i).Notifications.addAll(FavAreasUpdate);
		}
		*/
	}
	
	
}
