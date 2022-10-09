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
        
        //inserting data to DB
        Employee employee = new Employee();
        //user.setId(105);
        employee.setUsername("dddddddd");
        employee.setPassword("dddddddddddddd");
        employee.setEmail("ioii@wwwe.pl");
		session.persist(employee);
		
		//selecting data from DB
		Employee employeeSel = session.load(Employee.class, 1);
		System.out.println(employeeSel.getUsername());
		System.out.println(employeeSel.getEmail());
		
		//deleting data from DB
		Employee employeeDel = session.load(Employee.class, 106);
		session.delete(employeeDel);
		
		//updating data from DB
		Employee employeeUpd = session.load(Employee.class, 2);
		employeeUpd.setEmail("neeeeeeeeeeeeeeeew");
		session.saveOrUpdate(employeeUpd);
		
		transaction.commit();
		session.close();
		//sessionFactory.close();

	}

}
