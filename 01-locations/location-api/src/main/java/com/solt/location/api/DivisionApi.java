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

import com.solt.location.model.entity.Division;
import com.solt.location.model.repo.DivisionRepo;

@RestController
@RequestMapping("divisions")
public class DivisionApi {
	
	@Autowired
	private DivisionRepo repo;

	@GetMapping
	public List<Division> findAll() {
		return repo.findAll();
	}
	
	@GetMapping("{id:\\d+}")
	public Division findById(@PathVariable int id) {
		return repo.findById(id).orElseThrow();
	}
	
	@PostMapping
	public Division create(@RequestBody Division d) {
		return repo.save(d);
	}
	
	@PutMapping
	public Division update(@RequestBody Division d) {
		return repo.save(d);
	}
}
