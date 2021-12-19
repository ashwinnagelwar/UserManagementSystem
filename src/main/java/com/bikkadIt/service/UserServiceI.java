package com.bikkadIt.service;

import java.util.Map;

import com.bikkadIt.bindings.LoginForm;
import com.bikkadIt.bindings.UnlockAccForm;
import com.bikkadIt.bindings.UserForm;
import com.bikkadIt.entities.UserAccount;

public interface UserServiceI {
	
	public Map<Integer, String> getCountries();

	public Map<Integer, String> getStates(Integer country_id);

	public Map<Integer, String> getCities(Integer state_id);

	public boolean emailUnique(String email);

	public boolean saveUser(UserForm userForm);

	public boolean isTempPwdValid(String email, String tempPwd);

	public boolean unlockAccount(UnlockAccForm unlockAccForm);

	public String forgotPwd(String emailId);
	
	public String loginCheck(LoginForm loginForm);
}
