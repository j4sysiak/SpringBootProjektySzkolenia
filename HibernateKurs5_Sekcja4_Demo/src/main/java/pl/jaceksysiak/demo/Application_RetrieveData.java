package pl.jaceksysiak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.demo.entity.User;


public class Application_RetrieveData {

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
			
		    //get Employee from DB
			int tmpUserId=1;
			User tmpUser = session.get(User.class, tmpUserId);
			System.out.println("User: " + tmpUser.getFirstName());
			
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