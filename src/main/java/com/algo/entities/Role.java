package com.algo.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;



@Entity
@Table(name = "roles")

public class Role implements Serializable {
	
	public Role() {
	}
	
		
	public Role(Long id, String role, String description) {
		super();
		this.id = id;
		this.role = role;
		this.description = description;
	}

	
	
	public Role(Long id, String role, com.algo.entities.RoleName name, String description) {
		super();
		this.id = id;
		this.role = role;
		this.name = name;
		this.description = description;
	}


	public RoleName getName() {
		return name;
	}


	public void setName(RoleName name) {
		this.name = name;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String role;
	@Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;
	private String description;
	
//	@OneToOne(mappedBy = "role",fetch = FetchType.EAGER, optional = false)
//	private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
