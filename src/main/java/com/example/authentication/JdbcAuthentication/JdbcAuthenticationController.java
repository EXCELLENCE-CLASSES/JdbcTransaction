package com.example.authentication.JdbcAuthentication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcAuthenticationController {
	
	
	
	@RequestMapping("/")
	public String everyoneAccess() 
	{
		return ("<h1>Welcome People</h1>");
		
	}
	
	@RequestMapping("/User")
	public String UserAndAdminAccess() 
	{
		return ("<h1>Welcome User And Admin</h1>");
		
	}
	@RequestMapping("/Admin")
	public String AdminAccess() 
	{
		return ("<h1>Welcome Admin</h1>");
		
	}
	
	
	

}
