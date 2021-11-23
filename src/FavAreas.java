import java.util.ArrayList;
import java.util.Scanner;

public class FavAreas {
	protected ArrayList<String> favSrc= new ArrayList<String>();
	
	
	
	public void addFavArea(String src) {favSrc.add(src);}
	
	
	public void ViewFavArea(){
		System.out.println("Favorite areas: ");
		for(int i=0;i<favSrc.size();i++)
		{
			System.out.println(favSrc.get(i));
		}
		
	}
	
	public ArrayList<String>  notifyDriver(Request r,Driver d) {
		//System.out.println("Pending Requests In Drivers Favorite areas:");
		ArrayList<String> Notifications = new ArrayList<String>();
		try {
		for(int i=0;i<r.PendingTrips.size();i++)
		{
			
			for(int j=0;j<d.favAreas.favSrc.size();j++)
			{
				if(r.PendingTrips.get(i).Source.contains(d.favAreas.favSrc.get(j)))
				{
					System.out.println("Trip ID:" + r.PendingTrips.get(i).TripId + "    Source:"+ 
					r.PendingTrips.get(i).Source + "   Destination:"+ r.PendingTrips.get(i).Destination
					+"   Price:"+ r.PendingTrips.get(i).Price);
					String AddNotifiction= "Trip ID:" + r.PendingTrips.get(i).TripId + "    Source:"+ 
						r.PendingTrips.get(i).Source + "   Destination:"+ r.PendingTrips.get(i).Destination
						+"   Price:"+ r.PendingTrips.get(i).Price;
					Notifications.add(AddNotifiction);
					
					//System.out.println("Drivers Notified");
				}
			}
		}
		
		}catch(Exception e) {
			System.out.println("FavAreaClass");
		}
		return Notifications;
	}



}

