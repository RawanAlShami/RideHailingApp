package com.example.demo.Persistence;

import java.util.ArrayList;

public class FavAreasPersistence {
	protected ArrayList<String> favSrc= new ArrayList<String>();
	
	
	
	public boolean addFavArea(String src) 
	{return favSrc.add(src);}
	
	public ArrayList<String> GetFavAreasModel()
	{return favSrc;}
}

