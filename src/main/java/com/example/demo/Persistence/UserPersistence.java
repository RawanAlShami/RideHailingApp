package com.example.demo.Persistence;
import java.util.ArrayList;
import com.example.demo.Core.UserEntity;

public class UserPersistence 
{
	//ARRAYLIST
	private static ArrayList<UserEntity> Users = new ArrayList<UserEntity>();
		
	//CRUD 
	public boolean AddUser(UserEntity U)
	{	return Users.add(U);	}
	
	public UserEntity GetUser(int ID)
	{
		for(int i=0;i<Users.size();i++)
		{
			if(Users.get(i).GetID()==ID)
				return Users.get(i);
		}
		return null;
	}
	
	public ArrayList<UserEntity> GetUsers()
	{return Users;}	

}