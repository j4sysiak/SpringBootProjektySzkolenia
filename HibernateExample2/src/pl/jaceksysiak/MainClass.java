package pl.jaceksysiak;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
		
        
        Employee user = new Employee();
        user.setId(103);
		user.setUsername("dddddddd");
		user.setPassword("dddddddddddddd");

		session.persist(user);
		transaction.commit();
		session.close();

		sessionFactory.close();

	}

}
