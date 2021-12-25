package com.bikkadIt.service;

import java.io.BufferedReader;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;
import com.bikkadIt.bindings.LoginForm;
import com.bikkadIt.bindings.UnlockAccForm;
import com.bikkadIt.bindings.UserForm;
import com.bikkadIt.constants.AppConstant;
import com.bikkadIt.entities.CityMaster;
import com.bikkadIt.entities.CountryMaster;
import com.bikkadIt.entities.StateMaster;
import com.bikkadIt.entities.UserAccount;
import com.bikkadIt.repositories.CityRepository;
import com.bikkadIt.repositories.CountryRepository;
import com.bikkadIt.repositories.StateRepository;
import com.bikkadIt.repositories.UserRepository;
import com.bikkadIt.util.EmailUtil;

@Service
public class UserServiceImpl implements UserServiceI{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private EmailUtil emailUtil;

	@Override
	public Map<Integer, String> getCountries() 
	{
		List<CountryMaster> countryList = countryRepository.findAll();
		
		Map<Integer, String> countryMap=new HashMap<Integer, String>();
		
		countryList.forEach(country-> countryMap.put(country.getCountry_id(), country.getCountry_name()));
		
		return countryMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer country_id) {
		List<StateMaster> stateList = stateRepository.findByCountryId(country_id);
		
		Map<Integer,String> stateMap=new HashMap<Integer, String>();
		
		stateList.forEach(state-> stateMap.put(state.getState_id(), state.getState_name()));
		return stateMap;
	}

	@Override
	public Map<Integer, String> getCities(Integer state_id) {
		List<CityMaster> citiList = cityRepository.findByStateId(state_id);
		
		Map<Integer, String> citiMap=new HashMap<Integer,String>();
		
		citiList.forEach(city->citiMap.put(city.getCity_id(), city.getCity_name()));
		return citiMap;
	}

	@Override
	public boolean emailUnique(String email) 
	{
		UserAccount UserAccount = userRepository.findByUserEmail(email);
		
		if(UserAccount!=null)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public boolean saveUser(UserForm userForm) {
		
		if(userForm.getPassword()==null && userForm.getActive_sw()==null)
		{
		userForm.setActive_sw("N");
		userForm.setPassword(generateTempPwd());
		}
		System.out.println(userForm);
		UserAccount entity=new UserAccount();
		
		BeanUtils.copyProperties(userForm, entity);
		System.out.println(entity);
		UserAccount entity2 = userRepository.save(entity);
		if(entity2.getUser_id()!=null)
		{
			String body=getUserEmailBody(entity2);
			
			String subject=AppConstant.REG_EMAIL_SUBJECT;
			
			emailUtil.sendMail(entity2.getUserEmail(), body, subject);
			return true;
		}
		return false;
	}
	
	private String getUserEmailBody(UserAccount userAccount) 
	{
		StringBuffer sb=new StringBuffer();
		String fileName="User_Email_Body.txt";
		
		List<String> lines = new ArrayList<String>();
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
			lines = br.lines().collect(Collectors.toList());
		} catch (IOException e) {

			e.printStackTrace();
		}
		
			lines.forEach(line->
			{
				if(line.contains("{FNAME}"))
				{
					line.replace("{FNAME}", userAccount.getFirst_name());
				}
				if(line.contains("{LNAME}"))
				{
					line.replace("{LNAME}", userAccount.getLast_name());
				}
				if(line.contains("{TEMP-PWD}"))
				{
					line.replace("{TEMP-PWD}", userAccount.getPassword());
				}
				if(line.contains("{EMAIL}"))
				{
					line.replace("{EMAIL}", userAccount.getUserEmail());
				}
				
				sb.append(line);
				
			});
			System.out.println(sb);
			return sb.toString();
		
	}
	
	private String generateTempPwd()
	{
		String temPwd=RandomStringUtils.randomAlphabetic(6);
		return temPwd;
	}

	@Override
	public boolean isTempPwdValid(String email, String tempPwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unlockAccount(UnlockAccForm unlockAccForm) {
		String email = unlockAccForm.getEmail();
		String tempPwd = unlockAccForm.getTempPwd();
		UserAccount userAccount = userRepository.findByUserEmailAndPassword(email, tempPwd);
		if(userAccount!=null)
		{
			userAccount.setActive_sw("Y");
			userAccount.setPassword(unlockAccForm.getNewPwd());
			userRepository.save(userAccount);
			return true;
		}
		
		return false;
	}

	@Override
	public String forgotPwd(String emailId) {
		UserAccount UserAccount = userRepository.findByUserEmail(emailId);
		if(UserAccount!=null)
		{
			String subject=AppConstant.FORGET_EMAIL_SUBJECT;
			String body=getForgetPwd(UserAccount);
			
			emailUtil.sendMail(emailId, body, subject);
			return AppConstant.SUCCESS;
		}
		return AppConstant.FAILED;
	}
	
	
	private String getForgetPwd(UserAccount userAccount)
	{
		StringBuffer sb=new StringBuffer();
		
		File file=new File("Get_Forget_Password.txt");
		
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader br=new BufferedReader(fr);
		
		List<String> lines=new ArrayList<String>();
		
		lines=br.lines().collect(Collectors.toList());
		lines.forEach(line->{
			if(line.contains("{FNAME}"))
			{
				line.replace("{FNAME}", userAccount.getFirst_name());
			}
			if(line.contains("{LNAME}"))
			{
				line.replace("{LNAME}", userAccount.getLast_name());
			}
			if(line.contains("{PWD}"))
			{
				line.replace("{PWD}", userAccount.getPassword());
			}
			
			sb.append(line);
		});
		
		return sb.toString();
		
	}

	@Override
	public String loginCheck(LoginForm loginForm) {
		
	UserAccount userAccount=userRepository.findByUserEmailAndPassword(loginForm.getUser_email(), loginForm.getPassword());
		
		if(userAccount!=null)
		{
			String active=userAccount.getActive_sw();
			if(active=="Y")
			{
				return "Your account is Locked";
			}
			else
			{
				return "Login Success";
			}
		}
		return "Invalid Credential";
	}

}
