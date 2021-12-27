import java.util.ArrayList;

public class UserModel 
{
	//ARRAY OF USERS
	private ArrayList<UserEntity> Users = new ArrayList<UserEntity>();
	
	//CRUD 
	public void AddUser(UserEntity U)
	{Users.add(U);}
	
	public ArrayList<UserEntity> GetUsers()
	{return Users;}
	
}
