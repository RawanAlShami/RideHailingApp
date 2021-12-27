public class AdminEntity extends Accounts
{
	//ADMIN CONTROLLER OBJECT
	protected AdminController AdminController=new AdminController();
	
	//CONSTRUCTOR
	public AdminEntity(String UName, String Pass, String MobNo, String Mail) 
	{
		super(UName, Pass, MobNo, Mail);
		System.out.println("Account Created Successfully");
		
	}
}
