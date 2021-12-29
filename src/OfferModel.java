import java.util.ArrayList;

public class OfferModel {
		
		protected static ArrayList<TripEntity>  AllOffers=new ArrayList<TripEntity>();
		
		public void AddToAllOffers(TripEntity TripEntity)
		{AllOffers.add(TripEntity);}
		
		public void RemoveFromAllOffers(TripEntity TripEntity)
		{
			AllOffers.remove(TripEntity);
			AllOffers.trimToSize();
		}
		
		public ArrayList<TripEntity> GetAllOffers()
		{return AllOffers;}
}
