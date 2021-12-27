import java.util.ArrayList;

public class UserController 
{
	//USER MODEL OBJECT 
	UserModel UserModel=new UserModel();
	
	
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
	
	/*
	public TripEntity CreateTrip(String Src,String Dest)
	{
		UserTrip=new TripEntity(Src,Dest);
		UserTrip.SetUser(this);
		TripHistory.add(UserTrip);
		return UserTrip;
	}
	
	public DriverEntity RegisterAsDriver(String NId, String DLicense, Admin A) 
	{
		DriverEntity D =new DriverEntity(Username, Password,MobileNo,Email,NId,DLicense, A);
		return D;
	}
	public void driverOfferUpdate(double p) 
	{
		UserTrip.Price=p;
		System.out.println("User Notified");
	}
	
	public TripEntity geTrip() 
	{return UserTrip;}
	*/
}
