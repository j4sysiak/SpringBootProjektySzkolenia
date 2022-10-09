package pl.jaceksysiak;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import pl.jaceksysiak.entity.Employee;

public class MainClass__QueryData3_NamedQueries {

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
			
			Query query = session.getNamedQuery("findEmployeeByName");
			query.setString("username", "Jack");
			
		//-----------Query Employee Data
			List<Employee> employees = query.list();
			
			for(Employee tmpEmployee : employees) {
				System.out.println(tmpEmployee.toString());
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
