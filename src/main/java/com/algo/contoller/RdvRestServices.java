package com.algo.contoller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algo.dao.RdvRepository;
import com.algo.entities.Rdv;
import com.algo.entities.Role;
import com.algo.entities.Thematique;
import com.algo.services.RdvService;

import io.jsonwebtoken.Jwts;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.jasperreports.JasperReportsUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algo.entities.QuestionReponseLigne;
import com.algo.entities.Rdv;
import com.algo.entities.Rubrique;
import com.algo.entities.Thematique;
import com.algo.services.QuestionReponseService;
import com.algo.services.RdvService;
import com.algo.services.RubriqueService;
import com.algo.services.ThematiqueService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;



@RestController

@CrossOrigin(origins = "http://localhost:4200")
public class RdvRestServices {

	private final String invoice_template = "/reports/report1.jrxml";
    private final String logo = "/images/logo.png";
	@Autowired
	private QuestionReponseService questionReponseService;
	@Autowired
	private RdvService rdvservice;
	
	
	@Autowired
	private RdvRepository rdvRepository;

	@RequestMapping(value = "/saveRdv", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")
	public Rdv saverdv(@RequestBody Rdv rdv) {
		return rdvservice.save(rdv);
	}

	@RequestMapping(value = "/updateRdv", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")
	public Rdv updateRdv(@RequestBody Rdv rdv) {
		return rdvservice.save(rdv);
	}
	
	//
	@RequestMapping(value = "/updateEtatRdv", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")
	public Rdv updateEtatRdv(@RequestBody Long idrdv) {
		
		System.out.println("etatrdv id rdv"+idrdv);
		Rdv rdv = rdvservice.find(idrdv);
		
		rdv.setEtat(true);
		
		return rdvservice.save(rdv);
	}

	@RequestMapping(value = "/getRdvThematiqueCode/{codethematique}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")
	public Rdv getRdvByThematique(@PathVariable String codethematique) {
		return rdvservice.findRdvByCodeThematique(codethematique);
	}


	@RequestMapping(value = "/getAllRdvDateTime", method = RequestMethod.GET)
	@PreAuthorize("hasRole('PM') or hasRole('ADMIN') or hasRole('PM') ")
	public Collection<Rdv> getAllRdvDateTime() {
		return rdvservice.findByDateTime();
	}
	
	@RequestMapping(value = "/getAllRdvUsermanagerDateTime/{usermanager}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('PM') or hasRole('ADMIN') or hasRole('PM')")
	public Collection<Rdv> getAllRdvusermanagerDateTime(String usermanager) {
		return rdvservice.findRdvByUsernamemanager(usermanager);
	}
	
	
	@RequestMapping(value = "/getAllRdvByusername/{username}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")
	public Collection<Rdv> getAllRdvByUsername(@PathVariable String username) {
		System.out.println(username);
		return rdvservice.findRdvByUsername(username);
	}
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@RequestMapping(value = "/getAllRdvByIduser/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")
	public Collection<Rdv> getAllRdvByuserId(@PathVariable Long id,@RequestHeader HttpHeaders headers ) {
		long contentLength = headers.getContentLength();
		String autho=headers.AUTHORIZATION.toString();
		System.out.println("id="+id);

		System.out.println("headers"+headers.toString().substring(146, 326));

		System.out.println("Jwts.header().toString()="+Jwts.header().toString());
		return rdvservice.findRdvByIdUser((long) id);
	}
	
	
		
	@RequestMapping(value = "/getAllRdvByYear/{year}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")
	public ArrayList<Rdv> getAllRdvByY(@PathVariable int year) {

		Collection<Rdv> rdv = rdvservice.findByDateTime();
		ArrayList<Rdv> rdvbyyear = new ArrayList<Rdv>(rdv);
		ArrayList<Rdv> rd = new ArrayList<Rdv>();
		for (Rdv rdvitem : rdvbyyear) {

			System.out.println(rdvitem.getDatetime().getYear());

			if (year == (rdvitem.getDatetime().getYear())) {

				rd.add((Rdv) rdvitem);
			}

		}
		return rd;
	}
	
	@RequestMapping(value = "/deleterdv/{idrdv}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")

	public void deleteRdv(@PathVariable Long idrdv){
		
		rdvservice.delete(idrdv);		
	}

	@RequestMapping(value = "/getrdv/{idRdv}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")

	public Rdv getRdv(@PathVariable Long idRdv){
		System.out.println(idRdv);
		return rdvservice.find(idRdv);		
	}
	
	
	
	@RequestMapping(path = "/printreport/{idRdv}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")

	public ResponseEntity<InputStreamResource> printReport(@PathVariable Long idRdv) throws IOException {
		System.out.println("------------ /printreport --------------- idRdv = "+ idRdv);
		
		 
		File file2Upload = generateInvoiceFor(idRdv);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        
	
	InputStreamResource resource = new InputStreamResource(new FileInputStream(file2Upload));

	headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.pdf");
	
//    return ResponseEntity.ok()
//            .headers(headers)
//            .contentLength(file2Upload.length())
//            .contentType(MediaType.parseMediaType("application/octet-stream"))
//            .body(resource);
	
    return ResponseEntity.ok()
            
            .contentLength(file2Upload.length())
            .contentType(MediaType.parseMediaType("application/pdf"))
            .body(resource);
				
	}
	
	public File generateInvoiceFor(Long idRdv) throws IOException {

        File pdfFile = File.createTempFile("report", ".pdf");


        try(FileOutputStream pos = new FileOutputStream(pdfFile))
        {
            // Load invoice jrxml template.
        	final JasperReport report = loadTemplate();

            // Create parameters map.
            final Map<String, Object> parameters = parameters(idRdv);
            
            // Create an empty datasource.
            final JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singletonList("Invoice"));

            // Render as PDF.
            JasperReportsUtils.renderAsPdf(report, parameters, dataSource, pos);

        }
        catch (final Exception e)
        {
        }
        return pdfFile;
    }
	
	// Fill template order parametres
    private Map<String, Object> parameters(Long idRdv) {
        final Map<String, Object> parameters = new HashMap<>();
        
        Rdv rdv = rdvservice.find(idRdv);
        
        String titre = rdv.getThematique().getLibelleThematique();
        
        System.out.println("Titre: "+titre);
        
        Collection<QuestionReponseLigne> listQuestionsReponses = questionReponseService.findListQRCloneByRdv(idRdv);
                
        
        System.out.println("listQuestionsReponses.size() --> " + listQuestionsReponses.size());
             
        final JRBeanCollectionDataSource collectionQuestionsReponses = new JRBeanCollectionDataSource(listQuestionsReponses);

        parameters.put("collectionQuestionsReponses", collectionQuestionsReponses);
        
        parameters.put("logo", getClass().getResourceAsStream(logo));
        parameters.put("title", titre);    

        return parameters;
    }

    
    
   
    // Load invoice jrxml template
    private JasperReport loadTemplate() throws JRException {


        final InputStream reportInputStream = getClass().getResourceAsStream(invoice_template);
        final JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);

        return JasperCompileManager.compileReport(jasperDesign);
    }
	
	
}
