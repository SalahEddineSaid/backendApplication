package com.algo.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.algo.dao.UserRepository;
import com.algo.entities.User;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public User find(String userName) {

		return userRepository.findOneByUsername(userName);
	}

	public User find(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public List<User> getAllUser() {

		return (List<User>) userRepository.findAll();

	}
	
	
	public List<User> getAllUseryByoler(Long idrole) {

		return (List<User>) userRepository.findAllByRoles_Id(idrole);

	}
	
	
	public List<User> getAllUseryByIdmanager(Long idmanager) {

		return (List<User>) userRepository.findAllByIdManager(idmanager);

	}
	public void delete(Long id) {
		
		userRepository.deleteById(id);
	}

}
