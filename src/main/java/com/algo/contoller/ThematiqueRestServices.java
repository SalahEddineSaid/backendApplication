package com.algo.contoller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.jasperreports.JasperReportsUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algo.entities.QuestionReponse;
import com.algo.entities.Rdv;
import com.algo.entities.Role;
import com.algo.entities.Rubrique;
import com.algo.entities.Thematique;
import com.algo.services.QuestionReponseService;
import com.algo.services.RubriqueService;
import com.algo.services.ThematiqueService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@RestController
@CrossOrigin("*")
public class ThematiqueRestServices {
    private final String invoice_template = "/reports/report1.jrxml";
    private final String logo = "/images/logo.png";

	@Autowired
	private ThematiqueService thematiqueService;
	
	@Autowired
	private RubriqueService rubriqueService;
	
	@RequestMapping(value = "/getAllthematiquee", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM') ")
	public Collection<Thematique> getAllthematique(){
		
		return thematiqueService.getAllThematiques();
		
	}
	
	@RequestMapping(value = "/getthematique/{idthematique}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Thematique getthematique(@PathVariable Long idthematique){
		
		return thematiqueService.find(idthematique);		
	}
	
	@RequestMapping(value = "/saveThematique", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Thematique savethematiquee(@RequestBody Thematique thematique) {

		return thematiqueService.savethematique(thematique) ;
	}
	
	@RequestMapping(value = "/updateThematique", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Thematique updateThematique(@RequestBody Thematique thematique) {
		return thematiqueService.savethematique(thematique);
	}
	
	@RequestMapping(value = "/deletethematique/{idthematique}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void deleteThematique(@PathVariable Long idthematique){
		
		 thematiqueService.delete(idthematique);		
	}
	

	

	

	

}
