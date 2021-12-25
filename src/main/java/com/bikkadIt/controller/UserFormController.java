package com.bikkadIt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadIt.bindings.UserForm;
import com.bikkadIt.constants.AppConstant;
import com.bikkadIt.entities.UserAccount;
import com.bikkadIt.service.UserServiceI;
import com.bikkadIt.service.UserServiceImpl;

@RestController
public class UserFormController {
	
	@Autowired
	private UserServiceI userServiceImpl;
	
	@PostMapping("/signUp")
	public ResponseEntity<String> signUp(@RequestBody UserForm userForm)
	{
		String msg="";
		boolean saveUser = userServiceImpl.saveUser(userForm);
		if(saveUser)
		{
			msg=AppConstant.SUCCESS;
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		msg=AppConstant.FAILED;
		return new ResponseEntity<String>(msg,HttpStatus.BAD_GATEWAY);
	}
	
	@GetMapping("/getCountries")
	public ResponseEntity<Map<Integer, String>> getCountries()
	{
	    Map<Integer,String> countries = userServiceImpl.getCountries();
	    return new ResponseEntity<Map<Integer,String>>(countries,HttpStatus.FOUND);
	}
	
	@GetMapping("/getState/{countryId}")
	public ResponseEntity<Map<Integer, String>> getState(@PathVariable Integer countryId)
	{
		Map<Integer,String> states = userServiceImpl.getStates(countryId);
		return new ResponseEntity<Map<Integer,String>>(states,HttpStatus.FOUND);
	}
	
	@GetMapping("/getCity/{stateId}")
	public ResponseEntity<Map<Integer, String>> getCity(@PathVariable Integer stateId)
	{
		Map<Integer,String> cities = userServiceImpl.getCities(stateId);
		return new ResponseEntity<Map<Integer,String>>(cities,HttpStatus.FOUND);
	}
	
	@GetMapping("/checkEmail/{email}")
	public ResponseEntity<String> emailCheck(@PathVariable String email)
	{
		String msg="";
		boolean emailUnique = userServiceImpl.emailUnique(email);
		if(emailUnique==true)
		{
			msg=AppConstant.UNIQUE;
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		else
		{
		msg=AppConstant.DUPLICATE;
		return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
	}

}
