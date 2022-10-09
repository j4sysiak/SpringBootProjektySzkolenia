package pl.jaceksysiak.controllers;

import javax.validation.Valid;

import org.owasp.html.PolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.jaceksysiak.model.Profile;
import pl.jaceksysiak.model.SiteUser;
import pl.jaceksysiak.service.ProfileService;
import pl.jaceksysiak.service.SiteUserService;

@Controller
public class ProfileController {
	
	@Autowired
	private SiteUserService siteUserService;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private PolicyFactory htmlPolicy;
	
	private SiteUser getUser() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		return siteUserService.get(email);
	}
	 
	@RequestMapping(value="/profile")
	public ModelAndView showProfile(ModelAndView modelAndView) {
    
 		SiteUser user = getUser();
 		Profile profile = profileService.getUserProfile(user);
 		
		//modelAndView.getModel().put("profile", profile);
		 
		if(profile == null) {
			profile = new Profile();
			profile.setUser(user);
			profileService.save(profile);
		}
		
 		Profile webProfile = new Profile();
 		webProfile.safeCopyFrom(profile);
 		
 		modelAndView.getModel().put("profile", webProfile);
 		modelAndView.setViewName("app.profile");
 		
		return modelAndView;
	}

	@RequestMapping(value="/edit-profile-about", method=RequestMethod.GET)
	public ModelAndView editProfileAbout(ModelAndView modelAndView) {
		
		SiteUser user = getUser();
		Profile profile = profileService.getUserProfile(user);
		
		Profile webProfile = new Profile();
		webProfile.safeCopyFrom(profile);
		
		modelAndView.getModel().put("profile", webProfile);
		modelAndView.setViewName("app.editProfileAbout");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/edit-profile-about", method=RequestMethod.POST)
	public ModelAndView editProfileAbout(ModelAndView modelAndView, @Valid Profile webProfile, BindingResult result) {
		
		modelAndView.setViewName("app.editProfileAbout");
		
		SiteUser user = getUser();
		Profile profile = profileService.getUserProfile(user);
		
		profile.safeMergeFrom(webProfile, htmlPolicy);
		
		if(!result.hasErrors()) {
			profileService.save(profile);
			modelAndView.setViewName("redirect:/profile");
		}
		
		return modelAndView;
	}
	
}






































