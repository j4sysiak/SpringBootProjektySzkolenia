package pl.jaceksysiak.demo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.demo.entity.Account;
import pl.jaceksysiak.demo.entity.AccountType;
import pl.jaceksysiak.demo.entity.Address;
import pl.jaceksysiak.demo.entity.Bank;
import pl.jaceksysiak.demo.entity.Credential;
import pl.jaceksysiak.demo.entity.Transaction;
import pl.jaceksysiak.demo.entity.User;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
	        
	   configuration.configure("hibernate.cfg.xml")
					.addAnnotatedClass(User.class)
					.addAnnotatedClass(Account.class)
					.addAnnotatedClass(AccountType.class)
					.addAnnotatedClass(Bank.class)
					.addAnnotatedClass(Address.class)
					.addAnnotatedClass(Credential.class)
					.addAnnotatedClass(Transaction.class)
					.buildSessionFactory();
			
			return configuration
					.buildSessionFactory(new StandardServiceRegistryBuilder()
							.applySettings(configuration.getProperties())
							.build());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"There was an error building the factory");
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
