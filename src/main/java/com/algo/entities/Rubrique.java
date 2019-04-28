package com.algo.entities;

import java.io.Serializable;
import java.util.List;

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
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "rubrique")
@Scope("session")
public class Rubrique implements Serializable {

	public Rubrique() {
	}

	public Rubrique(Long idrubrique, String libelleRubrique, String codeRubrique, Thematique thematique,
			List<QuestionReponse> questionReponse) {
		super();
		this.idrubrique = idrubrique;
		this.libelleRubrique = libelleRubrique;
		this.codeRubrique = codeRubrique;
		this.thematique = thematique;
		this.questionReponse = questionReponse;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long idrubrique;
	
	@Column(name="libelle_rubrique")
	private String libelleRubrique;
	
	@Column(name="code_rubrique")
	private String codeRubrique;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)  // il faut ajouter les cascases une a une
	@JoinColumn(name = "id_thematique", nullable = false)
	//@JsonBackReference
	//@JsonIgnore
	private Thematique thematique;

//	@OneToMany(mappedBy = "rubrique")
//	@Column(name = "id_questreponse")
//	@JsonBackReference
//	private List<QuestionReponse> questreponse;
	
	//en cas de bug enleve ça
	//@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy = "rubrique")
	private List<QuestionReponse> questionReponse;
	
	@JsonIgnore
	@OneToMany(mappedBy = "rubrique")
	private List<QuestionReponseLigne> questionReponseLignes;

	public Long getIdrubrique() {
		return idrubrique;
	}

	public void setIdrubrique(Long idrubrique) {
		this.idrubrique = idrubrique;
	}

	public String getLibelleRubrique() {
		return libelleRubrique;
	}

	public void setLibelleRubrique(String libelleRubrique) {
		this.libelleRubrique = libelleRubrique;
	}

	public String getCodeRubrique() {
		return codeRubrique;
	}

	public void setCodeRubrique(String codeRubrique) {
		this.codeRubrique = codeRubrique;
	}

	public Thematique getThematique() {
		return thematique;
	}

	public void setThematique(Thematique thematique) {
		this.thematique = thematique;
	}

	public List<QuestionReponse> getQuestionReponse() {
		return questionReponse;
	}

	public void setQuestionReponse(List<QuestionReponse> questionReponse) {
		this.questionReponse = questionReponse;
	}

	
}
