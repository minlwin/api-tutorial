package com.solt.location.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solt.location.model.entity.District;
import com.solt.location.model.repo.DistrictRepo;

@RestController
@RequestMapping("districts")
public class DistrictApi {

	@Autowired
	private DistrictRepo repo;
	
	@GetMapping
	private List<District> findAll(){
		return repo.findAll();
	}
	@GetMapping("divisions/{id}")
	private List<District> findByDivisionId(@PathVariable int id) {
		return repo.findByDivisionId(id);
	}
	
	@GetMapping("{id:\\d+}")
	private District findById(@PathVariable int id) {
		return repo.findById(id).orElseThrow();
	}
	
	@PostMapping
	private District create (@RequestBody District d) {
		return repo.save(d);
	}
	
	@PutMapping
	private District save (@RequestBody District d) {
		return repo.save(d);
	}
	
}
