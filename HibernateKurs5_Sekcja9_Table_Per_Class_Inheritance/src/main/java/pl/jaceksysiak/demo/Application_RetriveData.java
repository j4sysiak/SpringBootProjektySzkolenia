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

public class Application_RetriveData {

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
			
			Long tmpId=1L;
			Portfolio dbPortfolio = (Portfolio) session.get(Portfolio.class, tmpId);
			session.refresh(dbPortfolio);
			
			for(Investment i : dbPortfolio.getInvestements()){
				System.out.println(i.getName());
			}
			
			
			
//        taki sql bêdzie:			
//			Hibernate: select investemen0_.PORTFOLIO_ID as PORTFOLI5_1_0_, 
//			investemen0_.INVESTMENT_ID as INVESTME1_1_0_, 
//			investemen0_.INVESTMENT_ID as INVESTME1_1_1_, 
//			investemen0_.ISSUER as ISSUER2_1_1_, 
//			investemen0_.NAME as NAME3_1_1_, 
//			investemen0_.PORTFOLIO_ID as PORTFOLI5_1_1_, 
//			investemen0_.PURCHASE_DATE as PURCHASE4_1_1_, 
//			investemen0_.QUANTITY as QUANTITY1_3_1_, 
//			investemen0_.SHARE_PRICE as SHARE_PR2_3_1_, 
//			investemen0_.INTEREST_RATE as INTEREST1_0_1_, 
//			investemen0_.MATURITY_DATE as MATURITY2_0_1_, 
//			investemen0_.VALUE as VALUE3_0_1_, 
//			investemen0_.clazz_ as clazz_1_ 
//			from (
//
//			 select 
//			 INVESTMENT_ID, 
//			 ISSUER, 
//			 NAME, 
//			 PURCHASE_DATE, 
//			 PORTFOLIO_ID, 
//			 QUANTITY, 
//			 SHARE_PRICE, 
//			 null as INTEREST_RATE, 
//			 null as MATURITY_DATE, 
//			 null as VALUE, 
//			 1 as clazz_ 
//			 from STOCK 
//			 union 
//			 select 
//			 INVESTMENT_ID, 
//			 ISSUER, NAME, 
//			 PURCHASE_DATE, 
//			 PORTFOLIO_ID, 
//			 null as QUANTITY, 
//			 null as SHARE_PRICE, 
//			 INTEREST_RATE, 
//			 MATURITY_DATE, 
//			 VALUE, 2 as clazz_ from BOND 
//			 
//			 ) investemen0_ 
//			 where investemen0_.PORTFOLIO_ID=?
//					 
			
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