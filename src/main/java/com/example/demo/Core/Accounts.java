package com.example.demo.Core;

//ABSTRACT CLASS TO ENCAPSULATE ALL ACCOUNTS
public abstract class Accounts
{
	//MEMBER VARIABLES
	protected String Username;
	protected String Password;
	protected int UserID;
	protected String Email;
	protected String MobileNo;
	protected boolean LoggedIn=false;
	protected static int UserIdCounter=0;
	
	//DEFAULT CONSTRUCTOR
	public Accounts() 
	{
		UserID=UserIdCounter++;
	}
	
	//SUPER CONSTRUCTOR
	public Accounts(String UName, String Pass,String MobNo, String Mail)
	{
		Username=UName;
		Password=Pass;
		MobileNo=MobNo;
		Email=Mail;
	}
	
	//SETTERS AND GETTERS
	public int GetID()
	{ return UserID; }
	
	public void setId(int userId)
	{ UserID=userId; }
	
	public String getUsername() 
	{ return Username; }

	public void setUsername(String username)
	{ Username = username; }

	public String getPassword() 
	{ return Password; }

	public void setPassword(String password) 
	{ Password = password; }

	public int getUserID() 
	{ return UserID; }

	public String getEmail() 
	{ return Email;	}

	public void setEmail(String email) 
	{ Email = email; }

	public String getMobileNo() 
	{ return MobileNo; }

	public void setMobileNo(String mobileNo) 
	{ MobileNo = mobileNo; }

	public boolean isLoggedIn() 
	{ return LoggedIn; }

	public void setLoggedIn(boolean loggedIn) 
	{ LoggedIn = loggedIn; }

	//LOGIN FUNCTION
	public void Login(String email, String password) 
	{
		if(email.equals(Email) && password.equals(Password))
			LoggedIn=true;
	}
}