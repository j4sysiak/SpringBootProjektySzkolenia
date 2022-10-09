package pl.jaceksysiak;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.entity.Address;
import pl.jaceksysiak.entity.Employee;

public class MainClass_CreateData {
	
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
			
		//-----------Employee	
			Employee tmpEmployee=new Employee("Jack");
		//	tmpEmployee1.setName("Jack");

			
		//----------- Address
			Address address1 = new Address("Warzawa", "Poland");
			//address1.setCity("Warzawa");
			//address1.setCountry("Poland");
			
			Address address2 = new Address();
			address2.setCity("Washington");
			address2.setCountry("USA");
			
			//add addresses to employee
			tmpEmployee.add(address1);
			tmpEmployee.add(address2);
			
			// save the courses
			session.save(tmpEmployee);
			session.save(address1);
			session.save(address2);
			
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
