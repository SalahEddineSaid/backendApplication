package com.algo.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import com.algo.entities.Rdv;
import com.algo.entities.Role;
import com.algo.entities.Rubrique;

public interface RdvRepository extends JpaRepository<Rdv, Long> {

	Collection<Rdv> findByUser_UsernameOrderByDatetime(String username);
	Collection<Rdv> findByUser_IdOrderByDatetimeDesc(Long id);

	
	Collection<Rdv> findByUser_UsernamemanagerOrderByDatetimeDesc(String usernamemanger);
	
	Rdv findByThematique_CodeThematique(String codethematique);	
	Rdv findByThematique(String thematique);

	
	Rdv findByThematique_Idthematique(Long idThematique);
   
	
	Collection<Rdv> findAllByOrderByDatetimeAsc();

	Collection<Rdv> findAllByDatetimeStartingWith(Date datetime);

}
