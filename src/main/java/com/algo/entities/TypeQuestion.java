package com.algo.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="type_question")
public class TypeQuestion implements Serializable {
	
	public TypeQuestion() {
	}

	public TypeQuestion(long idtype, String code, String description) {
		super();
		this.idtype = idtype;
		this.code = code;
		this.description = description;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	long idtype;
	
	@Column(name = "code")
	private	String code;
	
	@Column(name = "description")
	private String description;

	public long getIdtype() {
		return idtype;
	}

	public void setIdtype(long idtype) {
		this.idtype = idtype;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}