package pl.jaceksysiak.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.demo.entity.Bank;
import pl.jaceksysiak.demo.entity.User;
import pl.jaceksysiak.demo.entity.Address;


public class Application_CreateData {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Bank.class)
								.addAnnotatedClass(User.class)
								.addAnnotatedClass(Address.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			
			//creating User
			User tmpUser = new User();
			tmpUser.setFirstName("Robert");
			tmpUser.setLastName("Wielki");
			tmpUser.setBirthDate(new Date());
			tmpUser.setEmailAddress("jaceksysiak@wp.pl");
			tmpUser.setLastUpdatedDate(new Date());
			tmpUser.setLastUpdatedBy("Jacek Sysiak");
			tmpUser.setCreatedDate(new Date());
			tmpUser.setCreatedBy("Jacek Sysiak");
			
			//creating Bank and Address
			Bank tmpBank = new Bank();
			tmpBank.setName("BRE Bank");
			tmpBank.setInternational(false);
			tmpBank.setLastUpdatedDate(new Date());
			tmpBank.setLastUpdatedBy("Jacek Sysiak");
			tmpBank.setCreatedDate(new Date());
			tmpBank.setCreatedBy("Jacek Sysiak");
			tmpBank.setAddressLine1("iiiiiiiiiiiiiiiiiii");
			tmpBank.setAddressLine2("jjjjjjjjjjjjjjjjjjj");
			tmpBank.setCity("Warszawa");
			tmpBank.setState("Mazowsze");
			tmpBank.setZipCode("21-200");
			
			
			
			//creating Address
			Address tmpAddress2 = new Address();
			tmpAddress2.setAddressLine1("iiiiiiiiiiiiiiiiiii");
			tmpAddress2.setAddressLine2("jjjjjjjjjjjjjjjjjjj");
			tmpAddress2.setCity("Warszawa");
			tmpAddress2.setState("Mazowsze");
			tmpAddress2.setZipCode("21-200");
			
			//Adding Address to User
			tmpUser.setAddress(tmpAddress2);
			
			// save the Bank
			session.save(tmpBank);
			session.save(tmpUser);
						
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