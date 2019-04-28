package com.algo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;;

@Entity
@Table(name = "thematique")
@Scope("session")
public class Thematique implements Serializable {
	
	public Thematique() {
	}

	public Thematique(Long idthematique, String codeThematique, String libelleThematique, List<Rdv> rdvs, List<Rubrique> rubriques) {
		super();
		this.idthematique = idthematique;
		this.codeThematique = codeThematique;
		this.libelleThematique = libelleThematique;
		this.rdvs = rdvs;
		this.rubriques = rubriques;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long idthematique;

	@Column(name = "code_Thematique")
	private String codeThematique;
	
	@Column(name = "libelle_Thematique")
	private String libelleThematique;
	
	//@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy = "thematique")
	private List<Rdv> rdvs;

	//@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy = "thematique")
	private List<Rubrique> rubriques;

	public Long getIdthematique() {
		return idthematique;
	}

	public void setIdthematique(Long idthematique) {
		this.idthematique = idthematique;
	}

	public String getCodeThematique() {
		return codeThematique;
	}

	public void setCodeThematique(String codeThematique) {
		this.codeThematique = codeThematique;
	}

	public String getLibelleThematique() {
		return libelleThematique;
	}

	public void setLibelleThematique(String libelleThematique) {
		this.libelleThematique = libelleThematique;
	}

	public List<Rdv> getRdvs() {
		return rdvs;
	}

	public void setRdvs(List<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

	public List<Rubrique> getRubriques() {
		return rubriques;
	}

	public void setRubriques(List<Rubrique> rubriques) {
		this.rubriques = rubriques;
	}
	
}
