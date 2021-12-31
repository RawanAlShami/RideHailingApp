package com.example.demo.Persistence;
import java.util.ArrayList;

import com.example.demo.Core.TripEntity;

public class OfferPersistence 
{
	//ARRAYLIST
	protected static ArrayList<TripEntity>  AllOffers=new ArrayList<TripEntity>();
		
	//CRUD
	public void AddToAllOffers(TripEntity TripEntity)
	{ AllOffers.add(TripEntity); }
		
	public void RemoveFromAllOffers(int id)
	{
		for(int i=0;i<AllOffers.size();i++)
		{
			if(AllOffers.get(i).getTripId()==id)
			{
				AllOffers.remove(i);
			}
		}
		AllOffers.trimToSize();
	}
		
	public ArrayList<TripEntity> GetAllOffers()
	{ return AllOffers; }
}
