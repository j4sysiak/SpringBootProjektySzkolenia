package pl.jaceksysiak.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSillyMembership() {
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		return false;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": I'm going to sleep now...");
		
	}
}
