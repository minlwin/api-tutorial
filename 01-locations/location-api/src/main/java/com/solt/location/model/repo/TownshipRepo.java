package com.solt.location.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solt.location.model.entity.Township;

public interface TownshipRepo extends JpaRepository<Township, Integer> {

	
	List<Township> findByDistrictId(int id);
}
