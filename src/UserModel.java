import java.util.ArrayList;

public class UserModel 
{
	//ARRAY OF USERS
	private ArrayList<UserEntity> Users = new ArrayList<UserEntity>();
	//private ArrayList<TripEntity> TripHistory=new ArrayList<TripEntity>();
	
	//CRUD 
	public void AddUser(UserEntity U)
	{Users.add(U);}
	
	public ArrayList<UserEntity> GetUsers()
	{return Users;}
	
	/*public void AddToTripHistory(TripEntity T)
	{TripHistory.add(T);}
	
	public ArrayList<TripEntity> GetTripHistory()
	{return TripHistory;}*/
	
}
