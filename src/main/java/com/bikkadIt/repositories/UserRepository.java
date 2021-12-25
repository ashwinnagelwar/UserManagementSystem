package com.bikkadIt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadIt.entities.UserAccount;
@Repository
public interface UserRepository extends JpaRepository<UserAccount, Integer>{

	public UserAccount findByUserEmailAndPassword(String userEmail,String password);
	
	public UserAccount findByUserEmail(String userEmail);
	
}
