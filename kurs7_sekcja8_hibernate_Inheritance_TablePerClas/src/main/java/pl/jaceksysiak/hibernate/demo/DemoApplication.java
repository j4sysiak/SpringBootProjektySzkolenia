package pl.jaceksysiak.hibernate.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pl.jaceksysiak.hibernate.demo.entity.Course;
import pl.jaceksysiak.hibernate.demo.entity.FullTimeEmployee;
import pl.jaceksysiak.hibernate.demo.entity.PartTimeEmployee;
import pl.jaceksysiak.hibernate.demo.entity.Review;
import pl.jaceksysiak.hibernate.demo.entity.Student;
import pl.jaceksysiak.hibernate.demo.repository.CourseRepository;
import pl.jaceksysiak.hibernate.demo.repository.EmployeeRepository;
import pl.jaceksysiak.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Course course = courseRepository.findById(10001L);
		
		logger.info("Course 10001L -> {}", course);
		
		courseRepository.save(new Course("Microservices in 100 Steps"));
		
	   // komentuje, żeby nie usuwało mi tego rekordu	courseRepository.deleteById(10001L);
       */
		
	   //	courseRepository.playWithEntityManager();
		
	   //studentRepository.saveStudentWithPassport();
		
	  //courseRepository.addHardcodedReviewsForCourse();
		
		/*
		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("5", "Great Hands-on Stuff."));	
		reviews.add(new Review("5", "Hatsoff."));
		courseRepository.addReviewsForCourse(10003L, reviews );
		
		
		studentRepository.insertHardcodedStudentAndCourse();
		studentRepository.insertStudentAndCourse(new Student("Jack"), new Course("Microservices in 100 Steps"));
		*/
		

		// Jack FullTimeEmployee salary - 10000$
		// Jill PartTimeEmployee - 50$ per hour
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

		logger.info("All Employees -> {}", employeeRepository.retrieveAllEmployees());
		
	}
}