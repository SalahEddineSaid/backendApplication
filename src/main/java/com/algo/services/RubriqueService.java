package com.algo.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algo.dao.RubriqueRepository;
import com.algo.entities.Rdv;
import com.algo.entities.Rubrique;

@Service
public class RubriqueService {

	@Autowired
	private RubriqueRepository rubriqueRepository;

	public Collection<Rubrique> getAllRubrique() {
		// TODO Auto-generated method stub
		return rubriqueRepository.findAll();
	}

	public Collection<Rubrique> getRubriquebyCodeThematique(String codethematique) {
		// TODO Auto-generated method stub
		return rubriqueRepository.findByThematique_CodeThematique(codethematique);
	}

	public Collection<Rubrique> getRubriquebyIdThematique(Long idthematique) {

		return rubriqueRepository.findByThematique_Idthematique(idthematique);
	}
	
	public Rubrique find(Long id) {

		return rubriqueRepository.findById(id).orElse(null);
	}
	
	public Rubrique save(Rubrique rubrique) {
		return rubriqueRepository.save(rubrique);
	}
	
	public void delete(Long id) {
		rubriqueRepository.deleteById(id);
	}
}
