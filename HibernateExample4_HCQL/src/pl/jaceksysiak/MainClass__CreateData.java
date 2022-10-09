package pl.jaceksysiak;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.entity.Employee;

public class MainClass__CreateData {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
		//-----------Employee	
			Employee tmpEmployee1=new Employee("Jack", 1000, 22);
			Employee tmpEmployee2=new Employee("Bob", 2000, 44);
			Employee tmpEmployee3=new Employee("Mark", 5000, 55);

			// start a transaction
			session.beginTransaction();
			
			// save the courses
			session.save(tmpEmployee1);
			session.save(tmpEmployee2);
			session.save(tmpEmployee3);
			
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
