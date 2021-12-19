package com.bikkadIt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadIt.bindings.UnlockAccForm;
import com.bikkadIt.bindings.UserForm;
import com.bikkadIt.service.UserServiceI;

@RestController
public class UnlockFormController {
	
	@Autowired
	private UserServiceI userServiceI;
	
	@GetMapping("/unlockAccount")
	public ResponseEntity<String> unlockAccount(UnlockAccForm unlockAccForm)
	{
		String msg="";
		boolean unlockAccount = userServiceI.unlockAccount(unlockAccForm);
		if(unlockAccount)
		{
			msg="Account unlocked successfully";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		
		msg="failed to unlock your account";
		return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
	}

}
