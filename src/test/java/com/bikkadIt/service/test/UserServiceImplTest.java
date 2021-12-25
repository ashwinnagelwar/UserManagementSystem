package com.bikkadIt.service.test;

import static org.mockito.Mockito.RETURNS_MOCKS;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;

import com.bikkadIt.entities.CountryMaster;
import com.bikkadIt.repositories.CityRepository;
import com.bikkadIt.repositories.CountryRepository;
import com.bikkadIt.repositories.StateRepository;
import com.bikkadIt.repositories.UserRepository;
import com.bikkadIt.service.UserServiceI;

public class UserServiceImplTest {
	
	@Autowired
	private UserServiceI userServiceI;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
//	@Autowired
//	private CountryMaster countryMaster;
	
	public void getCountriesTest()
	{
		CountryMaster countryMaster1=new CountryMaster();
		countryMaster1.setCountry_id(1);
		countryMaster1.setCountry_name("India");
		countryMaster1.setCountry_code(11);
		
		CountryMaster countryMaster2=new CountryMaster();
		countryMaster2.setCountry_id(2);
		countryMaster2.setCountry_name("America");
		countryMaster2.setCountry_code(12);
		
		List<CountryMaster> list=new ArrayList<CountryMaster>();
		list.add(countryMaster1);
		list.add(countryMaster2);
		
		Map<Integer,String> countries=new HashMap<Integer,String>();
		countries.put(countryMaster1.getCountry_id(),countryMaster1.getCountry_name());
		countries.put(countryMaster2.getCountry_id(),countryMaster2.getCountry_name());
		
		when(countryRepository.findAll()).thenReturn(list);

		userServiceI.getCountries();
		
		
	}

private Object When(OngoingStubbing<List<CountryMaster>> thenReturn) {
	// TODO Auto-generated method stub
	return null;
}
	

}
