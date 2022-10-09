package pl.carWasher.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@RequestMapping(value = { "/", "/index.html" })
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo("jaceksysiak@wp.pl");
		simpleMailMessage.setCc("j4sysiak@gmail.com");
		simpleMailMessage.setText("TEST MESSAGE");
		
		javaMailSender.send(simpleMailMessage);
		
		return modelAndView;
	}

	@RequestMapping(value = "/login.html")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
}