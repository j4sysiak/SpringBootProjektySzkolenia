package pl.jaceksysiak.demo;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.demo.entity.Bond;
import pl.jaceksysiak.demo.entity.Investment;
import pl.jaceksysiak.demo.entity.Portfolio;
import pl.jaceksysiak.demo.entity.Stock;

public class Application_CreateData {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Stock.class)
								.addAnnotatedClass(Investment.class)
								.addAnnotatedClass(Bond.class)
								.addAnnotatedClass(Portfolio.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			//Creating the Object 
			Portfolio portfolio= new Portfolio();
			portfolio.setName("First Investments");
			
		    Stock stock = createStock();		
		    stock.setPortfolio(portfolio);
		    
		    Bond bond = createBond();
		    bond.setPortfolio(portfolio);
		
			portfolio.getInvestements().add(stock);
			portfolio.getInvestements().add(bond);
			
			//Saving the Object to DB	
			session.save(stock);
			session.save(bond);
			
			
			
//
//			Portfolio dbPortfolio = (Portfolio) session.get(Portfolio.class, portfolio.getPortfolioId());
//			session.refresh(dbPortfolio);
//			
//			for(Investment i:dbPortfolio.getInvestements()){
//				System.out.println(i.getName());
//			}
			
			// commit transaction
			session.getTransaction().commit();

		}
		finally {
			
			// add clean up code
			session.close();			
			factory.close();
		}
	}

	private static Bond createBond() {
		Bond bond = new Bond();
		bond.setInterestRate(new BigDecimal("123.22"));
		bond.setIssuer("JP Morgan Chase");
		bond.setMaturityDate(new Date());
		bond.setPurchaseDate(new Date());
		bond.setName("Long Term Bond Purchases");
		bond.setValue(new BigDecimal("10.22"));
		return bond;
	}

	private static Stock createStock(){
		Stock stock = new Stock();
		stock.setIssuer("Allen Edmonds");
		stock.setName("Private American Stock Purchases");
		stock.setPurchaseDate(new Date());
		stock.setQuantity(new BigDecimal("1922"));
		stock.setSharePrice(new BigDecimal("100.00"));
		return stock;
	}

	}