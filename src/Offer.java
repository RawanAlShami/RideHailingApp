public class Offer {
	protected boolean OfferStatus;
	Trip t;
	
	public Trip OfferNewPrice(Trip T,double Price)
	{
		t=T;
		
		t.Price=Price;
		NotifyUserOffer(Price);
		
		return T;		
	}
	public void NotifyUserOffer(double p) {
		t.GetUser().driverOfferUpdate(p);
	}
}
