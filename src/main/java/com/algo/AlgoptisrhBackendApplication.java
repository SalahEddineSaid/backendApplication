package com.algo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.algo.dao.QuestionReponseRepository;
import com.algo.dao.RubriqueRepository;


@SpringBootApplication
public class AlgoptisrhBackendApplication {

	  
	@Autowired
	QuestionReponseRepository questionrepository;
	@Autowired
	RubriqueRepository rubriquerepository;;
    
	public static void main(String[] args) {
	
	
		System.out.println("start:");
		System.out.println("start ...:");
				
        SpringApplication.run(AlgoptisrhBackendApplication.class, args);
        
     
	}
	
	public void run(String... args) throws Exception {

}
}