	import java.util.ArrayList;
	
	public class DriverController 
	{
		protected RequestModel RequestModel=new RequestModel();
		protected DriverModel DriverModel=new DriverModel();
		
		
		public ArrayList<TripEntity>  GetPendingFavAreaTrips(DriverEntity DriverEntity) {
		ArrayList<TripEntity> Notifications = new ArrayList<TripEntity>();
		ArrayList<TripEntity> PendingTrips=RequestModel.GetPendingTrips();
		for(int i=0;i<PendingTrips.size();i++)
		{
				
			for(int j=0;j<DriverEntity.FavAreas.favSrc.size();j++)
			{
				if(PendingTrips.get(i).Source.contains(DriverEntity.FavAreas.favSrc.get(j)))
				{
					Notifications.add(PendingTrips.get(i));
				}
			}
		}
		return Notifications;
		}
		
		
		public void CreateDriver(String UName, String Pass, String MobNo, String Mail,  String NatId, String DLicense)
		{
			DriverEntity DriverEntity=new DriverEntity(UName, Pass, MobNo, Mail, NatId, DLicense);
			DriverModel.AddToPending(DriverEntity);
		}
		
		public DriverEntity LogIn(String Email, String Password) 
		{
			ArrayList<DriverEntity> AllUsers=DriverModel.GetDrivers();
			
			for(int i=0; i<AllUsers.size(); i++)
			{
				AllUsers.get(i).Login(Email, Password);
				if(AllUsers.get(i).LoggedIn)
					return AllUsers.get(i);
			}
			//CHECKS IN INTERFACE IF NULL-> USER NOT FOUND. REENTER EMAIL AND PASSWORD
			return null;
		}
	}