package com.semtask.App;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class F1Service {
	@Autowired
	private F1Repository repo;
	
	public List<Formula1> listAll() {		
		return repo.findAll();
	}
	
	public void save(Formula1 f1) {
		repo.save(f1);
	}
	
	public Formula1 get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
