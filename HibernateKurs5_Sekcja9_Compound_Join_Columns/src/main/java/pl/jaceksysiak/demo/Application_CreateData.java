package pl.jaceksysiak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.demo.entity.Currency;
import pl.jaceksysiak.demo.entity.Market;

public class Application_CreateData {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Currency.class)
								.addAnnotatedClass(Market.class)
								.buildSessionFactory();
		
		// create session 1
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			//Creating the Object 
			Currency currency = new Currency();
			currency.setCountryName("United Kingdom");
			currency.setName("Pound");
			currency.setSymbol("Pound Sign");
			
			Market market = new Market();
			market.setMarketName("London Stock Exchange");
			market.setCurrency(currency);
			
			//Saving the Object to DB		
			session.persist(market);
			
			Market dbMarket = (Market) session.get(Market.class, market.getMarketId());
			System.out.println(dbMarket.getCurrency().getName());
		    
			
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