package com.algo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algo.entities.Role;
import com.algo.entities.RoleName;


public interface RoleRepository extends JpaRepository<Role, String> {
	 Optional<Role> findByName(RoleName roleName);
}
