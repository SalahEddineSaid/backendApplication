package com.algo.contoller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algo.dao.RoleRepository;
import com.algo.dao.UserRepository;
import com.algo.entities.Role;
import com.algo.entities.RoleName;
import com.algo.entities.Thematique;
import com.algo.entities.User;
import com.algo.message.request.Userregister;
import com.algo.message.response.ResponseMessage;
import com.algo.services.UserService;
import com.algo.services.RoleService;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
public class UserRestServices {
	// admin@123
	@Autowired
	private UserRepository userrepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	private RoleRepository rolerepository;

	@Autowired
	private UserService userservice;
	
	@Autowired
	private RoleService roleservice;
	
	@Autowired
	private RoleRepository roleRepository;

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?>  saveuser(@Valid @RequestBody Userregister userregister) {

	/*	
		System.out.println("signUpRequest.getUsername()="+user.getUsername()+"getUsernamemanager"+user.getUsernamemanager()+"password"+user.getPassword()+"roleuser");
		if (userrepository.existsByUsername(user.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userrepository.existsByEmail(user.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User usere = new User(user.getName(), user.getUsername(), user.getEmail(),
				encoder.encode(user.getPassword()),user.getUsernamemanager());

		Set<Role> strRoles = user.getRoles();
		
		
		System.out.println("size+"+user.getRoles());
		if(user.getRoles().size()==0)
			 System.out.println("role++");
		for (Role s : user.getRoles()) {
			
		    System.out.println("role++"+s.getName());
		}
		//strRoles.forEach(System.out::println);
		
		System.out.println("role"+user.getRoles());
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role.getName().toString()) {
			case "admin":
				
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);
				System.out.println("role.getName().toString()"+role.getName().toString());

				break;
			case "pm":
				Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(pmRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});
   System.out.println("userRole"+user.getRoles());
		user.setRoles(roles);
		
		userrepository.save(user);
		
		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
		
		
		*/
		
		/*
			
		    System.out.println("role++"+rolename);
		
		System.out.println("signUpRequest.getUsername()="+user.getUsername()+"getUsernamemanager"+user.getUsernamemanager()+"password"+user.getPassword()+"roleuser");

		Set<Role> roles = new HashSet<>();

		 Role userRole = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));;
			roles.add(userRole);
			user.setRoles(roles);
			
			
			user.setPassword(encoder.encode(user.getPassword()));

	*/
		
		if (userrepository.existsByUsername(userregister.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userrepository.existsByEmail(userregister.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}
		
		
		System.out.println("signUpRequest.getUsername()="+userregister.getUsername()+"getUsernamemanager"+userregister.getUsernamemanager()+"password"+userregister.getPassword()+"roleuser"+userregister.getRolename());

		User user = new User(userregister.getName(), userregister.getUsername(), userregister.getEmail(),
				encoder.encode(userregister.getPassword()),userregister.getUsernamemanager());
		Set<Role> roles = new HashSet<>();
		if(userregister.getRolename().equals("ROLE_PM")) {
		Role adminRole = roleRepository.findByName(RoleName.ROLE_PM)
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		roles.add(adminRole);
		}
		if(userregister.getRolename().equals("ROLE_USER")) {
			Role adminRole = roleRepository.findByName(RoleName.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(adminRole);
			}
		if(userregister.getRolename().equals("ROLE_ADMIN")) {
			
			Role userRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(userRole);
		}
		
			
		user.setRoles(roles);
			
		
		
		 userservice.save(user);
		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);

	}

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public User getUser(@PathVariable Long id) {

		return userservice.find(id);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public User updateUser(@RequestBody User user) {
		return userservice.save(user);
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void deleteThematique(@PathVariable Long id) {

		userservice.delete(id);
	}

	@RequestMapping(value = "/saverole", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Role saverole(@RequestBody Role role) {

		return roleservice.save(role);
	}

	@RequestMapping(value = "/getallrole", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Role> getAllRoles() {
       System.out.println("userrole"+roleservice.getAllRole());
		return (List<Role>) roleservice.getAllRole();

	}

	@RequestMapping(value = "/getalluser", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<User> getAllUsers() {

		return (List<User>) userservice.getAllUser();

	}

	@RequestMapping(value = "/getusersbyrole/{idrole}", method = RequestMethod.GET)
	public List<User> getAlluserbyroleid(@PathVariable Long idrole) {

		return userservice.getAllUseryByoler(idrole);
	}

	@RequestMapping(value = "/getusersbymanager/{idmanager}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<User> getAlluserbyidmanager(@PathVariable Long idmanager) {
        System.out.println("usermaager="+idmanager);
		return userservice.getAllUseryByIdmanager(idmanager);
	
	}
	
	
//	@RequestMapping(value = "/getusersbynamemanager/", method = RequestMethod.GET)
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//	public List<User> getAlluserbyidmanagername(@PathVariable String usernamemanager) {
//        System.out.println("usermaagername="+usernamemanager);
//		return userrepository.findAllByUsernamemanager("yas123456");
//	
//	}
	@RequestMapping(value = "/getusersbynamemanager/{usernamemanager}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")
	public List<User> getAlluserbynamemanager(@PathVariable String usernamemanager) {
        System.out.println("usermaagername="+usernamemanager);
		return userrepository.findAllByUsernamemanager(usernamemanager);
	
	}

//	@RequestMapping(value = "/addroleToUser/{username}/{role}")
//	public User addRoleToUser(@PathVariable String username, @PathVariable String role) {
//		User u = userservice.find(username);
//		Role r = roleservice.getRole(role);
//		System.out.println("r" + r.getRole());
//		u.setRoles(r);
//		userservice.save(u);
//		return u;
//	}
}
