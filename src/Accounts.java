public abstract class Accounts 
{
	protected String Username;
	protected String Password;
	protected int UserID;
	protected int UserIdCounter=0;
	protected String Email;
	protected String MobileNo;
	protected boolean LoggedIn=false;
	
	public Accounts(String UName, String Pass,String MobNo, String Mail)
	{
		Username=UName;
		Password=Pass;
		MobileNo=MobNo;
		Email=Mail;
		UserID=UserIdCounter++;
	}

	public void Login(String Mail, String Pass) 
	{
		if(Mail==Email && Pass==Password)
		{
			System.out.println("User / Admin Logged In Successfully");
			LoggedIn=true;
		}
		else
		{
			System.out.println("Logged In Unsucessful. Please Ensure That Your Credidentials Are Correct");
			LoggedIn=false;
		}
	}
}
