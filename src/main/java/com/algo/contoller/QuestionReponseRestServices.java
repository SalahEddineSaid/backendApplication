package com.algo.contoller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algo.dao.QuestionReponseRepository;
import com.algo.entities.QuestionReponse;
import com.algo.entities.QuestionReponseLigne;
import com.algo.entities.Thematique;
import com.algo.services.QuestionReponseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionReponseRestServices {
	
	@Autowired
	private QuestionReponseService questionReponseService;
		
	

		
	@RequestMapping(value = "/getAllQuestionReponsebyRubrique/{idrubrique}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")
	public List<QuestionReponse> getAllQuestionReponseByRubriqueId(@PathVariable Long idrubrique) {

		return questionReponseService.findByRubrique(idrubrique);
	}
	
	
	
	@RequestMapping(value = "/saveQuestionreponse", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")

	public QuestionReponse savequestionreponse(@RequestBody QuestionReponse questionreponse) {
		
		System.out.println("dd");
		return questionReponseService.save(questionreponse) ;
	}
	
	
	@RequestMapping(value = "/saveQuestionreponseclone", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")

	public List<QuestionReponseLigne> savequestionreponseclone(@RequestBody List<QuestionReponseLigne> questionreponseligne) {
		
		System.out.println("listeclone");
		return questionReponseService.saveclone(questionreponseligne) ;
	}
	
	@RequestMapping(value = "/getAllQuestionReponse", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")

	public List<QuestionReponse> getAllQuestionReponse() {

		return questionReponseService.getAll();
	}
	
	@RequestMapping(value = "/getAllQuestionReponseByIdRubrique/{idrubrique}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")

public List<QuestionReponse> getAllQuestionReponseByIdRubrique(@PathVariable Long idrubrique) {

		return questionReponseService.findByRubrique(idrubrique);
	}
	
	@RequestMapping(value = "/getQuestion/{idQuestion}", method = RequestMethod.GET)
	public QuestionReponse getQuestion(@PathVariable Long idQuestion) {

		return questionReponseService.find(idQuestion);
	}
	
	@RequestMapping(value = "/updateQuestion", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")

	public QuestionReponse updateQuestion(@RequestBody QuestionReponse questionReponse) {
		return questionReponseService.save(questionReponse);
	}
	
	@RequestMapping(value = "/deleteQuestion/{idQuestion}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")

	public void deleteQuestion(@PathVariable Long idQuestion){
		
		 questionReponseService.delete(idQuestion);		
	}
	
	 
	@RequestMapping(value = "/updateListQuestion", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")

	public List<QuestionReponse> updateListQuestion(@RequestBody List<QuestionReponse> listQuestionReponse) {
		
		return questionReponseService.updateList(listQuestionReponse);
	}

	
	@RequestMapping(value = "/getQuestionByidrubriqueclone/{idrubrique}/{idrdv}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")

	public List<QuestionReponseLigne> getQuestionByidrubriqueclone(@PathVariable Long idrubrique,@PathVariable Long idrdv) {

		return questionReponseService.getAllquestionclonebyidrubrique(idrubrique,idrdv);
	}
	
	
	@RequestMapping(value = "/getQuestionsCloneByidRdv/{idRdv}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")

	public List<QuestionReponseLigne> getQuestionsCloneByidRdv(@PathVariable Long idRdv) {

		return questionReponseService.findListQRCloneByRdv(idRdv);
	}
	
}
