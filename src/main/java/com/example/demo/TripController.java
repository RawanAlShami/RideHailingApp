package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.application.TripService;

@RestController
public class TripController 
{
	protected TripService TripService=new TripService();
	
	@GetMapping("/CalculateTripsETA/{TripId}")
	public String CalculateDistanceAndETA(@PathVariable int TripId)
	{return TripService.CalculateDistance(TripId);}
}