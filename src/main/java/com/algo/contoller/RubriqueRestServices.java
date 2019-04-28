package com.algo.contoller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algo.entities.Rdv;
import com.algo.entities.Rubrique;
import com.algo.entities.Thematique;
import com.algo.services.RubriqueService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RubriqueRestServices {

	@Autowired
	private RubriqueService rubriqueService;

	@RequestMapping(value = "/getRubriqueByCodethematique/{codethematique}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")
	public Collection<Rubrique> getAllRubriqueByCodeThematique(String codethematique) {
		return rubriqueService.getRubriquebyCodeThematique(codethematique);
	}

	@RequestMapping(value = "/getRubriqueByIdthematique/{idthematique}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")
	public Collection<Rubrique> getAllRubriqueByIdThematique(Long idthematique) {
		return rubriqueService.getRubriquebyIdThematique(idthematique);
	}

	@RequestMapping(value = "/getAllRubrique", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")
	public Collection<Rubrique> getAllRubrique() {
		// TODO Auto-generated method stub
		System.out.println("ee");
		return rubriqueService.getAllRubrique();
	}
	
	@RequestMapping(value = "/getrubriquebythematique/{idthematique}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")
	public Collection<Rubrique> getthematique(@PathVariable Long idthematique){
		
		return rubriqueService.getRubriquebyIdThematique(idthematique);		
	}
	

	@RequestMapping(value = "/saveRubrique", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")
	public Rubrique saveRubrique(@RequestBody Rubrique rubrique) {
		return rubriqueService.save(rubrique);
	}
	
	@RequestMapping(value = "/updateRubrique", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")
	public Rubrique updateRubrique(@RequestBody Rubrique rubrique) {
		return rubriqueService.save(rubrique);
	}
	
	@RequestMapping(value = "/deleteRubrique/{idRubrique}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")
	public void deleteRubrique(@PathVariable Long idRubrique) {
		rubriqueService.delete(idRubrique);
	}

}
