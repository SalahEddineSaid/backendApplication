package com.algo.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algo.dao.TypeQuestionRepository;
import com.algo.entities.TypeQuestion;

@Service
public class TypeQuestionService {

	@Autowired
	private TypeQuestionRepository typeQuestionRepository;


	public Collection<TypeQuestion> getAll() {
		return typeQuestionRepository.findAll();
	}

}
