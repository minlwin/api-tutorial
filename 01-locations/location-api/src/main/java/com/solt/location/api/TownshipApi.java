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

import com.solt.location.model.entity.Township;
import com.solt.location.model.repo.TownshipRepo;

@RestController
@RequestMapping("townships")
public class TownshipApi {
	
	@Autowired
	private TownshipRepo repo;

	@GetMapping
	private List<Township> findAll(){
		return repo.findAll();
	}
	@GetMapping("districts/{id}")
	private List<Township> findByDistrictId(@PathVariable int id) {
		return repo.findByDistrictId(id);
	}
	
	@GetMapping("{id:\\d+}")
	private Township findById(@PathVariable int id) {
		return repo.findById(id).orElseThrow();
	}
	
	@PostMapping
	private Township create (@RequestBody Township d) {
		return repo.save(d);
	}
	
	@PutMapping
	private Township save (@RequestBody Township d) {
		return repo.save(d);
	}

	
}
