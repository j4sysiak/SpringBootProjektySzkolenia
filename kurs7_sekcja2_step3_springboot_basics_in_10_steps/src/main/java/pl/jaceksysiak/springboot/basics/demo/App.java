package pl.jaceksysiak.springboot.basics.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		
		//1. sposób
		//SpringApplication.run(App.class, args);
		
		//2. sposób
		ApplicationContext applicationContext = SpringApplication.run(App.class, args);
		
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println("applicationContext: " + name);
		}
	}

}
