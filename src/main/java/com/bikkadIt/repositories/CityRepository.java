package com.bikkadIt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadIt.entities.CityMaster;
@Repository
public interface CityRepository extends JpaRepository<CityMaster, Integer>{

}
