package com.algo.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.algo.entities.*;


public interface UserRepository extends CrudRepository<User, Long> {

		User findOneByUsername(String userName);
		List<User> findAllByRoles_Id(Long idrole);
		List<User> findAllByIdManager(Long manager);
		List<User> findAllByUsernamemanager(String usernamemanager);
		Optional<User> findByUsername(String username);
	    Boolean existsByUsername(String username);
	    Boolean existsByEmail(String email);

}
