package pl.jaceksysiak.springdemo;

public class CricketCoach implements Coach {

	//define a private field for the dependency
	private FortuneService fortuneService;
	
	//add new fields for emailAddress and team
	private String emailAddress;
	private String team;
	 
	//non-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside non-arg constructor");
	}
	
	//define a constructor for dependency injection
//	public CricketCoach(FortuneService theFortuneService) {
//		this.fortuneService = theFortuneService;
//	}
	
	//setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
		
	}
 
	@Override
	public String getDailyFortune() {
		// use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - setTeam");
		this.team = team;
	}

}
