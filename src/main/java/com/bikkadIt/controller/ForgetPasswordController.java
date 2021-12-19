package com.bikkadIt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadIt.service.UserServiceI;
import com.bikkadIt.service.UserServiceImpl;

@RestController
public class ForgetPasswordController {
	
	@Autowired
	private UserServiceI userServiceImpl;
	
	@GetMapping("/forgetpassword/{email}")
	public ResponseEntity<String> forgetpassword(@PathVariable String email)
	{
		String forgotPwd = userServiceImpl.forgotPwd(email);
		if(forgotPwd!=null)
		{
			return new ResponseEntity<String>(forgotPwd,HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<String>(forgotPwd,HttpStatus.NOT_FOUND);
		}
		
	}

}
