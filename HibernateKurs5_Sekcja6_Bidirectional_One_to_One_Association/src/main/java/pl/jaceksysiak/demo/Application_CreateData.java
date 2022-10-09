package pl.jaceksysiak.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.demo.entity.User;
import pl.jaceksysiak.demo.entity.Credential;


public class Application_CreateData {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.addAnnotatedClass(Credential.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			//Creating the Object User
			User user = new User();
			user.setFirstName("Kevin");
			user.setLastName("Bowersox");
			user.setAge(20);
			user.setBirthDate(new Date());
			user.setCreatedBy("Kevin Bowersox");
			user.setCreatedDate(new Date());
			user.setEmailAddress("kevin.bowersox@navy.mil");
			user.setLastUpdatedDate(new Date());
			user.setLastUpdatedBy("Kevin Bowersox");

			//Creating the Object Credential
			Credential credential = new Credential();
			credential.setPassword("kevinspassword");
			credential.setUsername("kmb385");
			
			
			credential.setUser(user);
			user.setCredential(credential);
			
			//Saving the Object to DB
			session.save(credential);
				
            //<-----------------  one way
			Credential dbCreditial = session.get(Credential.class, user.getCredential().getCredentialId());
			System.out.println(dbCreditial.getPassword());
			
			//------------------> other way
			User dbUser = (User) session.get(User.class, credential.getUser().getUserId());
			System.out.println(dbUser.getFirstName());
			
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

























