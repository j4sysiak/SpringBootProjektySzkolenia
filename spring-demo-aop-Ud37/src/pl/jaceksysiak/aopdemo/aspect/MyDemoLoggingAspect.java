package pl.jaceksysiak.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice

	//@Before("execution(public void addAccount())")	
	//@Before("execution(public void pl.jaceksysiak.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(void add*())")
	//@Before("execution(* add*())")
	//@Before("execution(* add*(pl.jaceksysiak.aopdemo.Account, ..))")   // account and any other param.
	//@Before("execution(* add*(..))")   //any parameters
	  @Before("execution(* pl.jaceksysiak.aopdemo.dao.*.*(..))")      // avery thing in given package
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on some method");
		
	}
}










