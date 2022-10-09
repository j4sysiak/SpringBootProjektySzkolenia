package pl.jaceksysiak.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.demo.entity.User;


public class Application_CreateData {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			//creating user
			User user = new User();
			user.setFirstName("Kevin");
			user.setLastName("Ahyttt");
			user.setBirthDate(new Date());
			user.setEmailAddress("kmb385@yahoo.com");
			user.setLastUpdatedBy("kevin");
			user.setLastUpdatedDate(new Date());
			
			// save the courses
			session.save(user);
						
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			
			// add clean up code
			session.close();			
			factory.close();
		}
	}
}