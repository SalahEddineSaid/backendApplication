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
import com.algo.entities.Thematique;
import com.algo.entities.TypeQuestion;
import com.algo.services.QuestionReponseService;
import com.algo.services.TypeQuestionService;

@RestController
@CrossOrigin("*")
public class TypeQuestionRestServices {
		
	@Autowired
	private TypeQuestionService typeQuestionService;
			
	@RequestMapping(value = "/getAllTypeQuestion", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Collection<TypeQuestion> getAllTypeQuestion() {

		return typeQuestionService.getAll();
	}

}
