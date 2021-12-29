import java.util.ArrayList;
import java.util.Scanner;

public class DriverInterface 
{
	protected DriverController DriverController=new DriverController();
	protected DriverEntity CurrentDriver; 
	protected OfferController OfferController=new OfferController(); 
	
	
	public void ShowMenu()
	{
		Scanner input=new Scanner(System.in);
		boolean DriverRepeat=true;
		while(DriverRepeat) {
			System.out.println("Driver Menu:");
			System.out.println("1 - Create Account");
			System.out.println("2 - Login");
			System.out.println("3 - Return To Main Menu");
			System.out.println("Choose An Operation: ");
			int DriverMenuChoice=input.nextInt();
			switch(DriverMenuChoice) {
			
			//Create account
			case 1:
			{
				String Username, Password, MobileNumber, Email, NationalId, DriversLiscense;
				System.out.println("Enter Username, Password, Mobile Number, Email, NationalID, DriversLicense (NewLine Separated): ");
				Username=input.next();
				Password=input.next();
				MobileNumber=input.next();
				Email=input.next();
				NationalId=input.next();
				DriversLiscense=input.next();
				DriverController.CreateDriver(Username, Password, MobileNumber, Email, NationalId, DriversLiscense);
				System.out.println("Driver request is pending");
				break;
			}
			//Driver LOGIN
			case 2:{
				String Email, Password;
				boolean logged=true;
				boolean log=true;
				while(log) {
				
					System.out.println("Please Provide Your Email And Password (NewLine Separated): ");
					Email=input.next();
					Password=input.next();
					
					CurrentDriver=DriverController.LogIn(Email, Password);
					if(CurrentDriver==null)
					{
						System.out.println("Driver Is Either Pending Or Not Found");
						log=false;
						logged=false;
						continue;
					}
					else
					{
						log=false;
						logged=true;
						System.out.println("Logged In Successfully");
					}	
				}
				
				
				try {
				while(logged)
				{
					System.out.println("1 - View Notifications");
					System.out.println("2 - Add Favorite Area");
					System.out.println("3 - View Favorite areas ");
					System.out.println("4 - View Favorite Area Trip Requests");
					System.out.println("5 - View All Trip Requests");
					System.out.println("6-  Suggest A New Price");
					System.out.println("7 - logout");
					System.out.println("Choose An Operation: ");
					int LoggedChoice=input.nextInt();
					
					switch(LoggedChoice) {
						
						case 1:
						{	
							
							System.out.println("Pending Requests In Drivers Favorite areas:");
							ArrayList<TripEntity> PendingFavAreaTrips=DriverController.GetPendingFavAreaTrips(CurrentDriver);
							for(int i=0;i<PendingFavAreaTrips.size();i++)
							{
								System.out.println("ID:"+PendingFavAreaTrips.get(i).GetTripID()+
								"  Source:"+PendingFavAreaTrips.get(i).GetSource()+
								"  Destination:"+PendingFavAreaTrips.get(i).GetDestination()+
								"  Price:"+PendingFavAreaTrips.get(i).GetPrice());
							}
						
							break;
						}
						
						//Add Favorite Area
						case 2:{
							System.out.println("Please enter favorite source: ");
							String src=input.next();
							CurrentDriver.FavAreas.addFavArea(src);
							break;
							
						}
						// View favorite areas
						case 3:{
							ArrayList<String> FavAreas=CurrentDriver.FavAreas.GetFavAreas();
							System.out.println("Favorite Areas:");
							for (int i=0;i<FavAreas.size();i++) {
								System.out.println(FavAreas.get(i));
							}
							break;
						}
						//View Pending favorite area trips
						case 4:{
								
								System.out.println("Pending Requests In Drivers Favorite areas:");
								ArrayList<TripEntity> PendingFavAreaTrips=DriverController.GetPendingFavAreaTrips(CurrentDriver);
								for(int i=0;i<PendingFavAreaTrips.size();i++)
								{
									System.out.println("ID:"+PendingFavAreaTrips.get(i).GetTripID()+
									"  Source:"+PendingFavAreaTrips.get(i).GetSource()+
									"  Destination:"+PendingFavAreaTrips.get(i).GetDestination()+
									"  Price:"+PendingFavAreaTrips.get(i).GetPrice());
								}
							
							break;
						}
						//View All Trip Requests
						case 5:{
							System.out.println("All Trip Requests:");
							ArrayList<TripEntity> PendingTrips=DriverController.RequestModel.GetPendingTrips();
							for(int i=0;i<PendingTrips.size();i++)
							{
								System.out.println("ID:"+PendingTrips.get(i).GetTripID()+
								"  Source:"+PendingTrips.get(i).GetSource()+
								"  Destination:"+PendingTrips.get(i).GetDestination());
							}
							break;
						}
						//Driver suggest new price
						case 6:{
							System.out.println("Please Suggest A New Price And Trips ID (NextLine Separated)");
							double NewPrice=input.nextDouble();
							int TripId=input.nextInt();
							boolean TripIdFound;
							TripIdFound=OfferController.OfferNewPrice(NewPrice, TripId, CurrentDriver);
							if(TripIdFound)
								System.out.println("Offer Updated");
							else
								System.out.println("Trip ID not found");
							break;
						}
						//Driver LogOut
						case 7:{
							CurrentDriver.LoggedIn=false;
							logged=false;
							break;
						}
					}
				}
				}
				catch(Exception e) {
					System.out.println("");
				}
				
				
			
				break;
			}
			//Return to main menu
			case 3:{
				DriverRepeat=false;
				break;
			}
			}
			
		}
	}
}
