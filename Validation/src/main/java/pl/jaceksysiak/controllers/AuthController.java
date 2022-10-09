package pl.jaceksysiak.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.jaceksysiak.model.SiteUser;
import pl.jaceksysiak.service.SiteUserService;

@Controller
public class AuthController {
	
	@Autowired
	private SiteUserService siteUserService;

//	@RequestMapping("/admin")
//	String admin() {
//		return "admin";
//	}
	
	@RequestMapping("/login")
	String login() {
		return "app.login";
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	ModelAndView register(ModelAndView modelAndView) {
		
		SiteUser user = new SiteUser();
		
		modelAndView.getModel().put("user", user);
		modelAndView.setViewName("app.register");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	ModelAndView register(ModelAndView modelAndView, @ModelAttribute(value="user") @Valid SiteUser user, BindingResult result) {
		
		modelAndView.setViewName("app.register");
		
		if(!result.hasErrors()) {
			siteUserService.register(user);
			modelAndView.setViewName("redirect:/");
		}
		return modelAndView;
	}
	
}
































