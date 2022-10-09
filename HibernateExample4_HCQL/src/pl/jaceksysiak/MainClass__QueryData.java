package pl.jaceksysiak;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.entity.Employee;

public class MainClass__QueryData {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
		//-----------Query Employee Data
			Criteria criteria = session.createCriteria(Employee.class); 

			List<Employee> listEmpl = criteria.list();
			
			for(Employee tmpEmployee : listEmpl) {
				System.out.println(tmpEmployee.getUsername());
				System.out.println(tmpEmployee.getSalary());
				System.out.println(tmpEmployee.getAge());
				System.out.println("++++++++++++++++++++++++++++++++++++++++");
			}
			
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
