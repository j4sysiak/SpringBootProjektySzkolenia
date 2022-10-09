package pl.carWasher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

//import com.carWasher.properties.CarWasherProperties;

@SpringBootApplication
@EnableScheduling
//@EnableConfigurationProperties(value=CarWasherProperties.class)
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}