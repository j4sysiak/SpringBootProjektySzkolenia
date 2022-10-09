package pl.jaceksysiak.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.jaceksysiak.aopdemo.dao.AccountDAO;
import pl.jaceksysiak.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		Account newAccount = new Account();
		newAccount.setName("Madhu");
		newAccount.setLevel("Platinum");
		
		theAccountDAO.addAccount(newAccount, true);
		theAccountDAO.doWork();
		
		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyMembership();
		theMembershipDAO.goToSleep();
				
		// close the context
		context.close();
	}

}










