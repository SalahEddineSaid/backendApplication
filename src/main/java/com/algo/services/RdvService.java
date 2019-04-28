package com.algo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.algo.dao.RdvRepository;
import com.algo.entities.Rdv;
import com.algo.entities.Thematique;
import com.algo.entities.User;

@Service
public class RdvService {

	@Autowired
	private RdvRepository rdvrepository;
	
	@Autowired
	private QuestionReponseService questionReponseService;

	public Collection<Rdv> findRdvByUsername(String username) {

		return rdvrepository.findByUser_UsernameOrderByDatetime(username);

	}
	
	
	
	public Collection<Rdv> findRdvByUsernamemanager(String usernamemanager) {

		return rdvrepository.findByUser_UsernamemanagerOrderByDatetimeDesc(usernamemanager);

	}
	public Collection<Rdv> findRdvByIdUser(Long id) {

		return rdvrepository.findByUser_IdOrderByDatetimeDesc(id);

	}

	public Rdv findRdvByCodeThematique(String codethematique) {

		return rdvrepository.findByThematique_CodeThematique(codethematique);

	}

	public Rdv save(Rdv rdv) {
		
		rdv = rdvrepository.save(rdv);
		
		questionReponseService.cloneQuestionParThematiquePourRdv(rdv,rdv.getThematique().getIdthematique());

		return rdv;
	}

	public Collection<Rdv> findByDateTime() {

		return rdvrepository.findAllByOrderByDatetimeAsc();
	}
	
	public void delete(Long id) {
		
		rdvrepository.deleteById(id);
	}
	
	public Rdv find(Long id) {
		
		return rdvrepository.findById(id).orElse(null);
	}

}
