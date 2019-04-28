package com.algo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;
import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })
public class User implements Serializable {

	public User() {
	}

	@NotBlank
	@Size(min = 3, max = 50)
	private String name;
	

	@Size(min = 3, max = 50)
	private String usernamemanager;
	
	
	public User(@NotBlank @Size(min = 3, max = 50) String name,
 @Size(min = 3, max = 50) String usernamemanager, Long id, Long idManager,
			@NotBlank @Size(min = 3, max = 50) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(min = 6, max = 100) String password, String actived, String type, Set<Role> roles,
			List<Rdv> rdvs) {
		super();
		this.name = name;
		this.usernamemanager = usernamemanager;
		this.id = id;
		this.idManager = idManager;
		this.username = username;
		this.email = email;
		this.password = password;
		this.actived = actived;
		this.type = type;
		this.roles = roles;
		this.rdvs = rdvs;
	}

	public String getUsernamemanager() {
		return usernamemanager;
	}

	public void setUsernamemanager(String usernamemanager) {
		this.usernamemanager = usernamemanager;
	}

	public User(@NotBlank @Size(min = 3, max = 50) String name, Long id, Long idManager,
			@NotBlank @Size(min = 3, max = 50) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(min = 6, max = 100) String password, String actived, String type, Set<Role> roles,
			List<Rdv> rdvs) {
		super();
		this.name = name;
		this.id = id;
		this.idManager = idManager;
		this.username = username;
		this.email = email;
		this.password = password;
		this.actived = actived;
		this.type = type;
		this.roles = roles;
		this.rdvs = rdvs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	public Long getIdManager() {
		return idManager;
	}

	public void setIdManager(Long idManager) {
		this.idManager = idManager;
	}

	private Long idManager;

	@NotBlank
	@Size(min = 3, max = 50)
	private String username;

	@NaturalId
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(min = 6, max = 100)
	private String password;

	@Column(name = "actived")
	private String actived;

	@Column(unique = true, name = "type")
	private String type;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Rdv> rdvs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public User(Long id, Long idManager, @NotBlank @Size(min = 3, max = 50) String username,
			@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(min = 6, max = 100) String password,
			String actived, String type, Set<com.algo.entities.Role> roles, List<Rdv> rdvs) {
		super();
		this.id = id;
		this.idManager = idManager;
		this.username = username;
		this.email = email;
		this.password = password;
		this.actived = actived;
		this.type = type;
		this.roles = roles;
		this.rdvs = rdvs;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActived() {
		return actived;
	}

	public void setActived(String actived) {
		this.actived = actived;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Rdv> getRdvs() {
		return rdvs;
	}

	public void setRdvs(List<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

	public User(String name, String username, String email, String password) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	
	public User(String name, String username, String email, String password,String usernamemanager) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.usernamemanager=usernamemanager;
	}
	
	
	public User(String name, String username, String email, String password,String usernamemanager,Set<com.algo.entities.Role> roles) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.usernamemanager=usernamemanager;
		this.roles=roles;
		
	}


}
