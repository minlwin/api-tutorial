package com.solt.location.model.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.solt.location.model.entity.District;
import com.solt.location.model.entity.Division;
import com.solt.location.model.entity.Township;
import com.solt.location.model.repo.DistrictRepo;
import com.solt.location.model.repo.DivisionRepo;
import com.solt.location.model.repo.TownshipRepo;

@Configuration
public class LocationInitializer {
	
	@Autowired
	private DivisionRepo divisions;
	@Autowired
	private DistrictRepo districts;
	@Autowired
	private TownshipRepo townships;

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			loadTownships();
		};
	}
	
	@Transactional
	private void loadTownships() {
		if(divisions.count() == 0) {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/locations.csv")))) {
				
				String line = null;
				while(null  != (line = br.readLine())) {
					
					String [] array = line.split(",");
					
					if(array.length == 3) {
						Division division = getDivision(array[0]);
						District district = getDistrict(division, array[1]);
						Township township = new Township();
						township.setDistrict(district);
						township.setName(array[2]);
						townships.save(township);
					}
											
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private District getDistrict(Division division, String name) {
		District d = districts.findOneByDivisionAndName(division, name);
		
		if(null == d) {
			d = new District();
			d.setDivision(division);
			d.setName(name);
			d = districts.save(d);
		}
		return d;
	}

	private Division getDivision(String name) {
		Division d = divisions.findOneByName(name);
		if(null == d) {
			d = new Division();
			d.setName(name);
			d = divisions.save(d);
		}
		return d;
	}

}
