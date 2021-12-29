		
		import java.util.ArrayList;
		import java.util.Scanner;
		
		public class FavAreasModel {
			protected ArrayList<String> favSrc= new ArrayList<String>();
			
			
			
			public void addFavArea(String src) 
			{favSrc.add(src);}
			
			public ArrayList<String> GetFavAreas()
			{return favSrc;}
		}
