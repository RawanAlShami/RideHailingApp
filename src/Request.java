import java.util.ArrayList;

public class Request  implements RequestSubject
	{
	protected ArrayList<Trip> PendingTrips = new ArrayList<Trip>();
	
	private ArrayList<Trip> ActiveTrips = new ArrayList<Trip>();
	
	private ArrayList<Trip> TripHistory = new ArrayList<Trip>();
	
	protected ArrayList<Driver> Driver = new ArrayList<Driver>();
	
	
	public void addToPending(Trip T){
		PendingTrips.add(T);
		//notifyObserver();
	}
	
	
	public void PendingToActive(Trip T) {
		try {
		ActiveTrips.add(T);
		PendingTrips.remove(T);
		}catch(Exception e) {
			System.out.println("Trip Not Found!");
		}
	}
	
	
	/*public void DeleteFromPending(Trip T) {
		try {
			PendingTrips.remove(T);
			}catch(Exception e) {
				System.out.println("Trip Not Found!");
			}
	}*/
	
	
	
	public void ActiveToHistory(Trip T) {
		try {
			ActiveTrips.remove(T);
			TripHistory.add(T);
			}catch(Exception e) {
				System.out.println("Trip Not Found!");
			}
	}


	public void addObserver(Driver d) {
		// TODO Auto-generated method stub
		Driver.add(d);
		//System.out.println("Driver D:" + d.GetDriversLicense()+" Accepted:"+ d.Accepted);
		
	}


	public void removeObserver(Driver d) {
		// TODO Auto-generated method stub
		Driver.remove(d);
	}


	@Override
	public void  notifyObserver() {
		ArrayList<String> FavAreasUpdate= new ArrayList<String>();
		for(int i=0;i<Driver.size();i++)
		{
			FavAreasUpdate=Driver.get(i).favAreas.notifyDriver(this,Driver.get(i));
			Driver.get(i).Notifications.addAll(FavAreasUpdate);
		}
	}
	
	public Trip GetTrip(int id) {
		
		for(int i=0;i<PendingTrips.size();i++) {
			if(PendingTrips.get(i).TripId==id)
				return PendingTrips.get(i);
		}
		return null;
	}
}
