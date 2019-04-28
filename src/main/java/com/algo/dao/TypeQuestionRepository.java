package com.algo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algo.entities.TypeQuestion;

@Repository
public interface TypeQuestionRepository extends JpaRepository<TypeQuestion, Long> {

}
