package pl.carWasher.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.carWasher.dao.jpa.CarWasherRepository;
import pl.carWasher.model.Car;

@Controller
@RequestMapping("/carWasherController")
public class CarWasherController {
	
	@Autowired
	private CarWasherRepository repository;
	
	@RequestMapping("/cacheBustingTest")
	public ModelAndView cacheBustinTest() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("cacheBustingTest");

		return modelAndView;
	}
	
	@RequestMapping("/car/{id}")
	public Car getCar(@PathVariable int id) {
		return repository.getCar(id);
	}
	
	
	@RequestMapping("/cars")
	public List<Car> getCars() {
		return repository.getCars();
	}

}
