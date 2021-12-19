package com.bikkadIt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadIt.bindings.LoginForm;
import com.bikkadIt.service.UserServiceI;
import com.bikkadIt.service.UserServiceImpl;

@RestController
public class UserLoginController {
	
	@Autowired
	private UserServiceI userServiceImpl;
	
	@PostMapping("/loginCheck")
	public ResponseEntity<String> logInCheck(@RequestBody LoginForm loginForm)
	{
		String msg=userServiceImpl.loginCheck(loginForm);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	

}
