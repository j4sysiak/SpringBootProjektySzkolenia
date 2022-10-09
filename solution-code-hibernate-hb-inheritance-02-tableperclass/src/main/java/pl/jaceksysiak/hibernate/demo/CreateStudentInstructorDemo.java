package pl.jaceksysiak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.hibernate.demo.entity.Instructor;
import pl.jaceksysiak.hibernate.demo.entity.Student;

public class CreateStudentInstructorDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.addAnnotatedClass(Instructor.class)
									.buildSessionFactory();
		

		//create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects			
			Student tempStudent = new Student("Mary", "Public", "mary@luv2code.com", "Hibernate");
			Instructor tempInstructor = new Instructor("John", "Doe", "john@luv2code.com", 20000.00);
			 			  
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student and instructor...");
			session.save(tempStudent);
			session.save(tempInstructor);
			
		//commit the transaction
		session.getTransaction().commit();
		System.out.println("Done!!");
		}
		finally {
		//clean up code
			session.close();
			factory.close();
		}
		

	}

}





