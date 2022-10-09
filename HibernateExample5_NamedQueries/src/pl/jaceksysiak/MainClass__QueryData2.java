package pl.jaceksysiak;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import pl.jaceksysiak.entity.Employee;

public class MainClass__QueryData2 {

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
			//criteria.setFirstResult(2);
			//criteria.setMaxResults(3);
			//criteria.setProjection(Projections.property("username"));
			criteria.add(Restrictions.gt("salary", 1000));
			criteria.addOrder(Order.desc("age"));
			
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
