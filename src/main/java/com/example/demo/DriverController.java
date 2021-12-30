package com.example.demo;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.application.IUserService;
import com.example.demo.application.IDriverService;
import com.example.demo.application.UserService;
import com.example.demo.Core.DriverEntity;
import com.example.demo.Core.UserEntity;
import com.example.demo.application.DriverService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;

@RestController
public class DriverController {
	protected DriverService DriverService;
	
	public DriverController()
	{	DriverService=new DriverService();	}

    @PostMapping("/CreateDriver")
	public String CreateDriver(@RequestBody DriverEntity Driver)
	{	
		if(DriverService.CreateDriver(Driver))
			return "Driver Created Successfully";
		else
			return "Failed To Create New Driver";
	}
    
    @GetMapping("/DriverLogIn/{email}/{password}")
	public DriverEntity LogIn(@PathVariable String email,@PathVariable String password)
	{	return DriverService.LogIn(email, password);	}
    
    
    @GetMapping("/GetDriver/{id}")
	public DriverEntity GetDriver(@PathVariable int id)
	{	return DriverService.GetDriver(id);	}
    
    @GetMapping("/DriverLogOut")
	public String LogOut() {
		return DriverService.LogOut();
	}
    
    
    
    
    
    
}