package com.algo.entities;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rdv")
@Scope("session")
public class Rdv implements Serializable {
	
	public Rdv() {
	}

	public Rdv(Long idrdv, LocalDateTime datetime, boolean etat, User user, Thematique thematique,
			List<QuestionReponseLigne> questionReponseLignes) {
		super();
		this.idrdv = idrdv;
		this.datetime = datetime;
		this.etat = etat;
		this.user = user;
		this.thematique = thematique;
		this.questionReponseLignes = questionReponseLignes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idrdv;

	@Column(name="datetime")
	private LocalDateTime datetime;
	
    @Column(name="etat")
	private boolean etat;

	@ManyToOne(fetch = FetchType.EAGER, optional = false) // il faut ajouter les cascases une a une
	@JoinColumn(name = "id_user", nullable = false)
	//@JsonBackReference
	//@JsonIgnore
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false) // il faut ajouter les cascases une a une
	@JoinColumn(name = "id_thematique", nullable = false)
	//@JsonBackReference
	//@JsonIgnore
	private Thematique thematique;
	
	@JsonIgnore
	@OneToMany(mappedBy = "rdv")
	private List<QuestionReponseLigne> questionReponseLignes;

	public Long getIdrdv() {
		return idrdv;
	}

	public void setIdrdv(Long idrdv) {
		this.idrdv = idrdv;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Thematique getThematique() {
		return thematique;
	}

	public void setThematique(Thematique thematique) {
		this.thematique = thematique;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public List<QuestionReponseLigne> getQuestionReponseLignes() {
		return questionReponseLignes;
	}

	public void setQuestionReponseLignes(List<QuestionReponseLigne> questionReponseLignes) {
		this.questionReponseLignes = questionReponseLignes;
	}
	
	
}
