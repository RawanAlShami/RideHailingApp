package com.example.demo;

import java.util.ArrayList;
import com.example.demo.Core.TripEntity;
import com.example.demo.Core.UserEntity;
import com.example.demo.application.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController 
{
	//SERVICES
	protected UserService UserService;
	
	public UserController()
	{	UserService=new UserService();	}
    
	@PostMapping("/CreateUser")
	public String CreateUser(@RequestBody UserEntity User)
	{	
		if(UserService.CreateUser(User))
			return "User Created Successfully";
		else
			return "Failed To Create New User";
	}
	
	@GetMapping("/GetUser/{id}")
	public UserEntity GetUser(@PathVariable int id)
	{	return UserService.GetUser(id);	}
	
	@GetMapping("/GetUsersModel")
	public ArrayList<UserEntity> GetUsersModel()
	{	return UserService.GetUsersModel();	}
	
	@GetMapping("/UserLogIn/{email}/{password}")
	public UserEntity LogIn(@PathVariable String email,@PathVariable String password)
	{	return UserService.LogIn(email, password);	}
	
	@GetMapping("/UserLogOut")
	public String LogOut() 
	{	return UserService.LogOut();	}
	
	@GetMapping("/CreateTrip/{Src}/{Dest}")
	public TripEntity CreateTrip(@PathVariable String Src,@PathVariable String Dest)
	{	return UserService.CreateTrip(Src, Dest);	}
	
	@GetMapping("/GetOffers")
	public ArrayList<TripEntity> GetOffers()
	{	return UserService.GetOffers();	}
	
	@GetMapping("/AcceptOffer/{TripId}/{price}/{drivername}")
	public String AcceptOffer(@PathVariable int TripId,@PathVariable double price,@PathVariable String drivername)
	{
		if(UserService.AcceptOffer(TripId, price, drivername))
		{
			return "Offer Accepted & Driver Nodified";
		}
		else
			return "Offer Not Found";
	}
	
	@GetMapping("/ViewTripHistory")
	public ArrayList<TripEntity> ViewTripHistory()
	{return UserService.ViewTripHistory();}
	
	
	@GetMapping("/RateTrip/{TripId}/{rating}")
	public String RateTrip(@PathVariable int TripId,@PathVariable int rating)
	{
		if(UserService.RateTrip(TripId, rating))
			return "Trip Rated Successfully";
		else
			return "Failed To Rate Trip";
	}
	
	@GetMapping("/RegisterAsDriver/{NId}/{DLicense}")
	public String RegisterAsDriver(@PathVariable String NId,@PathVariable String DLicense)
	{
		if(UserService.RegisterAsDriver(NId, DLicense))
			return "Driver Account Created, Request Is Pending";
		else
			return "Could Not Create Driver Account";
	}

}