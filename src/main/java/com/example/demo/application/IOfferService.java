package com.example.demo.application;

import com.example.demo.Core.DriverEntity;

public interface IOfferService 
{
	boolean OfferNewPrice(double Price, int TripId, DriverEntity DriverEntity);
}
