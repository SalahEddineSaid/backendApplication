package com.algo.message.request;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Userregister implements Serializable{

	
	@NotBlank
	    @Size(min = 3, max = 50)
	    private String name;

	    @NotBlank
	    @Size(min = 3, max = 50)
	    private String username;

	    @NotBlank
	    @Size(max = 60)
	    @Email
	    private String email;
	    
	 
		@Size(max = 60)
	    private String usernamemanager;
	    
		
	    private String rolename;
	    
	    @NotBlank
	    @Size(min = 6, max = 40)
	    private String password;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

		public String getUsernamemanager() {
			return usernamemanager;
		}

		public void setUsernamemanager(String usernamemanager) {
			this.usernamemanager = usernamemanager;
		}

		public String getRolename() {
			return rolename;
		}

		public void setRolename(String rolename) {
			this.rolename = rolename;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	
	
	
}
