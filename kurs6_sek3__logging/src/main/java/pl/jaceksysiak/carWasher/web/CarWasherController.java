package pl.jaceksysiak.carWasher.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/carWasherController")
public class CarWasherController {
	
	@RequestMapping("/cacheBustingTest")
	public ModelAndView cacheBustinTest() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("cacheBustingTest");

		return modelAndView;
	}

}
