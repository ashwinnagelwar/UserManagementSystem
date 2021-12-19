package com.bikkadIt.repositories;

import java.util.List;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadIt.entities.StateMaster;
@Repository
public interface StateRepository extends JpaRepository<StateMaster, Integer>{

	public List<StateMaster> findByCountryId(Integer countryId);
}
