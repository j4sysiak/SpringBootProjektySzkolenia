package pl.jaceksysiak.demo;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.demo.entity.AccountType;
import pl.jaceksysiak.demo.entity.Account;

public class Application_CreateData {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Account.class)
								.addAnnotatedClass(AccountType.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			//Creating the Object 
			Account account = createNewAccount();
			account.setAccountType(AccountType.SAVINGS);
			
			//Saving the Object to DB		
			session.save(account);
			
			
			Account dbAccount = (Account) session.get(Account.class, account.getAccountId());
			System.out.println(dbAccount.getName());
			System.out.println(dbAccount.getAccountType());
			
			// commit transaction
			session.getTransaction().commit();
			

		    
		}
		finally {
			
			// add clean up code
			session.close();			
			factory.close();
		}
	}
	
	private static Account createNewAccount() {
		Account account = new Account();
		account.setCloseDate(new Date());
		account.setOpenDate(new Date());
		account.setCreatedBy("Kevin Bowersox");
		account.setInitialBalance(new BigDecimal("50.00"));
		account.setName("Savings Account");
		account.setCurrentBalance(new BigDecimal("100.00"));
		account.setLastUpdatedBy("Kevin Bowersox");
		account.setLastUpdatedDate(new Date());
		account.setCreatedDate(new Date());
		return account;
	}
	

	}