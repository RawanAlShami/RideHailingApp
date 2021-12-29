//ABSTRACT CLASS TO ENCAPSULATE ALL ACCOUNTS
public abstract class Accounts
{
	//MEMBER VARIABLES
	protected String Username;
	protected String Password;
	protected int UserID;
	protected int UserIdCounter=0;
	protected String Email;
	protected String MobileNo;
	protected boolean LoggedIn=false;
	
	//SUPER CONSTRUCTOR
	public Accounts(String UName, String Pass,String MobNo, String Mail)
	{
		Username=UName;
		Password=Pass;
		MobileNo=MobNo;
		Email=Mail;
		UserID=UserIdCounter++;
	}
	
	//LOGIN FUNCTION
	public void Login(String Mail, String Pass) 
	{
		if(Mail.equals(Email) && Pass.equals(Password))
			LoggedIn=true;
	}

}
