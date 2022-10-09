package pl.jaceksysiak;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.entity.Address;
import pl.jaceksysiak.entity.Employee;

public class MainClass_RetrieveData {
	
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
			
		    //get Employee from DB
			int tmpId=1;
			Employee tmpEmployee = session.get(Employee.class, tmpId);
			System.out.println("Employee: " + tmpEmployee);
			
			//get Addresses from DB
			System.out.println("Addresses: " + tmpEmployee.getAddresses());
			
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
