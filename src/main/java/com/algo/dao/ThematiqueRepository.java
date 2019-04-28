package com.algo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algo.entities.Role;
import com.algo.entities.Thematique;

public interface ThematiqueRepository extends JpaRepository<Thematique, Long> {

	
	
}
