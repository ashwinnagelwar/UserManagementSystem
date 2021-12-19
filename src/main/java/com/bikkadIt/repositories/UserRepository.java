package com.bikkadIt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadIt.entities.UserAccount;
@Repository
public interface UserRepository extends JpaRepository<UserAccount, Integer>{

	public UserAccount findByUseremailAndPassword(String user_email,String password);
	
	public UserAccount findByUseremail(String userEmail);
	
}
