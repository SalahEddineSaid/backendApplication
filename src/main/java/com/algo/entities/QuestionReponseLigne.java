package com.algo.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "question_reponse_ligne")
@Scope("session")
public class QuestionReponseLigne implements Serializable {

	public QuestionReponseLigne() {
	}
	
	public QuestionReponseLigne(Long idquestreponse, String question, String reponse, String reponseManager,
			String description, Rdv rdv, TypeQuestion typeQuestion, Rubrique rubrique) {
		super();
		this.idquestreponse = idquestreponse;
		this.question = question;
		this.reponse = reponse;
		this.reponseManager = reponseManager;
		this.description = description;
		this.rdv = rdv;
		this.typeQuestion = typeQuestion;
		this.rubrique = rubrique;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long idquestreponse;
	
	@Column(name="question")
	private String question;
	
	@Column(name="reponse")
	private String reponse;
	
	@Column(name="reponse_manager")
	private String reponseManager;
	
	@Column(name="description")
	private String description;	

	@ManyToOne(fetch = FetchType.EAGER, optional = false) // il faut ajouter les cascases une a une
	@JoinColumn(name = "id_rdv", nullable = false)
	//@JsonBackReference
	//@JsonIgnore
	private Rdv rdv;

	@ManyToOne(fetch = FetchType.EAGER, optional = false) // il faut ajouter les cascases une a une
	@JoinColumn(name = "id_type_question", nullable = false)
//	@JsonBackReference
    private TypeQuestion typeQuestion;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false) // il faut ajouter les cascases une a une
	@JoinColumn(name = "id_rubrique", nullable = false)
	//@JsonBackReference
	//@JsonIgnore
	private Rubrique rubrique;

	public Long getIdquestreponse() {
		return idquestreponse;
	}

	public void setIdquestreponse(Long idquestreponse) {
		this.idquestreponse = idquestreponse;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public String getReponseManager() {
		return reponseManager;
	}

	public void setReponseManager(String reponseManager) {
		this.reponseManager = reponseManager;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Rdv getRdv() {
		return rdv;
	}

	public void setRdv(Rdv rdv) {
		this.rdv = rdv;
	}

	public TypeQuestion getTypeQuestion() {
		return typeQuestion;
	}

	public void setTypeQuestion(TypeQuestion typeQuestion) {
		this.typeQuestion = typeQuestion;
	}

	public Rubrique getRubrique() {
		return rubrique;
	}

	public void setRubrique(Rubrique rubrique) {
		this.rubrique = rubrique;
	}
	
}
