package com.algo.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algo.entities.Role;
import com.algo.entities.Rubrique;

public interface RubriqueRepository extends JpaRepository<Rubrique, Long> {

	public Collection<Rubrique> findByThematique_CodeThematique(String codethematique);

	public Collection<Rubrique> findByThematique_Idthematique(Long idthematique);

	
	
}
