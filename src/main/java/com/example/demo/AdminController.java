package com.example.demo;


import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Core.AdminEntity;
import com.example.demo.Core.DriverEntity;
import com.example.demo.application.AdminService;

@RestController
public class AdminController 
{
	protected AdminService AdminService;
	
	public AdminController()
	{	AdminService=new AdminService();	}
	
	@PostMapping("/CreateAdmin")
	public String CreateAdmin(@RequestBody AdminEntity Admin)
	{	
		if(AdminService.CreateAdmin(Admin))
			return "Admin Created Successfully";
		else
			return "Failed To Create New Admin";
	}
	
	@GetMapping("/GetAdmin")
	public AdminEntity GetAdmin()
	{	return AdminService.GetAdmin();	}
	
	@GetMapping("/AdminLogIn/{email}/{password}")
	public AdminEntity LogIn(@PathVariable String email,@PathVariable String password)
	{	return AdminService.LogIn(email, password);	}
	
	@GetMapping("/AdminLogOut")
	public String LogOut() {
		AdminEntity Administrator=AdminService.GetAdmin();
		return AdminService.LogOut(Administrator);
	}
	
	@GetMapping("/ViewPendingDriverRequests")
	public ArrayList<DriverEntity> ViewPendingDriverRequests()
	{
		return AdminService.ViewPendingDriversRequests();
	}
	
	@GetMapping("/VerifyDriversRegistration/{nationalId}")
	public String VerifyDriversRegistration(@PathVariable String nationalId)
	{
		if(AdminService.VerifyDriversRegistration(nationalId))
			return "Driver Is Verified";
		else 
			return "Driver Is Not Found"; 
	}
	
	@GetMapping("/ViewAcceptedDrivers")
	public ArrayList<DriverEntity> ViewAcceptedDrivers()
	{
		return AdminService.ViewAcceptedDrivers(); 
	}
	
}
