package pl.jaceksysiak;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.entity.Address;
import pl.jaceksysiak.entity.Employee;

public class MainClass_DeleteAddressData {
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.addAnnotatedClass(Address.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			//get Addresses from DB
			int tmpId = 10;
			Address tmpAddress = session.get(Address.class, tmpId);
			
			System.out.println("This address to delete: " + tmpAddress);
			session.delete(tmpAddress);
		 
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
