package com.example.demo.Persistence;

import java.util.ArrayList;

public class FavAreasPersistence 
{
	//ARRAYLIST
	protected ArrayList<String> favSrc= new ArrayList<String>();
	
	//CRUD
	public boolean addFavArea(String src) 
	{ return favSrc.add(src); }
	
	public ArrayList<String> GetFavAreasModel()
	{ return favSrc; }
}

