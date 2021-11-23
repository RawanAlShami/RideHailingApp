import java.util.ArrayList;

public class FavAreas {
	protected ArrayList<Trip> favAreas= new ArrayList<Trip>();
	public void addFavArea(Trip T) {favAreas.add(T);}
	public ArrayList<Trip> getFavArea(){return favAreas;}
}
