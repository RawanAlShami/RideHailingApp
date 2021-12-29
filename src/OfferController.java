import java.util.ArrayList;

public class OfferController {
		protected RequestModel RequestModel=new RequestModel();
		protected OfferModel OfferModel=new OfferModel();
		
		public boolean OfferNewPrice(double Price, int TripId, DriverEntity DriverEntity)
		{
			TripEntity NewOffer=new TripEntity(); 
			ArrayList<TripEntity> PendingTrips=RequestModel.GetPendingTrips();
			for(int i=0;i<PendingTrips.size();i++) {
				if(PendingTrips.get(i).TripId==TripId)
				{
					NewOffer.Source=PendingTrips.get(i).GetSource();
					NewOffer.Destination=PendingTrips.get(i).GetDestination();
					NewOffer.Status=PendingTrips.get(i).Status;
					NewOffer.SetDriver(DriverEntity);
					NewOffer.SetUser(PendingTrips.get(i).GetUser());
					NewOffer.TripId=PendingTrips.get(i).GetTripID();
					NewOffer.SetPrice(Price);
					OfferModel.AddToAllOffers(NewOffer);
					return true;
				}
			}
			return false;
			
		}
}
