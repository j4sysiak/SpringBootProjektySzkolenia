package pl.jaceksysiak.database.demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pl.jaceksysiak.database.demo.entity.Person;
import pl.jaceksysiak.database.demo.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		
		//1. sposób
		SpringApplication.run(JpaDemoApplication.class, args);
		
		//2. sposób
//		ApplicationContext applicationContext = SpringApplication.run(App.class, args);
//		
//		for (String name : applicationContext.getBeanDefinitionNames()) {
//			System.out.println("applicationContext: " + name);
//		}
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("All users -> {}", repository.findById(10001));
		logger.info("Inserting 10004 -> {}", repository.insert(new Person(10004, "Tara", "Berlin", new Date())));
		logger.info("Update 10003 -> {}", repository.update(new Person(10003, "Pieter", "Utrecht", new Date())));
		repository.deleteById(10002);
		logger.info("All users -> {}", repository.findAll());
	
	}

}
