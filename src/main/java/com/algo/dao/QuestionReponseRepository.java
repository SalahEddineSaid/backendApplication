package com.algo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.algo.entities.QuestionReponse;
import com.algo.entities.Role;

@Repository
public interface QuestionReponseRepository extends CrudRepository<QuestionReponse, Long> {

	List<QuestionReponse> findByRubrique_Idrubrique(Long idrubrique);
	
	List<QuestionReponse> findByRubrique_Thematique_Idthematique(Long idThematique);

}
