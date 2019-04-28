package com.algo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bouncycastle.util.Iterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.algo.dao.QuestionReponseLigneRepository;
import com.algo.dao.QuestionReponseRepository;
import com.algo.entities.QuestionReponse;
import com.algo.entities.QuestionReponseLigne;
import com.algo.entities.Rdv;
import com.algo.entities.Rubrique;

@Service
public class QuestionReponseService {

	@Autowired
	private QuestionReponseRepository questreponserepository;
	
	@Autowired
	private QuestionReponseLigneRepository questionReponseLigneRepository;

	
	public QuestionReponse save(QuestionReponse questreponse) {

		return questreponserepository.save(questreponse);
	}
	
	public List<QuestionReponse> updateList(List<QuestionReponse> listQuestionReponse) {

		List<QuestionReponse> listResponse = new ArrayList<QuestionReponse>();
		
		for(QuestionReponse q : listQuestionReponse) {		 
		 listResponse.add(questreponserepository.save(q));
		}
		
		return listResponse;		
	}

	public QuestionReponse Update(QuestionReponse questreponse) {

		return questreponserepository.save(questreponse);
	}

	public List<QuestionReponse> getAll() {
		return (List<QuestionReponse>) questreponserepository.findAll();
	}
	
	
	
	public List<QuestionReponseLigne> getAllquestionclonebyidrubrique(Long idrubrique,Long idrdv) {
		return (List<QuestionReponseLigne>) questionReponseLigneRepository.findByRubrique_idrubriqueAndRdv_idrdv(idrubrique, idrdv);
	}
	

	public QuestionReponse find(Long id) {

		return questreponserepository.findById(id).orElse(null);
	}

	public List<QuestionReponse> findByRubrique(Long idrubrique) {

		return questreponserepository.findByRubrique_Idrubrique(idrubrique);
	}
	
	public void delete(Long id) {
		
		questreponserepository.deleteById(id);
	}
	
	public void cloneQuestionParThematiquePourRdv(Rdv rdv, Long idThematique) {

		List<QuestionReponse> listQuestionACloner = questreponserepository.findByRubrique_Thematique_Idthematique(idThematique);
		
		List<QuestionReponseLigne> listQuestionClones = new ArrayList<QuestionReponseLigne>();
		
		QuestionReponseLigne tmpClone;
		
		for(QuestionReponse tmp : listQuestionACloner) {
			tmpClone = new QuestionReponseLigne();
			
			tmpClone.setDescription(tmp.getDescription());
			tmpClone.setQuestion(tmp.getQuestion());
			tmpClone.setRubrique(tmp.getRubrique());
			tmpClone.setTypeQuestion(tmp.getTypeQuestion());
			tmpClone.setRdv(rdv);		
			
			listQuestionClones.add(tmpClone);
		}
		
		questionReponseLigneRepository.saveAll(listQuestionClones);
		
	}
	//saveclone
	
	
	public List<QuestionReponseLigne>  saveclone(List<QuestionReponseLigne> questreponseLigne) {

		return (List<QuestionReponseLigne>) questionReponseLigneRepository.saveAll(questreponseLigne);
	}
	
	
	
	public List<QuestionReponseLigne> findListQRCloneByRdv(Long idRdv) {

		return questionReponseLigneRepository.findByRdv_Idrdv(idRdv);
	}
}
