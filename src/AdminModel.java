import java.util.ArrayList;

public class AdminModel 
{
	protected ArrayList<AdminEntity> Admins = new ArrayList<AdminEntity>();

	
	public AdminEntity GetAdmin()
	{
		if(Admins.isEmpty())
			Admins.add(null);
			
		return Admins.get(0);
	}
	
	public void SetAdmin(AdminEntity Admin)
	{Admins.add(Admin);}
}
