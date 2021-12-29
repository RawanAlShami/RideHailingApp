	import java.util.ArrayList;
	
	public class UserController 
	{	
		
		RequestModel RequestModel=new RequestModel();
		DriverModel DriverModel=new DriverModel();
		protected OfferModel OfferModel=new OfferModel();
		//USER MODEL OBJECT 
		UserModel UserModel=new UserModel();
		
		public void RegisterAsDriver(String NId, String DLicense,UserEntity UserEntity) 
		{
			DriverEntity DriverEntity =new DriverEntity(UserEntity.Username, UserEntity.Password,UserEntity.MobileNo,UserEntity.Email,NId,DLicense);
			DriverModel.AddToPending(DriverEntity);
		}
		
		//CREATES USER
		public void CreateUser(String UName, String Pass, String MobNo, String Mail)
		{
			UserEntity U=new UserEntity(UName,Pass,MobNo,Mail);
			UserModel.AddUser(U);
		}
		
		//FINDS USER AND LOGS THEM IN
		public UserEntity LogIn(String Email, String Password)
		{
			ArrayList<UserEntity> AllUsers=UserModel.GetUsers();
			
			for(int i=0; i<AllUsers.size(); i++)
			{
				AllUsers.get(i).Login(Email, Password);
				if(AllUsers.get(i).LoggedIn)
					return AllUsers.get(i);
			}
			//CHECKS IN INTERFACE IF NULL-> USER NOT FOUND. REENTER EMAIL AND PASSWORD
			return null;
		}
		
		public void LogOut(UserEntity User)
		{
			User.LoggedIn=false;
		}
		
		
		 TripEntity CreateTrip(String Src,String Dest,UserEntity CurrentUser)
		{
			TripEntity Trip=new TripEntity(Src,Dest);
			Trip.SetUser(CurrentUser);
			RequestModel.addToPending(Trip);
			return Trip;
		}
		 
		 public ArrayList<TripEntity> GetOffer(UserEntity UserEntity)
		 {
			 ArrayList<TripEntity> Offer=new ArrayList<TripEntity>();
			 ArrayList<TripEntity> DriverOffers=OfferModel.GetAllOffers();
			 for(int i=0;i<DriverOffers.size();i++)
			 {
				 if(DriverOffers.get(i).GetUser().UserID==UserEntity.UserID)
				 {
					 Offer.add(DriverOffers.get(i));
				 }
			 }
			 if(Offer.isEmpty())
					Offer.add(null);
			 
			 return Offer;
		 }
	}
