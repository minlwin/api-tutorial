package com.solt.location.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solt.location.model.entity.District;
import com.solt.location.model.entity.Division;

public interface DistrictRepo extends JpaRepository<District, Integer> {
	
	List<District> findByDivisionId(int id);

	District findOneByDivisionAndName(Division division, String name);
	
}
