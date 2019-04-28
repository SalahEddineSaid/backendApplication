package com.algo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.algo.dao.RoleRepository;
import com.algo.entities.Role;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	public Role save(Role role) {
		return roleRepository.save(role);
	}

	public List<Role> getAllRole() {

		return (List<Role>) roleRepository.findAll();

	}

	public Role getRole(String idrole) {

		return roleRepository.findById(idrole).orElse(null);
	}

}
