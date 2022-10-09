package pl.jaceksysiak.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.demo.entity.Address;
import pl.jaceksysiak.demo.entity.Bank;


public class Application_CreateData {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Bank.class)
								.addAnnotatedClass(Address.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			//creating Bank
			Bank tmpBank = new Bank();
			tmpBank.setName("BRE Bank");
			tmpBank.setInternational(false);
			tmpBank.setLastUpdatedDate(new Date());
			tmpBank.setLastUpdatedBy("Jacek Sysiak");
			tmpBank.setCreatedDate(new Date());
			tmpBank.setCreatedBy("Jacek Sysiak");
			tmpBank.setAddressLine1("PPPPPPPPPPPPPPPPPPPP");
			tmpBank.setAddressLine2("9999999hhhhhhhhhhhhhhhhh");
			tmpBank.setCity("New York");
			tmpBank.setState("NY");
			tmpBank.setZipCode("78-90-99");
			tmpBank.getContacts().put("MANAGER", "Jacek");
			tmpBank.getContacts().put("ADMIN", "Tomek");
			tmpBank.getContacts().put("USER", "Kora");
			
			// save the Bank
			session.save(tmpBank);
						
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