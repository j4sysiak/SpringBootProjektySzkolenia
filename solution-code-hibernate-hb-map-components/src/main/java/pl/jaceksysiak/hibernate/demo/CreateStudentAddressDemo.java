package pl.jaceksysiak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.hibernate.demo.entity.Address;
import pl.jaceksysiak.hibernate.demo.entity.Student;

public class CreateStudentAddressDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.addAnnotatedClass(Address.class)
									.buildSessionFactory();
		

		//create session
		Session session = factory.getCurrentSession();
		
		try {
		//create the Student object
		Student tempStudent = new Student("John","Doe","john@luv2code.com");
		
		//create the Address object
		Address homeAddress = new Address("Some Street 123", "12345", "Some City");
		
		 //2nd example:  Overriding embedded attributes
		 Address billingAddress = new Address("Some Billing Street 123", "67890", "Some Billing City");
			
		//start a transaction
		session.beginTransaction();
			
		//save the object
		System.out.println("Saving the student and billing address...");
		tempStudent.setHomeAddress(homeAddress);
		tempStudent.setBillingAddress(billingAddress);
		session.save(tempStudent);
			
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





