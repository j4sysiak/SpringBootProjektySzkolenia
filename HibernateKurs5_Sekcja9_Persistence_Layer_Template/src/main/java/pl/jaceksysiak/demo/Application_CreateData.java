package pl.jaceksysiak.demo;

import java.util.Arrays;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.demo.dao.UserHibernateDao;
import pl.jaceksysiak.demo.dao.interfaces.UserDao;
import pl.jaceksysiak.demo.entity.Account;
import pl.jaceksysiak.demo.entity.AccountType;
import pl.jaceksysiak.demo.entity.Address;
import pl.jaceksysiak.demo.entity.Bank;
import pl.jaceksysiak.demo.entity.Credential;
import pl.jaceksysiak.demo.entity.Transaction;
import pl.jaceksysiak.demo.entity.User;

public class Application_CreateData {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.addAnnotatedClass(Account.class)
								.addAnnotatedClass(AccountType.class)
								.addAnnotatedClass(Bank.class)
								.addAnnotatedClass(Address.class)
								.addAnnotatedClass(Credential.class)
								.addAnnotatedClass(Transaction.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			//Creating the Object 
			UserDao dao = new UserHibernateDao();
			dao.setSession(session);
			User user = createUser();
			
			
			//Saving the Object to DB
			dao.save(user);
				
			// commit transaction
			session.getTransaction().commit();

		}
		finally {
			
			// add clean up code
			session.close();			
			factory.close();
		}
	}
	
	private static User createUser() {
		User user = new User();
		//Address address = createAddress();
		user.setAddresses(Arrays.asList(new Address[] { createAddress() }));
		user.setBirthDate(new Date());
		user.setCreatedBy("Kevin Bowersox");
		user.setCreatedDate(new Date());
		user.setCredential(createCredential(user));
		user.setEmailAddress("test@test.com");
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setLastUpdatedBy("system");
		user.setLastUpdatedDate(new Date());
		return user;
	}

	private static Credential createCredential(User user) {
		Credential credential = new Credential();
		credential.setUser(user);
		credential.setUsername("test_username");
		credential.setPassword("test_password");
		return credential;
	}

	private static Address createAddress() {
		Address address = new Address();
		address.setAddressLine1("101 Address Line");
		address.setAddressLine2("102 Address Line");
		address.setCity("New York");
		address.setState("PA");
		address.setZipCode("10000");
		address.setAddressType("PRIMARY");
		return address;
	}

	}