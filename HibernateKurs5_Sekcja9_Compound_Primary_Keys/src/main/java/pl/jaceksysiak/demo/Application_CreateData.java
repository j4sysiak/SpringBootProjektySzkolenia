package pl.jaceksysiak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.demo.entity.Currency;
import pl.jaceksysiak.demo.entity.ids.CurrencyId;

public class Application_CreateData {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Currency.class)
								.buildSessionFactory();
		
		// create session 1
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			//Creating the Object 
			Currency currency = new Currency();
			currency.setCountryName("United States");
			currency.setName("Dollar");
			currency.setSymbol("$");
			
			//Saving the Object to DB		
			session.persist(currency);
			
			// commit transaction
			session.getTransaction().commit();
			
			
			
			// create session 2
			Session session2 = factory.getCurrentSession();
		    session2.beginTransaction();
		    
			Currency dbCurrency = (Currency) session2.get(Currency.class, new CurrencyId("Dollar", "United States"));
			System.out.println(dbCurrency.getName());
			
			session2.getTransaction().commit();
		    
		    
		}
		finally {
			
			// add clean up code
			session.close();			
			factory.close();
		}
	}
	

	}