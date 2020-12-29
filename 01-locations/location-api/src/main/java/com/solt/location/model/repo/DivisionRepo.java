package com.solt.location.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solt.location.model.entity.Division;

public interface DivisionRepo extends JpaRepository<Division, Integer> {

	Division findOneByName(String name);

}
