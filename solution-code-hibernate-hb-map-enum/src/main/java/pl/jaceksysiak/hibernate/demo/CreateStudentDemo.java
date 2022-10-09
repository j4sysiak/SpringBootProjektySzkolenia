package pl.jaceksysiak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.hibernate.demo.entity.Status;
import pl.jaceksysiak.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		

		//create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects			
			 Student student1 = new Student("Mary", "Public", "paul@luv2code.com",Status.ACTIVE);
			 Student student2 = new Student("John", "Doe", "john@luv2code.com",Status.INACTIVE);
			 			 
			 
			// start a transaction
			session.beginTransaction();
			
	
			// save the student object
			System.out.println("Saving the users...");
			session.persist(student1);
			session.persist(student2);
			
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





