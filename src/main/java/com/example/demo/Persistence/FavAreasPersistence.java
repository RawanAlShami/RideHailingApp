package com.example.demo.Persistence;

import java.util.ArrayList;

public class FavAreasPersistence {
	protected ArrayList<String> favSrc= new ArrayList<String>();
	
	
	
	public void addFavArea(String src) 
	{favSrc.add(src);}
	
	public ArrayList<String> GetFavAreas()
	{return favSrc;}
}

