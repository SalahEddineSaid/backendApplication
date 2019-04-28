package com.algo.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algo.dao.ThematiqueRepository;
import com.algo.entities.Thematique;

@Service
public class ThematiqueService {
	
	@Autowired 
	private ThematiqueRepository thematiqueRepository;
	 
	public Collection<Thematique> getAllThematiques(){
		
		return thematiqueRepository.findAll();
	}
	
	
	public Thematique savethematique(Thematique thematique) {
		
		return thematiqueRepository.save(thematique);
	}
	
	public Thematique find(Long id) {
		
		return thematiqueRepository.findById(id).orElse(null);
	}
	
	public void delete(Long id) {
		
		thematiqueRepository.deleteById(id);
	}

}
