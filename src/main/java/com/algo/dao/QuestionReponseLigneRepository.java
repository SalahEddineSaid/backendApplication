package com.algo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.algo.entities.QuestionReponseLigne;

@Repository
public interface QuestionReponseLigneRepository extends CrudRepository<QuestionReponseLigne, Long> {

	
//	List<QuestionReponseLigne> findByRubrique_idrubriqueAndRdv_idrdv(Long idrubrique,Long idrdv);

	//List<QuestionReponseLigne> findByRubrique_idrubriqueAndRdv_idrdv(Long idrubrique, Long idrdv);

	List<QuestionReponseLigne> findByRubrique_idrubriqueAndRdv_idrdv(Long idrubrique, Long idrdv);
	List<QuestionReponseLigne> findByRdv_Idrdv(Long idRdv);
	
}
